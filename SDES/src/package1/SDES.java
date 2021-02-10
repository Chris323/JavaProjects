package package1;
import java.util.*;
public class SDES {
	public static void main(String args[]) {
		System.out.println("---------------------------------");
		System.out.println("PART 1 - COMPLETING SDES TABLE");	
		System.out.println("---------------------------------");
		System.out.println("Encrypting");
		encrypt();
		System.out.println("\nDecrypting");
		decrypt();
	}
	private static void decrypt() {
		byte[][] keys = new byte[4][];
		byte[][] pts = new byte[4][];
		byte[][] cts = new byte[4][];
		keys[0] = new byte[]{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 };
		keys[1] = new byte[]{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 };
		keys[2] = new byte[]{ 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 };
		keys[3] = new byte[]{ 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 };
		
		//cyphertext array
		cts[0] = new byte[]{ 0, 0, 0, 1, 1, 1, 0, 0 };
		cts[1] = new byte[]{ 1, 1, 0, 0, 0, 0, 1, 0 };
		cts[2] = new byte[]{ 1, 0, 0, 1, 1, 1, 0, 1 };
		cts[3] = new byte[]{ 1, 0, 0, 1, 0, 0, 0, 0 };
		System.out.println("Raw Key \tPlain Text \tCipher Text");      
		for(int k = 0; k < 4; k++){
			pts[k] = Decrypt(keys[k], cts[k]);
			print(keys[k]);
			System.out.print("\t");
			print(pts[k]);
			System.out.print("\t");
			print(cts[k]);
			System.out.println();
		}
	}
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
	private static void encrypt() {
		byte[][] keys= new byte[4][];// array of keys
		byte[][] pts = new byte[4][];// array of plain texts
		byte[][] cts = new byte[4][];
    
		//key arrays
		keys[0] = new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		keys[1] = new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		keys[2] = new byte[]{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		keys[3] = new byte[]{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		
		//plaintext arrays
		pts[0] = new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0 };
		pts[1] = new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1 };
		pts[2] = new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0 };
		pts[3] = new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1 };

//		TEST DATA
//		keys[0] = new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//		keys[1] = new byte[]{ 1, 1, 1, 0, 0, 0, 1, 1, 1, 0 };
//		keys[2] = new byte[]{ 1, 1, 1, 0, 0, 0, 1, 1, 1, 0 };
//		keys[3] = new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
//		pts[0] = new byte[]{ 1,0,1,0 ,1,0,1,0 };
//		pts[1] = new byte[]{ 1,0,1,0 ,1,0,1,0 };
//		pts[2] = new byte[]{ 0,1,0,1 ,0,1,0,1 };
//		pts[3] = new byte[]{ 1,0,1,0 ,1,0,1,0 };
		System.out.println("Raw Key \tPlain Text \tCipher Text");      
