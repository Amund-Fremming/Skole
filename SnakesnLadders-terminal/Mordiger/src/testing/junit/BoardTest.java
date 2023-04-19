package testing.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entity.Board;
import entity.Player;

public class BoardTest {
	
	/* TestData */
	private Board board;
	private Player player1, player2, player3, player4;
	private Queue<Player> gameQueue;
	private int[][] matrix;
	
	@BeforeEach
	public void setup() {
		gameQueue = new LinkedBlockingQueue<Player>();
		
		player1 = new Player(1);
		player2 = new Player(2);
		player3 = new Player(3);
		player4 = new Player(4);
		
		gameQueue.add(player1);
		gameQueue.add(player2);
		gameQueue.add(player3);
		gameQueue.add(player4);	
		
		board = new Board(gameQueue);
		matrix = board.getMatrix();
	}
	
	@Test
	@DisplayName("Tests if the board is empty")
	public void testClearBoard() {
		board.clearBoard();
		for(int i = 0; i < matrix.length; i++) {
			
			for(int j = 0; j < matrix[i].length; j++) {
				
				assertTrue(matrix[i][j] == 0);
				
			}
			
		}
		
	}
	
	@Test
	@DisplayName("Tests if the board updates correctly after moves")
	public void testUpdateBoard() {
		
		player1.setBoardPlacement(10);
		player2.setBoardPlacement(22);
		player3.setBoardPlacement(30);
		player3.setBoardPlacement(40);
		
		board.updateBoard();
		
		board.printBoard();
		
		board.getIndexFromPosition(player1.getBoardPlacement());
		
		assertTrue(matrix[9][9] == 1);
		assertTrue(matrix[8][1] == 2);
		assertTrue(matrix[7][9] == 3);
		assertTrue(matrix[6][0] == 4);
	}
	
	
	
	
	
	

}
