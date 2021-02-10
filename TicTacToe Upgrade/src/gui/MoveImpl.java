package gui;

import tictactoeFX.Coordinate;
import tictactoeFX.Game;
import tictactoeFX.Game.Turn;

public class MoveImpl implements Move {
	Turn t; 
	int row;
	int col;
	
	public MoveImpl(int rowIn, int colIn, Turn t) {
		row = rowIn;
		col = colIn;
		this.t = t;
	}

	@Override
	public int getRow() {
		return row;
	}

	@Override
	public int getCol() {
		return col;
	}

	@Override
	public Turn getPlayer() {

		return t;
	}
	

}
