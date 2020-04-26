package v1;

import javafx.application.Application;
import javafx.stage.Stage;

public class Driver extends Application{

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Start method makes a new application
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		App app = new App(primaryStage);
		
	}

}