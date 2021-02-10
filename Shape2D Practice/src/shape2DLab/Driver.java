package shape2DLab;

public class Driver {

	public static void main(String[] args) {
		
		Shape2D Rectangle1 = new Rectangle(2.0, 2.0);
		Shape2D Rectangle2 = new Rectangle(-1.0, -4.0);
		
		Shape2D circle1 = new Circle(2.0);
		Shape2D circle2 = new Circle(-1.0);
		
		
		System.out.print(Rectangle1);
		System.out.print(Rectangle2);
		
		System.out.print(circle1);
		System.out.print(circle2);

	}

}
