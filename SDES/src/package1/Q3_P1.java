package package1;

public class Q3_P1 {
	public static void main(String[] args){
		System.out.println("3) Part 1");
		Part3_1();
	}
	private static void Part3_1(){
		byte[] key = { 0, 1, 1, 1, 0, 0, 1, 1, 0, 1 };
		String message = "CRYPTOGRAPHY";
		byte[] plaintext = CASCII.Convert(message);
		byte[] cipher_text = SDES.Encrypt(key, plaintext);

		System.out.println("Message:\n" + message + "\nPlaintext CASCII bits:");
		print(plaintext);
		System.out.println("\nCipher text CASCII bits: ");
		print(cipher_text);
		//System.out.println("Encrypted message: \n" + CASCII.toString(cipher_text) + "\n");
		//System.out.println("Decrypted message: " + CASCII.toString(SDES.Decrypt(key, cipher_text)) + "\n");
	}
	public static void print(byte[] arr){
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}