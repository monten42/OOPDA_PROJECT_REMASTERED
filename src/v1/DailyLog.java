package v4;

import java.time.LocalDate;
import java.util.ArrayList;

public class DailyLog {
	LocalDate date;
	int caloriesConsumed, calorieLimit, caloriesBurned;
	ArrayList<Food> foodsEaten;
	ArrayList<Exercise> exercises;
	
	public DailyLog(int calorieLimit) {
		date = LocalDate.now();
		this.calorieLimit = calorieLimit;
		caloriesConsumed = 0;
		caloriesBurned = 0;
		foodsEaten = new ArrayList<>(5);
		exercises = new ArrayList<>(5);
	}
	
	/**
	 * @return the caloriesConsumed
	 */
	public int getCaloriesConsumed() {
		return caloriesConsumed;
	}

	/**
	 * @return the caloriesBurned
	 */
	public int getCaloriesBurned() {
		return caloriesBurned;
	}
	
	/**
	 * @param calorieLimit the calorieLimit to set
	 */
	public void setCalorieLimit(int calorieLimit) {
		this.calorieLimit = calorieLimit;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCalorieLimit() {
		return calorieLimit;
	}
	
	/**
	 * 
	 * @return
	 */
	public LocalDate getDate() {
		return date;
	}
	public String basicInfo() {
		return "Date: " + date + 
				"\nCalories Consumed: " + caloriesConsumed + "/" + calorieLimit +
				"\nCalories Burned: " + caloriesBurned;
	}
	
	public void addFood(Food food) {
		foodsEaten.add(food);
		caloriesConsumed += food.getCalories();
	}
	
	public void addExercise(Exercise exercise) {
		exercises.add(exercise);
		//caloriesBurned += exercise.getCalories();
	}
	
	public String foodInfo() {
		String foods = "";
		for(Food food : foodsEaten) {
			foods = foods + food.toString() + "\n";
		}
		return foods;
	}
	
	public String exerciseInfo() {
		String workouts = "";
		for(Exercise exercise : exercises) {
			workouts = workouts + exercise.toString() + "\n";
		}
		return workouts;
	}

}
