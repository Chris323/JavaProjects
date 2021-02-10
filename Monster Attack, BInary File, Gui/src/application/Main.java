package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import gui.MenuGUI;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			MenuGUI root = new MenuGUI();
			
			Scene scene = new Scene(root,500,100);
			scene.getStylesheets().add("application/application.css");
			primaryStage.setTitle("Damn Monsters");
			primaryStage.setScene(scene);
			primaryStage.show();
			root.startMenu();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
