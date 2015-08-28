package prg1;

import java.util.Scanner;

//main class
public class TraversalMain {
	public static void main(String arg[]) {

		Scanner in = new Scanner(System.in);
		System.out.println("enter total number of values");
		int totalNumber = in.nextInt();
		System.out.println("enter values");
		int value = in.nextInt();
		BinaryTree tree = new BinaryTree(value);
		for (int i = 1; i < totalNumber; i++) {
			value = in.nextInt();
			tree.addNode(value);
		}
		int choice;
		do {
			System.out
					.println("enter value 1 for Pre-order traversal, 2 for Post-oeder traversal, 3 to exit");
			choice = in.nextInt();

			if (choice == 1) {
				tree.traversePreOrder();
			}

			else if (choice == 2) {
				tree.traversePostOrder();
			}

			else if (choice == 3) {
				System.exit(0);
			}

			else {
				System.out.println("invalid input");
			}

		} while (choice != 3);

	}

}
