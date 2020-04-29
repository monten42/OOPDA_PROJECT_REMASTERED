package v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUI extends Application{

	private static final int sW = 830;
	private static final int sH = 500;
	private static Stage stage;
	private static BorderPane mainPane;
	private static Pane loginPane, btnPane;
	
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
	
	@Override
	public void stop() {
		FileIO.writeUserInfo(currentUser);
        Platform.exit();
        System.exit(0);
	}

	private static void setupGUI() {
		btnPane = makeButtonPane();
		loginPane = makeLoginPane();	
		mainPane = new BorderPane();
		stage = new Stage();

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
		rightPane.setVisible(false);
		VBox leftPane = new VBox();
		leftPane.setAlignment(Pos.CENTER);
		
		Label selectNow = new Label("Select a user:");
		ComboBox<String> userSelection = new ComboBox<String>();
		userSelection.setEditable(true);
		userSelection.setMinWidth(100);
		userSelection.getItems().addAll(FileIO.usernames());		
		

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
		Button useUserBtn = new Button("Sign In");
		Button signUp = new Button("Sign Up");
		
		
		Label userNotFound = new Label("The entered user does not exist");
		userNotFound.setTextFill(Color.web("#ff0000"));
		userNotFound.setVisible(false);
		Label createUserSuccess = new Label("User Created Successfully");
		createUserSuccess.setVisible(false);
		
		leftPane.setPadding(new Insets(0, 20, 20, 60));
		leftPane.getChildren().addAll(selectNow, userSelection, useUserBtn, signUp, userNotFound, createUserSuccess);
		leftPane.setMinWidth(200);
		leftPane.setSpacing(10);

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

		
		Label createUserError = new Label("The username entered is already taken, please enter a new username");
		createUserError.setTextFill(Color.web("#ff0000"));
		createUserError.setVisible(false);
		rightPane.add(createUserError, 0, 8, 3, 1);

		useUserBtn.setOnAction((event) -> {

			if(FileIO.usernames().contains(userSelection.getValue())) {
				currentUser = FileIO.retrieveUser(userSelection.getValue());
				currentUser.getHistory().logDate();
				mainPane.setCenter(makeDashboardPane());
				mainPane.setBottom(btnPane);
				FileIO.logLogin(currentUser.getUsername());
			}
			else {
				userNotFound.setVisible(true);
			}

		});

		enterBtn.setOnAction((event) -> {
			if(FileIO.usernames().contains(txtUserName.getText())) {
				createUserError.setText("The username entered is already taken, please enter a new username");
				createUserError.setVisible(true);
				txtUserName.setPromptText(txtUserName.getText());
				txtUserName.clear();
			}
			else {
				try {			
					User user = new User(txtUserName.getText(), textName.getText(), txtGender.getText(), Integer.parseInt(txtAge.getText()), 
							Integer.parseInt(txtHeight.getText()), Integer.parseInt(txtWeight.getText()), Integer.parseInt(txtCalorieLimit.getText()));	
					
					createUserError.setVisible(false);
					createUserSuccess.setVisible(true);
					FileIO.writeUserInfo(user);
					rightPane.setVisible(false);
					userSelection.getItems().add(txtUserName.getText());
				}
				catch(NumberFormatException e) {
					createUserError.setText("One or more of the values entered are not valid.  Please try again.");
					createUserError.setVisible(true);
				}
			}
		});
		
		signUp.setOnAction((event) -> rightPane.setVisible(true));


		pane.getChildren().addAll(leftPane, rightPane);

		return pane;	
	}


	private static HBox makeButtonPane() {
		HBox pane = new HBox();
		pane.setStyle("-fx-border-color: black");
		Button historyBtn = new Button("History");
		Button userBtn = new Button("User");
		Button dashboardBtn = new Button("Dashboard");	
		Button foodBtn = new Button("Food");
		Button exerciseBtn = new Button("Exercises");
		historyBtn.setOnAction(e -> mainPane.setCenter(makeHistoryPane()));
		userBtn.setOnAction(e -> mainPane.setCenter(makeUserPane()));
		dashboardBtn.setOnAction(e -> mainPane.setCenter(makeDashboardPane()));
		foodBtn.setOnAction(e -> mainPane.setCenter(makeFoodPane()));
		exerciseBtn.setOnAction(e -> mainPane.setCenter(makeExercisePane()));
		ArrayList<Button> buttons = new ArrayList<Button>(Arrays.asList(historyBtn, userBtn, dashboardBtn, foodBtn, exerciseBtn));
		for (Button btn : buttons) {
			btn.setMinHeight(sH / 6);
			btn.setMinWidth(sW / buttons.size());
		}
		pane.getChildren().addAll(buttons);
		return pane;
	}
	
	/**
	 * Allows the user to view and edit all of their personal information
	 * @return an HBox with all of the information and fields necessary to change the information
	 */
	private static HBox makeUserPane() {
		HBox allSettings = new HBox(30);
		VBox options = new VBox(40);
		VBox textboxes = new VBox(30);
		VBox buttons = new VBox(30);
		
		allSettings.setStyle("-fx-background-color: #25BDB1");
		
		allSettings.setAlignment(Pos.CENTER);
		options.setAlignment(Pos.CENTER);
		textboxes.setAlignment(Pos.CENTER);
		buttons.setAlignment(Pos.CENTER);
		
		Label name, gender, age, height, weight, calorieLimit;
		name = new Label("Name: " + currentUser.getName());
		gender = new Label("Gender: " + currentUser.getGender());
		age = new Label("Age: " + currentUser.getAge());
		height = new Label("Height: " + currentUser.getHeight());
		weight = new Label("Weight: " + currentUser.getWeight());
		calorieLimit = new Label("Calorie Limit: " + currentUser.getHistory().getCalorieLimit());
		
		TextField changeName, changeGender, changeAge, changeHeight, changeWeight, changeCalorieLimit;
		changeName = new TextField();
		changeGender = new TextField();
		changeAge = new TextField();
		changeHeight = new TextField();
		changeWeight = new TextField();
		changeCalorieLimit = new TextField();
		changeName.setPromptText("Enter new name");
		changeGender.setPromptText("Enter new gender");
		changeAge.setPromptText("Enter new age");
		changeHeight.setPromptText("Enter new height");
		changeWeight.setPromptText("Enter new weight");
		changeCalorieLimit.setPromptText("Enter new calorie limit");
	
		
		Button setName, setGender, setAge, setHeight, setWeight, setCalorieLimit;
		setName = new Button("Set");
		setGender = new Button("Set");
		setAge = new Button("Set");
		setHeight = new Button("Set");
		setWeight = new Button("Set");
		setCalorieLimit = new Button("Set");
		
		Label wrongInput = new Label("");
		wrongInput.setPrefWidth(100);
		wrongInput.setWrapText(true);
		
		
		setName.setOnAction(e -> currentUser.setName(changeName.getText()));
		setGender.setOnAction(e -> currentUser.setGender(changeGender.getText()));
		setAge.setOnAction(e -> {if(checkSettingInput(e, changeAge)) {
									currentUser.setAge(Integer.parseInt(changeAge.getText()));
									age.setText("Age: " + currentUser.getAge());
								}
								else {
									wrongInput.setText("The age value entered is not a number");
								}
							});
		setHeight.setOnAction(e -> {if(checkSettingInput(e, changeHeight)) {
									currentUser.setHeight(Integer.parseInt(changeHeight.getText()));
									height.setText("Height: " + currentUser.getHeight());
								}
								else {
									wrongInput.setText("The height value entered is not a number");
								}
							});
		setWeight.setOnAction(e -> {if(checkSettingInput(e, changeWeight)) {
									currentUser.setWeight(Integer.parseInt(changeWeight.getText()));
									weight.setText("Weight: " + currentUser.getWeight());
								}
								else {
									wrongInput.setText("The weight value entered is not a number");
								}
							});
		setCalorieLimit.setOnAction(e -> {if(checkSettingInput(e, changeCalorieLimit)) {
									currentUser.setCalorieLimit(Integer.parseInt(changeCalorieLimit.getText()));
									calorieLimit.setText("Calorie Limit: " + currentUser.getHistory().getCalorieLimit());
								}
								else {
									wrongInput.setText("The calorie limit value entered is not a number");
								}
							});
							
							
							options.getChildren().addAll(name, gender, age, height, weight, calorieLimit);
		textboxes.getChildren().addAll(changeName, changeGender, changeAge, changeHeight, changeWeight, changeCalorieLimit);
		buttons.getChildren().addAll(setName, setGender, setAge, setHeight, setWeight, setCalorieLimit);
		allSettings.getChildren().addAll(options, textboxes, buttons, wrongInput);
		
		
		
		
		return allSettings;
	}
	
	
	
	/**
	 * Checks if a string value is parsable to an int value
	 * @param e action event of a button
	 * @param text the text being checked to see if it is parsable to int
	 * @return true if the string is parsable to int
	 */
	private static boolean checkSettingInput(ActionEvent e, TextField text) {
		try {
			Integer.parseInt(text.getText());
		}
		catch (NumberFormatException nfe){
			return false;
		}
		return true;
	}
	/**
	 * Allows the user to check their daily logs from the past
	 * @return a VBox with all the elements to display the history
	 */
	private static VBox makeHistoryPane() {
		HBox choices = new HBox();
		HBox lists = new HBox(50);
		VBox info = new VBox(30);
		
		
		ComboBox<String> history = new ComboBox<String>();
		history.getItems().addAll(currentUser.getHistory().getKeySet());
		history.setEditable(true);
		Button b = new Button("Press");
		Label calorieInfo = new Label("Calories");
		Label foods = new Label("Foods");
		Label exercises = new Label("Exercises");

		
		lists.setAlignment(Pos.CENTER);
		choices.setAlignment(Pos.CENTER);
		calorieInfo.setAlignment(Pos.CENTER);
		info.setAlignment(Pos.TOP_CENTER);
		
		lists.getChildren().addAll(foods, exercises);
		choices.getChildren().addAll(history, b);
		info.getChildren().addAll(choices, calorieInfo, lists);
		
		b.setOnAction(e -> {calorieInfo.setText(currentUser.getHistory().retrieveDateTest(history.getValue()).basicInfo());
							foods.setText(currentUser.getHistory().retrieveDateTest(history.getValue()).foodInfo());
							exercises.setText(currentUser.getHistory().retrieveDateTest(history.getValue()).exerciseInfo());
							});
	

		return info;	
	}

	private static BorderPane makeDashboardPane() {
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: #4ED6CB");
		Label lbl = new Label("Dashboard page test!");
		pane.setCenter(lbl);
		return pane;
	}

	private static BorderPane makeFoodPane() {
		
		//Left Side
		
		//Search bar
		TextField search = new TextField();
		search.setOnKeyTyped(e ->{
			
			
			
			
		});
		
		
		//List of Food
		ListView<FoodItem> listview = new ListView<FoodItem>();
		listview.setMaxWidth(200);
			for(FoodItem food: currentUser.getFoodList().getFoods()) {
				listview.getItems().add(food);
			}
		
		//Button to log food
		Button logFood = new Button("Log");
		logFood.setPadding(new Insets(0,20,0,20));
		logFood.setOnAction(e->{
		currentUser.getHistory().getCurrentDailyLog().addFood(
				listview.getSelectionModel().getSelectedItem());
		});
		
		//Left side in vbox
		VBox left = new VBox(search, listview, logFood);
		
		
		
		//Right side

		
		Label name = new Label("Name : ");
		Label calories = new Label("Calories : ");
		Label confirm = new Label();
		
		
		TextField enterName = new TextField();
		TextField enterCalories = new TextField();
		
		//Name
		HBox nameField = new HBox(name, enterName);
		
		//Calories
		HBox calorieField = new HBox(calories, enterCalories);
		
		Button addFood = new Button("Add a Food");
		
		addFood.setOnAction(e->{ 
			if(checkSettingInput(e, enterCalories)) {
			FoodItem food  = new FoodItem(enterName.getText(), Integer.parseInt(enterCalories.getText()));
			if(currentUser.getFoodList().addFood(enterName.getText(), Integer.parseInt(enterCalories.getText()))) {
				System.err.println("ALL FOOD!");
			}
			else {
				System.err.println("lmao nope");
			}
			listview.getItems().add(food);
			confirm.setText("The food has been successfully added!");
			}
			else {
				confirm.setText("Not valid input for a food");
			}
			
		} );
		
		//Right side VBox
		
		VBox right = new VBox(nameField, calorieField, addFood, confirm);
		
		//Hbox to house left and right
		HBox whole = new HBox(left, right);
		BorderPane panel = new BorderPane();
		panel.setCenter(whole);
		return panel;
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
