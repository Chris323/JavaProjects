package divideAndConquer;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DivideAndConquer solve = new DivideAndConquer();
		
		System.out.println("Solving a^n:");
		System.out.println("Please enter a:");
		int a = input.nextInt(); 
		
		System.out.println("Please enter n:");
        int n = input.nextInt(); 
        
        System.out.println("Answer is:");
        System.out.printf("%d", solve.powerMult(a, n)); 

	}

}
