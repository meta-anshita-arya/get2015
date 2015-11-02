import java.util.Scanner;

/**
 * @author Anshita
 *
 */
public class GameInterface {

	public static void main(String[] args) {
		char mainChoice;
		Game game = null;
		do {
			//Menu
			MenuClass.menuForCricketTemplate();
			// taking input
			int overs = Utility.checkingInteger();
			System.out.println("Enter No of Teams");
			int noOfTeams = Utility.checkingInteger();
			System.out.println("Enter No Of players");
			int noOfPlayers = Utility.checkingInteger();

			switch (overs) {
			case 50:
				game = new OneDay();
				game.play(noOfTeams, noOfPlayers);
				break;
			case 20:
				game = new TwentyTwenty();
				game.play(noOfTeams, noOfPlayers);
				break;
			case 450:
				game = new Test();
				game.play(noOfTeams, noOfPlayers);
				break;
			default:
				System.out.println("Enter Correct format: Overs should be as specified,"
						+ " Team should be 2 and players in each team should be 11. ");
			}

			mainChoice = Utility.checkingString();
		} while (mainChoice == 'Y');

	}
}
