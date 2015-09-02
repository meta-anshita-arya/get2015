import java.util.Scanner;

//program for binary search and return leftmost occurance

public class BinarySearch {
	// recursive function for binary search
	int binarySearch(int x, int start, int end, int arr[]) {
		int mid;
		while (start <= end) {// executes till value of start is less than or
								// equal to end
			mid = (start + end) / 2;
			if (x == arr[mid]) {// executes if value of x is equal to arr[mid]
				System.out.println("Number Found");
				return mid; // Returning position of number found
			} else if (x > arr[mid]) {// executes if value of x is greater than
										// arr[mid]
				return (binarySearch(x, mid + 1, end, arr));
			} else {
				return (binarySearch(x, start, mid - 1, arr));
			}
		}
		return -1;
	}

	int leftmostOccurance(int[] arr, int index) {
		int left = index;
		if (index == 0) {// executes if value of index is equal to 0
			return index;
		} else {
			while (left > 0 && arr[index] == arr[left - 1]) {// executes till
																// value of left
																// is greater
																// than 0 and
																// value of
																// arr[index] is
																// equal to
																// value of
																// arr[left-1]
				left--;
			}
			return left;
		}

	}

	int rightmostOccurance(int[] arr, int index) {
		int right = index;
		if (index == (arr.length) - 1) {
			return index;
		} else {
			while (right < arr.length - 1 && arr[index] == arr[right + 1]) {// executes
																			// till
																			// value
																			// of
																			// right
																			// is
																			// less
																			// than
																			// length
																			// of
																			// arr
																			// and
																			// value
																			// of
																			// arr[index]
																			// is
																			// equal
																			// to
																			// value
																			// of
																			// arr[right+1]
				right++;
			}
			return right;
		}

	}

}
