package solution;

import java.util.Arrays;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		DivideAndConquer divAndConq = new DivideAndConquer();
		BruteForce brutFor = new BruteForce();
		Random randNum = new Random();
		
		
		int[] randArray = new int[10];
		
		for (int i = 0; i < randArray.length; i++) {
			// the code is randNum.nextInt(max - min) + min
			randArray[i] = randNum.nextInt(20 + 20) - 20;
		}
		
		
		System.out.print("The random array is: ");
		System.out.println(Arrays.toString(randArray));
		
		brutFor.BruteForceMax(randArray);
		
		System.out.println("The maximum sum using Divide and Conquer is: " +
				divAndConq.MaximumSum(randArray, 0, randArray.length - 1));
		}

}
