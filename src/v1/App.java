package v5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javafx.scene.control.Button;
import javafx.stage.Stage;
public class App {

	// Array for challenge exercises of the day
	private Exercise[] challengeExercises = new Exercise[3];
	// If application is running or not
	private boolean running = true;
	// Current user signed in to application
	private User currentUser;

	/**
	 * Generic constructor for Application
	 */
	public App(Stage stage) {
		
		Dashboard.show();
		FileIO.fileIO();
		//setupUser();
		//userEnvironment();
		
	}

	/**
	/**
	 * Make sure currentUser gets set
	 * If no users exist you can create one then select it
	 
	private void setupUser() {
		boolean running = true;
		int option; 
		while(running) {
			option = ButtonOptions.show("Pick an Option", Arrays.asList("Choose Existing User", "Create New User", "Close Program"));
			switch(option) {
				case 1:
					if(FileIO.usernames().size() > 0) {
						currentUser = promptChooseUser();
						System.out.println("Logged in as " + currentUser.getUsername());
						running = false;
					}
					else {
						InformationBox.show("Warning", "No users currently exist, please create one");
					}
					break;
				case 2:
					promptCreateUser();
					break;
				case 3:
					break;
			}
		}
		
	}
	

	/**
	 * Presents a window to user where all users are displayed on buttons
	 * Button pressed on will determine what user is returned
	 *
	 * @return Chosen user
	 
	private User promptChooseUser(){
		ArrayList<String> userList = FileIO.usernames();
		int userNum = ButtonOptions.show("Pick an Option", userList);
		return FileIO.retrieveUser(userList.get(userNum - 1));
	}

	/**
	 * Presents 6 windows to user in succession to enter various details (will make this not require 6 windows some time soon)
	 * A user object is created and stored from these details
	 *
	private void promptCreateUser() {
		String username = TextInput.show("UserName Prompt", "Choose a Username:");
		while(FileIO.usernames().contains(username)) {
			username = TextInput.show("UserName Prompt", "That username is taken, please enter a new username:");
		}
		String name = TextInput.show("Name Prompt", "Enter Full Name:");
		String gender = TextInput.show("Gender Prompt", "Enter Gender:");
		int age = Integer.parseInt(TextInput.show("Age Prompt", "Enter Age:"));
		int height = Integer.parseInt(TextInput.show("Height Prompt", "Enter Height:"));
		int weight = Integer.parseInt(TextInput.show("Weight Prompt", "Enter Weight:"));
		int calorieLimit = Integer.parseInt(TextInput.show("Daily Calorie Limit Prompt", "Enter Daily Calorie Limit:"));

		saveNewUser(new User(username, name, gender, age, height, weight, calorieLimit));
	}

	private void userEnvironment(){
		System.out.println(currentUser.printInfo());
		boolean running = true;
		int option;
		while(running) {
			option = ButtonOptions.show(currentUser.getUsername()+"'s Dashboard", Arrays.asList("Name: " + currentUser.getName(), "Gender: " + currentUser.getGender(),
					"Age: " + currentUser.getAge(), "Height: " + currentUser.getHeight(), "Weight: " + currentUser.getWeight(), "Limit: " + currentUser.getLogger().getCalorieLimit() + " cal"));
			switch(option) {
			case 1:
				currentUser.setName(TextInput.show("Name Prompt", "Enter Full Name:"));
				break;
			case 2:
				currentUser.setGender(TextInput.show("Gender Prompt", "Enter Gender:"));
				break;
			case 3:
				currentUser.setAge(Integer.parseInt(TextInput.show("Age Prompt", "Enter Age:")));
				break;
			case 4:
				currentUser.setHeight(Integer.parseInt(TextInput.show("Height Prompt", "Enter Height:")));
				break;
			case 5:
				currentUser.setWeight(Integer.parseInt(TextInput.show("Weight Prompt", "Enter Weight:")));
				break;
			case 6:
				currentUser.getLogger().setCalorieLimit(Integer.parseInt(TextInput.show("Daily Calorie Limit Prompt", "Enter Daily Calorie Limit:")));
				break;
			
				
			}
		}
		
	}
	*/


	private void saveNewUser(User user) {
		//FileIO.createNewUser(user.getUsername());
		FileIO.writeUserInfo(user);
	}
}
