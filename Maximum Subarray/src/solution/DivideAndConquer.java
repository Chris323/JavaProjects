package solution;

public class DivideAndConquer {
	
	public int MaximumSum(int[] A, int left, int right) {
		
		if (right == left) {
			return A[left];
		}

		int mid = (left + right) / 2;
		int leftMax = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = mid; i >= left; i--)
		{
			sum += A[i];
			if (sum > leftMax) {
				leftMax = sum;
			}
		}

		int rightMax = Integer.MIN_VALUE;
		sum = 0;	
		for (int i = mid + 1; i <= right; i++)
		{
			sum += A[i];
			if (sum > rightMax) {
				rightMax = sum;
			}
		}

		int maxLeftRight = Integer.max(MaximumSum(A, left, mid), 
									MaximumSum(A, mid + 1, right));

		
//		System.out.println(leftMax + rightMax);
		return Integer.max(maxLeftRight, leftMax + rightMax);
	}
}
