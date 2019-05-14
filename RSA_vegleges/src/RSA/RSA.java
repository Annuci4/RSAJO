package RSA;

import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
    public static BigInteger message;
    public static BigInteger enCrypted;
    public static BigInteger deCrypted;
    public static BigInteger phi_e;
    public static BigInteger e;
    public static BigInteger d;
    public static BigInteger n;
    public static BigInteger p;
    public static BigInteger q;
    
    public static void keyGenerator(){
       p = new BigInteger(1024, new java.util.Random());
       q = new BigInteger(1024, new java.util.Random());

        while(isPrime.millerRabin(p, 10)!=true){
            p = new BigInteger(1024, new java.util.Random());
        }		 
        while(isPrime.millerRabin(q, 10)!=true){
            q = new BigInteger(1024, new java.util.Random());
        }
        System.out.println("A p: "+ p + "\nA q: " + q );
            
        
        
    //Modulus
    n = p.multiply(q);
    
    //euler féle phi függvény
    phi_e = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        
    //e kiszámítása
    int db=0;
    for(BigInteger i = BigInteger.valueOf(2); i.compareTo(phi_e) < 0; i = i.add(BigInteger.ONE)) {
                if(LNKO.lnko(phi_e,i).equals(BigInteger.ONE)) {
                    e = i;
                    db++;
                    break;
                }
    }     
    //e = BigInteger.valueOf(65537);
    
    //d kiszámítása
    d = KEA.calculate(phi_e,e);
        //System.out.println("A d itt: "+ d );
    if (d.compareTo(BigInteger.ZERO)==-1){
        d = d.add(phi_e);
    }
  } 
    
    public static BigInteger EnCrypt(){  
        enCrypted = powerMod.PowerMod(message, e, n);
        System.out.println("A titkosítandó szöveg: " + message);
        System.out.println("A titkosított szöveg: " + enCrypted);
        return enCrypted;
    }
        
    public static BigInteger DeCrypt(){     
	BigInteger dP = d.mod(p.subtract(BigInteger.ONE));
        BigInteger dQ = d.mod(q.subtract(BigInteger.ONE));
        
        BigInteger p_modpow = powerMod.PowerMod(enCrypted, dP , p);
        BigInteger q_modpow = powerMod.PowerMod(enCrypted, dQ , q);
        
        BigInteger c1;
        BigInteger c2;
        BigInteger swap;
        if(q.compareTo(p)==1){
            swap = q;
            q = p;
            p = swap;
        }
        KEA.calculate(p,q);
        c1=KEA.x;
        c2=KEA.y;  
        System.out.println(c1);
        System.out.println(c2);

        BigInteger m = (p.multiply(p_modpow).multiply(c1)).add(q.multiply(q_modpow).multiply(c2));
        deCrypted = m.mod(n);
        
        //deCrypted = powerMod.PowerMod(enCrypted, d, n);
        System.out.println("A visszafejtett szöveg: " + deCrypted);
        return deCrypted;
    }
    
    public static void main(String[] args) {        
        message = BigInteger.valueOf(123456789);
        
        keyGenerator();
        System.out.println("modulus: " + n); 
        System.out.println("phi_e: " + phi_e);
        System.out.println("e: " + e);
        System.out.println("titkos: " + d);
        EnCrypt();
        DeCrypt(); 
        //kinai.kinai();
    }
}