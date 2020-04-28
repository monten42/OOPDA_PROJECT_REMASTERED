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
		fl.addFood("Egg", 78);
		fl.addFood("Bacon", 54);
		fl.addFood("Sausage Link", 230);
		fl.addFood("Cheerios", 100);
		fl.addFood("Honey Nut Cheerios", 145);
		fl.addFood("Yogurt", 200);
		fl.addFood("Oatmeal", 158);
		fl.addFood("Strawberry", 4);
		fl.addFood("White Bread", 77);
		fl.addFood("Pancake", 86);
		fl.addFood("Banana", 105);
		fl.addFood("Egg Whites", 17);
		fl.addFood("Coffee Creamer", 70);
		fl.addFood("Hash Brown", 305);
		fl.addFood("Waffle", 100);
		fl.addFood("Bagel", 300);
		
		ExerciseList el = new ExerciseList();
		//aerobic exercises 
		el.addAerobicExercise("Swimming", 150, "20:00");
		el.addAerobicExercise("Running", 250, "20:00");
		el.addAerobicExercise("Skiing", 100, "20:00");
		el.addAerobicExercise("Stair Stepper" , 400, "20:00");
		el.addAerobicExercise("Yoga", 200, "20:00");
		el.addAerobicExercise("Biking", 150, "20:00");
		el.addAerobicExercise("Rowing", 200, "20:00");
		el.addAerobicExercise("Elliptical", 200, "20:00");
		//rep exercises
		el.addRepExercise("Circuit Workout", 3, 9, 500);
		el.addRepExercise("Lifting Weights", 10, 5, 300);
		el.addRepExercise("Lifting Weights", 10, 10, 600);
		el.addRepExercise("HIIT", 5, 7, 400);
		try {
			FileOutputStream filee = new FileOutputStream("Admin\\exerciselist.ser");
			ObjectOutputStream outt = new ObjectOutputStream(filee);
			outt.writeObject(el);
			outt.close();
			FileOutputStream file = new FileOutputStream("Admin\\foodlist.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(fl);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		User user = FileIO.retrieveUser("frogkm");
		//System.out.println(user.getFoodList().getFood("Bagel"));
		FoodList list =FileIO.deserializeFoodList();
		System.out.println(list.getFood("Bagel"));
		

	}

	
	
}
