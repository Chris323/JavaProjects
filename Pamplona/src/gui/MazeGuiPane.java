package gui;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.GridPane;
import pamplonaFX.Coordinate;
import pamplonaFX.Game;
import tictactoeFX.Game.Turn;

public class MazeGuiPane extends GridPane {
	Label[][] labels;
	Game g;
	private int size = 10;
	public void startGame() {
		setUpLabels();
		g = new Game();
	}
	
	private void setUpLabels() {
		labels = new Label[size][size];

		for (int row = 0; row < size; row++)
			for (int col = 0; col < size; col++) {
				Label l = new Label();
				setUpLabel(l, row, col);
				labels[row][col] = l;
				add(l, col, row);
				l.setText(getC);
			}
	}

	private void setUpLabel(final Label l, final int row, final int col) {
		l.setPrefHeight(75);
		l.setPrefWidth(75);
		
		
	}
}	