//		System.out.println("0000000000 \t00000000 \t?");      
//	    System.out.println("1111111111 \t11111111 \t?");                
//		System.out.println("0000011111 \t00000000 \t?");                
//		System.out.println("0000011111 \t11111111 \t?");           
		for(int i = 0 ; i < 4 ; i++) {
			cts[i] = Encrypt(keys[i],pts[i]);
			print(keys[i]);
			System.out.print("\t");
			print(pts[i]);
			System.out.print("\t");
			print(cts[i]);
			System.out.println();
		}

	}
	//Fully running SDES (encrypting)
	public static byte[] Encrypt(byte[] rawkey, byte[] plaintext) {
		byte[] key_1 = new byte[8]; //sub key K1 (round1)
		byte[] key_2 = new byte[8]; //sub key K2 (round2)
		KeyGenerator(rawkey, key_1, key_2);
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
	// fully running SDES (decrypting)
	public static byte[] Decrypt(byte[] rawkey, byte[] ciphertext) {
		
		int capacity = (int) Math.ceil(ciphertext.length / 8) * 8;
		byte[] plaintext = new byte[capacity];
		byte[] key_1 = new byte[8]; //sub key K1 (round1)
		byte[] key_2 = new byte[8]; //sub key K2 (round2)
		KeyGenerator(rawkey, key_1, key_2);
		for(int k = 0; k < ciphertext.length; k += 8){
			byte[] temp_ciphertext = Arrays.copyOfRange(ciphertext, k, k+8);
			byte[] temp = Decrypting(key_1, key_2, temp_ciphertext);
			for(int m = 0; m < 8; m++){
				plaintext[m + k] =  temp[m];
			}
		}
		return plaintext;
	}
	//used in "Decrypt()" method
	public static byte[] Decrypting(byte[] key_1, byte[] key_2, byte[] ciphertext){
		byte[] temp = initial_Permutation(ciphertext); //begin
		f_sub_k(temp, key_2);
		temp = switch_into_half(temp);
		f_sub_k(temp, key_1);
		temp = final_Permutation(temp);
		return temp;
	}
	
	//used in "Encrypt()" method
	public static byte[] Encrypting(byte[] key_1, byte[] key_2, byte[] plaintext){
		byte[] temp = initial_Permutation(plaintext); //begin
		f_sub_k(temp, key_1); //round 1
		temp = switch_into_half(temp); //midpoint
		f_sub_k(temp, key_2); //round 2
		temp = final_Permutation(temp); //complete
		return temp;
	}
	//function used during rounds
	private static void f_sub_k(byte[] input, byte[] key){
		byte[] Finalkey = Final(input, key);
		for(int i = 0; i < 4; i++)
			input[i] = (byte)(input[i] ^ Finalkey[i]);
	}
	//inverse initial permutation
	private static byte[] final_Permutation(byte[] in){		
		return (new byte[]{in[3],in[0],in[2],in[4],in[6],in[1],in[7],in[5]});
	}
	
	//swapping halves, 8 bit key
	private static byte[] switch_into_half(byte[] in){		
		return (new byte[]{in[4], in[5], in[6], in[7], in[0], in[1], in[2], in[3]});
	}
	//used for f sub k
	private static byte[] Final(byte[] in, byte[] key){
		byte[] temp = new byte[]{in[7], in[4], in[5], in[6], in[5], in[6], in[7], in[4]};
		for(int i = 0; i< 8; i++){
			temp[i] = (byte)(temp[i] ^ key[i]);
		}
		s0(temp);
		s1(temp);
		return (new byte[]{temp[1],temp[3],temp[2],temp[0]});
	}
	//s box, used in "Final()" method
	private static void s0(byte[] input) {
		byte row = (byte)(input[0] * 2 + input[3]);
		byte col = (byte)(input[1] * 2 + input[2]);
		byte number = S_0[row][col];
		input[0] = (byte)(number / 2);
		input[1] = (byte)(number % 2);
	}
	//s box, used in "Final()" method
	private static void s1(byte[] input){	//S box
		byte row = (byte)(input[4] * 2 + input[7]);
		byte col = (byte)(input[5] * 2 + input[6]);
		
		byte number = S_1[row][col];	
		
		input[2] = (byte)(number / 2);
		input[3] = (byte)(number % 2);
	}
	//initial permutation of plaintext, also used with cyphertext
	private static byte[] initial_Permutation(byte[] in){
		return (new byte[]{in[1], in[5], in[2],in[0],in[3],in[7],in[4],in[6]});
	}
	//generates key from 10 bit value
	private static void KeyGenerator(byte[] rawkey, byte[] key_1, byte[] key_2) {
		byte[] afterP10 = P10(rawkey);
		byte[] LS1 = LS(afterP10, 1); // shift left once
		P10to8(LS1, key_1); // creation of sub key K1
		byte[] LS2 = LS(LS1, 2); // shift left twice
		P10to8(LS2, key_2); //creation of sub key K2
	}
	
	//Convert P10 to P8
	private static void P10to8(byte[] in, byte[] out){
		int[] indexes = {5,2,6,3,7,4,9,8};
		for (int i = 0 ; i < out.length; i++) {
			out[i] = in[indexes[i]];
		}
	}
	//Left shift of bit positions
	private static byte[] LS(byte[] in, int n) {
		byte[] out = new byte[10];
		for(int i = 0 ; i <= 4; i++) {
			out[i] = in[(i+n)%5];
		}
		for(int i = 5 ; i <= 9; i++) {
			out[i] = in[(i+n)%5+5];
		}
		return out;
	}
	private static void print(byte[] in){
		for(int i = 0 ; i < in.length ; i++) {
			System.out.print(in[i] );
		}
	}
	//P10 key gen, shift index positions
	private static byte[] P10(byte[] in) {
		byte[] out = new byte[]{in[2],in[4], in[1], in[6], in[3], in[9], in[0],in[8],in[7],in[5]};
		return out;
	}

}
