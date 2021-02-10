package tictactoeFX;

import solver.SolverImpl;
import solver.TicTacToeSolver;

public class Game {
	private TicTacToeSolver oPlayer;
	boolean victoryExists = false;

	public enum Turn {
		X, O
	};

	private Turn turn;
	private Character[][] board;

	public Game() {
		oPlayer = new SolverImpl();
		turn = Turn.X;
		board = new Character[3][3];
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				board[row][col] = ' ';
	}

	public boolean makePlayerMove(int row, int col) {
		if (board[row][col] == ' ') {
			board[row][col] = 'X';
			turn = Turn.O;
			return true;
		}
		return false;
	}

	public Coordinate makeAutoMove() {
		Coordinate oSquare = oPlayer.getMove('O', turn, board);
		int row = oSquare.getRow();
		int col = oSquare.getCol();
		board[row][col] = 'O';
		if (!oPlayer.checkForVictory('O', board)) {
			turn = Turn.X;
		}
		return oSquare;
	}

	public boolean boardFull() {
		for (int rowCounter = 0; rowCounter < board.length; rowCounter++)
			for (int colCounter = 0; colCounter < board[0].length; colCounter++)
				if (board[rowCounter][colCounter] == ' ')
					return false;
		return true;
	}

	public boolean gameOver() {
		if (oPlayer.checkForVictory('O', board) || oPlayer.checkForVictory('X', board)) {
			victoryExists = true;
			return true;
		}
		if (boardFull())
			return true;
		return false;

	}

	public boolean getVictoryExists() {
		return victoryExists;
	}

	public Coordinate[] getVictoryCoords() {
		return oPlayer.getVictoryCoords();
	}

	public Turn getTurn() {
		return turn;
	}
}
