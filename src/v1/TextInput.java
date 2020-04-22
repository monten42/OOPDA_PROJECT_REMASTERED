package v1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Creates window with a label, textField, and button
 * The user answers a prompt in the textField, then presses submit
 */
public class TextInput {
	private static Stage stage;
	private static String userInput;
	
	/**
	 * 
	 * @param title Title of window
	 * @param prompt Description to show user
	 * @return String value entered by user
	 */
	public static String show(String title, String prompt) {
		stage = new Stage();       
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(250);
		stage.setMinHeight(200);
		Label promptLbl = new Label(prompt);
		TextField txtInput = new TextField();
		txtInput.setMinWidth(100);
		Button submitBtn = new Button("Submit");
		submitBtn.setOnAction(e -> btn_Clicked(txtInput.getText()));
		VBox pane = new VBox(20); 
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(promptLbl, txtInput, submitBtn);
		Scene scene = new Scene(pane);       
		stage.setScene(scene);
		stage.showAndWait();   
		return userInput;
	}
	
	/**
	 * Button pressed on
	 * @param input User String input
	 */
	private static void btn_Clicked(String input) {
		userInput = input;
		stage.close();
		
	}

}
