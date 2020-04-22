package v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Creates a window with any number of buttons with unique text
 * Buttons are laid out horizontally
 */
public class ButtonOptions {
	
	private static Stage stage;
	private static int optionPicked;
	
	/**
	 * 
	 * @param title Title of window
	 * @param options List of strings to set respective button's text
	 * @return Number of button pressed
	 */
	public static int show(String title, List<String> options) {
		stage = new Stage();       
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(250);
		stage.setMinHeight(200);
		
		List<Button> buttons = new ArrayList<Button>(options.size());
		
		
		for(int i = 0; i < options.size(); i++) {    
			Button btn = new Button(options.get(i));
			btn.setOnAction(e -> btn_Clicked(buttons.indexOf((Button)e.getSource()) + 1));
			buttons.add(btn);
		}
		HBox pane = new HBox(20); 
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(buttons);
		pane.setPadding(new Insets(20, 20, 20, 20));
		Scene scene = new Scene(pane);   
		stage.setScene(scene);
		stage.showAndWait();   
		return optionPicked;
	}
	
	/**
	 * Button clicked on
	 * @param optionNum Number of pressed button
	 */
	private static void btn_Clicked(int optionNum) {
		optionPicked = optionNum;
		stage.close();
		
	}
	
	

}
