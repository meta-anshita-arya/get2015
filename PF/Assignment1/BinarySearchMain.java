import java.util.Scanner;

//main class
public class BinarySearchMain {

	private static Scanner in;

	// main function
	public static void main(String[] args) {
		in = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int size = in.nextInt();// user input
		System.out.println("Enter an array of numbers: ");
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();// enter elements in array
		}
		System.out.println("Enter number you want to search: ");
		int num = in.nextInt();// enter number to be searched
		BinarySearch obj = new BinarySearch();// object creation
		int start = 0;
		int end = arr.length - 1;
		int index = obj.binarySearch(num, start, end, arr);
		if (index > -1) {// will execute if index is greater than -1
			int left = obj.leftmostOccurance(arr, index);
			System.out.println("leftmost occurance at position" + left);
			int right = obj.rightmostOccurance(arr, index);
			System.out.println("rightmost occurance at position" + right);
		} else {
			System.out.println("number not found");
		}
	}
}
