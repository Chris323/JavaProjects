package solutions;

public class Permutations {
	RandomHireTwice solution = new RandomHireTwice();
	double count = 0;
	 //Prints the array 
    void printArr(int a[], int n) 
    { 
        for (int i=0; i<n; i++) 
            System.out.print(a[i] + " "); 
        System.out.println(); 
        count++;
    } 
  
    //Generating permutation using Heap Algorithm 
    void heapPermutation(int a[], int size, int n) 
    { 
        // if size becomes 1 then prints the obtained 
        // permutation 
    	
        if (size == 1 && solution.hireTwiceCheck(a) == true) 
            printArr(a,n); 
 //       	count++;
  
        for (int i=0; i<size; i++) 
        { 
            heapPermutation(a, size-1, n); 
  
            // if size is odd, swap first and last 
            // element 
            if (size % 2 == 1) 
            { 
                int temp = a[0]; 
                a[0] = a[size-1]; 
                a[size-1] = temp; 
            } 
  
            // If size is even, swap ith and last 
            // element 
            else
            { 
                int temp = a[i]; 
                a[i] = a[size-1]; 
                a[size-1] = temp; 
            } 
        } 
    } 
}
