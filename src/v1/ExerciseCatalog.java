package v1;
import java.util.HashMap;

public class ExerciseCatalog {
	private HashMap<String, Integer> exercises = FileIO.getExerciseList();
	private HashMap<String, Integer> personalExercises;
	public void addExercise(Exercise exercise) {
		
	}
	public boolean checkPersonalExercise(Exercise exercise, String username) {
		personalExercises = FileIO.getPersonalExerciseList(username);
		if(personalExercises.keySet().contains(exercise.getName())) {
			return true;
		}
		else {
			return false;
		}
	}
	public void addPersonalExercise(Exercise exercise, String username) {
		if(!checkPersonalExercise(exercise, username)) {
			FileIO.addPersonalExercise(exercise, username);
		}
	}
}
