package leftovers;

public class Ant extends Scavenger{
	protected String name = "Ant";
	protected int mouthCapacity = 1;
	
	
	@Override
	public String toString() {
		return name + " has a mouth capacity of " + mouthCapacity;
}
}
