
//Program to implement sorting using Binary Search tree
import java.util.Scanner;

//Class to input details from user and print the sorted array
public class TreeSortMain {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		TreeSortImplementation<Integer> treeSort = new TreeSortImplementation<Integer>();
		int noOfElements;
		// Input number of elements from user
		System.out.println("Enter no. of elements");
		noOfElements = scan.nextInt();
		int arr[] = new int[noOfElements];
		int result[] = new int[noOfElements];
		// Input roll numbers from user
		System.out.println("Enter all the roll numbers of students");
		arr[0] = scan.nextInt();
		Node<Integer> node = new Node<Integer>(arr[0]);
		for (int i = 1; i < noOfElements; i++) {
			int checkDuplicate = 0;
			while (checkDuplicate == 0) {
				arr[i] = scan.nextInt();
				int count = 0;
				for (int j = 0; j < i; j++) {
					if (arr[i] == arr[j]) {
						System.out
								.println("this  number already exixts, please enter again");
						count++;
					}
				}
				if (count == 0) {
					checkDuplicate = 1;
				} else {
					checkDuplicate = 0;
				}

			}

			// Inserting elements of array in a binary search tree
			treeSort.insertTree(node, arr[i]);
		}
		// Printing sorted array
		result = treeSort.inorder(node, arr);
		System.out
				.println("Printing all the roll numbers of students in sorted order");
		for (int i = 0; i < noOfElements; i++) {
			System.out.println(result[i]);
		}
		scan.close();
	}// End of main function
}// End of class
