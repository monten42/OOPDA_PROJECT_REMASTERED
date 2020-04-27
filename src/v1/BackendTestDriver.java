package v1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BackendTestDriver {

	public static void main(String[] args) {
		
		FoodList fl= new FoodList();
		fl.addFood("Burger", 150);
		fl.addFood("Cheese Steak", 500);
		fl.addFood("Candy", 20);
		
		ExerciseList el = new ExerciseList();
		el.addAerobicExercise("Squats", 10, "00:20");
		el.addRepExercise("Bench Press", 5, 9, 2000);
		try {
			FileOutputStream filee = new FileOutputStream("exerciselist.txt");
			ObjectOutputStream outt = new ObjectOutputStream(filee);
			outt.writeObject(el);
			outt.close();
			FileOutputStream file = new FileOutputStream("foodlist.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(fl);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
