package pamplonaFX;

public class Coordinate {
		int row;
		int col;
		char c;
		
		public Coordinate(int rowIn, int colIn, char cIn){
			row = rowIn;
			col = colIn;
			c = cIn; 
		}
		
		public char getC() {
			return c;
		}

		public void setC(char c) {
			this.c = c;
		}
		
		public int getRow(){
			return row;
		}
		
		public int getCol(){
			return col;		
		}
}
