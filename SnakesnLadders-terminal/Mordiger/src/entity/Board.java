package entity;

import java.util.Queue;

import interfaces.BoardInterface;

public class Board implements BoardInterface {

	//
	private Queue<Player> gameQueue;
	private int[][] matrix;

	public Board(Queue<Player> gameQueue) {
		this.gameQueue = gameQueue;
		matrix = new int[10][10];
	}

	@Override
	public void printBoard() {
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("[");

			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 0)
					System.out.print("[ ]");
				else
					System.out.print(String.format("[%d]", matrix[i][j]));
			}

			System.out.println("]");

		}
	}

	@Override
	public void clearBoard() {
		matrix = new int[10][10];

	}

	@Override
	public void updateBoard() {
		clearBoard();
		for (Player player: gameQueue) {
			String position = getIndexFromPosition(player.getBoardPlacement());
			int row = Character.getNumericValue(position.charAt(0));
			int column = Character.getNumericValue(position.charAt(1));
			matrix[row][column] = player.getID();
		}

	}

	public Queue<Player> getGameQueue() {
		return gameQueue;
	}

	public void setGameQueue(Queue<Player> gameQueue) {
		this.gameQueue = gameQueue;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	@Override
	public int getValueAtIndex(int row, int column) {
		if (!(row >= 0 && row <= 9) && !(column >= 0 && column <=9)) {
			throw new IllegalArgumentException("Row and column must be between 0 and 9");
		} else {
			return matrix[row][column];
		}
	}

	@Override
	public String getIndexFromPosition(int pos) {
		int row = 0;
		int column = 0;

		// checks row (if number is round -> subtract 1)
		if (pos % 10 == 0) {
			row = 10 - (pos / 10);
		} else {
			row = 9 - (pos / 10);
		}

		// If the row order is reversed (counted from the right)
		if ((pos >= 11 && pos <=20) || (pos >= 31 && pos <=40) || (pos >= 51 && pos <=60) || (pos >= 71 && pos <=80) || (pos >= 91 && pos <=100)) {
			// if the position is a round number (col placed at the beginning)
			if ((pos % 10) - 1 == -1) {
				column = 0;
			} else {
				column = 10 - (pos % 10);
			}

		} else {
			// if the position is a round number (col placed at the end)
			if ((pos % 10) - 1 == -1) {
				column = 9;
			} else {
				column = (pos % 10) - 1;
			}
		}

		String resultat = String.format("%d%d", row, column);
		return resultat;
	}

}
