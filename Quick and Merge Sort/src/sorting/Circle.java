package sorting;

public class Circle {
	protected double radius;
	
	public Circle(double radiusIn) {
		radius = radiusIn;
	}

	public double getRadius() {
		return radius;
	}

	public double getArea() {
		return radius * radius * Math.PI;
	}

	@Override
	public String toString() {
		return "Circle with radius: " + getRadius() + ", area: " + getArea();
	}
}
