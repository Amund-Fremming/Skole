package testing.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entity.Dice;

public class DiceTest {
	
	/* TestData */
	private Dice dice;
	private final String VALID = "[1-6]{1}";
	
	@BeforeEach
	public void setup() {
		dice = new Dice();
	}
	
	@Test
	@DisplayName("Shold return a number betweeen 1-6")
	public void testRollDice() {
		
		for(int i = 0; i < 100; i++) {
			String num = dice.rollDice() + "";
			assertTrue(num.matches(VALID));	
		}
		
	}
	
	@Test
	@DisplayName("Should return the dice number")
	public void testGetDiceNumber() {
		
		for(int i = 0; i < 100; i++) {
			dice.rollDice();
			String num = dice.getDiceNumber() + "";
			assertTrue(num.matches(VALID));
		}
		
	}
	
	
	

}
