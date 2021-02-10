package sorting;

public class SortDriver {

	public static void main(String[] args) {
		Sorter tester = new Sorter();
		
		Circle[] testArray = tester.generateCircleArray();
		
		
		System.out.println("Unsorted");
		tester.printArray(testArray);
		
		System.out.println("Sorted");
		tester.sort(testArray);

	}

}
