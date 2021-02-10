package primeNumb;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumbers {
	ArrayList<Integer> firstN = new ArrayList<>();
	ArrayList<Integer> factors = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	int range = 0;

	private void userInput() {
		System.out.println("Please enter the integer you want to place as n");
		range = input.nextInt();

	}

	private void firstNPrime() {
		int count = 0;
		int num = 2;
		while (count != range) {
			boolean prime = true;
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					prime = false;
					break;
				}
			}
			if (prime) {
				count++;
				firstN.add(num);
			}
			num++;
		}
	}

	public void numLessOrEqualToN() {
		boolean[] primes = new boolean[range + 1];
		for (int i = 2; i < primes.length; i++) {
			primes[i] = true;
		}
		int num = 2;
		while (true) {
			for (int i = 2;; i++) {
				int multiple = num * i;
				if (multiple > range) {
					break;
				} 
				else {
					primes[multiple] = false;
				}
			}
			boolean nextNumFound = false;
			for (int i = num + 1; i < range + 1; i++) {
				if (primes[i]) {
					num = i;
					nextNumFound = true;
					break;
				}
			}
			if (!nextNumFound) {
				break;
			}
		}
		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				System.out.println(i);
			}
		}
	}

	private void primeFactor() {
		for (int i = 2; i < range; i++) {
			while (range % i == 0) {
				System.out.print(i + " ");
				factors.add(i);
				range = range / i;
			}
		}
		if (range > 2) {
			System.out.print("* " + range);
			factors.add(range);
		}
	}
	
	private String finalProd() {
		StringBuilder build = new StringBuilder();
//		int prev = factors.get(0);
		int powerCount = 1;
		int powerControl = 1;
//		int current = prev;
		
		for(int i = 1; i < factors.size(); i++) {
			int current = factors.get(i);
			int prev = factors.get(i--);
			if(current == prev) {
				powerCount++;
				break;
			}
			if (current != prev && powerCount > 1) {
				build.append(prev + "^" + powerCount);
				break;
				}
			if(current != prev && powerCount == 1) {
				build.append("*" + current);
				break;
			}
		}
		System.out.print(build.toString());
		return build.toString();
		
	}

//	private void formatFactors() {
//		StringBuilder builder = new StringBuilder();
//		
//		int prev = factors.get(0);
//		int power = 1;
//		int factor = prev;
//
//		for (int i = 1; i < factors.size(); i++) {
//			factor = factors.get(i);
//			if (factor == prev) {
//				power++;
//				break;
//			} else {
//				appendFactor(builder, prev, power);
//				prev = factor;
//				power = 1;
//			}
//		}
//		appendFactor(builder, factor, power);
//		
//	}
//
	private void appendFactor(StringBuilder builder, int factor, int power) {
		builder.append(" * ").append(factor);
		if (power > 1) {
			builder.append("^").append(power);
		}
		System.out.print(builder.toString());
	}

	public void print() {
		userInput();
		firstNPrime();
		System.out.println("The first n prime numbers are:");
		System.out.println(firstN);
		System.out.println("All prime numbers equal or less than n are:");
		numLessOrEqualToN();
		System.out.print("Prime Factorization of a n is: ");
		primeFactor();
//		formatFactors();
//		finalProd();
	}
}
