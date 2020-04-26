package v1;

/**
 * The Exercise class is an abstract class to hold information about an exercise. More specific exercise subclasses will be maded and contain more specific information
 * @author Cyan
 *
 */
public abstract class Exercise  {

	/**
	 * Just the name
	 */
	private String name;

	/**
	 * Constructor to initialize the name field;
	 * @param name
	 */
	public Exercise(String name) {
		this.name = name;
	}

	/**
	 * Standard getter for the name field
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Standard setter for the name field
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	//Eventually override this so that Rep or Aerobic exercises can display their types?
	/**
	 * Standard toString overload method
	 * @return the name of the exercise as a String
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * This is purely for testing purposes delete when calories is implemented
	 */
	public int getCaloriesBurned() {
		return 50;
	}



}
