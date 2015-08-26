package prg2;

import java.util.Scanner;

//main class
public class MainClass {

	// main function
	public static void main(String arg[]) {
		Scanner in;
		in = new Scanner(System.in);
		MenuList menulist = new MenuList();
		Allotment allotment = new Allotment();
		String name;
		int temp;
		int choice = 0;
		System.out.println("WELCOME");
		System.out.println("enter total number of students");
		int limit = in.nextInt();
		Students students = new Students(limit);
		do {
			menulist.printMenu();
			choice = in.nextInt();
			switch (choice) {
			// to add students
			case 1:

				for (int i = 0; i < limit; i++) {
					System.out.println("enter name");
					name = in.next();
					System.out.println("enter rank");
					temp = in.nextInt();
					students.enqueue(name, temp);
				}
				students.sorting();
				break;

			// to print list of available colleges
			case 2:
				menulist.printListOfCollegeWithAvailableSeats();
				break;

			// for allotment
			case 3:
				for (int i = 0; i < limit; i++) {

					int check;
					name = students.getFront();
					do {
						menulist.selectCollege();
						System.out.println(name + "  enter your choice");
						temp = in.nextInt();
						check = allotment.allotToStudent(temp, name);
					} while (check != 1);
					name = students.dequeue();
					System.out.println(name + "  was alloted");
				}

				break;

			// to print list of students alloted to colleges
			case 4:
				menulist.printListOfNamesOfStudentsAlloted();
				break;

			// to empty lists
			case 5:
				students.makeEmpty();
				System.out.println("list cleared");
				break;

			default:
				System.out.println("invalid input");
				break;
			}
		} while (choice != 6);

	}
}
