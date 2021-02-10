package palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker {
	static Stack<Character> stack = new Stack<Character>();
	static Queue<Character> queue = new LinkedList<Character>();

	public static String toLowerCase(String stringIn) {
		StringBuilder newStr = new StringBuilder();

		for (int i = 0; i < stringIn.length(); i++) {
			if (Character.isAlphabetic(stringIn.charAt(i)) == true) {
				newStr.append(Character.toLowerCase(stringIn.charAt(i)));
			}
		}
//			System.out.println(newStr.toString());
		return newStr.toString();
	}
	
	public static String reverseString(String stringIn) {
		StringBuilder dawg = new StringBuilder();
		for(int i = 0; i < stringIn.length(); i++) {
			dawg.append(stringIn.charAt(i));
		}
		dawg = dawg.reverse();
		return dawg.toString();
		
	}

	public static boolean yayOrNay(String strung) {
		for (int i = 0; i < strung.length(); i++) {
			stack.push(strung.charAt(i));
			queue.offer(strung.charAt(i));

		}
		while (!queue.isEmpty()) {
			if (!queue.remove().equals(stack.pop())) {

				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the string you want to manipulate");
		String in = input.next();

		System.out.println(toLowerCase(in));
		System.out.println(reverseString(toLowerCase(in)));
		System.out.println(yayOrNay(toLowerCase(in)));
	}

}