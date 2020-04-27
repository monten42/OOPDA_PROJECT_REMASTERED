package v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Dashboard {

	private static final int sW = 700;
	private static final int sH = 500;

	private static Stage stage;
	private static BorderPane mainPane;
	private static HBox btnPane;
	private static Pane displayPane;

	//Created user to test methods(Will be replaced by log in information
	private static User tester = new User("Findog", "Jake Findlow", "Male", 19, 64, 190, 2000);
	private static User currentUser;
	/**
	 * Show the gui
	 */
	public static void show() {
		/**
		 * Creating and assigning a fake history to a user
		History history = new History(2000);
		DailyLog log1 = new DailyLog(2000);
		DailyLog log2 = new DailyLog(2000);
		FoodItem eggs = new FoodItem("Egg", 100);
		FoodItem bread = new FoodItem("Bread", 150);
		FoodItem chips = new FoodItem("Chips", 200);
		Exercise running = new AerobicExercise("Running", "0:30");
		Exercise bench = new RepExercise("Weights", 10, 3);
		log1.addFood(eggs);
		log1.addFood(bread);
		log2.addFood(chips);
		log1.addExercise(running);
		log2.addExercise(bench);
		history.setCurrentDailyLog(log1);
		history.logDateTest();
		history.setCurrentDailyLog(log2);
		tester.setHistory(history);
		*/
		
		btnPane = new HBox();
		mainPane = new BorderPane();
		stage = new Stage();

		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Dash");
		stage.setMinWidth(sW);
		stage.setMinHeight(sH);

		Button btn1 = new Button("History");
		btn1.setOnAction(e -> setDailyLog());
		Button btn2 = new Button("User");
		btn2.setOnAction(e -> setUser());
		Button btn3 = new Button("Dashboard");
		btn3.setOnAction(e -> setDashboard());
		Button btn4 = new Button("Food");
		btn4.setOnAction(e -> setFood());
		Button btn5 = new Button("Exercises");
		btn5.setOnAction(e -> setExercises());

		ArrayList<Button> buttons = new ArrayList<Button>(Arrays.asList(btn1, btn2, btn3, btn4, btn5));

		for (Button btn : buttons) {
			btn.setMinHeight(sH / 6);
			btn.setMinWidth(sW / buttons.size());
		}

		btnPane.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
		mainPane.setBottom(btnPane);
		stage.setResizable(false);
		
		
		
		stage.setScene(new Scene(mainPane));
		setLogin();
		
		stage.showAndWait();
		

	}

	private static void setLogin() {
		displayPane = new HBox();
		
		displayPane.getChildren().add(new Label("HELLO"));
		resetAndShow();
	}

	/**
	 * Sets displayPane with nodes to display daily log information
	 */
	private static void setDailyLog() {
		

		HBox choices = new HBox();
		HBox lists = new HBox(50);
		VBox info = new VBox(30);
		
		ComboBox<String> history = new ComboBox<String>();
		history.getItems().addAll(tester.getHistory().getKeySet());
		history.setEditable(true);
		Button b = new Button("Press");
		Label calorieInfo = new Label("Calories");
		Label foods = new Label("Foods");
		Label exercises = new Label("Exercises");

		lists.setAlignment(Pos.CENTER);
		choices.setAlignment(Pos.CENTER);
		calorieInfo.setAlignment(Pos.CENTER);
		info.setAlignment(Pos.CENTER);
		
		lists.getChildren().addAll(foods, exercises);
		choices.getChildren().addAll(history, b);
		info.getChildren().addAll(choices, calorieInfo, lists);
		
		b.setOnAction(e -> {calorieInfo.setText(tester.getHistory().retrieveDateTest(history.getValue()).basicInfo());
							foods.setText(tester.getHistory().retrieveDateTest(history.getValue()).foodInfo());
							exercises.setText(tester.getHistory().retrieveDateTest(history.getValue()).exerciseInfo());
							});

		displayPane = new VBox();
		displayPane = info;

		

		// ((BorderPane) displayPane).setBottom(lbl2);
		// ((BorderPane) displayPane).setTop(lbl2);
		resetAndShow();

	}

	/**
	 * Sets displayPane with nodes to display user information
	 */
	private static void setUser() {
		HBox allSettings = new HBox(30);
		VBox options = new VBox(40);
		VBox textboxes = new VBox(30);
		VBox buttons = new VBox(30);
		
		allSettings.setAlignment(Pos.CENTER);
		options.setAlignment(Pos.CENTER);
		textboxes.setAlignment(Pos.CENTER);
		buttons.setAlignment(Pos.CENTER);
		
		Label name, gender, age, height, weight, calorieLimit;
		name = new Label("Name: " + tester.getName());
		gender = new Label("Gender: " + tester.getGender());
		age = new Label("Age: " + tester.getAge());
		height = new Label("Height: " + tester.getHeight());
		weight = new Label("Weight: " + tester.getWeight());
		calorieLimit = new Label("Calorie Limit: " + tester.getHistory().getCalorieLimit());
		
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
		
		setName.setOnAction(e -> tester.setName(changeName.getText()));
		setGender.setOnAction(e -> tester.setGender(changeGender.getText()));
		setAge.setOnAction(e -> {if(checkSettingInput(e, changeAge)) {
									tester.setAge(Integer.parseInt(changeAge.getText()));
									age.setText("Age: " + tester.getAge());
								}
								else {
									wrongInput.setText("The age value entered is not a number");
								}
							});
		setHeight.setOnAction(e -> {if(checkSettingInput(e, changeHeight)) {
									tester.setHeight(Integer.parseInt(changeHeight.getText()));
									height.setText("Height: " + tester.getHeight());
								}
								else {
									wrongInput.setText("The height value entered is not a number");
								}
							});
		setWeight.setOnAction(e -> {if(checkSettingInput(e, changeWeight)) {
									tester.setWeight(Integer.parseInt(changeWeight.getText()));
									weight.setText("Weight: " + tester.getWeight());
								}
								else {
									wrongInput.setText("The weight value entered is not a number");
								}
							});
		setCalorieLimit.setOnAction(e -> {if(checkSettingInput(e, changeCalorieLimit)) {
									tester.setCalorieLimit(Integer.parseInt(changeCalorieLimit.getText()));
									calorieLimit.setText("Calorie Limit: " + tester.getHistory().getCalorieLimit());
								}
								else {
									wrongInput.setText("The calorie limit value entered is not a number");
								}
							});
		options.getChildren().addAll(name, gender, age, height, weight, calorieLimit);
		textboxes.getChildren().addAll(changeName, changeGender, changeAge, changeHeight, changeWeight, changeCalorieLimit);
		buttons.getChildren().addAll(setName, setGender, setAge, setHeight, setWeight, setCalorieLimit);
		allSettings.getChildren().addAll(options, textboxes, buttons, wrongInput);
		displayPane = new HBox();
		displayPane = allSettings;
		resetAndShow();

	}
	
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
	 * Sets displayPane with nodes to display dashboard
	 */
	private static void setDashboard() {

		Label lbl = new Label("Dashboard page test!");
		displayPane = new BorderPane();
		((BorderPane) displayPane).setCenter(lbl);
		resetAndShow();

	}

	/**
	 * Sets displayPane with nodes to display food information
	 */
	private static void setFood() {

		ListView list = new ListView();
		for(FoodItem food: currentUser.ge)
		displayPane = new BorderPane();
		((BorderPane) displayPane).setCenter(lbl1);
		((BorderPane) displayPane).setTop(lbl2);
		resetAndShow();

	}

	/**
	 * Sets displayPane with nodes to display exercise information
	 */
	private static void setExercises() {

		Label lbl1 = new Label("Exercises page test!");
		Label lbl2 = new Label("Wow!");
		displayPane = new BorderPane();
		((BorderPane) displayPane).setCenter(lbl1);
		((BorderPane) displayPane).setTop(lbl2);
		resetAndShow();

	}

	/**
	 * Clear mainPane and build it back again
	 */
	private static void resetAndShow() {
		mainPane.getChildren().clear();
		mainPane.setCenter(displayPane);
		mainPane.setBottom(btnPane);
	}
}
