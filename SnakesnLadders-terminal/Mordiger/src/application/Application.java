package application;

import java.util.Scanner;

import entity.Game;

public class Application {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many players? (2-4)");
		String reply = scanner.nextLine();
		
		int players = 2;
		try {
			players = Integer.parseInt(reply);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(players < 2 || players > 4)
				players = 2;
		}
		
		Game game = new Game(players);
		System.out.println("GAME STARTS!");
		
		while(!game.finishedGame()) {
			
			System.out.println("To roll dice hit enter: ");
			scanner.nextLine();
			game.rollDice();
			
		}
		
		
		
		
		
	}
	
}
