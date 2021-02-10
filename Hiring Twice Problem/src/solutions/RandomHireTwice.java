package solutions;

public class RandomHireTwice {

	public boolean hireTwiceCheck(int[] arrayIn) {
		int hireCount = 1;
		boolean twice = false;
		int min = arrayIn[0];
		for (int i = 1; i < arrayIn.length; i++) {
			if (arrayIn[i] < min) {
				min = arrayIn[i];
				hireCount++;
			}

		}
		if (hireCount == 2) {
			twice = true;
		}

		return twice;

	}

}
