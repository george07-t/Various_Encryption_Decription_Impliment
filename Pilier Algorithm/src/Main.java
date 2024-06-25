import java.math.BigInteger;

class Variable {
    BigInteger x, y;

    public Variable(BigInteger x, BigInteger y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    BigInteger zero = BigInteger.ZERO;
    BigInteger one = BigInteger.ONE;
    BigInteger g = new BigInteger("11");
    public Variable extGcd(BigInteger A, BigInteger M) {
        if (M.equals(zero))
            return new Variable(one, one);
        Variable p = extGcd(M, A.mod(M));
        BigInteger x = p.y, y = p.x.subtract(A.divide(M).multiply(p.y));
        return new Variable(x, y);
    }

    public BigInteger gcd(BigInteger A, BigInteger M) {
        Variable p = extGcd(A, M);
        return A.multiply(p.x).add(M.multiply(p.y));
    }

    public BigInteger L(BigInteger x, BigInteger n) {
        return x.subtract(one).divide(n);
    }

    public BigInteger encrypt(BigInteger message, BigInteger p, BigInteger q) {
        BigInteger n = p.multiply(q);
        if (gcd(p.multiply(q), p.subtract(one).multiply(q.subtract(one))).equals(one)) {
            BigInteger g = new BigInteger("11");
            BigInteger r = new BigInteger("18");
            BigInteger c = (g.modPow(message, n.multiply(n)).multiply(r.modPow(n, n.multiply(n)))).mod(n.multiply(n));
            return c;
        } else {
            System.out.println("Wrong Prime");
            return null;
        }
    }

    public BigInteger decrypt(BigInteger ciphertext, BigInteger p, BigInteger q) {
        BigInteger n = p.multiply(q);
        BigInteger lambda = (p.subtract(one).multiply(q.subtract(one))).divide(gcd(q.subtract(one), p.subtract(one)));
        if (gcd(p.multiply(q), p.subtract(one).multiply(q.subtract(one))).equals(one)) {
            BigInteger mu = g.modPow(lambda, n.multiply(n));
            mu = L(mu, n);
            Variable t = extGcd(n, mu);
            mu = t.y.mod(n).add(n).mod(n);
            BigInteger u = ciphertext.modPow(lambda, n.multiply(n));
            BigInteger m = L(u,n).multiply(mu).mod(n);

            return m;
        } else {
            System.out.println("Wrong Prime");
            return null;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        BigInteger p = new BigInteger("10089886811898868001");
        BigInteger q = new BigInteger("10092003300140014003");
        BigInteger message = new BigInteger("123");
        System.out.println("Original Message: " + message);
        BigInteger ciphertext = main.encrypt(message, p, q);
        System.out.println("Encrypted Message: " + ciphertext);
        //Encrypted Message: 1931979221342015505090130353809091786258907964444540277361992664439211308022
        BigInteger decryptedMessage = main.decrypt(ciphertext, p, q);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}