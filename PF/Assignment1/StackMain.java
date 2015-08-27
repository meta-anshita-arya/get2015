
import java.util.Scanner;

//main class
public class StackMain {

	// main function
	public static void main(String[] args) {
		StackFunction stackfunction = new StackFunction();
		Scanner sc = new Scanner(System.in);
		char ch;
		do {
			System.out.println("Enter what you want to do");
			System.out.println("1 Infix to postfix conversion");
			System.out.println("2 Exit");

			int choice;

			do {// Validation

				while (!sc.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					sc.next(); // this is important!
				}
				choice = sc.nextInt();
			} while (choice <= 0);
			switch (choice) {
			case 1:
				System.out.println("Enter Expression");
				String postfix = new String();
				StackFunction infix = new StackFunction();
				postfix = stackfunction.convert(sc.next());
				System.out.println("postfix is " + postfix);
				break;

			case 2:
				System.exit(0);
				break;

			default:
				System.out.println("enter rightvalues");

			}

			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = sc.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
		sc.close();

	}

}
