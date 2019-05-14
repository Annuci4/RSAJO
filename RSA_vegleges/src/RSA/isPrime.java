package RSA;

import java.math.BigInteger;

public class isPrime {
   
    public static final int[] aValues = { 2, 3 ,7, 112, 17, 29, 5, 18, 103, 49};
    
    public static boolean testPr(BigInteger n, BigInteger a, int s, BigInteger d) {
		for (int i = 0; i < s; i++) {
			BigInteger exp = BigInteger.valueOf(2).pow(i);
			exp = exp.multiply(d);
			BigInteger res = powerMod.PowerMod(a, exp, n);
			if (res.equals(n.subtract(BigInteger.ONE)) || res.equals(BigInteger.ONE)) {
				return true;
			}
		}
		return false;
    }
    public static boolean millerRabin(BigInteger n, int numValues) {
		BigInteger d = n.subtract(BigInteger.ONE); 
		int s = 0;
		while (d.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
			s++;
			d = d.divide(BigInteger.valueOf(2));
		}
		for (int i = 0; i < numValues; i++) { 
			BigInteger a = BigInteger.valueOf(aValues[i]); 
			boolean r = testPr(n, a, s, d);
			if (!r) {
				return false;
			}
		}
		return true;
    }
}