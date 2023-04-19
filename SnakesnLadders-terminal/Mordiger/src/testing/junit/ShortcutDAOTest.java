package testing.junit;

/*
 * This test class will also test that all data in the database is correct
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entity.database.Shortcut;
import util.ShortcutDAO;

public class ShortcutDAOTest {
	
	/* TestData */
	private ShortcutDAO dao;
	
	@BeforeEach()
	public void setup() {
		dao = new ShortcutDAO();
	}
	
	@Test
	@DisplayName("Checks if the queries return a Shortcut object, with no NULL values")
	public void testQueries() {
		
	}
	
	@Test
	@DisplayName("Tests that shortcut 16 query is correct")
	public void testGetSnake16() {
		Shortcut shortcut = dao.shortcutAt(16);
		assertTrue(shortcut != null && shortcut.getTo() == 4 && !shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that snake 49 query is correct")
	public void testGetSnake49() {
		Shortcut shortcut = dao.shortcutAt(49);
		assertTrue(shortcut != null && shortcut.getTo() == 11 && !shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that snake 62 query is correct")
	public void testGetSnake62() {
		Shortcut shortcut = dao.shortcutAt(62);
		assertTrue(shortcut != null && shortcut.getTo() == 18 && !shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that snake 87 query is correct")
	public void testGetSnake87() {
		Shortcut shortcut = dao.shortcutAt(87);
		assertTrue(shortcut != null && shortcut.getTo() == 24 && !shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that snake 47 query is correct")
	public void testGetSnake47() {
		Shortcut shortcut = dao.shortcutAt(47);
		assertTrue(shortcut != null && shortcut.getTo() == 26 && !shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that snake 56 query is correct")
	public void testGetSnake56() {
		Shortcut shortcut = dao.shortcutAt(56);
		assertTrue(shortcut != null && shortcut.getTo() == 53 && !shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that snake 64 query is correct")
	public void testGetSnake64() {
		Shortcut shortcut = dao.shortcutAt(64);
		assertTrue(shortcut != null && shortcut.getTo() == 60 && !shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that snake 92 query is correct")
	public void testGetSnake92() {
		Shortcut shortcut = dao.shortcutAt(92);
		assertTrue(shortcut != null && shortcut.getTo() == 71 && !shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that snake 95 query is correct")
	public void testGetSnake95() {
		Shortcut shortcut = dao.shortcutAt(95);
		assertTrue(shortcut != null && shortcut.getTo() == 75 && !shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that snake 98 query is correct")
	public void testGetSnake98() {
		Shortcut shortcut = dao.shortcutAt(98);
		assertTrue(shortcut != null && shortcut.getTo() == 78 && !shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that ladder 2 query is correct")
	public void testGetLadder2() {
		Shortcut shortcut = dao.shortcutAt(2);
		assertTrue(shortcut != null && shortcut.getTo() == 38 && shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that ladder 4 query is correct")
	public void testGetLadder4() {
		Shortcut shortcut = dao.shortcutAt(4);
		assertTrue(shortcut != null && shortcut.getTo() == 14 && shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that ladder 8 query is correct")
	public void testGetLadder8() {
		Shortcut shortcut = dao.shortcutAt(8);
		assertTrue(shortcut != null && shortcut.getTo() == 31 && shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that ladder 21 query is correct")
	public void testGetLadder21() {
		Shortcut shortcut = dao.shortcutAt(21);
		assertTrue(shortcut != null && shortcut.getTo() == 42 && shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that ladder 28 query is correct")
	public void testGetLadder28() {
		Shortcut shortcut = dao.shortcutAt(28);
		assertTrue(shortcut != null && shortcut.getTo() == 84 && shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that ladder 36 query is correct")
	public void testGetLadder36() {
		Shortcut shortcut = dao.shortcutAt(36);
		assertTrue(shortcut != null && shortcut.getTo() == 44 && shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that ladder 51 query is correct")
	public void testGetLadder51() {
		Shortcut shortcut = dao.shortcutAt(51);
		assertTrue(shortcut != null && shortcut.getTo() == 67 && shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that ladder 71 query is correct")
	public void testGetLadder71() {
		Shortcut shortcut = dao.shortcutAt(71);
		assertTrue(shortcut != null && shortcut.getTo() == 91 && shortcut.isLadder());
	}
	
	@Test
	@DisplayName("Tests that ladder 80 query is correct")
	public void testGetLadder() {
		Shortcut shortcut = dao.shortcutAt(80);
		assertTrue(shortcut != null && shortcut.getTo() == 100 && shortcut.isLadder());
	}
	
	
}
