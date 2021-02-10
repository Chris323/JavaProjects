package project2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Random;

public class RSAGenKey {	
	public static void main(String[] args) throws IOException {
		int bitLength = 512;
		int certainty = 10000;
		Random rnd = new Random();
		
		BigInteger p = new BigInteger(bitLength, certainty, rnd);
		BigInteger q = new BigInteger(bitLength, certainty, rnd);
		BigInteger n = p.multiply(q);
		System.out.println("n: " + n);
		BigInteger one = new BigInteger("1");
		BigInteger pMinusOne = p.subtract(one);
		BigInteger qMinusOne = q.subtract(one);
		BigInteger phiN = pMinusOne.multiply(qMinusOne);
		BigInteger e = new BigInteger("0");
		
		//Checking different potential e's to make sure the gcd of e and phiN is 1.
		while (true) {
			BigInteger tempE = new BigInteger(bitLength, rnd);
			if (phiN.gcd(tempE).equals(one)) {
				e = tempE;
				System.out.println("e: " + e);
				break;
			}
		}
		BigInteger d = e.modInverse(phiN);
		System.out.println("d: " + d);
		
		FileOutputStream fos = new FileOutputStream("pubkey.rsa");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(e);
		oos.writeObject(n);
		
		oos.close();
		
		FileOutputStream fos2 = new FileOutputStream("privkey.rsa");
		ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
		
		oos2.writeObject(d);
		oos2.writeObject(n);
		
		oos2.close();
		
	}
}
