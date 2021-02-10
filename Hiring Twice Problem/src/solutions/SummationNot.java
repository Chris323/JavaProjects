package solutions;

public class SummationNot {
	
	public double sumNotation(double in) {

		double current = 0;
		for (double i = 2; i <= in; i++) {
			current = current + (1 / (i - 1));
		//	System.out.println(current);
		}
		
		return current * (1/in);
	}

}
