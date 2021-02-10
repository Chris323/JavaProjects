package sorts;

import java.util.Arrays;

public class InsertionSort {
	
	 public static void insertionSort(int arrayIn[]) {    
	        for (int j = 1; j < arrayIn.length; j++) {  
	            int key = arrayIn[j];  
	            int i = j-1;  
	            while ( (i > -1) && (arrayIn [i] > key) ) {  
	                arrayIn [i+1] = arrayIn [i];  
	                i--;  
	            }  
	            arrayIn[i+1] = key;  
	        }  
	        System.out.println(Arrays.toString(arrayIn));
	    }  
}
