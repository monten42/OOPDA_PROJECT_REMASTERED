package v1;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUI extends Application{
	
	private static final int sW = 700;
	private static final int sH = 500;
	private static Stage stage;
	private static BorderPane mainPane;
	private static Pane userPane, historyPane, dashboardPane, foodPane, exercisePane, loginPane, btnPane;
	
	private static User currentUser;

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
		setupGUI();
		stage.showAndWait();
	}
	
	private static void setupGUI() {
		userPane = makeUserPane();
		historyPane = makeHistoryPane();
		dashboardPane = makeDashboardPane();
		foodPane = makeFoodPane();
		exercisePane = makeExercisePane();
		loginPane = makeLoginPane();
		btnPane = makeButtonPane();
		mainPane = new BorderPane();
		stage = new Stage();
		
		mainPane.setBottom(btnPane);
		mainPane.setCenter(loginPane);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Cyan is god");
		stage.setHeight(sW);
		stage.setHeight(sH);
		stage.setMaxWidth(sW);
		stage.setMaxHeight(sH);
		stage.setMinWidth(sW);
		stage.setMinHeight(sH);
		stage.setResizable(false);
		stage.setScene(new Scene(mainPane));
	}
	
	private static HBox makeLoginPane() {
		HBox pane = new HBox();
		pane.setStyle("-fx-background-color: #4ED6CB");
		GridPane rightPane = new GridPane();
		VBox leftPane = new VBox();
		
		Label selectNow = new Label("Select a user:");
		ComboBox<String> userSelection = new ComboBox<String>();	
		userSelection.setMinWidth(100);
		for(String username : FileIO.usernames()) {
			userSelection.getItems().addAll(username);
		}		
		
		
		Label newUser = new Label("To add a new user fill out these fields and hit 'Add This Profile'");
		TextField txtUserName = new TextField();
		TextField textName = new TextField();
		TextField txtGender = new TextField();
		TextField txtAge = new TextField();
		TextField txtHeight = new TextField();
		TextField txtWeight = new TextField();
		TextField txtCalorieLimit = new TextField();	
		Label lblUserName = new Label("Username:");
		Label lblName = new Label("Name:");
		Label lblGender = new Label("Gender:");
		Label lblAge = new Label("Age:");
		Label lblHeight = new Label("Height:");
		Label lblWeight = new Label("Weight:");
		Label lblCalorieLimit = new Label("Daily Calorie Limit:");	
		
		Button enterBtn = new Button("Add This Profile");
		enterBtn.setOnAction(e -> enterBtnPressed());
		
		leftPane.setPadding(new Insets(60, 20, 20, 60));
		leftPane.getChildren().addAll(selectNow, userSelection);
		leftPane.setMinWidth(200);
		leftPane.setSpacing(25);
		
		rightPane.setVgap(10);
		rightPane.setHgap(10);
		rightPane.setPadding(new Insets(50, 50, 50, 50));
		
		rightPane.add(newUser, 0, 0, 3, 1);	
		
		rightPane.add(lblUserName, 0, 1, 3, 1);
		rightPane.add(lblName, 0, 3);
		rightPane.add(lblGender, 1, 3);
		rightPane.add(lblAge, 2, 3);
		rightPane.add(lblHeight, 0, 5);
		rightPane.add(lblWeight, 1, 5);
		rightPane.add(lblCalorieLimit, 2, 5);
		
		rightPane.add(txtUserName, 0, 2, 3, 1);
		rightPane.add(textName, 0, 4);
		rightPane.add(txtGender, 1, 4);
		rightPane.add(txtAge, 2, 4);
		rightPane.add(txtHeight, 0, 6);
		rightPane.add(txtWeight, 1, 6);
		rightPane.add(txtCalorieLimit, 2, 6);
		rightPane.add(enterBtn, 1, 7, 3, 1);
		
		pane.getChildren().addAll(leftPane, rightPane);

		return pane;	
	}
	
	private static void enterBtnPressed() {
		/**
		String username = txtUserName.get
		User user = new User(String username, String name, String gender, int age, int height, int weight, int calorieLimit);
		FileIO.writeUserInfo(user);
		**/
	}
	
	private static HBox makeButtonPane() {
		HBox pane = new HBox();
		pane.setStyle("-fx-border-color: black");
		Button historyBtn = new Button("History");
		Button userBtn = new Button("User");
		Button dashboardBtn = new Button("Dashboard");	
		Button foodBtn = new Button("Food");
		Button exerciseBtn = new Button("Exercises");
		historyBtn.setOnAction(e -> mainPane.setCenter(historyPane));
		userBtn.setOnAction(e -> mainPane.setCenter(userPane));
		dashboardBtn.setOnAction(e -> mainPane.setCenter(dashboardPane));
		foodBtn.setOnAction(e -> mainPane.setCenter(foodPane));
		exerciseBtn.setOnAction(e -> mainPane.setCenter(exercisePane));
		ArrayList<Button> buttons = new ArrayList<Button>(Arrays.asList(historyBtn, userBtn, dashboardBtn, foodBtn, exerciseBtn));
		for (Button btn : buttons) {
			btn.setMinHeight(sH / 6);
			btn.setMinWidth(sW / buttons.size());
		}
		pane.getChildren().addAll(buttons);
		return pane;
	}
	
	private static BorderPane makeUserPane() {
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: #25BDB1");
		Label lbl1 = new Label("User!");
		Label lbl2 = new Label("Wow!");	
		pane.setCenter(lbl1);
		pane.setBottom(lbl2);		
		return pane;		
	}
	
	private static BorderPane makeHistoryPane() {
		BorderPane pane = new BorderPane();
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
		choices.getChildren().addAll(history, b);

		pane.setStyle("-fx-background-color: #1A8180");
		pane.setTop(choices);
		pane.setCenter(calorieInfo);
		pane.setBottom(lists);

		return pane;	
	}
	
	private static BorderPane makeDashboardPane() {
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: #4ED6CB");
		Label lbl = new Label("Dashboard page test!");
		pane.setCenter(lbl);
		return pane;
	}
	
	private static BorderPane makeFoodPane() {
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: #00FDFF");
		Label lbl1 = new Label("Food page test!");
		Label lbl2 = new Label("Wow!");	
		pane.setCenter(lbl1);
		pane.setTop(lbl2);
		return pane;
	}
	
	private static BorderPane makeExercisePane() {
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: #35E0FF");
		Label lbl1 = new Label("Exercises page test!");
		Label lbl2 = new Label("Wow!");	
		pane.setCenter(lbl1);
		pane.setTop(lbl2);
		return pane;
	}

	
}