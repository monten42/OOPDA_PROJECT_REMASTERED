package v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

	/**
	 * Show the gui
	 */
	public static void show() {
		btnPane = new HBox();
		mainPane = new BorderPane();
		stage = new Stage();

		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Dash");
		stage.setMinWidth(sW);
		stage.setMinHeight(sH);

		Button btn1 = new Button("Daily Log");
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

		// b.setOnAction(e ->
		// calorieInfo.setText(fileIO.getHistory(history.getValue()).basicInfo));
		// b.setOnAction(e ->
		// foods.setText(fileIO.getHistory(history.getValue()).foodInfo));
		// b.setOnAction(e ->
		// exercises.setText(fileIO.getHistory(history.getValue()).exerciseInfo));

		displayPane = new BorderPane();
		((BorderPane) displayPane).setTop(choices);
		((BorderPane) displayPane).setCenter(calorieInfo);
		((BorderPane) displayPane).setBottom(lists);

		

		// ((BorderPane) displayPane).setBottom(lbl2);
		// ((BorderPane) displayPane).setTop(lbl2);
		resetAndShow();

	}

	/**
	 * Sets displayPane with nodes to display user information
	 */
	private static void setUser() {

		Label lbl1 = new Label("User!");
		Label lbl2 = new Label("Wow!");
		displayPane = new BorderPane();
		((BorderPane) displayPane).setCenter(lbl1);
		((BorderPane) displayPane).setBottom(lbl2);
		resetAndShow();

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

		Label lbl1 = new Label("Food page test!");
		Label lbl2 = new Label("Wow!");
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
