package v1;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Writer;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class FileIO {
	private static final boolean APPEND_MODE = true;
	private static final boolean OVERWRITE_MODE = false;
	public static void fileIO() {
		new File("Admin").mkdir();
		new File("Admin\\Users").mkdir();
		try {
			new File("Admin\\Usernames.txt").createNewFile();
			//new File("Admin\\Food Catalog.txt").createNewFile();
			//new File("Admin\\Exercises.txt").createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void newMonth(String username, int month) throws IOException{
		String path = "Admin\\"+username;
		String months = "month"+month+".txt";
		new File(path+"\\Food\\"+months).createNewFile();
		new File(path+"\\Exercise\\"+months).createNewFile();
	}
	public static void readUserInfo(String username) {
		String path = "Admin\\"+username+"\\Details.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String detail;
			while((detail = br.readLine()) != null) {
				System.out.println(detail);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeUserInfo(User user) {
		
		try
		{
		   Writer usernameWriter = new FileWriter("Admin\\Usernames.txt", APPEND_MODE);
		   usernameWriter.write(user.getUsername() + "\n");
		   usernameWriter.close();
		   FileOutputStream fileStream = new FileOutputStream("Admin\\Users\\" + user.getUsername() + ".ser");
		   ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
		   objectStream.writeObject(user);
		   objectStream.close();
		}
		catch (InvalidClassException e)
		{
		    System.out.println("Invalid class exception");
		}
		catch (NotSerializableException e)
		{
		    System.out.println("NotSerializable");
		}
		catch (IOException e)
		{
		    System.out.println("IOException");
		}
		catch (Exception e)
		{
		    System.out.println("Error when saving to file.");
		}
		
	}
	
	public static User retrieveUser(String username) {
		try
		{
		    FileInputStream fileStream = new FileInputStream("Admin\\Users\\" + username + ".ser");
		    ObjectInputStream objectStream = new ObjectInputStream(fileStream);
		    User user = (User) objectStream.readObject(); 
		    objectStream.close();
		    return user;  
		    
		}
		catch (Exception e)
		{
		    System.out.println("Error when loading from file.");
		    return null;
		}
		
	}
	public static ArrayList<String> usernames(){
		ArrayList<String> usernames = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Admin\\Usernames.txt"));
			String line = br.readLine();
			while(line != null) {
				usernames.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  usernames;
	}
	public static HashMap<String, Integer> getFoodList() {
		HashMap<String, Integer> foods = new HashMap<>();
		String[] item = new String[2];
		try {
			BufferedReader br = new BufferedReader(new FileReader("Admin\\Food Catalog.txt"));
			String line = br.readLine();
			while(line != null) {
				item = line.split(":");
				foods.put(item[0].trim(), Integer.parseInt(item[1].trim()));
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foods;
	}
	public static HashMap<String, Integer> getPersonalFoodList(String username) {
		HashMap<String, Integer> foods = new HashMap<>();
		String[] item = new String[2];
		try {
			BufferedReader br = new BufferedReader(new FileReader("Admin\\"+username + "\\PersonalFoods.txt"));
			String line = br.readLine();
			while(line != null) {
				item = line.split(":");
				foods.put(item[0].trim(), Integer.parseInt(item[1].trim()));
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foods;
	}
	public static void addFood(FoodItem food) {
		try {
			Writer writer = new FileWriter("Admin\\Food Catalog.txt", APPEND_MODE);
			writer.write(food.toString() + "\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addPersonalFood(FoodItem food, String username) {
		try {
			Writer writer = new FileWriter("Admin\\"+username + "\\PersonalFoods.txt", APPEND_MODE);
			writer.write(food.toString() + "\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static HashMap<String, Integer> getExerciseList() {
		HashMap<String, Integer> exercises = new HashMap<>();
		String[] item = new String[2];
		try {
			BufferedReader br = new BufferedReader(new FileReader("Admin\\Exercise Catalog.txt"));
			String line = br.readLine();
			while(line != null) {
				item = line.split(":");
				exercises.put(item[0].trim(), Integer.parseInt(item[1].trim()));
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exercises;
	}
	public static HashMap<String, Integer> getPersonalExerciseList(String username) {
		HashMap<String, Integer> exercises = new HashMap<>();
		String[] item = new String[2];
		try {
			BufferedReader br = new BufferedReader(new FileReader("Admin\\"+username + "\\PersonalExercises.txt"));
			String line = br.readLine();
			while(line != null) {
				item = line.split(":");
				exercises.put(item[0].trim(), Integer.parseInt(item[1].trim()));
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exercises;
	}

	public static void addPersonalExercise(Exercise exercise, String username) {
		try {
			Writer writer = new FileWriter("Admin\\"+username + "\\PersonalExercises.txt", APPEND_MODE);
			writer.write(exercise.toString() + "\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
