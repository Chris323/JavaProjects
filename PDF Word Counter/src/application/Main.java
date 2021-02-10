package application;
	
import gui.PdfWordChartPane;
import javafx.application.Application;
import javafx.stage.Stage;
import lab7.Reader;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Reader test  = new Reader();
			test.wordCounter(test.userFilePath());
			
			PdfWordChartPane root = new PdfWordChartPane();
			
			Scene scene = new Scene(root,500,500);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			root.start();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

// Sorry, I couldnt figure out how to correctly run JDK 8, I can only run it on JDK 10. Could possibly be the 
//reason why the values dont register on the chart, but not sure. 
