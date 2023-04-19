package interfaces;
/**
 * The dice class contains one object variable:
 * 		Integer diceNumber
 * 
 * The class needs an instructor that sets the DiceNumber variable to 0
 * 
 * @author AdrianBerget
 *
 */

public interface DiceInterface {
	
	/**
	 * @return The current value of the dice
	 */
	
	public Integer getDiceNumber();
	
	/**
	 * @return The value of the dice throw
	 */
	
	public Integer rollDice();

}
