package solutions;

public class RandomArrays {

	public int totalHiresAvg(int[] arrayIn) {
		int hireCount = 1;
		int min = arrayIn[0];
		for(int i = 1; i < arrayIn.length; i++) {
			if(arrayIn[i] < min) {
				min = arrayIn[i];
				hireCount++;
			}				
		}
		return hireCount;
		
	}
}
