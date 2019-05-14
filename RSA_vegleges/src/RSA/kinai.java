package RSA;

import java.math.BigInteger;

public class kinai {
    public static BigInteger  faszom;
    public static BigInteger kinai(){
        BigInteger pk = BigInteger.valueOf(5);
        BigInteger qk = BigInteger.valueOf(11);
        BigInteger dk = BigInteger.valueOf(23);
        BigInteger ck = BigInteger.valueOf(15);
        
        BigInteger nk= pk.multiply(qk);
        BigInteger dP = dk.mod(pk.subtract(BigInteger.ONE));
        BigInteger dQ = dk.mod(qk.subtract(BigInteger.ONE));
                System.out.println("n" + nk);

        BigInteger p_modpow = powerMod.PowerMod(ck, dP , pk);
        BigInteger q_modpow = powerMod.PowerMod(ck, dQ , qk);
        
        System.out.println("pmod"+p_modpow);
        System.out.println("qmod"+q_modpow);

        BigInteger c1;
        BigInteger c2;
        BigInteger swap;
        if(qk.compareTo(pk)==1){
            swap=qk;
            qk=pk;
            pk=swap;
        }
        System.out.println("pk"+pk);
        System.out.println("qk"+qk);

        KEA.calculate(pk,qk);
        c1=KEA.x;
        c2=KEA.y; 
        System.out.println("c1"+c1);
        System.out.println("c2"+c2);
        
        BigInteger m=(pk.multiply(p_modpow).multiply(c1)).add(qk.multiply(q_modpow).multiply(c2));
        System.out.println((pk.multiply(p_modpow).multiply(c1)));
        System.out.println((qk.multiply(q_modpow).multiply(c2)));

        System.out.println("m"+m);
        
        faszom=m.mod(nk);
        System.out.println("faszom"+faszom);
        return faszom;
    }
}
