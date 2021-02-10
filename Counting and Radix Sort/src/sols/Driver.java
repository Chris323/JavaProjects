package sols;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		Random randNum = new Random();
		CountingSort countS = new CountingSort();
		RadixSort radixS = new RadixSort();

		// Random Array Generation A and Max Value
		int[] randArray = new int[10];
		int max = 0;

		for (int i = 0; i < randArray.length; i++) {
			// the code is randNum.nextInt(max - min) + min
			randArray[i] = randNum.nextInt(20);
			if (randArray[i] > max) {
				max = randArray[i];
			}
		}
		
		System.out.println("Random unsorted array:");
		System.out.println(Arrays.toString(randArray));
		countS.countingSort(randArray, max);
		System.out.println("Counting Sort implemented:");
		System.out.println(Arrays.toString(randArray));

		
		// Random Array Generation B and Max Value
		int[] randArray2 = new int[10];
		int max2 = 0;

		for (int i = 0; i < randArray2.length; i++) {
			// the code is randNum.nextInt(max - min) + min
			randArray2[i] = randNum.nextInt(9999 - 1000) + 1000;
			if (randArray2[i] > max) {
				max = randArray2[i];
			}
		}
		System.out.println("Random unsorted array:");
		System.out.println(Arrays.toString(randArray2));
//		radixS.radixSort(randArray2);
		System.out.println("Radix Sort implemented:");
		System.out.println(Arrays.toString(randArray2));
		
	}

}
