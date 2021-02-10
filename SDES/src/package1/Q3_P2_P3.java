package package1;

public class Q3_P2_P3 {
	static String s = "";
	public static void main(String[] args){
		System.out.println("3) Part 2");
		Decrypting_Message1();
		System.out.println("3) Part 3");
		Decrypting_Message2(); 
	}
	//part 2 message decryption
	private static void Decrypting_Message1(){
		System.out.println("Decrypting message 1:");
		String e_message1 ="1011011001111001001011101111110000111110100000000001110111010001111011111101101100010011000000101101011010101000101111100011101011010111100011101001010111101100101110000010010101110001110111011111010101010100001100011000011010101111011111010011110111001001011100101101001000011011111011000010010001011101100011011110000000110010111111010000011100011111111000010111010100001100001010011001010101010000110101101111111010010110001001000001111000000011110000011110110010010101010100001000011010000100011010101100000010111000000010101110100001000111010010010101110111010010111100011111010101111011101111000101001010001101100101100111001110111001100101100011111001100000110100001001100010000100011100000000001001010011101011100101000111011100010001111101011111100000010111110101010000000100110110111111000000111110111010100110000010110000111010001111000101011111101011101101010010100010111100011100000001010101110111111101101100101010011100111011110101011011";
		byte[] key = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		byte[] ct = CreateByteArray(e_message1);
		byte[] pt;
		for(int i= 0; i < 1024; i++){
			pt = SDES.Decrypt(key, ct);
			s = CASCII.toString(pt);
			if(checkSentence(s)) {
				print(key);
				System.out.println("\n"+s);
				return;
			}
			increment_key(key);
		}
	}
	//part 3 message decryption
	private static void Decrypting_Message2(){
		System.out.println("\n"+ "Decrypting message 2 :");
		String e_message2 = "00011111100111111110011111101100111000000011001011110010101010110001011101001101000000110011010111111110000000001010111111000001010010111001111001010101100000110111100011111101011100100100010101000011001100101000000101111011000010011010111100010001001000100001111100100000001000000001101101000000001010111010000001000010011100101111001101111011001001010001100010100000";

		byte[] key1 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		byte[] key2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		byte[] plaintext;
		byte[] ciphertext = CreateByteArray(e_message2);


		for(int k = 0; k < 1024; k++){	//n^2 complexity that's why it takes time
			for(int j = 0; j < 1024; j++){
				plaintext = TripleDES.Decrypt(key1, key2, ciphertext);
				String s = CASCII.toString(plaintext);
				//it should follow the rule
				if(checkSentence(s) && s.contains("SECRETS")){	// comment this
					print(key1);System.out.println("\n");
					print(key2);
					System.out.println("\n"+s);
					return; //comment this
				} // comment this
				increment_key(key1);
			}
			increment_key(key2);
		}
	}
	//Validation check
	private static boolean checkSentence(String s){	//punctuation rule
		char c;
		for(int i = 0; i < s.length() - 1; i++){
			c = s.charAt(i);
			if((c == '.' || c == ',' || c == '?') && s.charAt(i + 1) != ' ')
				return false;
		}
		return true;
	}
	

	private static byte[] CreateByteArray(String message){
		byte[] temp = new byte[message.length()];
		for(int i = 0; i < message.length(); i++){
			if(message.charAt(i) == '1') {
				temp[i] = (byte) 1;
			}
		}
		return temp;
	}
	//Brute force key gen
	private static void increment_key (byte[] key){
		if (key[9] == 0) {
			key[9] = 1;
			return;
		}
		else{
			key[9] = 0;
		}

		if (key[8] == 0) {
			key[8] = 1;
			return;
		}
		else{
			key[8] = 0;
		}
		if (key[7] == 0) {
			key[7] = 1;
			return;
		}
		else{
			key[7] = 0;
		}

		if (key[6] == 0) {
			key[6] = 1;
			return;
		}
		else{
			key[6] = 0;
		}

		if (key[5] == 0) {
			key[5] = 1;
			return;
		}
		else{
			key[5] = 0;
		}

		if (key[4] == 0) {
			key[4] = 1;
			return;
		}
		else{
			key[4] = 0;
		}

		if (key[3] == 0) {
			key[3] = 1;
			return;
		}
		else{
			key[3] = 0;
		}

		if (key[2] == 0) {
			key[2] = 1;
			return;
		}
		else{
			key[2] = 0;
		}

		if (key[1] == 0) {
			key[1] = 1;
			return;
		}
		else{
			key[1] = 0;
		}

		if (key[0] == 0) {
			key[0] = 1;
			return;
		}
		else{
			key[0] = 0;
		}
	}
	public static void print(byte[] arr){
		System.out.print("key: ");
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}

