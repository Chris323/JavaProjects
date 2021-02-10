package sols;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {
//	 public static void radixSort(int[] a, int max)  
//	    {  
//	        int bucket[][]=new int[10][10];  
//	        int bucket_count[]=new int[10];  
//	        int i, j, k, remainder, NOP=0, divisor=1, larger, pass;  
//	        larger = max;  
//	        while(larger>0)  
//	        {  
//	            NOP++;  
//	            larger/=10;  
//	        }  
//	        for(pass=0;pass<NOP;pass++) // Initialize the buckets  
//	        {  
//	            for(i=0;i<10;i++)  
//	            bucket_count[i]=0; 
//	            for(i=0;i<10;i++)  
//	            {  
//	                // sort the numbers according to the digit at passth place            
//	                remainder = (a[i]/divisor)%10;  
//	                bucket[remainder][bucket_count[remainder]] = a[i];  
//	                bucket_count[remainder] += 1;  
//	            }  
//	            // collect the numbers after PASS pass  
//	            i=0;  
//	            for(k=0;k<10;k++)  
//	            {  
//	                for(j=0;j<bucket_count[k];j++)  
//	                {  
//	                    a[i] = bucket[k][j];  
//	                    i++;  
//	                }  
//	            }  
//	            divisor *= 10;  
//	        }  
//	    }  
//	}  
	public static void radixSort(int[] input) {
	    final int RADIX = 10;
	    
	    //bucket
	    List<Integer>[] bucket = new ArrayList[RADIX];
	    
	    for (int i = 0; i < bucket.length; i++) {
	      bucket[i] = new ArrayList<Integer>();
	    }

	    // sort
	    boolean maxLength = false;
	    int tmp = -1, placement = 1;
	    while (!maxLength) {
	      maxLength = true;
	      
	      for (Integer i : input) {
	        tmp = i / placement;
	        bucket[tmp % RADIX].add(i);
	        if (maxLength && tmp > 0) {
	          maxLength = false;
	        }
	      }
	      
	      // empty lists into input array
	      int a = 0;
	      for (int b = 0; b < RADIX; b++) {
	        for (Integer i : bucket[b]) {
	          input[a++] = i;
	        }
	        bucket[b].clear();
	      }
	      
	      // next digit
	      placement *= RADIX;
	    }
	  }
}
