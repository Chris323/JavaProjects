package shape2DLab;

public class Rectangle implements Shape2D {
	double length;
	double width;

	public Rectangle(double lengthIn, double widthIn) {
		if (lengthIn < 0) {
			length = 0;
		}
		else {length = lengthIn;}
		
		if (widthIn < 0) {
			width = 0;
		}
		else {width = widthIn;}

	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double getArea() {
		double area = length * width;

		return area;

	}

	@Override
	public double getPerimeter() {
		double perimeter = 2 * length + 2 * width;

		return perimeter;
	}
	
	public String toString() {
		return "Rectangle Area: " + getArea() + "\n" + "Rectangle Perimeter: " + getPerimeter() +"\n";
	}
}
