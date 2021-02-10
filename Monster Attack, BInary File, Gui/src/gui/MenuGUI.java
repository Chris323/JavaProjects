package gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import monsterMonitor.AttackMonitor;

public class MenuGUI extends BorderPane {
	Button input = new Button("Input Attack");
	Button show = new Button("Show Attack");
	Button delete = new Button("Delete Attack");
	Button saveBin = new Button("Binary Save");
	Button readBin = new Button("Binary Read");
	Button saveTxt = new Button("Text Save");
	Button readTxt = new Button("Text Read");
	Button quit = new Button("Quit");
	GridPane newGP = new GridPane();
	AttackMonitor global = new AttackMonitor();
	

	public void startMenu() {
		this.setCenter(newGP);
		inputButtonSetUp();
		showButtonSetUp();
		deleteButtonSetUp();
		saveBinButtonSetUp();
		readBinButtonSetUp();
		saveTxtButtonSetUp();
		readTxtButtonSetUp();
		quitButtonSetUp();
		
	}



	public void inputButtonSetUp() {

		input.setMinWidth(150);
		input.getStyleClass().add("button");
		EventHandler<Event> handler = new inputClick<Event>();
		input.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		newGP.add(input, 0, 0, 1, 1);

	}

	private class inputClick<ActionEvent> implements EventHandler <Event>{
		@Override
		public void handle(Event event) {
			global.monitor(((Button)event.getSource()).getText());
	}

}
	public void showButtonSetUp() {

		show.setMinWidth(150);
		show.getStyleClass().add("button");
		EventHandler<Event> handler = new showClick<Event>();
		show.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		newGP.add(show, 1, 0, 1, 1);
	}

	private class showClick<ActionEvent> implements EventHandler <Event>{
		@Override
		public void handle(Event event) {
			global.monitor(((Button)event.getSource()).getText());
	}
}
	public void deleteButtonSetUp() {

		delete.setMinWidth(150);
		delete.getStyleClass().add("button");
		EventHandler<Event> handler = new deleteClick<Event>();
		delete.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		newGP.add(delete, 2, 0, 1, 1);
	}

	private class deleteClick<ActionEvent> implements EventHandler <Event>{
		@Override
		public void handle(Event event) {
			global.monitor(((Button)event.getSource()).getText());
	}
}
	public void saveBinButtonSetUp() {

		saveBin.setMinWidth(150);
		saveBin.getStyleClass().add("button");
		EventHandler<Event> handler = new saveBinClick<Event>();
		saveBin.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		newGP.add(saveBin, 0, 1, 1, 1);
	}

	private class saveBinClick<ActionEvent> implements EventHandler <Event>{
		@Override
		public void handle(Event event) {
			global.monitor(((Button)event.getSource()).getText());
	}
}
	public void readBinButtonSetUp() {

		readBin.setMinWidth(150);
		readBin.getStyleClass().add("button");
		EventHandler<Event> handler = new readBinClick<Event>();
		readBin.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		newGP.add(readBin, 1, 1, 1, 1);
	}

	private class readBinClick<ActionEvent> implements EventHandler <Event>{
		@Override
		public void handle(Event event) {
			global.monitor(((Button)event.getSource()).getText());
	}
}
	public void saveTxtButtonSetUp() {

		saveTxt.setMinWidth(150);
		saveTxt.getStyleClass().add("button");
		EventHandler<Event> handler = new saveTxtClick<Event>();
		saveTxt.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		newGP.add(saveTxt, 2, 1, 1, 1);
	}

	private class saveTxtClick<ActionEvent> implements EventHandler <Event>{
		@Override
		public void handle(Event event) {
			global.monitor(((Button)event.getSource()).getText());
	}
}
	public void readTxtButtonSetUp() {

		readTxt.setMinWidth(150);
		readTxt.getStyleClass().add("button");
		EventHandler<Event> handler = new readTxtClick<Event>();
		readTxt.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		newGP.add(readTxt, 0, 2, 1, 1);
	}

	private class readTxtClick<ActionEvent> implements EventHandler <Event>{
		@Override
		public void handle(Event event) {
			global.monitor(((Button)event.getSource()).getText());
	}
}
	public void quitButtonSetUp() {

		quit.setMinWidth(150);
		quit.getStyleClass().add("button");
		EventHandler<Event> handler = new quitClick<Event>();
		quit.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
		newGP.add(quit, 1, 2, 1, 1);
	}

	private class quitClick<ActionEvent> implements EventHandler <Event>{
		@Override
		public void handle(Event event) {
			global.monitor(((Button)event.getSource()).getText());
	}
}
}


