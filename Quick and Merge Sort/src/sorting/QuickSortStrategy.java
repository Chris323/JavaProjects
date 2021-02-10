package sorting;

public class QuickSortStrategy implements SortStrategy {
	int numComp = 0;
	
	@Override
	public int sort(Circle[] arrayIn) {
		quickSort(arrayIn, 0, arrayIn.length - 1);
		return numComp;
	}

	public void quickSort(Circle[] arrayIn, int low, int high) {
		int partition = partition(arrayIn, low, high);

		if (partition - 1 > low) {
			quickSort(arrayIn, low, partition - 1);
		}
		if (partition + 1 < high) {
			quickSort(arrayIn, partition + 1, high);
		}
	}

	public int partition(Circle[] arrayIn, int low, int high) {
		double pivot = arrayIn[high].getRadius();

		for (int i = low; i < high; i++) {
			numComp++;
			if (arrayIn[i].getRadius() < pivot) {
				Circle temp = arrayIn[low];
				arrayIn[low] = arrayIn[i];
				arrayIn[i] = temp;
				low++;
			}
		}

		Circle temp = arrayIn[low];
		arrayIn[low] = arrayIn[high];
		arrayIn[high] = temp;

		return low;
	}

	public int getNumComp() {
		return numComp;
	}
}
