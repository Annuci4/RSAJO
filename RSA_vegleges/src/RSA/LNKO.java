package RSA;

import java.math.BigInteger;

public class LNKO{
     public static BigInteger lnko(BigInteger p, BigInteger q) {
        while (!q.equals(BigInteger.ZERO)) {
            BigInteger temp = q;
            q = p.remainder(q);
            p = temp;
        }
        return p;
}
}
