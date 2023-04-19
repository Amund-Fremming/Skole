package oblig2.web.util;

/**
 * Utility class for validating input from user for safety.
 * 
 * @author AmundFremming
 *
 */

public class ValidatorUtil {
	
	// TODO regex
	private final static String VALID_TEXT = "^[a-zA-Z ]*$";
	private final static String VALID_NUMBERS = "\\d+";
	private final static String VALID_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
	private final static String VALID_REGNR = "^[A-Z]{2}[0-9]{5}$";
	private final static String VALID_STREETADDRESS = "^[a-zA-Z0-9 ]+$";
	// END
	
	/**
	 * @return True if text is valid, false if not
	 */
	public static boolean validateTextOnly(String text) {
		
		if (text.matches(VALID_TEXT)) {
			return true;
		}
		
		return false; 
	}
	
	/**
	 * @return True if number is valid, false if not
	 */
	public static boolean validateNumbersOnly(String number) {
		
		if (number.matches(VALID_NUMBERS)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * @return True if password is valid, false if not
	 */
	public static boolean validatePassword(String password) {
		
		// TODO
		// return true;
		
		if (password.matches(VALID_PASSWORD)) {
			return true;
		}
		
		return false;
	}

	/**
	 * @return True if RegNr is valid, false if not
	 */
	public static boolean validateRegnr(String regNr) {
		
		if (regNr.matches(VALID_REGNR)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * @return True if Street address is valid, false if not
	 */
	public static boolean validateStreetAdr(String address) {
		
		if (address.matches(VALID_STREETADDRESS)) {
			return true;
		}
		
		return false;
	}

}
