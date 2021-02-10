package project2;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class RSAEncrypt {
	public static void main(String[] args) {
		if (args.length == 2) {
			// Get message, keep case, and remove punctuation.
			String message = getFileContents(args[0]);

			// UPPERCASE
			message = message.toUpperCase();

			// CREATE CHAR ARRAY CONTAINING CHARACTERS IN SETS OF 3'S.
			char[][] char_message = getCharArray(message);

			// CONVERT set of 3's to 00-26.
			String[] converted = convertToDigits(char_message);

			// GET KEYS -> e , n
			BigInteger[] e_n = getPublickey(args[1]);
			BigInteger temp = new BigInteger("262626");
			if (e_n[1].compareTo(temp) == 1) {
				// ENCRYPT
				write(encrypt(e_n[0], e_n[1], converted));

			} else {
				System.out.println("n seems to be less than 262626");
			}

		} else {
			System.out.println(
					"Please run the program with two parameters like so : \n\tjava RSAEncrypt test.txt pub_key.txt");
		}
	}

	private static void write(String encryptedMessage) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("test.enc"));
			// Subtracted last character because it is a blankspace.
			out.write(encryptedMessage.substring(0, encryptedMessage.length() - 1));
			out.close();
			System.out.println("File created successfully: test.enc");
		} catch (IOException e1) {
		}
	}

	private static String[] convertToDigits(char[][] char_message) {
		String[] a = new String[char_message.length];
		for (int i = 0; i < char_message.length; i++) {
			a[i] = "";
			for (int j = 0; j < char_message[i].length; j++) {
				if (char_message[i][j] >= 'A' && char_message[i][j] <= 'Z') {
					int val = (int) char_message[i][j];
					val = val - 65;
					if (val < 10) {
						a[i] += "0" + val;
					} else {
						a[i] += val;
					}
				} else if (char_message[i][j] == ' ') {
					a[i] += 26;
				}
			}
		}

		return a;
	}

	private static char[][] getCharArray(String message) {
		// PADS MESSAGE IF MESSAGE LENGTH MOD 3 != 0. ADDS BLANK SPACES TO THE END.
		while (message.length() % 3 != 0) {
			message += " ";
		}
		char[][] messageArr = new char[message.length() / 3][3];
		int count = 0;
		for (int i = 0; i < messageArr.length; i++) {
			for (int j = 0; j < messageArr[i].length; j++) {
				messageArr[i][j] = message.charAt(count);
				count++;
			}
		}
		return messageArr;
	}

	private static String getFileContents(String filename) {
		System.out.println("Using file " + filename + "\nMessage: ");

		String contents = "";
		char temp;
		try (InputStream in = new FileInputStream(filename)) {
			int content;
			while ((content = in.read()) != -1) {
				temp = (char) content;
				contents += (temp >= 'A' && temp <= 'Z' || temp >= 'a' && temp <= 'z' || temp == ' ') ? temp : "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(contents);

		return contents;
	}

	private static String encrypt(BigInteger e, BigInteger n, String[] converted) {
		String encryptedMessage = "";
		BigInteger Encrypted = new BigInteger("0");
		// CONVERT STRINGS TO BIGINTEGERS.
		BigInteger[] blocks = new BigInteger[converted.length];
		for (int i = 0; i < converted.length; i++) {
			blocks[i] = new BigInteger(converted[i]);
		}
		// ENCRYPT C=P^e mod n
		for (int i = 0; i < blocks.length; i++) {
			Encrypted = blocks[i].modPow(e, n);
			encryptedMessage += Encrypted + " ";
		}

		System.out.println("Encrypted Message:\n" + encryptedMessage + "\n");
		return encryptedMessage;
	}

	private static BigInteger[] getPublickey(String filename) {
		BigInteger[] getter = new BigInteger[2];
		String contents = "";
		char temp;
		try (InputStream in = new FileInputStream(filename)) {
			int content;
			while ((content = in.read()) != -1) {
				temp = (char) content;
				contents += (temp >= 'A' && temp <= 'Z' || temp >= 'a' && temp <= 'z' || temp == ' ' || temp == '=')
						? ""
						: temp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] split = contents.split("\n");
		getter[0] = new BigInteger(split[0]);
		getter[1] = new BigInteger(split[1]);
		System.out.println(
				"\nUsing file \"" + filename + "\"\nExtracted : " + "\ne = " + split[0] + "\nn = " + split[1] + "\n");

		return getter;
	}
}
