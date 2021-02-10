package shape2DLab;

public class Circle implements Shape2D {
	double PI = 3.14;
	double radius;

	public Circle(double radiusIn) {
		if (radiusIn < 0) {
			radius = 0;
		}
		else {radius = radiusIn;}
	}

	public double getPi() {
		return PI;
	}

	public void setPi(double pi) {
		this.PI = pi;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		double area = PI * (radius * radius);
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter = 2 * PI * radius;

		return perimeter;
	}

	public String toString() {
		return "Circle Area: " + getArea() + "\n" + "Circle Circumference: " + getPerimeter() +"\n";
	}
}
