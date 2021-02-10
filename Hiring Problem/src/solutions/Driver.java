package solutions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		SumNot sum = new SumNot();
		RandomArrays hireTote = new RandomArrays();
		LnN solut = new LnN();
		Permutations pa=new Permutations();
		Random randNum = new Random();
		
		
		int valueN = 7;
		int[] firstTry = {6,5,7,3,9,2}; 
		
		
		
		//10,000 random arrays, total hires for each, Average for all
		int total = 0;
		for(int i = 0; i < 10000; i++) {
			int[] arrayIn = new int[valueN];
			for(int j = 0; j < arrayIn.length; j++) {
				arrayIn[j] = randNum.nextInt(100);
			}
			total += hireTote.totalHiresAvg(arrayIn);
		}
		double finAnswer = total/10000.0;

//		// An array with numbers 1 - n
//		int[] arrayPerm = new int [valueN];
//		for (int i = 0; i < valueN; i++) {
//			arrayPerm[i] = i + 1;
//		}
//		
//		//List of list of permutations of n!
//		List<List<Integer>> permute = pa.permute(arrayPerm);
//		
//		int counter = 0;
//		for(List<Integer> perm:permute)	{
//			counter += hireTote.totalHiresAvg(perm);
//		}
		
		
//		System.out.print(hireTote.totalHiresAvg(firstTry));		
		
		System.out.print("The answer for method one is: ");
		System.out.println(sum.sumNotation(valueN));
		System.out.print("The answer for method two is: ");
		System.out.println(finAnswer);
		System.out.println("The answer for method three is: ");
		System.out.print("The answer for method four is: ");
		System.out.println(solut.outputOfLn(valueN));
//		System.out.println(Arrays.toString(arrayPerm));
	}

}
