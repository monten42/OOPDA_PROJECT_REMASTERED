module fitnessApp {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	
	opens v1 to javafx.fxml;
	exports v1;
}	