package v1;

public class Exercise  {

	private String name;

	public Exercise(String name) {
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
	
	//Eventually override this so that Rep or Aerobic exercises can display their types?
	public String toString() {
		return name;
	}



}
