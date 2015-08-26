package prg2;

public class MenuList {
	CollegeList collegelist = new CollegeList();

	// print menu
	void printMenu() {

		System.out
				.println("1 to Add name and rank of all the students who want to apply");
		System.out.println("2 to get list of available colleges");
		System.out.println("3 to select a college");
		System.out
				.println("4 to print list of names of students alloted to colleges");
		System.out.println("5 to clear list");
		System.out.println("6 to exit");
	}

	// print list of colleges with available seats
	void printListOfCollegeWithAvailableSeats() {
		System.out.println("List of college        Seats Available");
		System.out.println("MLV   	           " + (4 - collegelist.count[0]));
		System.out.println("MIT    		       " + (4 - collegelist.count[1]));
		System.out.println("JCERC  		       " + (4 - collegelist.count[2]));
		System.out.println("ARYA  		       " + (4 - collegelist.count[3]));
		System.out.println("TINJR  		       " + (4 - collegelist.count[4]));

	}

	// print choices
	void selectCollege() {
		System.out
				.println("Enter choice 1 for MLV, 2 for MIT, 3 for JCERC, 4 for ARYA, 5 for TINJR");
	}

	// print list of students alloted to each college
	void printListOfNamesOfStudentsAlloted() {
		System.out
				.println("List of college and Names of Students alloted to them");
		CollegeList obj = new CollegeList();
		int i, j;
		String[] collegeList = { "MLV", "MIT", "JCERC", "ARYA", "TINJR" };
		for (i = 0; i < 5; i++) {
			System.out.println("List of students admitted in  "
					+ collegeList[i]);
			for (j = 0; j < obj.count[i]; j++) {
				System.out.println(obj.studentsList[i][j]);
			}
		}
	}
}
