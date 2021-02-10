package packageUno;

public class SDES {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void encrypt_demonstration() {
		//Test 10 Bit Keys (rawkey)
		byte Testkey1[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		byte Testkey2[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 0};
		byte Testkey3[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 0};
		byte Testkey4[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 0};
	}
	
	public static byte[] Encrypt(byte[] rawkey, byte[] plaintext) {
		
		//Add return statement
		return null;
		
	}
	public static byte[] Decrypt(byte[] rawkey, byte[] ciphertext) {
		
		//Add return statment
		return null;
		
	}
	
	//step1
	private static byte[] P10(byte[] rawkey) {
		
		byte[] keyPerm = new byte[10];
		//Key transitions, given
		keyPerm[0] = rawkey[2];	
		keyPerm[1] = rawkey[4];
		keyPerm[2] = rawkey[1];
		keyPerm[3] = rawkey[6];
		keyPerm[4] = rawkey[3];
		keyPerm[5] = rawkey[9];
		keyPerm[6] = rawkey[0];
		keyPerm[7] = rawkey[8];
		keyPerm[8] = rawkey[7];
		keyPerm[9] = rawkey[5];
		
		return keyPerm;
		
	}
	
	//step 2
	private static byte[] left_ShiftK1(byte[] rawkey) {
		//Create two halves of rawkey
		byte[] halfOne =  new byte [5];
		byte[] halfTwo = new byte [5];
		
		//populate halves
		for (int i = 0; i < 5; i++) {
			halfOne[i] = rawkey[i];
		}
		
		for (int j = 0; j < rawkey.length; j++) {
			if (j > 4) {
				halfTwo[j] = rawkey[j];
			}
		}
		
		//Shifting halves one to the left
		
		byte[] firstPart = new byte [5];
		byte[] secondPart = new byte [5];
		
		firstPart[4] = halfOne[0];
		firstPart[0] = halfOne[1];
		firstPart[1] = halfOne[2];
		firstPart[2] = halfOne[3];
		firstPart[3] = halfOne[4];
		
		secondPart[4] = halfTwo[0];
		secondPart[0] = halfTwo[1];
		secondPart[1] = halfTwo[2];
		secondPart[2] = halfTwo[3];
		secondPart[3] = halfTwo[4];
		
		//combining and finishing P10 permutations
		byte[] finalList = new byte[10];
		
		finalList[0] = firstPart[0];
		finalList[1] = firstPart[1];
		finalList[2] = firstPart[2];
		finalList[3] = firstPart[3];
		finalList[4] = firstPart[4];
		finalList[5] = secondPart[0];
		finalList[6] = secondPart[1];
		finalList[7] = secondPart[2];
		finalList[8] = secondPart[3];
		finalList[9] = secondPart[4];
		
		return finalList;
	}
	
	//step 3, final step for K1, also step 5 for k2
	private static void P10to8(byte[] shiftedKey, byte[] key_output){
		//got the indices for P10 from the link given in csns
				key_output[0] = shiftedKey[5];
				key_output[1] = shiftedKey[2];
				key_output[2] = shiftedKey[6];
				key_output[3] = shiftedKey[3];
				key_output[4] = shiftedKey[7];
				key_output[5] = shiftedKey[4];
				key_output[6] = shiftedKey[9];
				key_output[7] = shiftedKey[8];
	}
	
	//step 4, starting to work on k2
	private static byte[] left_ShiftK2(byte[] ls1key) {
		//Create two halves of rawkey
		byte[] halfOne =  new byte [5];
		byte[] halfTwo = new byte [5];
		
		//populate halves
		for (int i = 0; i < 5; i++) {
			halfOne[i] = ls1key[i];
		}
		
		for (int j = 0; j < ls1key.length; j++) {
			if (j > 4) {
				halfTwo[j] = ls1key[j];
			}
		}
		
		//Shifting halves two to the left
		
		byte[] firstPart = new byte [5];
		byte[] secondPart = new byte [5];
		
		firstPart[0] = halfOne[2];
		firstPart[1] = halfOne[3];
		firstPart[2] = halfOne[4];
		firstPart[3] = halfOne[0];
		firstPart[4] = halfOne[1];
		
		secondPart[0] = halfTwo[2];
		secondPart[1] = halfTwo[3];
		secondPart[2] = halfTwo[4];
		secondPart[3] = halfTwo[0];
		secondPart[4] = halfTwo[1];
		
		//combining and finishing P10 permutations
		byte[] finalList = new byte[10];
		
		finalList[0] = firstPart[0];
		finalList[1] = firstPart[1];
		finalList[2] = firstPart[2];
		finalList[3] = firstPart[3];
		finalList[4] = firstPart[4];
		finalList[5] = secondPart[0];
		finalList[6] = secondPart[1];
		finalList[7] = secondPart[2];
		finalList[8] = secondPart[3];
		finalList[9] = secondPart[4];
		
		return finalList;
		
	}
	
	public static void generateKeys(byte[] rawkey, byte[] k1, byte[] k2) {
		byte[] p10perm = P10(rawkey);
		byte[] ls1 = left_ShiftK1(p10perm);
		//K1
		P10to8(ls1, k1);
		byte[] ls2 = left_ShiftK2(ls1);
		//K2
		P10to8(ls2, k2);
	}
}
