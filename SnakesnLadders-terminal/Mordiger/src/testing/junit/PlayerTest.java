package testing.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entity.Player;

public class PlayerTest {
	
	/* TestData */
	private Player playerValid1, playerValid2, playerNotValid1, playerNotValid2;
	
	@BeforeEach()
	public void setup() {
		playerValid1 = new Player(1);
		playerValid2 = new Player(3);
		playerNotValid1 = new Player(0);
		playerNotValid2 = new Player(5);
	}
	
	/*
	 * Tester
	 */

	@Test
	public void testGetID() {
		Player playerID = new Player(1);
		
		assertEquals("ID doesn´t match", playerID.getID(), playerValid1.getID());
	}
	
	@Test
	public void testSetID() {
		Player playerID = new Player(2);
		
		playerValid2.setID(2);
		
		assertEquals("ID doesn´t match", playerID.getID(), playerValid2.getID());	
	}
	
	@Test
	public void testGetboardPlacement() {
		Player player1 = new Player(3);
		Integer placement = 1;
		
		assertEquals("Not the right placement", player1.getBoardPlacement(), placement);
	}
	
	@Test
	public void testSetboardPlacement() {
		Player player2 = new Player(4);
		Integer placement = 4;
		
		player2.setBoardPlacement(4);
		
		assertEquals("Not the right placement", player2.getBoardPlacement(), placement);
		
	}
	
}
