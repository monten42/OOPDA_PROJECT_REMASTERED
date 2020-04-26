package v1;

import java.util.ArrayList;

public class FoodList {

	private ArrayList<FoodItem> foods;
	
	public FoodList() {
		this.foods = new ArrayList<FoodItem>();
		
	}
	
	public ArrayList<FoodItem> getFoods(){
		return this.foods;
		
	}
	
	public void setFoods(ArrayList<FoodItem> newFoods) {
		this.foods = newFoods;
		
	}
	
	public boolean addFood(String name, int calories) {
		boolean noDupe = true;
		for(FoodItem food: foods) {
			if(food.getName().equals(name)) {
				noDupe = false;
			}}
		
		if(noDupe) {
			foods.add(new FoodItem(name, calories));
			return noDupe;
		}
		else {
			return noDupe;
		}
	}
	
	public boolean deleteFood(String name) {
		for(FoodItem food: foods) {
			if(food.getName().equals(name)) {
				foods.remove(food);
				return true;
			}}
		return true;
		}
	
	public void changeCalories(String name, int newCalories) {
		for(FoodItem food: foods) {
			if(food.getName().equals(name)) {
				food.setCalories(newCalories);
			}
			
		}
		
	}
	
	public void changeName(String name, String newName) {
		for(FoodItem food: foods) {
			if(food.getName().equals(name)) {
				food.setName(newName);
			}
			
		}
		
	}
	
}
