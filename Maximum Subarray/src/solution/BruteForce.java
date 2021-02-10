package solution;

public class BruteForce {

	public static void BruteForceMax(int[] A) {
		int maxSoFar = 0;
		int maxEndingHere = 0;
		int start = 0, end = 0;
		int beg = 0;

		for (int i = 0; i < A.length; i++) {
			maxEndingHere = maxEndingHere + A[i];

			if (maxEndingHere < 0) {
				maxEndingHere = 0;
				beg = i + 1;
			}
			
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
				start = beg;
				end = i;
			}
		}

		
		System.out.print("The maximum subarray is: [ ");
		for (int i = start; i <= end; i++) {
			System.out.print(A[i] + " ");
		}
		
		System.out.println("]");		
		System.out.println("The maximum sum using Brute Force: " + maxSoFar);

//		System.out.print("The contiguous sub-array with the largest sum is ");
//		for (int i = start; i <= end; i++) {
//			System.out.print(A[i] + " ");
//		}
	}
}

