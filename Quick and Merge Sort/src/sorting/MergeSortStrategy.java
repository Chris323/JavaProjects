package sorting;

public class MergeSortStrategy implements SortStrategy {
	int numComp = 0;

	@Override
	public int sort(Circle[] arrayIn) {
		if (arrayIn.length > 1) {

			Circle[] firstHalf = new Circle[arrayIn.length / 2];
			System.arraycopy(arrayIn, 0, firstHalf, 0, arrayIn.length / 2);
			sort(firstHalf);

			int lengthHalf = arrayIn.length - arrayIn.length / 2;
			Circle[] secondHalf = new Circle[lengthHalf];
			System.arraycopy(arrayIn, arrayIn.length / 2, secondHalf, 0, lengthHalf);
			sort(secondHalf);

			merge(firstHalf, secondHalf, arrayIn);
		}
		return numComp;
	}

	public void merge(Circle[] arrayIn1, Circle[] arrayIn2, Circle[] temp) {
		int current1 = 0; 
		int current2 = 0; 
		int current3 = 0; 

		while (current1 < arrayIn1.length && current2 < arrayIn2.length) {
			Circle element1 = arrayIn1[current1];
			double val1 = element1.getRadius();
			Circle element2 = arrayIn2[current2];
			numComp++;
			double val2 = element2.getRadius();
			if (val1 < val2)
				temp[current3++] = arrayIn1[current1++];
			else
				temp[current3++] = arrayIn2[current2++];
		}

		while (current1 < arrayIn1.length)
			temp[current3++] = arrayIn1[current1++];

		while (current2 < arrayIn2.length)
			temp[current3++] = arrayIn2[current2++];
	}

	public int getNumComp() {
		return numComp;
	}
}
