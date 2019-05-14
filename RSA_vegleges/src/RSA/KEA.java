package RSA;

import java.math.BigInteger;

public class KEA {
    
    public static BigInteger counter = BigInteger.ONE;
    public static BigInteger lastx = BigInteger.ZERO;
    public static BigInteger lasty = BigInteger.ONE;
    public static BigInteger x = BigInteger.ONE;  
    public static BigInteger y = BigInteger.ZERO;
    
    public static BigInteger calculate(BigInteger a, BigInteger b){
        counter = counter.subtract(BigInteger.ONE);       
        while (!b.equals(BigInteger.ZERO))
        {   
            BigInteger remaind = a.remainder(b);
            BigInteger quotient = a.divide(b);
            a = b;
            b = remaind;   
            BigInteger new_x = quotient.multiply(lastx).add(x);
            BigInteger new_y = quotient.multiply(lasty).add(y);
            x = lastx;
            y = lasty;
            lastx = new_x;
            lasty = new_y;
            
            counter = counter.add(BigInteger.ONE);           
        }
        if (!counter.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO))
            x = BigInteger.ZERO.subtract(x);
        else
            y = BigInteger.ZERO.subtract(y);
        return y;
    }        
}
