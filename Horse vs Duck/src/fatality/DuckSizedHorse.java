package fatality;



public class DuckSizedHorse extends Animal {
	protected double rain;

	public DuckSizedHorse(String nameIn, double rainIn) {
		this.name = nameIn;
		this.power = .1 / rainIn;
		this.accuracy = .1;
	}

	@Override
	public void receiveInjury(double d) {

		System.out.println(this.name + " creates " + d + " damage");
	
		health = health - d;

		if (health <= 0) {
			System.out.println(getName() + " is now dead");
		} 
		
		else {
			System.out.println(getName() + "'s health is now " + health);

		}	
		}

	@Override
	public void attack(Animal target) {
		System.out.println(getName() + " is  attacking " + target);
		double randNum = random.nextDouble() * 1.0;

		if (randNum < accuracy) {
			receiveInjury(power);
		} else {
			System.out.println(this.name + " attack was missed");
		}

	}

	@Override
	public String toString() {
		return this.name + " Horseman";
	}

}
