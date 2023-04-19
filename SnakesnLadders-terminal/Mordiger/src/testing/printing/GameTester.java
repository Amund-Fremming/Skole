package testing.printing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import entity.Game;

public class GameTester {
	
	public static void main(String[] args) throws IOException {
		
		Game game = new Game(4);
		// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			if(game.finishedGame()) {
				String s = JOptionPane.showInputDialog("hei");
				game = new Game(4);
			}
			game.rollDice();
			
		}
		
	}

}
