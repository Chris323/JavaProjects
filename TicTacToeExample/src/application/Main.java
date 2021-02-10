package application;
	
import gui.TicTacToePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TicTacToePane root = new TicTacToePane();
			
			Scene scene = new Scene(root,200,200);
			scene.getStylesheets().add("application/application.css");
			primaryStage.setTitle("TicTacToe");
			primaryStage.setScene(scene);
			primaryStage.show();
			root.startGame();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
