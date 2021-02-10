package countingCalories;

public class Cupcake extends Portion {
	protected double radius;
	protected double height;

	public Cupcake(double radiusIn, double heightIn) {
		radius = radiusIn;
		height = heightIn;
		calories = 4 * (radiusIn * radiusIn) * heightIn;
	}

	public double getRadius() {
		return radius;
	}

	public double getHeight() {
		return height;
	}

	public double getCalories() {
		return calories;
	}

	@Override
	public String toString() {
		return "Customer eats cupcake with volume " + radius*radius*height + "and " + calories + "calories!";

	}
}
