package interfaces;

import entity.database.Shortcut;

/**
 * This class have one object variable EntityManagerFactory emf.
 * The constructor has no parameters and only instantiates the emf.
 * 
 * The snakes of this board will be: 
 * 1: from 16 to 4, 
 * 2: from 49 to 11, 
 * 3: from 62 to 18, 
 * 4: from 87 to 24, 
 * 5: from 47 to 26, 
 * 6: from 56 to 53, 
 * 7: from 64 to 60, 
 * 8: from 92 to 71, 
 * 9: from 95 to 75, 
 * 10: from 98 to 78,
 * 
 * The ladder of this board will be: 
 * 1: from 2 to 38, 
 * 2: from 4 to 14,
 * 3: from 8 to 31,
 * 4: from 21 to 42, 
 * 5: from 28 to 84, 
 * 6: from 36 to 44, 
 * 7: from 51 to 67. 
 * 8: from 71 to 91, 
 * 9: from 80 to 100
 * 
 * Snakes will be represented with false, and ladders with true
 * 
 * @author AmundFremming
 *
 */

public interface ShortcutDAOInterface {

	/**
	 * Makes a query to the database with the players board placement as an argument.
	 * If a shortcut starts from the players placement a Shortcut Object will be returned,
	 * if no match the method returns NULL.
	 * 
	 * @param boardPlacement
	 * @return Shortcut
	 */
	public Shortcut shortcutAt(Integer boardPlacement);
	
	
}
