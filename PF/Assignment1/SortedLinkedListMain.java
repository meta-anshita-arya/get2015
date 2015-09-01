import java.util.Scanner;

//main class
public class SortedLinkedListMain {

	// main function
	public static void main(String args[]) {
		SortedLinkedList obj = new SortedLinkedList();
		Scanner scan = new Scanner(System.in);
		int size, i;
		int element;
		int choice;
		do {
			System.out.println("Enter 1 to create list");
			System.out.println("enter 2 insert in list");
			System.out.println("enter 3 to display");
			System.out.println("enter 4 to exit");
			System.out.println("enter your choice");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter number of elements to be added");
				size = scan.nextInt();
				System.out.println("Enter  elements to be added");
				for (i = 0; i < size; i++) {
					element = scan.nextInt();
					obj.addElement(element);
				}
				break;

			case 2:
				System.out.println("Enter new element to be added");
				element = scan.nextInt();
				obj.addElements(0, element);
				break;

			case 3:
				obj.display();
				break;

			case 4:
				System.exit(0);
				break;

			default:
				System.out.println("invalid input");
				break;
			}

		} while (choice != 4);
	}

}
