package shapes3D;

public class Driver {

	public static void main(String[] args) {
		Sphere Sphere1 = new Sphere(2.0);
		Sphere Sphere2 = new Sphere(4.0);
		
		Cube Cube1 = new Cube(3);
		Cube Cube2 = new Cube(4);
		
		
		System.out.println(Sphere1);
		System.out.println(Sphere1.getEquivalentCube());
		System.out.println(Sphere2);
		System.out.println(Sphere2.getEquivalentCube());
		
		System.out.println(Cube1);
		System.out.println(Cube1.getEquivalentCube());
		System.out.println(Cube2);
		System.out.println(Cube2.getEquivalentCube());
	}

}