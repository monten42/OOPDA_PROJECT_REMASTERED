package v5;

public class RepExercise extends Exercise {

	private int reps;
	private int intensity;


	public RepExercise(String name, int reps, int intensity) {
		super(name);
		this.reps = reps;
		this.intensity = intensity;
	}
	
	public int getReps() {
		return this.reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public int getIntensity() {
		return this.intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}
	
	public String toString() {
		return(super.getName() + " Reps: "+ this.reps + " intensity: " + this.intensity);
		
	}





}
