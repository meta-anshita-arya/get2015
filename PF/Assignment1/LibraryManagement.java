package ass1;

import java.sql.SQLException;
import java.util.List;

public class LibraryManagement {

	public static void main(String[] args) throws SQLException {
		int choice;
		char mainChoice;

		MenuClass menuClass = new MenuClass();
		Utility utility = new Utility();
		LibraryHelperClass libraryHelperClass = new LibraryHelperClass();
		do {
			menuClass.menuForLibraryManagement();
			// Taking choice
			choice = utility.checkingChoice();
			switch (choice) {
			case 1:
				List<Title> titleList = libraryHelperClass
						.getBooksDataRelatedToAuthor();

				if (titleList.size() != 0) {
					System.out.println("List of Books:");
					for (Title title : titleList) {
						System.out.println(title.getTitleName());
					}
				} else {
					System.out.println("No Book Purchased of this author");
				}

				break;
			case 2:
				boolean flag = libraryHelperClass.addNewMemberAndIssueBook();
				if (flag == true) {
					System.out.println("Member inserted and book is issued");
				} else {
					System.out.println("Book Doesn't Exist ");
				}
				break;
			case 3:
				int numberOfBooks = libraryHelperClass
						.getNumberOfBooksNotUseful();

				System.out.println("Number of Books not used since one year :"
						+ numberOfBooks);
				break;
			default:
				System.out.println("Enter correct choice");
			}
			mainChoice = utility.checkingString();
		} while (mainChoice == 'Y');
		libraryHelperClass.getConnection().close();
	}
}
