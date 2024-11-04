package main;

import gui.GetraenkemarktControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		new GetraenkemarktControl(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}