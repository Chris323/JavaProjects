package sorts;

import java.util.Arrays;
import java.util.Random;

public class Driver {
//	protected static int[] ayRay = new int [10];

	public static void main(String[] args) {
		Random rand = new Random();
		InsertionSort iSort = new InsertionSort();
		SelectionSort sSort = new SelectionSort();
		
		int[] ayRay = new int [10];
	    for (int i = 0; i < ayRay.length; i++) {
	      ayRay[i] = rand.nextInt(100) + 1;
	    }
	    
	    int[] ayRay2 = new int [10];
	    for (int i = 0; i < ayRay2.length; i++) {
	      ayRay2[i] = rand.nextInt(100) + 1;
	    }
	    
	    System.out.println("Unsorted Array #1:");
	    System.out.println(Arrays.toString(ayRay));
	    System.out.println("Insertion Sorted Array:");
	    iSort.insertionSort(ayRay);
	    System.out.println("Unsorted Array #2:");
	    System.out.println(Arrays.toString(ayRay2));
	    System.out.println("Selection Sorted Array:");
	    sSort.SelectionSort(ayRay2);
	}

}

