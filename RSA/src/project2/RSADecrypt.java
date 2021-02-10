package project2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Scanner;
public class RSADecrypt {

	public static void main(String[] args) {
		// READ FILE AND SPLIT INPUTS. 
		String[] message = getFileContents(args[0]);

		// GET KEYS -> d , n 
		BigInteger[] d_n = getPublickey(args[1]);
		// Print out d and n in the console. 

		// DECRYPT
		String decryptedMessage = decrypt(d_n[0], d_n[1], message);
		System.out.println("Decrypted Message:\n" + decryptedMessage);
		// write decrypted message to "test.dec"
		write(decryptedMessage);
	}



	private static void write(String decrypted_Messaege) {
		try {
	         BufferedWriter out = new BufferedWriter(new FileWriter("test.dec"));
	         //Subtracted last character because it is a blankspace.
	         out.write(decrypted_Messaege);
	         out.close();
	         System.out.println("\nFile \"test.dec\" created successfully");
	      }
	      catch (IOException e1) {
	      }
	}
	


	private static String decrypt(BigInteger d, BigInteger n, String[] message) {
		String decryptedMessage = "";
		BigInteger Decrypted = new BigInteger("0");
		
		// CONVERT STRINGS TO BIGINTEGERS.
		BigInteger[] blocks = new BigInteger[message.length];
		for(int i = 0 ; i < message.length ; i++) {
			blocks[i] = new BigInteger(message[i]);
		}
		
		// DECRYPT  C^d mod n
		for(int i = 0 ; i < message.length; i++) {
			//C^d mod n
			Decrypted = blocks[i].modPow(d,n);
			//convert to string 
			decryptedMessage += convert(Decrypted);
		}
		return decryptedMessage;		
	}



	private static String convert(BigInteger decrypted) {
		//converts the decrypted message P back to plaintext
		int ascii = 65 ; 
		
		//Converts BigInteger message to string
        String str = decrypted.toString(); 
        
        //Pad with Zeroes on the front if size less than 6 in length.
        while(str.length() < 6) {
        	str = "0" + str;
        }
       // splits the string into three parts, parses it to an integer 
        // between 00-26 then adds ascii(65) which lands the digits on 65-91
       int a_ch = Integer.parseInt(str.substring(0,2)) + ascii;
       int b_ch = Integer.parseInt(str.substring(2,4)) + ascii;
       int c_ch = Integer.parseInt(str.substring(4,6)) + ascii;
       //65-90 is A-Z we consider 26 or 91 as a space character ' '
       // using that we convert each unicode value to its ascii plaintext.
       String a = (a_ch == 91)?  " ": Character.toString((char) a_ch);
       String b = (b_ch == 91)?  " ": Character.toString((char) b_ch);
       String c = (c_ch  == 91)?  " ": Character.toString((char) c_ch);
       return a+b+c;
	}



	private static BigInteger[] getPublickey(String filename) {
		// primary key has d and n 
		BigInteger[] getter = new BigInteger[2];
		String contents = "";
		char temp;
		try (InputStream in = new FileInputStream(filename)) {
	            int content;
	            while ((content = in.read()) != -1) {
	            	temp = (char) content;
	                contents += (temp >= 'A' && temp <= 'Z' ||temp >= 'a' && temp <= 'z' || temp == ' ' || temp =='=') ? "" : temp;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		String[] split = contents.split("\n");
		getter[0] = new BigInteger(split[0]);
		getter[1] = new BigInteger(split[1]);
		System.out.println("Using file \"" + filename +"\"\nExtracted : " + "\nd = "+ split[0]+ "\nn = " +split[1] +"\n");
		return getter;
	}

	private static String[] getFileContents(String filename) {
		System.out.println("Using file " +filename + "\nExtracted Message: ");
		String contents = "";
		try {
			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNextLine()) {
				contents += scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(contents + "\n");
		String[] split = contents.split(" ");
		return split;		
	}
}
