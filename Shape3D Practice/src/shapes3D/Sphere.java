package shapes3D;

public class Sphere extends Shape3D {
	private double radius;
	
	public Sphere(double radiusIn) {

		radius = radiusIn;
	}
	

	public double getVolume() {
		double sphereVolume = 4/3 * (Math.PI) * Math.pow(radius, 3);
		return sphereVolume;
}


	@Override
	public Cube getEquivalentCube() {
		double value = (Math.pow(volume, 1.0/3));
		
		Cube newCube = new Cube(value);
		
		return newCube;
		
	}
	
	public String toString() {
		return "sphere with radius " + radius + " has volume " + getVolume();
	}

}