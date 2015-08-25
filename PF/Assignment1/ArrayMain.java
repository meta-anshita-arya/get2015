package prg1;

//main class
import java.util.Scanner;

public class ArrayMain {
	private static Scanner in;

	public static void main(String arg[]) {
		in = new Scanner(System.in);
		int choice = -1;
		int[] array = { 3, 8, 3, 9, 6, 1, 2, 16 };
		int actualSize = 8;
		// object creation
		ArrayAction obj = new ArrayAction(array, actualSize);
		while (choice != 0) {
			obj.menu();
			choice = in.nextInt();
			int element;
			int position;
			switch (choice) {
			// to add at end of array
			case 1:
				System.out.println("enter element to be added");
				element = in.nextInt();
				obj.AddElement(element);
				break;
			// to add at desired position

			case 2:
				System.out.println("enter element to be added");
				element = in.nextInt();
				System.out.println("enter position");
				position = in.nextInt();
				obj.AddElement(element, position);
				break;
			// to retrive first occurance of element at given position

			case 3:
				System.out.println("enter position to find first occurance");
				position = in.nextInt();
				obj.RetrievingTheFirstOccurrence(position);
				break;

			// to find first occurance of given element
			case 4:
				System.out
						.println("enter element whose first index you want to find");
				element = in.nextInt();
				obj.RetrievingTheFirstIndex(element);
				break;
			// to to remove element at given position
			case 5:
				System.out
						.println("enter position at which you want to remove element");
				position = in.nextInt();
				obj.RemovingAnItemOnLocation(position);
				break;

			// to remove given element
			case 6:
				System.out.println("enter element which you want to remove ");
				element = in.nextInt();
				obj.RemoveGivenItem(element);
				break;

			// to clear array
			case 7:
				obj.ClearTheList();
				break;

			// to reverse array
			case 8:
				obj.ReverseTheArray();
				break;

			// to sort array
			case 9:
				obj.SortArray();
				break;

			// to print array
			case 10:
				obj.print();
				break;

			// to exit
			case 0:
				System.exit(choice);

				
				//to add another array
			case 11:
				obj.AddArray();
				break;
				
				// default
			default:
				System.out.println("invalid input");
				break;
			}
		}
	}

}
