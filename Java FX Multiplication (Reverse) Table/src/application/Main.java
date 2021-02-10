package application;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;




public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane borderP = new BorderPane();
		borderP.getStyleClass().add("grid");
		
		GridPane gridP = new GridPane();
		
		Label answerInputTitle = new Label("Enter Answer ");
		answerInputTitle.getStyleClass().add("answerLabel");
		
		Button b = new Button("Calculate");
//		b.setMinWidth(150);
//		b.getStyleClass().add("button");
		
		HBox answerInputBox = new HBox();
		answerInputBox.getStyleClass().add("answerBox");
		answerInputBox.getChildren().add(answerInputTitle);
		answerInputBox.getChildren().add(b);
		
		Scene sceneNew = new Scene(borderP);
		sceneNew.getStylesheets().add("application/application.css");
	
	for (int rowCounter = 0; rowCounter < 10; rowCounter++)
		for (int colCounter = 0; colCounter < 10; colCounter++) {
			
			Label newLabel = new Label("problems");
			
				
		
			gridP.add(newLabel, colCounter, rowCounter);
		}
	
	borderP.setTop(answerInputBox);
	borderP.setBottom(gridP);

	primaryStage.setScene(sceneNew);
	primaryStage.show();
			
		}
		
	
	public static void main(String[] args) {
		launch(args);
	}
}
