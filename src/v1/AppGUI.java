package v4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.stage.Stage;


public class AppGUI extends Application{
	private BorderPane mainPane;
	public static void main(String[] args) {
		/* static method inherited from Application class that creates
		 * an instance of the Application class and starts the JavaFX lifecycle. */
		launch(args);
	}

	@Override public void start(Stage mainStage) throws InterruptedException {
		mainPane = new BorderPane();     // make layout to hold controls
		setupControls(mainPane);  // initialize and place controls
		Scene scene = new Scene(mainPane);	        // Setup a Splash Screen
		setStage(mainStage, scene);                 // Finalize and show the stage
	}
	
	private void setupControls(BorderPane mainpain) {
		Button log = new Button("Daily Log");
		Button food = new Button("Food");
		Button dashboard = new Button("Dashboard");
		Button exercise = new Button("Exercise");
		Button user = new Button("User Settings");
		
		
		HBox options = new HBox(0);
		options.setPrefSize(800, 100);
		options.setPadding(new Insets(50,0,0,0));
		options.setAlignment(Pos.CENTER);
		log.setPrefSize(options.getPrefWidth(), options.getPrefHeight());
		food.setPrefSize(options.getPrefWidth(), options.getPrefHeight());
		dashboard.setPrefSize(options.getPrefWidth(), options.getPrefHeight());
		exercise.setPrefSize(options.getPrefWidth(), options.getPrefHeight());
		user.setPrefSize(options.getPrefWidth(), options.getPrefHeight());
		
		options.getChildren().addAll(log, food, dashboard, exercise, user);
		
		log.setOnAction(e -> selectScene(1));
		
		Label cen = new Label("Default Center");
		Label top = new Label("Default Top");
		cen.setPadding(new Insets(0,0,300,0));
		mainPane.setPadding(new Insets(50,0,0,0));
		
		mainPane.setCenter(cen);
		mainPane.setBottom(options);
		mainPane.setTop(top);
	}
	
	public void selectScene(int scene) {
		switch(scene) {
		case 1:
			mainPane.setCenter(logGUI());
		}
	}
	
	public BorderPane logGUI() {
		BorderPane logPane = new BorderPane();
		 HBox choices = new HBox();
		 HBox lists = new HBox(50);
		 
		 ComboBox<String> history = new ComboBox<String>();
		 history.getItems().addAll("Choice 1", "Choice 2", "Choice 3");
		 history.setEditable(true);
		 Button b = new Button("Press");
		 Label calorieInfo = new Label("Calories");
		 Label foods = new Label("Foods");
		 Label exercises = new Label("Exercises");
		 
		 lists.setAlignment(Pos.CENTER);
		 choices.setAlignment(Pos.CENTER);
		 calorieInfo.setAlignment(Pos.CENTER);
		 lists.getChildren().addAll(foods, exercises);
		 choices.getChildren().addAll(history,b);
		 
		 //b.setOnAction(e -> calorieInfo.setText(fileIO.getHistory(history.getValue()).basicInfo));
		 //b.setOnAction(e -> foods.setText(fileIO.getHistory(history.getValue()).foodInfo));
		 //b.setOnAction(e -> exercises.setText(fileIO.getHistory(history.getValue()).exerciseInfo));
		 
		 logPane.setTop(choices);
		 logPane.setCenter(calorieInfo);
		 logPane.setBottom(lists);
		 
		 return logPane;
	}
	
	
	private void setStage(Stage stage, Scene scene) {
		stage.setTitle("GUI Testing");
		stage.setScene(scene);
		stage.show();		
	}
}
