package fatality;

import java.util.Random;

public abstract class Animal {

	Random random = new Random();
	protected double health = 1.0;
	protected double accuracy; 
	protected double power;
	protected String name;

	public boolean isAlive() {

		if (health >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public abstract void receiveInjury(double d); //{
//		
//		
//
//		System.out.println(getName() + " creates " + d + " damage");
//	
//		health = health - d;
//
//		if (health <= 0) {
//			System.out.println(getName() + " is now dead");
//		} 
//		
//		else {
//			System.out.println(getName() + "'s health is now " + health);
//
//		}
//	}

	public abstract void attack(Animal target); // {

//		// write code here to do the following:
//
//		// print a message indicating whom this Animal is attacking (name of the other
//		// Animal)
//		System.out.println(getName() + "is  attacking "+ target);
//		
//		// get a random double between 0 and 1
//		double randNum = random.nextDouble()*1.0;
//		// if the random double is less than accuracy, the attack succeeds. In that
//		// case,
//		if (randNum < accuracy) {
//			receiveInjury(power);
//		}
//		// call receiveInjury(power) on target. The argument is *this* Animal's power.
//		else {
//			System.out.println("The attack failed");
//		}
//		// otherwise, the attack fails. Print a message indicating that the attack
//		// missed.

//	}

	public String getName() {
		return name;

	}
}
