package Assignment2;

/**
 * @author Anshita
 *
 */
public class Test  extends Game
{
	/* To end Game
	 * (non-Javadoc)
	 * @see Assignment2.Game#endPlay()
	 */
	@Override
	void endPlay() 
	{
		System.out.println("Team B was not able to chase the run so match was Drawn");
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
