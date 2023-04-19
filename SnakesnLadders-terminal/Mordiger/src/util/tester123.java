package util;

import entity.database.Shortcut;

public class tester123 {
	
	public static void main(String[] args) {
		
		ShortcutDAO dao = new ShortcutDAO();
		Shortcut s = dao.shortcutAt(16);
		
		System.out.println(s.getFrom() + " " + s.getTo());
		
	}

}
