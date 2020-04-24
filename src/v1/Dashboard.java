package v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

		btnPane.setAlignment(Pos.BOTTOM_CENTER);
		btnPane.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
		mainPane.setBottom(btnPane);
		stage.setScene(new Scene(mainPane));
		stage.showAndWait();

	}

	private static void setLogin() {

	}

	/**
	 * Sets displayPane with nodes to display daily log information
	 */
	private static void setDailyLog() {

		Label lbl1 = new Label("daily log!");
		Label lbl2 = new Label("Wow!");
		displayPane = new BorderPane();
		((BorderPane) displayPane).setLeft(lbl1);
		((BorderPane) displayPane).setRight(lbl2);
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
		((BorderPane) displayPane).setTop(lbl2);
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
		mainPane.setTop(displayPane);
		mainPane.setBottom(btnPane);
	}
}
