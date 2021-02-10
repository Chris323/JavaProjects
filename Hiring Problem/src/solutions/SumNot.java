package solutions;

public class SumNot {

	public double sumNotation(double in) {

		double current = 0;
		for (double i = 1; i <= in; i++) {
			current = current + (1 / i);

		}

		return current;
	}
}
