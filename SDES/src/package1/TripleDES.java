package package1;

import package1.SDES;

public class TripleDES {

	public static void main(String[] args){
		

		System.out.println("Triple DES Table");
		System.out.print("K1");
		System.out.print("            ");
		System.out.print("K2");
		System.out.print("            ");
		System.out.print("Plaintext");
		System.out.print("   ");
		System.out.println("Ciphertext");

		encrypt_demonstration();
		decrypt_demonstration();

	}

	public static void encrypt_demonstration(){
		//Creating 2d arrays with k1, k2, cipher and plaintext values
		byte[][] k1 = new byte[4][];
		byte[][] k2 = new byte[4][];
		byte[][] plainText = new byte[4][];
		byte[][] cipherText = new byte[4][];

		//k1 2D array population
		k1[0] = new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		k1[1] = new byte[]{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 };
		k1[2] = new byte[]{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 };
		k1[3] = new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

		//k2 2D array population
		k2[0] = new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		k2[1] = new byte[]{ 0, 1, 1, 0, 1, 0, 1, 1, 1, 0 };
		k2[2] = new byte[]{ 0, 1, 1, 0, 1, 0, 1, 1, 1, 0 };
		k2[3] = new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

		//plaintext 2D array population
		plainText[0] = new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0 };
		plainText[1] = new byte[]{ 1, 1, 0, 1, 0, 1, 1, 1 };
		plainText[2] = new byte[]{ 1, 0, 1, 0, 1, 0, 1, 0 };
		plainText[3] = new byte[]{ 1, 0, 1, 0, 1, 0, 1, 0 };

		for(int i = 0; i < 4; i++){
			//populate second dimension of 2d array with encrypted bits
			cipherText[i] = Encrypt(k1[i], k2[i], plainText[i]);
			printText(k1[i]);
			System.out.print("    ");
			printText(k2[i]);
			System.out.print("    ");
			printText(plainText[i]);
			System.out.print("    ");
			printText(cipherText[i]);
			System.out.println();
		}
	}
	

	public static void decrypt_demonstration(){
		//Creating 2d arrays with k1, k2, cipher and plaintext values
		byte[][] k1 = new byte[4][];
		byte[][] k2 = new byte[4][];
		byte[][] cipherText = new byte[4][];
		byte[][] plainText = new byte[4][];
		
		//k1 2D array population
		k1[0] = new byte[]{ 1, 0, 0, 0, 1, 0, 1, 1, 1, 0 };
		k1[1] = new byte[]{ 1, 0, 1, 1, 1, 0, 1, 1, 1, 1 };
		k1[2] = new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		k1[3] = new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		
		//k2 2D array population
		k2[0] = new byte[]{ 0, 1, 1, 0, 1, 0, 1, 1, 1, 0 };
		k2[1] = new byte[]{ 0, 1, 1, 0, 1, 0, 1, 1, 1, 0 };
		k2[2] = new byte[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		k2[3] = new byte[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

		//ciphertext 2D array population
		cipherText[0] = new byte[]{ 1, 1, 1, 0, 0, 1, 1, 0 };
		cipherText[1] = new byte[]{ 0, 1, 0, 1, 0, 0, 0, 0 };
		cipherText[2] = new byte[]{ 1, 0, 0, 0, 0, 0, 0, 0 };
		cipherText[3] = new byte[]{ 1, 0, 0, 1, 0, 0, 1, 0 };

		for(int i = 0; i < 4; i++){
			//populate second dimension of 2d array with decrypted bits, print result
			plainText[i] = Decrypt(k1[i], k2[i], cipherText[i]);
			printText(k1[i]);
			System.out.print("    ");
			printText(k2[i]);
			System.out.print("    ");
			printText(plainText[i]);
			System.out.print("    ");
			printText(cipherText[i]);
			System.out.println();
		}
	}

	public static byte[] Encrypt( byte[] k1, byte[] k2, byte[] plaintext ){
		//Use encrypt from previous class, SDES
		//Encrypt plaintext using k1, decrypt result using k2, encrypt final result using k1 again
		return SDES.Encrypt(k1, SDES.Decrypt(k2, SDES.Encrypt(k1, plaintext)));
	}
	public static byte[] Decrypt( byte[] k1, byte[] k2, byte[] ciphertext ){
		//use decrypt from previous class, SDES
		//Decrypt ciphertext using k1, encrypt result using k2, decrypt final result using k1 again
		return SDES.Decrypt(k1, SDES.Encrypt(k2, SDES.Decrypt(k1, ciphertext)));
	}
	
	//print out array
	public static void printText(byte[] bytes){
		for(int i = 0; i < bytes.length; i++)
			System.out.print(bytes[i]);
	}
}