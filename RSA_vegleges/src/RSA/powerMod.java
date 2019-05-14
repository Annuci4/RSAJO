package RSA;

import java.math.BigInteger;

public class powerMod {
      public static BigInteger PowerMod(BigInteger a,BigInteger b,BigInteger m){  //a^b (mod m)
            BigInteger ans = BigInteger.ONE;  
            a = a.mod(m);  
            while(!(b.equals(BigInteger.ZERO))){  
                    if((b.mod(BigInteger.valueOf(2))).equals(BigInteger.ONE)){  
                            ans = (ans.multiply(a)).mod(m);  
                            b = b.subtract(BigInteger.ONE); 
                     }  
                    b = b.divide(BigInteger.valueOf(2));  
                    a = (a.multiply(a)).mod(m);  
            }              
            return ans;      
      }
}
       
            
    

