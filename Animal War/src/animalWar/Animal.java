package animalWar;

public abstract class Animal {
	protected String name;
	protected double weightInGrams;
	protected double newWeight;

	public void eat(double foodWeight) {
		newWeight = foodWeight + weightInGrams;
	}
	
	public abstract void call();

}
