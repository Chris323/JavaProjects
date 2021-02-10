package stringChecker;

public class RecursionMethods {

	public static void main(String[] args) {

//		String test = "hello world";
//		System.out.println(charCount(test));
//		System.out.println(reversedString(test));

	}

	public int charCount(String newStr) {

		if (newStr.equals(""))
			return 0;

		else
			return charCount(newStr.substring(1)) + 1;
	}

	public String reversedString(String stringIn) {

		if (stringIn.isEmpty()) {
			return stringIn;
		}

		else {

			return reversedString(stringIn.substring(1)) + stringIn.charAt(0);
		}
	}

}
