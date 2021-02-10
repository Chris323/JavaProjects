package fieldRunFX;

public class Coordinate {
	int row;
	int col;
	char a;
	
	public Coordinate(int rowIn, int colIn) {
		row = rowIn;
		col = colIn;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public char getA() {
		return a;
	}

	public void setA(char a) {
		this.a = a;
	}

}
