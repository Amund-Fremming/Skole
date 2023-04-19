package interfaces;

/**
 * Object variables: Integer from, Integer to.
 * The Constructor has to parameters(Integer from, Integer to)
 * and sets the parameters to their object variables.
 * 
 * @author AndrewTate
 *
 */

public interface ShortcutInterface {
	
	/**
	 * @return The number the shortcut starts.
	 */
	public Integer getFrom();
	
	/**
	 * @return The number the shortcut ends.
	 */
	public Integer getTo();
	
	/**
	 * @return true if the shortcut is a ladder, false if else
	 */
	public boolean isLadder();

}
