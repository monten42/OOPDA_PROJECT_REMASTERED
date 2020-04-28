package v1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Contains health history information about each user, personalized to them
 * @author Cyan
 *
 */
public class History implements Serializable {
	
	/**
	 * Default ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Data corresponding to dates
	 */
	private HashMap<LocalDate, DailyLog> previousDailylogs;
	
	/**
	 * Data from the current day
	 */
	public DailyLog currentDailyLog;
	
	public int calorieLimit;
	
	
	
	/**
	 * Constructs a History object with empty logs and currentLog
	 * @param calorieLimit for the logs
	 */
	public History(int calorieLimit) {
		previousDailylogs = new HashMap<LocalDate, DailyLog>();
		currentDailyLog = new DailyLog(calorieLimit);
		this.calorieLimit = calorieLimit;
	}
	
	
	/**
	 * If it is a new day the old daily log will get pushed to the HashMap and
	 * the new daily log will be saved
	 */
	public void logDate() {
		if(!getCurrentDailyLog().getDate().equals(LocalDate.now())) {
			previousDailylogs.put(getCurrentDailyLog().getDate(), currentDailyLog);
			currentDailyLog = new DailyLog(calorieLimit);
		}
	}
	
	/**
	 * Takes in date of format mm/dd/yyyy and retrieves the data from that day
	 * @param date
	 * @return the DailyLog of data from the specified date. 
	 */
	public DailyLog retrieveDate(String date) {
		String[] token = date.split("/");
		int[] numberToken = new int[3];
		numberToken[0] = Integer.parseInt(token[0]);
		numberToken[1] = Integer.parseInt(token[1]);
		numberToken[2] = Integer.parseInt(token[2]);
		
		for(LocalDate key: previousDailylogs.keySet()) {
			if(key.isEqual(LocalDate.of(numberToken[2], numberToken[0], numberToken[1]))) {
				return previousDailylogs.get(key);
				
			}
		}
		return null;
		
		
	}
	
	
	/**
	 * Overloaded Version of retrieve date. Uses a LocalDate object as a parameter and compares it to the history
	 * @param date
	 * @return the DailyLog object of the specified date
	 */
	public DailyLog retrieveDate(LocalDate date) {
	
		for(LocalDate key: previousDailylogs.keySet()) {
			if(key.isEqual(date)) {
				return previousDailylogs.get(key);
				
			}
		}
		return null;
		
		
		
	}
	
	
	/**
	 * Standard getter for the currentLog field
	 * @return
	 */
	public DailyLog getCurrentDailyLog() {
		return currentDailyLog;
		
	}
	/**
	 * Standard seetter for the currentLof field
	 * @return
	 */
	public void setCurrentDailyLog(DailyLog today) {
		currentDailyLog = today;
	}
	
	/**
	 * Standard mutator for the calorieLimit field
	 * @param calorieLimit
	 */
	public void setCalorieLimit(int calorieLimit) {
		
		this.calorieLimit = calorieLimit;
	}
	
	
	/**
	 * Standard getter for the calorieLimit field
	 * @return
	 */
	public int getCalorieLimit() {
		
		return this.calorieLimit;
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getKeySet() {
		ArrayList<String> dates = new ArrayList<>();
		for(LocalDate l : previousDailylogs.keySet()) {
			dates.add(l.toString());
		}
		return dates;
		
	}
	
	
	
	
	/**
	 * Used solely for testing dailylog gui, delete when serilization is complete
	 */
	public void logDateTest() {
		previousDailylogs.put(LocalDate.of(2020, 03, 21), currentDailyLog);
	}
	
	public DailyLog retrieveDateTest(String date) {
		return previousDailylogs.get(LocalDate.parse(date));
	}

	
	


		
		
	
}
