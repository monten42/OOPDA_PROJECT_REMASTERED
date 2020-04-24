package v4;

public class Driver {

	public static void main(String[] args) {
		DailyLog log = new DailyLog(2000);
		Food egg = new Food("Egg", 100);
		Food porkroll = new Food("Porkroll", 100);
		log.addFood(egg);
		log.addFood(porkroll);
		System.out.println(log.basicInfo());
		System.out.println(log.foodInfo());
	}

}
