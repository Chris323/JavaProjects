package sols;

public class CountingSort {

	public static void countingSort(int[] input, int k) {
	    // create buckets
	    int counter[] = new int[k + 1];
	    
	    // fill buckets
	    for (int i : input) {
	      counter[i]++;
	    }
	    
	    // sort array
	    int ndx = 0;
	    for (int i = 0; i < counter.length; i++) {
	      while (0 < counter[i]) {
	        input[ndx++] = i;
	        counter[i]--;
	      }
	    }
	  }
}
