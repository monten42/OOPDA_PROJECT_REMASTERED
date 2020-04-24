package v1;

import java.io.Serializable;
import java.time.LocalDate;
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
	private HashMap<LocalDate, String> logs;
	
	/**
	 * Data from the current day
	 */
	public HashMap<String, String> logCurrentDate;
	
	/**
	 * Username to which the History belongs to
	 */
	private String username;
	
	/**
	 * Constructs a History object with the associated username
	 * @param username
	 */
	public History(String username) {
		this.setUsername(username);
	}
	
	/**
	 * Pushed the logged data from the current date to an archived, previous date format in the logs field
	 */
	public void logDate() {
		String token = null;
		for(String key: logCurrentDate.keySet()) {
			token += key + ":" + logCurrentDate.get(key) + ",";
			
		}
		logs.put(LocalDate.now(), token);
		logCurrentDate.clear();
		
	}
	
	
	/**
	 * Takes in date of format mm/dd/yyyy and retrieves the data from that day
	 * @param date
	 * @return the string of data from the specified date. The format will be 'type:value' in one string delimited by commas
	 */
	public String retrieveDate(String date) {
		int dates[] = new int[3];
		String[] dateStrings = date.split("/");
		dates[0] = Integer.parseInt(dateStrings[2]);
		dates[1] = Integer.parseInt(dateStrings[0]);
		dates[2] = Integer.parseInt(dateStrings[1]);
		
		 return logs.get(LocalDate.of(dates[0], dates[1], dates[2]));
		
		
	}
	
	/**
	 * Logs data in form <type, value> in the current date hashMap
	 * will format to 'type:value' when transitioned to the history logs
	 * @param type
	 * @param value
	 */
	public void log(String type, String value) {
		logCurrentDate.put(type, value);
		
	}
	
	/**
	 * Changes data in the current date
	 * @param type
	 * @param newValue
	 * @return validation that the data is changed
	 */
	public boolean changeCurrentDateData(String type, String newValue) {
		return logCurrentDate.replace(type, logCurrentDate.get(type), newValue);
		
	}
	
	/**
	 * Changes data in the logged data
	 * @param date
	 * @param type
	 * @param newValue
	 * @return Validation of the changed data, true if change, false if not
	 */
	public boolean changeLogData(LocalDate date, String type, String newValue) {
		boolean foundToken = false;
		for(LocalDate key: logs.keySet()) {
			if(date.isEqual(key)) {
				String[] data = logs.get(key).split(",");
				String rebuiltString = "";
				for(int i = 0; i < data.length; i++) {
					String[] split = data[i].split(":");
					if(split[0].equals(type)) {
						split[1] = newValue;
						foundToken = true;
					}
						rebuiltString += split[0]+":"+split[1]+",";
						
				}
				logs.replace(key, rebuiltString);
					
				}
				
			}
		return foundToken;
			
		}
	
	
	/**
	 * Gets a type of data and the value from a logged date 
	 * @param date
	 * @param type
	 * @return The data as a String in format 'type:value'
	 */
	public String getLogData(LocalDate date, String type) {
		for(LocalDate key: logs.keySet()) {
			if(date.isEqual(key)) {
				String[] data = logs.get(key).split(",");
				for(int i = 0; i < data.length; i++) {
					String token = data[i];
					String[] split = data[i].split(":");
					if(split[0].equals(type)) {
						return token;
					}
						
				}
					
				}
				
			}
		return null;
		
	}

	/**
	 * Standard getter for Username field
	 * @return username as a string
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Standard setter for username field
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
		
		
	
}
