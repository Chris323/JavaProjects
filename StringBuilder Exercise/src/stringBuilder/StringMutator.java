package stringBuilder;

import java.util.Scanner;

public class StringMutator {

	public static String getNonAlpha(String stringIn) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stringIn.length(); i++) {

			if (Character.isAlphabetic(stringIn.charAt(i)) == false) {

				sb.append(stringIn.charAt(i));

			}

		}
		System.out.println(sb.toString());

		return sb.toString();

	}

	public static String getUpper(String stringIn) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < stringIn.length(); i++) {
			if (Character.isAlphabetic(stringIn.charAt(i)) == true) {

				sb.append(Character.toUpperCase(stringIn.charAt(i)));
			}

		}
		System.out.println(sb.toString());

		return sb.toString();

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the string you want to manipulate");
		String in = input.next();

		getNonAlpha(in);
		getUpper(in);

	}

}
