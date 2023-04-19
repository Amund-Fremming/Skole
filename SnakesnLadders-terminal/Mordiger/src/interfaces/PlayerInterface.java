package interfaces;
/**
 * The Player class will have two object variables;
 * 		Integer ID
 * 		Integer boardPlacement
 * 
 * The Player class have a constructor with a parameter Integer ID,
 * and set the boardPlacement object variable to 1 as this is the place
 * where the players will start.
 * 
 * @author AmundFremming
 *
 */

public interface PlayerInterface {
	
	/**
	 * @return	The player ID.
	 */
	public Integer getID();
	
	/**
	 * @param ID  Sets the players ID.
	 */
	public void setID(Integer ID);
	
	/**
	 * @return  The players board placement.
	 */
	public Integer getBoardPlacement();
	
	/**
	 * @param boardPlacement  Sets the board placement
	 */
	public void setBoardPlacement(Integer boardPlacement);


}
