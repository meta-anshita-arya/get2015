package prg2;

//has list of college
public class CollegeList {
	static int[] count = new int[5];
	static String[][] studentsList = new String[5][4];

	int MLV(String name) {

		if (count[0] < 4) {// check for seat if available or not
			studentsList[0][(count[0])] = name;
			count[0]++;
			System.out.println(name + "was alloted");
			return 1;// if alloted
		} else {
			System.out.println("Seats Full");
			return 0;// if not alloted
		}
	}

	int MIT(String name) {
		if (count[1] < 4) {// check for seat if available or not
			studentsList[1][(count[1])] = name;
			count[1] = count[1] + 1;
			System.out.println(name + "was alloted");
			return 1;// if alloted
		} else {
			System.out.println("Seats Full");
			return 0;// if not alloted
		}
	}

	int JCERC(String name) {
		if (count[2] < 4) {// check for seat if available or not
			studentsList[2][(count[2])] = name;
			count[2] = count[2] + 1;
			System.out.println(name + "was alloted");
			return 1;// if alloted
		} else {
			System.out.println("Seats Full");
			return 0;// if not alloted
		}
	}

	int ARYA(String name) {
		if (count[3] < 4) {// check for seat if available or not
			studentsList[3][(count[3])] = name;
			count[3] = count[3] + 1;
			System.out.println(name + "was alloted");
			return 1;// if alloted
		} else {
			System.out.println("Seats Full");
			return 0;// if not alloted
		}
	}

	int TINJR(String name) {
		if (count[4] < 4) {// check for seat if available or not
			studentsList[4][(count[4])] = name;
			count[4] = count[4] + 1;
			System.out.println(name + "was alloted");
			return 1;// if alloted
		} else {
			System.out.println("Seats Full");
			return 0;// if not alloted
		}

	}

}
