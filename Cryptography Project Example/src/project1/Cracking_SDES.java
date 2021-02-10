package project1;

public class Cracking_SDES {
	static final char c = ((char)219);
	public static void main(String[] args)
	{
		msg1();
	}
	private static void msg1(){
		System.out.println(c + c + c + " Message 1 " + c + c + c);

		byte[] key = { 0, 1, 1, 1, 0, 0, 1, 1, 0, 1 };
		String message = "CRYPTOGRAPHY";
		byte[] plaintext = CASCII.Convert(message);
		byte[] cipher_text = SDES.Encrypt(key, plaintext);

		// Original message
		System.out.println("Message: \n " + message + "\n");
		// Plain text
		System.out.println("Plaintext CASCII bits:");
		Decrypt_Message.printArray(plaintext);
		System.out.println();
		// Cipher text
		System.out.println("Cipher text CASCII bits: ");
		Decrypt_Message.printArray(cipher_text);
		System.out.println();
		// Encrypted text
		String output = CASCII.toString(cipher_text);
		System.out.println("Encrypted message: \n" + output + "\n");
		// Decrypted text
		byte[] decryptedText = SDES.Decrypt(key, cipher_text);
		System.out.print("Decrypted text: ");
		Decrypt_Message.printArray(decryptedText);
		System.out.println();
		// Decrypted message (Should return the original message)
		String result = CASCII.toString(decryptedText);
		System.out.println("Decrypted message: " + result + "\n");
	}


}
