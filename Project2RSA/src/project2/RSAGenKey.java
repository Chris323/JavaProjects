package project2;

import java.math.BigInteger;
import java.util.Random;

public class RSAGenKey {
	public static void main(String[] args) {
		if (args.length == 3) {
			// p, q, e
			KeyGenFromGiven(args);
		} else if (args.length == 1) {
			// k
			// randomly picks p and q in k bits and generates a key pair.
		}
	}

	private static void KeyGenFromGiven(String[] args) {
		Random rand = new Random();
		// STORE P, Q, E FROM ARGS
		BigInteger p = new BigInteger(args[0]);
		BigInteger q = new BigInteger(args[1]);
		BigInteger e = new BigInteger(args[2]);
		// PRINT OUT ARGS
		System.out.println("Bob chose p:" + p + "  q:" + q + "  e:" + e);
		// CALCULATE N
		BigInteger n = p.multiply(q);
		BigInteger one = new BigInteger("1");
		// CALCULATE p - 1
		BigInteger pMinusOne = p.subtract(one);
		// CALCULATE q - 1
		BigInteger qMinusOne = q.subtract(one);
		// CALCULATE phi(N) = (p-1)x(q-1)
		BigInteger phiN = pMinusOne.multiply(qMinusOne);

		// CONFIRM phiN.gcd(e) = 1
		if (phiN.gcd(e).equals(one)) {
			System.out.println("YES! gcd = 1");
		} else {
			System.out.println("No! gcd != 1");
		}

		// CALCULATE d
		BigInteger d = e.modInverse(phiN);

		// Write this to pub_key.txt file
		System.out.println("pub_key.txt: ");
		System.out.println("e: " + e);
		System.out.println("n: " + n);
		// Write this to pri_key.txt file
		System.out.println("pri_key.txt");
		System.out.println("d: " + d);
		System.out.println("n: " + n);
	}

}
