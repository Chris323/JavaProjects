package fieldRunFX;

import java.util.Random;

import gui.PastureGUIPane;
import javafx.scene.control.Label;

public class PastureMap {
	
	Coordinate[][] coords;
	
	public PastureMap() {
		setUpLabels();
	}
	
	public void pastureMapInput(int rowIn, int colIn, String styleIn){
		
		if (styleIn.equalsIgnoreCase("fence")){
			coords[rowIn][colIn].setA('F');
			
		}
		
		if (styleIn.equalsIgnoreCase("start")){
			coords[rowIn][colIn].setA('S');
			
		}
		
		if (styleIn.equalsIgnoreCase("pasture")){
			coords[rowIn][colIn].setA(' ');
			
		}
		
		if (styleIn.equalsIgnoreCase("exit")){
			coords[rowIn][colIn].setA('E');
			
		}
		
		if (styleIn.equalsIgnoreCase("cow")){
			coords[rowIn][colIn].setA('C');
			
		}
		
		if (styleIn.equalsIgnoreCase("dirt")){
			coords[rowIn][colIn].setA('D');
			
		}
		
		if (styleIn.equalsIgnoreCase("person")){
			coords[rowIn][colIn].setA('P');
			
		}
		
	}
	
	public void toggleBox() {
		
	}

	public void setUpLabels() {
		coords = new Coordinate[27][22];

		for (int row = 0; row < 27; row++)
			for (int col = 0; col < 22; col++) {
				Coordinate newCoords = new Coordinate(row, col);
				coords[row][col] = newCoords;

			}
	}
}


	

