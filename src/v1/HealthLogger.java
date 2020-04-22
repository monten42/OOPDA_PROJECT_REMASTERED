package v1;

import java.io.Serializable;

public class HealthLogger implements Serializable{
	
	//Basic fields
	private int calorieLimit, calorieCount;
	private double weight, height, goalWeight, bodyMassIndex;

	public HealthLogger(int calorieCount, int weight, int height) {
		this.calorieCount = calorieCount;
		this.weight = weight;
		this.height = height;
	}

	public int getCalorieLimit() {
		return calorieLimit;
	}

	public void setCalorieLimit(int calorieLimit) {
		this.calorieLimit = calorieLimit;
	}

	public int getCalorieCount() {
		return calorieCount;
	}

	public void setCalorieCount(int calorieCount) {
		this.calorieCount = calorieCount;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getGoalWeight() {
		return goalWeight;
	}

	public void setGoalWeight(double goalWeight) {
		this.goalWeight = goalWeight;
	}

	public double getBodyMassIndex() {
		return bodyMassIndex;
	}
	
	public void calculateBodyMassIndex(int weight, int height) {
		bodyMassIndex = ((double)weight * 703)/(double)height;
	}
	
	public void setBodyMassIndex(double bodyMassIndex) {
		this.bodyMassIndex = bodyMassIndex;
	}

}
