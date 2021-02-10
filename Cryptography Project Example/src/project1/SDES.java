package project1;
import java.util.*;

public class SDES {
	public static void main(String[] args){
	
		System.out.println("Part 1 SDES Table");	

		System.out.println();
		System.out.println("Encrypting");
		encrypt_d();	//demo
		System.out.println("---------------------------------------------");
		System.out.println("Decrypting");
		decreypt_d();
	
	}

	private static void encrypt_d(){
		byte[][] key_e = new byte[4][];
		byte[][] plaintext_e = new byte[4][];
		byte[][] ciphertext_e = new byte[4][];
//having values from csns to find corresponding ciphertext
		key_e[0] = new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		key_e[1] = new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		key_e[2] = new byte[]{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		key_e[3] = new byte[]{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };

		plaintext_e[0] = new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0 };
		plaintext_e[1] = new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1 };
		plaintext_e[2] = new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0 };
		plaintext_e[3] = new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1 };

		for(int k = 0; k < 4; k++){
			ciphertext_e[k] = Encrypt(key_e[k], plaintext_e[k]);
		
			printArray(key_e[k]);
			System.out.print("       ");
			printArray(plaintext_e[k]);
			System.out.print("       ");
			printArray(ciphertext_e[k]);
			System.out.println();
		}
	}

	private static void decreypt_d(){
		byte[][] key_d = new byte[4][];
		byte[][] plaintext_d = new byte[4][];
		byte[][] ciphertext_d = new byte[4][];
		//having the values from csns to find corresponding plaintext
		key_d[0] = new byte[]{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 };
		key_d[1] = new byte[]{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 };
		key_d[2] = new byte[]{ 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 };
		key_d[3] = new byte[]{ 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 };

		ciphertext_d[0] = new byte[]{ 0, 0, 0, 1, 1, 1, 0, 0 };
		ciphertext_d[1] = new byte[]{ 1, 1, 0, 0, 0, 0, 1, 0 };
		ciphertext_d[2] = new byte[]{ 1, 0, 0, 1, 1, 1, 0, 1 };
		ciphertext_d[3] = new byte[]{ 1, 0, 0, 1, 0, 0, 0, 0 };

		for(int k = 0; k < 4; k++){
			plaintext_d[k] = Decrypt(key_d[k], ciphertext_d[k]);
			
			printArray(key_d[k]);
			System.out.print("       ");
			printArray(plaintext_d[k]);
			System.out.print("       ");
			printArray(ciphertext_d[k]);
			System.out.println();
		}
	}


	//	Encrypt & Decrypt


	public static byte[] Encrypt(byte[] rawkey, byte[] plaintext){
		byte[] key_1 = new byte[8];
		byte[] key_2 = new byte[8];
		generateKeys(rawkey, key_1, key_2);


		int capacity = (int) Math.ceil(plaintext.length / 8) * 8;
		byte[] ciphertext = new byte[capacity];

		for(int k = 0; k < plaintext.length; k += 8){
			byte[] temp_plaintext = Arrays.copyOfRange(plaintext, k, k+8);
			byte[] temp = Encrypting(key_1, key_2, temp_plaintext);
			for(int m = 0; m < 8; m++){
				ciphertext[m + k] =  temp[m];
			}
		}
		return ciphertext;
	}
	
	public static byte[] Decrypt(byte[] rawkey, byte[] ciphertext){
		byte[] key_1 = new byte[8];
		byte[] key_2 = new byte[8];
		generateKeys(rawkey, key_1, key_2);


		int capacity = (int) Math.ceil(ciphertext.length / 8) * 8;
		byte[] plaintext = new byte[capacity];

		for(int k = 0; k < ciphertext.length; k += 8){
			byte[] temp_ciphertext = Arrays.copyOfRange(ciphertext, k, k+8);
			byte[] temp = Decrypting(key_1, key_2, temp_ciphertext);
			for(int m = 0; m < 8; m++){
				plaintext[m + k] =  temp[m];
			}
		}
		return plaintext;
	}


	public static byte[] Encrypting(byte[] key_1, byte[] key_2, byte[] plaintext){
		byte[] temp = initial_Permutation(plaintext);
		f_sub_k(temp, key_1);
		temp = switch_into_half(temp);
		f_sub_k(temp, key_2);
		temp = final_Permutation(temp);
		return temp;
	}
	
	public static byte[] Decrypting(byte[] key_1, byte[] key_2, byte[] ciphertext){
		byte[] temp = initial_Permutation(ciphertext);
		f_sub_k(temp, key_2);
		temp = switch_into_half(temp);
		f_sub_k(temp, key_1);
		temp = final_Permutation(temp);
		return temp;
	}
	
	
	//	generating keys

	
	private static void generateKeys(byte[] rawkey, byte[] key_1, byte[] key_2){
		byte[] afterP10 = P10(rawkey);
		byte[] afterS1 = Circular_Shift_to_left(afterP10, 1);
		P10to8(afterS1, key_1);
		byte[] afterS2 = Circular_Shift_to_left(afterS1, 2);
		P10to8(afterS2, key_2);
	}
	
	private static byte[] P10(byte[] key_input){
		
		byte[] key_output = new byte[10];
		//got the indices for P10 from the link given in csns
		key_output[0] = key_input[2];	//the first output bit is the bit 2 of the input
		key_output[1] = key_input[4];
		key_output[2] = key_input[1];
		key_output[3] = key_input[6];
		key_output[4] = key_input[3];
		key_output[5] = key_input[9];
		key_output[6] = key_input[0];
		key_output[7] = key_input[8];
		key_output[8] = key_input[7];
		key_output[9] = key_input[5];
		
		
		
		return key_output;
	}
	
	private static byte[] Circular_Shift_to_left(byte[] key_input, int shiftToLeft){
		//shifting to left
		byte[] key_output = new byte[10];
		int temp=0;
		int count=0;

		for(int k=0; k<=9;k++) {
			
			if(k<5) {
				key_output[k] = key_input[(temp+shiftToLeft)%5];
				temp++;
			}
			else {
				key_output[k] = key_input[(count+shiftToLeft)%5+5];
				count++;
			}
		}
		
		return key_output;
	}
	
	private static void P10to8(byte[] key_input, byte[] key_output){

		//got the indices for P10 from the link given in csns
		key_output[0] = key_input[5];
		key_output[1] = key_input[2];
		key_output[2] = key_input[6];
		key_output[3] = key_input[3];
		key_output[4] = key_input[7];
		key_output[5] = key_input[4];
		key_output[6] = key_input[9];
		key_output[7] = key_input[8];		
		
	}
	
	
	private static byte[] initial_Permutation(byte[] key_input){
		
		byte[] key_output = new byte[8];
		key_output[0] = key_input[1];
		key_output[1] = key_input[5];
		key_output[2] = key_input[2];
		key_output[3] = key_input[0];
		key_output[4] = key_input[3];
		key_output[5] = key_input[7];
		key_output[6] = key_input[4];
		key_output[7] = key_input[6];
		

		
		return key_output;
	}
	//initial and final permutation are inverses of each other
	private static byte[] final_Permutation(byte[] key_input){
		
		byte[] key_output = new byte[8];
		key_output[0] = key_input[3];
		key_output[1] = key_input[0];
		key_output[2] = key_input[2];
		key_output[3] = key_input[4];
		key_output[4] = key_input[6];
		key_output[5] = key_input[1];
		key_output[6] = key_input[7];
		key_output[7] = key_input[5];
		
		return key_output;
	}
	
	
	private static byte[] switch_into_half(byte[] key_input){
		
		byte[] key_output = new byte[8];
		key_output[0] = key_input[4];
		key_output[1] = key_input[5];
		key_output[2] = key_input[6];
		key_output[3] = key_input[7];
		key_output[4] = key_input[0];
		key_output[5] = key_input[1];
		key_output[6] = key_input[2];
		key_output[7] = key_input[3];
		//dividing it into half
		return key_output;
	}

	
	private static void f_sub_k(byte[] input, byte[] key){
		byte[] Finalkey = Final(input, key);
		for(int i = 0; i < 4; i++)
			input[i] = (byte)(input[i] ^ Finalkey[i]); //^ is the XOR
	}
	
	private static byte[] Final(byte[] key_input, byte[] key){
		
		byte[] temp = new byte[8];
		temp[0] = key_input[7];
		temp[1] = key_input[4];
		temp[2] = key_input[5];
		temp[3] = key_input[6];
		temp[4] = key_input[5];
		temp[5] = key_input[6];
		temp[6] = key_input[7];
		temp[7] = key_input[4];
		
		
		for(int i = 0; i < 8; i++)
			temp[i] = (byte)(temp[i] ^ key[i]); // XOR
		
		s0(temp);
		s1(temp);
		
		//4 bit produced by S0 and S1 goes to another permutation
		
		byte[] output = new byte[4];	
		output[0] = temp[1];	
		output[1] = temp[3];
		output[2] = temp[2];
		output[3] = temp[0];
		
		return output;
	}
	
	private static void s0(byte[] input){	//S box
		byte row = (byte)(input[0] * 2 + input[3]);
		byte col = (byte)(input[1] * 2 + input[2]);
		
		byte number = S_0[row][col];
		
		input[0] = (byte)(number / 2);
		input[1] = (byte)(number % 2);
	}
	
	private static void s1(byte[] input){	//S box
		byte row = (byte)(input[4] * 2 + input[7]);
		byte col = (byte)(input[5] * 2 + input[6]);
		
		byte number = S_1[row][col];	
		
		input[2] = (byte)(number / 2);
		input[3] = (byte)(number % 2);
	}
//these values of table are given in the document
	  final static byte[][] S_0 = {
			    { 1, 0, 3, 2},
			    { 3, 2, 1, 0},
			    { 0, 2, 1, 3},
			    { 3, 1, 3, 2}
			  };

			  final static byte[][] S_1 = {
			    { 0, 1, 2, 3},
			    { 2, 0, 1, 3},
			    { 3, 0, 1, 0},
			    { 2, 1, 0, 3}
			  };

//printing the array
				public static void printArray(byte[] array){
					for(int k = 0; k < array.length; k++)
						System.out.print(array[k]);
				}
			  
}
