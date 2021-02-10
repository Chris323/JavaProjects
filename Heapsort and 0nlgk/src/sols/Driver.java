package sols;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Heapsort heapy = new Heapsort();
		OnLgk secondSort = new OnLgk();
		Random randNum = new Random();
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Please input N value for array:");
		int nInput = input.nextInt();
		int[] randArray = new int[nInput];

		for (int i = 0; i < randArray.length; i++) {
			// the code is randNum.nextInt(max - min) + min
			randArray[i] = randNum.nextInt(20 + 20) - 20;
		}
		
		System.out.print("The random array is: ");
		System.out.println(Arrays.toString(randArray));
		
		System.out.print("The sorted array is: ");
		heapy.sort(randArray);
		System.out.println(Arrays.toString(randArray));
		
		
		System.out.println("Enter the value of N for the list: "); //int k
		int k = input.nextInt();
		System.out.println("How many elements are in each list: "); //int l
		int l = input.nextInt();
		secondSort.generateList(k, l);
		
	}
}
