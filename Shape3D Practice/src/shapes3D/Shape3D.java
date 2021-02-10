package shapes3D;

public abstract class Shape3D {
	protected double volume;

	public Shape3D() {}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
//	public boolean isLargerThan(Shape3D) {
//		if
//		
//		System.out.print()
//		
//		return true;
//	}
	
	public abstract Cube getEquivalentCube();
	
	 
}
