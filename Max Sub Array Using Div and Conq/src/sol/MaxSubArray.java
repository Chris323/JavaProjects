package sol;

import java.util.Arrays;
import java.util.Scanner;

class MaxSubArray {

    private static Result maxCrossingSum(int arr[], int l, int m, int h) {

        int sum = 0;
        int maxLeft = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        int maxRight = arr.length - 1;
        for (int i = m + 1; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        return new Result(maxLeft, maxRight, leftSum + rightSum);
    }

    private static Result maxSubArray(int[] A, int low, int high) {

        if (low == high) {
            return new Result(low, high, A[low]);
        }

        int mid = (low + high) / 2;

        Result leftSubArray = maxSubArray(A, low, mid);
        Result rightSubArray = maxSubArray(A, mid + 1, high);
        Result maxCrossingSubArray = maxCrossingSum(A, low, mid, high);

        int leftSum = leftSubArray.sum;
        int rightSum = rightSubArray.sum;
        int crossSum = maxCrossingSubArray.sum;

        if (leftSum > rightSum && leftSum > crossSum) {
            return new Result(leftSubArray.low, leftSubArray.high, leftSubArray.sum);
        } else if (rightSum > leftSum && rightSum > crossSum) {
            return new Result(rightSubArray.low, rightSubArray.high, rightSubArray.sum);
        } else {
            return new Result(maxCrossingSubArray.low, maxCrossingSubArray.high,
                maxCrossingSubArray.sum);
        }
    }

    public static class Result {

        public int low;
        public int high;
        public int sum;
        public Result(int low, int high, int sum) {
            this.low = low;
            this.high = high;
            this.sum = sum;
        }

    }

    /* Driver program to test maxSubArray */
    public static Result maxSubArray(int[] arr) {
        return maxSubArray(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] arrString = sc.nextLine().split(" ");

        int n = arrString.length;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrString[i]);
        }

        Result result = maxSubArray(arr);

        int[] subArray = new int[result.high - result.low + 1];
        int j = 0;
        for (int i = result.low; i <= result.high; i++) {
            subArray[j++] = arr[i];
        }

        System.out.println(Arrays.toString(subArray));
        System.out.println("Sum : " + result.sum);
    }
}