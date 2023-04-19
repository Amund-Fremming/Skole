package interfaces;

/**
 * The Game class will have 5 object variables; 
 * 		boolean canRollAgain
 * 		Integer sixesRolled
 * 		LinkedList<Player> playerQueue
 * 		Dice dice
 * 		Board board
 * 
 * The Game class have a constructor with parameters; 
 * 		Dice dice, Board board, LinkedList<Player> playerQueue
 * The constructor sets the parameters to their object variables and instantiates
 * the other variables to default values.
 * 
 * @author AmundFremming
 *
 */

public interface GameInterface {
	
	/**
	 * Checks if the player has thrown dice number 6 three times in a row.
	 * 
	 * @return	True or false
	 */
	void backToStart();
	
	/**
	 * Iterates one time trough the queue, so the next player is first in the queue.
	 */
	void nextPlayer();
	
	/**
	 * Closes all processes and shuts down the application.
	 */
	public void exitGame();
	
	/**
	 * Creates a new instance of a game, and starts of the new game. 
	 */
	public void newGame();
	
	/**
	 * Checks if all players except one has finished
	 * 
	 * @return true if 1 player left, false if else
	 */
	public boolean finishedGame();
	
	/**
	 * Sets the object variable sixesRolled to 0 if a player throws the dice with a
	 * number thats not 6.
	 */
	public void clearSixesRolled();
	
	/**
	 * This method stands for all the functionallity in the game. It rolls the dice, and then
	 * moves the player accordingly. This method also cheks for ladders and snakes, and if the player
	 * can move to board placement 100.
	 */
	public void rollDice();
		
}
