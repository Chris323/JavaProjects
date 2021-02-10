package countingCalories;

public class Pancake extends Portion {
	protected double radius;

	public Pancake(double radiusIn) {
		radius = radiusIn;
		this.calories = radiusIn * 10;
	}

	public double getRadius() {
		return radius;
	}

	public double getCalories() {
		return calories;
	}

	@Override
	public String toString() {
		return "Customer eats cupcake with radius " + radius + "and " + calories + "calories!";

	}
}
