
package Assignment2;

/**
 * @author Anshita
 *
 */
public class OneDay extends Game
{
	/* To end Game
	 * (non-Javadoc)
	 * @see Assignment2.Game#endPlay()
	 */
	@Override
	void endPlay() 
	{
		System.out.println("Team B chased the Required  runs and won the Match");
		System.out.println("Cricket Game Finished!");
	}



	/* To start game
	 * (non-Javadoc)
	 * @see Assignment2.Game#startPlay()
	 */
	@Override
	void startPlay() {
		System.out.println("Toss performed. Team A won the toss.");
		System.out.println("Team A elected to bat first");
		System.out.println("Game is now starting.");
	}
}
