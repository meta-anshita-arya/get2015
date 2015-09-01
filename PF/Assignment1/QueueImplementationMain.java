import java.util.LinkedList;
import java.util.Scanner;

//main class
public class QueueImplementationMain {

	// main function
	public static void main(String arg[]) {
		Scanner scanner = new Scanner(System.in);

		int choice;
		do {
			System.out.println("Enter 1 for insertion in queue");
			System.out.println("enter 2 for deletion in queue");
			System.out.println("enter 3 to view element at begining");
			System.out.println("enter 4 for clear");
			System.out.println("enter 5 to exit");
			System.out.println("enter your choice");
			choice = scanner.nextInt();
			QueueImplementation object = new QueueImplementation();
			switch (choice) {
			case 1:
				System.out.println("enter the number");
				String element = scanner.next();
				object.add(element);
				break;
			case 2:
				object.remove();
				break;
			case 3:
				object.getBegining();
				break;
			case 4:
				object.clear();
				break;
			default:
				System.out.println("entered wrong choice");
				break;

			}

		} while (choice != 5);

	}
}
