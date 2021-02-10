package gui;

import java.util.Stack;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import tictactoeFX.Coordinate;
import tictactoeFX.Game;
import tictactoeFX.Game.Turn;

public class TicTacToePane extends GridPane {
	Stack <MoveImpl> ogStack = new Stack<MoveImpl>(); //I need to push all moves onto this stack
	Stack <MoveImpl> undoStack = new Stack<MoveImpl>();
	Label[][] labels;
	Game g;

	public void startGame() {
		setUpLabels();
		g = new Game();
	}

	private void setUpLabels() {
		labels = new Label[3][3];

		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++) {
				Label l = new Label();
				setUpLabel(l, row, col);
				labels[row][col] = l;
				add(l, col, row);
			}
	}

	private void setUpLabel(final Label l, final int row, final int col) {
		l.setPrefHeight(75);
		l.setPrefWidth(75);

		if (row < 2) {
			if (col > 0)
				l.getStyleClass().add("leftAndBottomBorder");
			else
				l.getStyleClass().add("bottomBorder");
		} else if (col > 0)
			l.getStyleClass().add("leftBorder");
		l.setOnMouseClicked(new EventHandler<InputEvent>() {
			@Override
			public void handle(InputEvent arg0) {
				
				if (!g.gameOver() && g.getTurn() == Turn.X) {
					if (g.makePlayerMove(row, col))
						l.setText("X");
					MoveImpl move = new MoveImpl(row, col, Turn.X);
					ogStack.add(move);
									
				}
				if (!g.gameOver() && g.getTurn() == Turn.O) {
					Coordinate c = g.makeAutoMove();
//					ogStack.add(c);
					labels[c.getRow()][c.getCol()].setText("O");
					
				}
				if (g.gameOver()) {
					if (g.getVictoryExists()) {
						Coordinate[] victoryCoords = g.getVictoryCoords();
						for (Coordinate c : victoryCoords)
							labels[c.getRow()][c.getCol()].getStyleClass().add("victory");
					}
				}
			}
		});
	}
	
	

	
}
