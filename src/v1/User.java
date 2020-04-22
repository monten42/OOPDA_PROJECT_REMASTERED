package v1;

import java.io.Serializable;

public class User implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3999007488314647320L;
	private String name, gender, username;
	private int age, height, weight;
	private HealthLogger logger;
	
	public User(String username, String name, String gender, int age, int height, int weight, int calorieLimit) {
		this.username = username;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		logger = new HealthLogger(calorieLimit, weight, height);
	}
	
	public User() {
		this.username = "Unknown";
		this.name = "Unknown";
		this.gender = "Unknown";
		this.age = 18;
		this.height = 66;  //5ft 6in
		this.weight = 200; //200 lbs
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String printInfo() {
		return("Name: " + name + "\nGender: " + gender +
						   "\nAge: " + age + "\nHeight: " + height + 
						   "\nWeight: " + weight + "\nCalorie Limit: " + logger.getCalorieLimit());
	}
	
	public void printDashboard() {
		System.out.println("------------DASHBOARD------------");
		System.out.println("Name: " + name);
		System.out.println("Last recorded weight: " + weight);
		System.out.println("Calories consumed today: " + logger.getCalorieCount() + " / " + logger.getCalorieLimit());
		System.out.println("Daily challenges completed: ");
		System.out.println("---------------------------------");
		
	}

	public HealthLogger getLogger() {
		return logger;
	}

	public void setLogger(HealthLogger logger) {
		this.logger = logger;
	}

}
