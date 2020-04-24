package v1;

import java.io.Serializable;

/**
 * More accessible daily log information, before it is transferred to the History class for more concrete storage
 * @author Cyan
 *
 */
public class DailyLog implements Serializable{
	
	/**
	 * Default Serialize ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Field for the amount of caloriesBurned
	 */
	private int caloriesBurned;
	
	/**
	 * Field for the total calorie limit for the day
	 */
	private int caloriesLimit;
	
	/**
	 * Field for the calories eaten
	 */
	private int caloriesEaten;
	
	/**
	 * Field for user's history
	 */
	private History history;
	
	/**
	 * Constructs a DailyLog object with all value at 0 and the history set
	 */
	public DailyLog() {
		caloriesBurned = 0;
		caloriesLimit = 0;
		caloriesEaten = 0;
		history = new History();
		
	}
	
	/**
	 * Constructs a DailyLog object with a preset calorie limit, the history set, and the rest of the values set to 0
	 * @param caloriesTotal
	 */
	public DailyLog(int caloriesTotal, String filepath) {
		this.caloriesLimit = caloriesTotal;
		this.caloriesEaten = 0;
		this.caloriesBurned = 0;
		history = new History();
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
	public int getCaloriesLimit() {
		return caloriesLimit;
	}

	/**
	 * standard setter for  Calorie limit
	 * @param caloriesTotal
	 */
	public void setCaloriesLimit(int caloriesTotal) {
		this.caloriesLimit = caloriesTotal;
	}

	/**
	 * standard getter for calories eaten
	 * @return calories eaten as an int
	 */
	public int getCaloriesEaten() {
		return caloriesEaten;
	}

	/**
	 * standard setter for calories eaten
	 * @param caloriesEaten
	 */
	public void setCaloriesEaten(int caloriesEaten) {
		this.caloriesEaten = caloriesEaten;
	}
	
	public void logData() {
		history.log("caloriesEaten", Integer.toString(this.caloriesEaten));
		history.log("calorieLimie", Integer.toString(this.caloriesLimit));
		history.log("caloriesBurned", Integer.toString(this.caloriesBurned));
	}
	
	public void finishDay() {
		history.logDate();
	}
	
	public String toString() {
		return ("Calories eaten: " + this.caloriesEaten + ", Calories burned: " + this.caloriesBurned + ", Calorie limit: " + this.caloriesLimit);
		
	}
	
	/**
	 * Standard getter for the history field
	 * @return the history of the daily log as a History object
	 */
	public History getHistory() {
		return this.history;
	}
	
	/**
	 * Standard setter for the history filed
	 * @param newHistory
	 */
	public void setHistory(History newHistory) {
		this.history = newHistory;
	}
	
	
}
