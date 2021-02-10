package solutions;

import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		SummationNot sum = new SummationNot();
		RandomHireTwice solu = new RandomHireTwice();
		Random randNum = new Random();
		Permutations obj = new Permutations(); 
	         

		int nValue = 6;
		int[] firstTest = { 6, 10, 7, 8, 9 };

		// 10,000 random arrays, total hires for each, Average for all
		int totalS = 0;
		for (int i = 0; i < 10000; i++) {
			int[] arrayIn = new int[nValue];
			for (int j = 0; j < arrayIn.length; j++) {
				arrayIn[j] = randNum.nextInt(100);
			}
			if (solu.hireTwiceCheck(arrayIn) == true) {
				totalS++;
			}
		}
		double finAnswer = totalS / 10000.0;

		// 1,000,000 random arrays, total hires for each, Average for all
		int totalSes = 0;
		for (int i = 0; i < 1000000; i++) {
			int[] arrayIn = new int[nValue];
			for (int j = 0; j < arrayIn.length; j++) {
				arrayIn[j] = randNum.nextInt(100);
			}
			if (solu.hireTwiceCheck(arrayIn) == true) {
				totalS++;
			}
		}
		double finalAnswer = totalS / 1000000.0;
		
		// An array with numbers 1 - n
		int[] arrayPerm = new int [nValue];
		for (int i = 0; i < nValue; i++) {
			arrayPerm[i] = i + 1;
		}
		
		//N factorial
		double yas = 1;
		for (int i = 1; i <= nValue; i++) {
			yas = yas * i;
		}

		
		System.out.print("Question 1 is: ");
		System.out.println(sum.sumNotation(nValue));
//		System.out.println(solu.hireTwiceCheck(firstTest));
		System.out.print("Question 2 is: ");
		System.out.println(finAnswer);
		System.out.print("Question 3 is: ");
		System.out.println(finalAnswer);
		System.out.println("Question 4 Perms are: ");
		obj.heapPermutation(arrayPerm, arrayPerm.length, arrayPerm.length);
		System.out.print("Question 4 perms where hires are exactly 2: ");
		System.out.println(obj.count);
		System.out.print("Question 4 N! is: ");
		System.out.println(yas);
		System.out.print("Question 4 S/N1 is: ");
		System.out.println(obj.count/yas);

	}

}
