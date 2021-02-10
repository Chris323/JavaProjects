package project2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class RSAGenKey {
	public static void main(String[] args) {
		if (args.length == 3) {
			// p, q, e
			KeyGenFromGiven(args);
		} else if (args.length == 1) {
			// k
			// randomly picks p and q in k bits and generates a key pair.
			if (Integer.parseInt(args[0]) >= 10) {
				KeyGen(args);
			} else {
				System.out.println("Rerun with argument greater than or equal to 10.\nex: java RSAGenKey 10");
			}
		}
	}

	private static void KeyGen(String[] args) {
		SecureRandom random = new SecureRandom();
		Random rand = new Random();
		// STORE K FROM ARGS
		int bits = Integer.parseInt(args[0]);

		BigInteger p = BigInteger.probablePrime(bits, random);
		BigInteger q = BigInteger.probablePrime(bits, random);
		BigInteger min = new BigInteger("262626");
		do {
			p = new BigInteger(bits, 100, new Random());
			q = new BigInteger(bits, 100, new Random());
		} while ((q.compareTo(p) == 0) || (min.compareTo(p.multiply(q)) > 0));
		BigInteger n = p.multiply(q);
		BigInteger one = new BigInteger("1");
		// CALCULATE p - 1
		BigInteger pMinusOne = p.subtract(one);
		// CALCULATE q - 1
		BigInteger qMinusOne = q.subtract(one);
		// CALCULATE phi(N) = (p-1)x(q-1)
		BigInteger phiN = pMinusOne.multiply(qMinusOne);

		// Deckare e and temp
		BigInteger e = new BigInteger("0");
		BigInteger temp = new BigInteger("0");

		while (true) {
			temp = new BigInteger(bits, rand);
			if (phiN.gcd(temp).equals(one)) {
				e = temp;
				break;
			}
		}

		BigInteger d = e.modInverse(phiN);
		System.out.println("p:" + p + " q:" + q + " n:" + n + " e:" + e + " d:" + d);

		// Write this to pub_key.txt and pri_key.txt files
		write(e, n, d);
	}

	private static void KeyGenFromGiven(String[] args) {
		Random rand = new Random();
		// STORE P, Q, E FROM ARGS
		BigInteger p = new BigInteger(args[0]);
		BigInteger q = new BigInteger(args[1]);
		BigInteger e = new BigInteger(args[2]);
		// PRINT OUT ARGS
		// CALCULATE N
		BigInteger n = p.multiply(q);

		BigInteger one = new BigInteger("1");
		// CALCULATE p - 1
		BigInteger pMinusOne = p.subtract(one);
		// CALCULATE q - 1
		BigInteger qMinusOne = q.subtract(one);
		// CALCULATE phi(N) = (p-1)x(q-1)
		BigInteger phiN = pMinusOne.multiply(qMinusOne);

		// CALCULATE d
		BigInteger d = e.modInverse(phiN);
		System.out.println("p:" + p + " q:" + q + " n:" + n + " e:" + e + " d:" + d);

		// Write this to pub_key.txt and pri_key.txt files
		write(e, n, d);
	}

	private static void write(BigInteger e, BigInteger n, BigInteger d) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("pub_key.txt"));
			out.write("e = " + e + "\n");
			out.write("n = " + n);
			out.close();
			System.out.println("File \"pub_key.txt\" created successfully");
		} catch (IOException e1) {
		}
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("pri_key.txt"));
			out.write("d = " + d + "\n");
			out.write("n = " + n);
			out.close();
			System.out.println("File \"pri_key.txt\" created successfully");
		} catch (IOException e1) {
		}
	}
}
