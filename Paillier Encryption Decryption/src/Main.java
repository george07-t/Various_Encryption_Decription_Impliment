import java.math.BigInteger;

class variable{
    BigInteger x, y;

    public variable(BigInteger x, BigInteger y) {
        this.x = x;
        this.y = y;
    }
}
class Paillier {

    BigInteger zero = BigInteger.ZERO;
    BigInteger one = BigInteger.ONE;

    public variable ext_gcd(BigInteger A, BigInteger M)
    {
        if(M.equals(zero))
            return new variable(one,one);
        variable p = ext_gcd(M,A.mod(M));
        BigInteger x = p.y, y= p.x.subtract(A.divide(M).multiply(p.y));
        return new variable(x,y);
    }
    public BigInteger gcd(BigInteger A, BigInteger M)
    {
        variable p = ext_gcd(A,M);
        return A.multiply(p.x).add(M.multiply(p.y));
    }
    public BigInteger L(BigInteger x, BigInteger n)
    {
        return x.subtract(one).divide(n);
    }
    public void solve()
    {
        BigInteger p=new BigInteger("10007"),q=new BigInteger("10009");
        BigInteger n = p.multiply(q);
        BigInteger lamda = (p.subtract(one).multiply(q.subtract(one))).divide(gcd(q.subtract(one),p.subtract(one)));
        if(gcd(p.multiply(q),p.subtract(one).multiply(q.subtract(one))).equals(one))
        {
            BigInteger g = new BigInteger("11");
            BigInteger mu = g.modPow(lamda,n.multiply(n));
            mu = L(mu,n);
            variable t= ext_gcd(n,mu);
            mu = t.y.mod(n).add(n).mod(n);
            BigInteger message = new BigInteger("123");
            BigInteger r = new BigInteger("18");
            BigInteger c = (g.modPow(message,n.multiply(n)).multiply(r.modPow(n,n.multiply(n)))).mod(n.multiply(n));

            BigInteger m = c.modPow(lamda,n.multiply(n)).multiply(mu);
            m = L(m,n).mod(n);
            System.out.println("Decrypted Message "+m);

        }
        else
        {
            System.out.println("Wrong Prime");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Paillier paillier = new Paillier();
        paillier.solve();
    }
}