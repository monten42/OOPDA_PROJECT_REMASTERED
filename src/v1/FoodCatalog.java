package v1;
import java.util.HashMap;

public class FoodCatalog {
	private HashMap<String, Integer> foods = FileIO.getFoodList();
	private HashMap<String, Integer> personalFoods;
	public void addFood(FoodItem food) {
		
	}
	public boolean checkPersonalFood(FoodItem food, String username) {
		personalFoods = FileIO.getPersonalFoodList(username);
		if(personalFoods.keySet().contains(food.getName())) {
			return true;
		}
		else {
			return false;
		}
	}
	public void addPersonalFood(FoodItem food, String username) {
		if(!checkPersonalFood(food, username)) {
			FileIO.addPersonalFood(food, username);
		}
	}
}
