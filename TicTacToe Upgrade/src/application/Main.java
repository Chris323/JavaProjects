package application;
	

import java.util.Stack;

import gui.MoveImpl;
import gui.TicTacToePane;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			
			BorderPane bp = new BorderPane();
			HBox hbox = new HBox();
			
			
//			MoveImpl move = new MoveImpl(0, 0, null);
			
			Button undo = new Button("Undo");
			undo.setPrefWidth(110);
			undo.setMaxHeight(20);
			undo.getStyleClass().add("button");
	
//			EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
//					   
//					   @Override 
//					   public void handle(MouseEvent e) { 
//					    if (!ogStack.isEmpty()) {
//					    	
//					    }
//					      
//					   } 
//					}; 
//					
//			undo.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
				
			Button redo = new Button("Redo");
			redo.setPrefWidth(110);
			redo.setMaxHeight(20);
			redo.getStyleClass().add("button");
						
//			EventHandler<MouseEvent> eventHandlers = new EventHandler<MouseEvent>() { 
//					   
//					   @Override 
//					   public void handle(MouseEvent e) { 
////					      System.out.println("Hello World"); 
//						   undoStack.pop();
//						   ogStack.push(move);
//						   
//					   } 
//					}; 
//					
//			redo.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandlers);
			
			hbox.getChildren().add(undo);
			hbox.getChildren().add(redo);			
			
			TicTacToePane root = new TicTacToePane();
			bp.setCenter(root);
			bp.setTop(hbox);
			
			Scene scene = new Scene(bp,220,310);
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