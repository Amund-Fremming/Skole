package oblig2.web.util;

import javax.servlet.http.HttpSession;

import oblig2.web.entities.Userr;

/**
 * Utility class for controlling the user in the current session
 * 
 * @author haraldnilsen
 *
 */
public class LoginUtil {

    /**
     * Checks if the user in the current session is logged in
     * 
     * @param session: current session
     * @return true if logged in, false otherwise
     */
    public static boolean isLoggedIn(HttpSession session) {
        return session != null && session.getAttribute("user") != null;
    }
    
    /**
     * Logs in the user given as param to the current session
     * 
     * @param userr
     * @return true if successful login, false otherwise
     */ 
    public static void logIn(Userr userr, HttpSession session) {
        
        session.setAttribute("user", userr);
    }
    
    
    /**
     * Logs out the user from the current session
     */
    public static void logOut(HttpSession session) {
        session.invalidate();
    }
    
    
}