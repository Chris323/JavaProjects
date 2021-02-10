package sorts;

import java.util.Arrays;

public class SelectionSort {
	
	public static int[] SelectionSort(int[] arrayIn){      
        for (int i = 0; i < arrayIn.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < arrayIn.length; j++)
                if (arrayIn[j] < arrayIn[index]) 
                    index = j;
      
            int smallerNumber = arrayIn[index];  
            arrayIn[index] = arrayIn[i];
            arrayIn[i] = smallerNumber;
        }
        System.out.println(Arrays.toString(arrayIn));
        return arrayIn;
    }
}
