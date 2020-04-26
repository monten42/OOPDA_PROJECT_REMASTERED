package v1;

public abstract class Exercise  {

	private String name;
	private int caloriesBurned;
	public Exercise(String name, int caloriesBurned) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCaloriesBurned() {
		return this.caloriesBurned;
	}
	
	public void setCaloriesBurned(int newCaloriesBurned) {
		this.caloriesBurned = newCaloriesBurned;
	}
	
	//Eventually override this so that Rep or Aerobic exercises can display their types?
	public String toString() {
		return name;
	}



}
