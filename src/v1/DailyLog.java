package v5;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * More accessible daily log information, before it is transferred to the History class for more concrete storage
 * @author Cyan
 *
 */
public class DailyLog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2602357011051485005L;
	LocalDate date;
    int caloriesConsumed, calorieLimit, caloriesBurned;
    ArrayList<FoodItem> foodsEaten;
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
	 * Standard getter for calories burned
	 * @return calories burned as an int
	 */
	public int getCaloriesBurned() {
		return caloriesBurned;
	}
	
	/**
	 * Standard setter for calories burned
	 * @param caloriesBurned
	 */
	public void setCaloriesBurned(int caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	
	/**
	 * standard getter for calories total
	 * @return claories limit as an int
	 */
	public int getcalorieLimit() {
		return calorieLimit;
	}

	/**
	 * standard setter for  Calorie limit
	 * @param caloriesTotal
	 */
	public void setcalorieLimit(int caloriesTotal) {
		this.calorieLimit = caloriesTotal;
	}

	/**
	 * standard getter for calories eaten
	 * @return calories eaten as an int
	 */
	public int getcaloriesConsumed() {
		return caloriesConsumed;
	}

	/**
	 * standard setter for calories eaten
	 * @param caloriesConsumed
	 */
	public void setcaloriesConsumed(int caloriesConsumed) {
		this.caloriesConsumed = caloriesConsumed;
	}
	
	
	
	public String basicInfo() {
        return "Date: " + date + 
                "\nCalories Consumed: " + caloriesConsumed + "/" + calorieLimit +
                "\nCalories Burned: " + caloriesBurned;
    }

    public void addFood(FoodItem food) {
        foodsEaten.add(food);
        caloriesConsumed += food.getCalories();
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
        //caloriesBurned += exercise.getCalories();
    }

    public String foodInfo() {
        String foods = "";
        for(FoodItem food : foodsEaten) {
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
