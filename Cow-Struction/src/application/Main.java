package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import gui.PastureGUIPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			PastureGUIPane root = new PastureGUIPane();

			Scene scene = new Scene(root, 700, 700);
			scene.getStylesheets().add("application/application.css");
			primaryStage.setTitle("Cow-Struction");
			primaryStage.setScene(scene);
			primaryStage.show();
			root.startGame();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
