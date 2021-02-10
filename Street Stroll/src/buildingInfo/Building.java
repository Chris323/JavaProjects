package buildingInfo;

public class Building {

	protected double size;
	protected boolean haunted = false;

	public Building(double sizeIn, boolean hauntedIn) {
		size = sizeIn;
		haunted = hauntedIn;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public boolean isHaunted() {
		return haunted;
	}

	public void setHaunted(boolean haunted) {
		this.haunted = haunted;
	}

	public String explore() {
		return null;
	}
	
	public String toString() {
		
		return size + "sq meters" + haunted;
	}
}
