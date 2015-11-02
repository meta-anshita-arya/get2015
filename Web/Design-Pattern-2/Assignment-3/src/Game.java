/**
 * @author Anshita
 *
 */
public abstract class Game
{
	/**
	 * @param noOfTeams :no of teams
	 * @param noOfPlayers :no of players
	 * @return :return true if teams and players are valid 
	 */
	boolean initialize(int noOfTeams, int noOfPlayers) 
	{
		boolean flag =false;
		if (noOfTeams != 2) {//if no of teams not equal to 2 then game cannot start
			System.out.println("Not sufficient teams.(Hint:There should be 2 teams)");
		}
		if (noOfPlayers != 11) {//if no of players not equal to 11 then game cannot start
			System.out.println("Not sufficient members in the team.(Hint:There should be 11 team members)");
		} 
		else if((noOfTeams == 2)&&(noOfPlayers == 11)) {//if no of teams equal to 2 and no of players equal to 11 then start game
			System.out.println("Game is ready to start.\n");
			flag= true;
		}
			
		return flag;
	
	}

	
	/**
	 * abstract method start play to implement in child class
	 */
	abstract void startPlay();
	
	/**
	 * abstract method end play to implement in child class
	 */
	abstract void endPlay();

	
	/**template method
	 * @param noOfTeams :No of teams
	 * @param noOfPlayers :No of players
	 */
	public final void play(int noOfTeams, int noOfPlayers){

		//initialize the game
		if(initialize(noOfTeams, noOfPlayers))//checking if players and team are valid or not
		{
			//start game
			startPlay();
	
			//end game
			endPlay();
		}
	}
}






