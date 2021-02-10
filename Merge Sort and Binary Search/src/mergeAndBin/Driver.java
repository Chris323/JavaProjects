package mergeAndBin;

import java.util.Arrays;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MergeSort sortOf = new MergeSort();
		BinarySearch search = new BinarySearch();
		
		
		int arrAy[] = {7, 4, 8, 10, 2, 1, 5};
		
		System.out.println("Given Array:");
		System.out.println(Arrays.toString(arrAy));
		
		sortOf.sort(arrAy, 0, arrAy.length - 1);
		
		System.out.println("");
		System.out.println("Array after MergeSort:");
		System.out.println(Arrays.toString(arrAy));
		
		System.out.println("");
		System.out.println("Please enter the value you wish to search for in this array:");
		int key = input.nextInt();
		
		int index = search.runBinarySearch(arrAy, key, 0, arrAy.length - 1);
		
		if (index == 2147483647) {
		System.out.println("Value not in the array.");
		}
		else {
		System.out.println("Value is in array, index location is:");	
		System.out.println(index);
		}
	}

}
