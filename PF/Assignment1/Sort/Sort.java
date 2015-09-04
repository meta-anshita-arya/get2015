//main class
public class Sort {

	// main function
	public static void main(String arg[]) {
		MenuAndPrint menuandprint = new MenuAndPrint();
		int[] array = menuandprint.arrayInput();
		int length = array.length;
		int[] sorted = new int[length];
		int choice = menuandprint.menu();// user choice
		while (choice != 4) {
			switch (choice) {

			case 1:// for comparision sort
				ComparisionSort comparision = new ComparisionSort();
				sorted = comparision.comparisionSort(array, length);
				menuandprint.print(sorted, length);
				break;

			case 2:// for linear sort
				LinearSort linear = new LinearSort();
				sorted = linear.linearsorting(array, length);
				menuandprint.print(sorted, length);
				break;

			case 3: // to input new values in array
				array = menuandprint.arrayInput();
				length = array.length;
				sorted = new int[length];
				break;

			case 4:// to exit
				System.exit(0);
				break;

			default:// default
				System.out.println("invalid input, please enter correctly");
				break;
			}
			choice = menuandprint.menu();
		}

	}
}
