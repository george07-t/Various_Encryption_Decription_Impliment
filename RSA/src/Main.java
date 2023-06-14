import java.math.BigInteger;

class varibale{
    BigInteger x, y;

    public varibale(BigInteger x, BigInteger y) {
        this.x = x;
        this.y = y;
    }
}
class RSA_Cryptography{

    BigInteger zero = BigInteger.ZERO;
    BigInteger one = BigInteger.ONE;

    public varibale ext_gcd(BigInteger A, BigInteger M)
    {
        if(M.equals(zero))
        {
            return  new varibale(one,one);
        }

        varibale p = ext_gcd(M, A.mod(M));
        BigInteger x = p.y , y=p.x.subtract((A.divide(M).multiply(p.y)));

        return  new varibale(x,y);

    }
    public void solve()
    {
        BigInteger p =new BigInteger("10007"), q = new BigInteger("10009");
        BigInteger phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger n = p.multiply(q);

        BigInteger e = new BigInteger("29");
        varibale t = ext_gcd(phi,e);

        if(t.x.multiply(phi).add(t.y.multiply(e)).equals(one))
        {
            BigInteger d = (t.y.mod(phi).add(phi)).mod(phi);
            BigInteger message = new BigInteger("9999");

            BigInteger cipher = message.modPow(e,n);
            System.out.println(cipher);
            BigInteger plain = cipher.modPow(d,n);
            System.out.println(plain);
        }
    }
}
class RSA_Digital_Signature{

    public varibale ext_gcd(BigInteger A, BigInteger M)
    {
        if(M.equals(BigInteger.ZERO))
        {
            return new varibale(BigInteger.ONE, BigInteger.ONE);
        }
        varibale p = ext_gcd(M, A.mod(M));
        BigInteger x = p.y, y = p.x.subtract((A.divide(M)).multiply(p.y));

        return new varibale(x,y);
    }
    public void solve()
    {
        BigInteger p = new BigInteger("10007"), q = new BigInteger("10009");
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger n = p.multiply(q);
        BigInteger d = new BigInteger("1004");



        varibale t = ext_gcd(phi,d);

        while (!t.x.multiply(phi).add(t.y.multiply(d)).equals(BigInteger.ONE))
        {
            d=d.add(BigInteger.ONE);
            t = ext_gcd(phi,d);
        }


        BigInteger e = t.y.mod(phi).add(phi).mod(phi);

        BigInteger m = new BigInteger("453");

        BigInteger sign = m.modPow(d,n);
        System.out.println(sign);

        BigInteger verify = sign.modPow(e,n);
        System.out.println(verify);

    }
}
public class Main {
    public static void main(String[] args) {
        RSA_Cryptography rsa = new RSA_Cryptography();
        rsa.solve();

        RSA_Digital_Signature rsa3 = new RSA_Digital_Signature();
        rsa3.solve();
    }
}