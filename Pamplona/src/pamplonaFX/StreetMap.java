package pamplonaFX;

import java.util.Random;

public class StreetMap {
	private Coordinate[][] coords;
	private int size = 10;

	public void setStreetMap() {
		coords = new Coordinate[size][size];
		for (int row = 0; row < size; row++)
			for (int col = 0; col < size; col++){

				if (row == 0 && col == 0){
					coords[row][col].setC('S');
				}
				if (row == size && col == size){
					coords[row][col].setC('E');
				}
				else if (row == 0 || row == size || col == 0 || col == size){
					coords[row][col].setC('W');
				}
				else{
					Random r = new Random();
					int temp = r.nextInt(10 - 1 + 1) + 1;
					
					if (temp <= 8){
						coords[row][col].setC(' ');
					} else {
						coords[row][col].setC('W');
					}
				}
		
			}
	}
}
