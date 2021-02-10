package shapes3D;

public class Cube extends Shape3D {
	private double side;
	
	public Cube(double sideIn) {
		side = sideIn;
	}
	
	public double getVolume() {
		double cubeVolume = Math.pow(side, 3);
		return cubeVolume;
	}

	@Override
	public Cube getEquivalentCube() {
		Cube newCube = new Cube(getVolume());
		return newCube;
		
	}
	
	public String toString() {
		return "cube with side " + side + " has volume " + getVolume();
	}
}