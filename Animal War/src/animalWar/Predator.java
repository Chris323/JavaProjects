package animalWar;

public abstract class Predator extends Animal {
	
	public void predate(Prey food) {
		this.eat(food.weightInGrams);
		
		System.out.println(this.name + " eats " + food.name );
	}
	
	

}
