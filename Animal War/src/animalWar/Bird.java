package animalWar;

public class Bird extends Prey {
	
	public Bird(double weightInGramsIn, String nameIn) {
		weightInGrams = weightInGramsIn;
		name = nameIn;
	}

	@Override
	public void flee() {
		System.out.println(this.name + " flies away");
	}

	@Override
	public void call() {
		System.out.println(this.name + " chirps");
		
	}

	@Override
	public String toString() {
		return 
				name + " is a Bird weighing " + weightInGrams ;
		
	}
}
