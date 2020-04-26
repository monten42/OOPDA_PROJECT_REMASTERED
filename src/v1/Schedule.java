package v1;

import java.util.HashMap;
import java.io.Serializable;
import java.time.LocalTime;

public class Schedule implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Exercise, LocalTime[]> schedule;
	
	public Schedule() {
		this.schedule = new HashMap<Exercise, LocalTime[]>();
	}
	
	public void addToSchedule(Exercise newExercise, LocalTime[] times) {
		boolean fits = true;
		for(Exercise key: schedule.keySet()) {
			if(fits == true && schedule.get(key)!= null && !(schedule.get(key)[0].isAfter(times[1]) || schedule.get(key)[1].isBefore(times[0]) )) {
				fits = false;
			}

			
		}
		if(fits) {
			schedule.put(newExercise, times);
		}
		
	}
	
	public void removeFromSchedule(String name) {
		Exercise ref = null;
		for(Exercise key: schedule.keySet()) {
			if(key.getName().equals(name)) {
				ref = key;
			}
		}
		
		if(ref!= null) {
			schedule.remove(ref);
		}
		
		
	}
	
	public void changeExerciseTime(String name, LocalTime[] newTimes) {
		for(Exercise key: schedule.keySet()) {
			if(key.getName().equals(name)) {
				schedule.put(key, newTimes);
			}
		}
		
	}
	
	public void setSchedule(HashMap<Exercise, LocalTime[]> newSchedule) {
		this.schedule = newSchedule;
	}
	
	public HashMap<Exercise, LocalTime[]> getSchedule(){
		return this.schedule;
	}
	
	
	
}
