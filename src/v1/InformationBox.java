package v1;


import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;

/**
 * Creates new window with a label and a button
 * User reads the information, then selects the "ok" button
 */
public class InformationBox {
	
	private static Stage stage;
	
	/**
	 * 
	 * @param title Title of window
	 * @param message Message to display to user
	 */
	public static void show(String title, String message) {
		stage = new Stage();       
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(300);
		stage.setMinHeight(200);
		Label lbl = new Label(message);
		Button btn = new Button("Ok");
		btn.setOnAction(e -> btn_Clicked());
		VBox pane = new VBox(20); 
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(lbl, btn);
		
		Scene scene = new Scene(pane);       
		stage.setScene(scene);
		stage.showAndWait();   
	}
	
	/**
	 * Button pressed on
	 */
	private static void btn_Clicked() {
		stage.close();
	}

}
