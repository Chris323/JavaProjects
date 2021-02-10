package gui;

import java.util.Random;

import fieldRunFX.PastureMap;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//import fieldRunFX.Coordinate;
//import fieldRunFX.Game;
//import fieldRunFX.Game.Turn;

public class PastureGUIPane extends BorderPane {
	protected Label[][] labels;
	GridPane newGP = new GridPane();
	Button b = new Button("Reset");
	PastureMap newGame = new PastureMap();
	Random newNum = new Random();
//	Game newGame;

	public void startGame() {
		setUpLabels();
		this.setCenter(newGP);
		this.setBottom(b);
		buttonSetUp();
		borderSetUpA();
		borderSetUpB();
		pastureSetUp();
	}
	
	public void buttonSetUp(){
		
		b.setMinWidth(150);
		b.getStyleClass().add("button");
		EventHandler<Event> handler = new resetClick<Event>();
		b.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		
	}
	
	private class resetClick<ActionEvent> implements EventHandler <Event>{
		@Override
		public void handle(Event event) {
//			System.out.println("hello");
			pastureSetUp();
		}
	}


	public void borderSetUpA() {

		int row = 0;
		for (int col = 0; col < 22; col++) {

			if (row == 0 && col == 1) {
				labels[0][1].getStyleClass().add("start");
				newGame.pastureMapInput(0, 1, "start");

			}

			else {
				labels[row][col].getStyleClass().add("fence");
				newGame.pastureMapInput(row, col, "fence");
			}
		}

		row = 26;
		for (int col = 0; col < 22; col++) {
		
			if (row == 26 && col == 20) {
				labels[26][20].getStyleClass().add("exit");
				newGame.pastureMapInput(26, 20, "exit");

			}

			else {
				labels[row][col].getStyleClass().add("fence");
				newGame.pastureMapInput(row, col, "fence");
			}
		}

	}

	public void borderSetUpB() {
		
		int col = 0;
		for (int row = 0; row < 27; row++) {

			labels[row][col].getStyleClass().add("fence");
			newGame.pastureMapInput(row, col, "fence");
		}

		col = 21;
		for (int row = 0; row < 27; row++) {

			labels[row][col].getStyleClass().add("fence");
			newGame.pastureMapInput(row, col, "fence");
		}
	}
	
	public void pastureSetUp() {
		
		
		for (int row = 1; row < 26; row++)
			for (int col = 1; col < 21; col++) {
			
				double  rand = newNum.nextDouble();
				
			if (rand < .16) {	
				labels[row][col].getStyleClass().clear();
				labels[row][col].getStyleClass().add("fence");
				newGame.pastureMapInput(row, col, "fence");
			}
			
			else if (rand > .15 && rand < .17) {
				labels[row][col].getStyleClass().clear();
				labels[row][col].getStyleClass().add("cow");
				newGame.pastureMapInput(row, col, "cow");
			}
			
			else {
				labels[row][col].getStyleClass().clear();
				labels[row][col].getStyleClass().add("pasture");
				newGame.pastureMapInput(row, col, "pasture");
			}
			}
	}

	public void setUpLabels() {
		labels = new Label[27][22];

		for (int row = 0; row < 27; row++)
			for (int col = 0; col < 22; col++) {
				
				Label newLabel = new Label();
				
				setUpLabel(newLabel, row, col);
				labels[row][col] = newLabel;
				newGP.add(newLabel, col, row);
	
//				newLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
//				
//
//					@Override
//					public void handle(Event event) {
//						
//						if (event.equalsIgnoreCase("fence")) {
//							
//						}
//								
//							}
//						
//				});
	}
}
			
		
	
//	private class toggleClick<ActionEvent> implements EventHandler <Event>{
//		@Override
//		public void handle(Event event) {
//			
//				Label clicked = (Label) event.getSource();
//				
//				if (clicked.equalsIgnoreCase("fence"))
//						
//					}
//					
//}

	public void setUpLabel(final Label newLabelIn, final int row, final int col) {
		newLabelIn.setPrefHeight(50);
		newLabelIn.setPrefWidth(50);


	}

}

