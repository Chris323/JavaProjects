package animalWar;

public class Cat extends Predator {

	public Cat(String nameIn, double weightInGramsIn) {
		name = nameIn;
		weightInGrams = weightInGramsIn;
	}

	@Override
	public void call() {
		System.out.println(this.name + " says \"Meow\"");

	}

	@Override
	public String toString() {
		return 
				name + "is a Cat weighing " + weightInGrams ;
		
	}
}
