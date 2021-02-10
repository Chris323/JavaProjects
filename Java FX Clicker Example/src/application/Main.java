package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Main extends Application {
	private int numClicked;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane bp = new BorderPane();
		bp.getStyleClass().add("grid");

		GridPane gp = new GridPane();

		Label clickedLabel = new Label("Buttons Clicked: ");
		clickedLabel.getStyleClass().add("clickedLabel");
		Label numClickedLabel = new Label("0");
		numClickedLabel.getStyleClass().add("clickedLabel");

		HBox clickedCounterBox = new HBox();
		clickedCounterBox.getStyleClass().add("clickedBox");
		clickedCounterBox.getChildren().add(clickedLabel);
		clickedCounterBox.getChildren().add(numClickedLabel);

		Scene sc = new Scene(bp);
		sc.getStylesheets().add("styles/style.css");

		numClicked = 0;

		for (int rowCounter = 0; rowCounter < 10; rowCounter++)
			for (int colCounter = 0; colCounter < 10; colCounter++) {

				Button b = new Button("Unclicked");
				b.setMinWidth(150);
				b.getStyleClass().add("button");
				b.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
					
					Boolean clicked = false;

					@Override
					public void handle(Event event) {
						if (clicked == true) {
							clicked = false;
							b.setText("Unclicked");
							numClicked--;
						} else {
							clicked = true;
							b.setText("Clicked");
							numClicked++;
						}
						numClickedLabel.setText(String.valueOf(numClicked));
					}
				});
				gp.add(b, colCounter, rowCounter);
			}
		bp.setTop(clickedCounterBox);
		bp.setBottom(gp);

		primaryStage.setScene(sc);
		primaryStage.show();
	}
	public static void main(String[] args){
		Application.launch(args);
	}

}

