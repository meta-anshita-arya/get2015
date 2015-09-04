import java.util.Scanner;

public class MenuAndPrint {
	// to get all inputs from user, provide menu and display result
	Scanner scan = new Scanner(System.in);

	// to provide menu to user and input choice
	int menu() {
		System.out
				.println(" enter 1 for Comparision Sorting, 2 for Linear Sorting, 3 to input new array, 4 to exit");
		int choice = scan.nextInt();
		return choice;
	}

	// to get array inputs from user
	int[] arrayInput() {
		System.out.println(" enter number of elements");
		int length = scan.nextInt();
		int[] array = new int[length];
		System.out.println(" enter " + length + " number of elements");
		for (int position = 0; position < length; position++) {
			array[position] = scan.nextInt();
		}
		return array;
	}

	// to display array
	void print(int[] array, int length) {
		for (int position = 0; position < length; position++) {
			System.out.println(array[position]);
		}
	}
}
