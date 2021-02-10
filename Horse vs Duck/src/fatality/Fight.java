package fatality;

import java.util.Random;

public class Fight {

	public static void main(String[] args) {
		Random random = new Random();
		
		double randNum1 = random.nextDouble() * 1.0;
		double randNum2 = random.nextDouble() * 1.0;
		
		Animal duck = new HorseSizedDuck("Howard", randNum1);
		Animal horse = new DuckSizedHorse("Bojack", randNum2);
		
		System.out.println(duck.toString());
		System.out.println(horse.toString());
		
		System.out.println("The fight begins");
		
		System.out.println("Current wind is " + randNum1 + " and rain is " + randNum2);
		
		while(duck.isAlive() && horse.isAlive() == true) {		
			duck.attack(horse);
			if(horse.isAlive() == false) {
				System.out.println(horse.getName() + " has died");
			}
			horse.attack(duck);
			if(duck.isAlive() == false) {
				System.out.println(duck.getName() + " has died");
			}
				
		}
}
}
