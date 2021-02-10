package animalWar;

public class Mouse extends Prey {
	
	public Mouse(double weightInGramsIn, String nameIn) {
		name = nameIn;
		weightInGrams = weightInGramsIn;
	}

	@Override
	public void flee() {
		System.out.println(this.name + " runs into a nearby crevice");
	}

	@Override
	public void call() {
		System.out.println(this.name + " squeaks");
		
	}

	@Override
	public String toString() {
		return 
				name + " is a Mouse weighing " + weightInGrams ;
		
	}
}
