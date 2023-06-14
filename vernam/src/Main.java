import java.math.BigInteger;

class vernam{
    public void solve()
    {
        int plain = 12,key =13;
        String a = Integer.toBinaryString(plain),b= Integer.toBinaryString(key);

        String c="";

        for( int i=0;i<a.length();i++)
        {
            if(a.charAt(i)==b.charAt(i))
            {
                c+="0";
            }
            else
                c+="1";
        }
        System.out.println(c);
        String m="";
        for( int i=0;i<c.length();i++)
        {
            if(c.charAt(i)==b.charAt(i))
            {
                m+="0";
            }
            else
                m+="1";
        }
        System.out.println(Integer.parseInt(m,2));



    }
}

public class Main {
    public static void main(String[] args) {
        vernam v = new vernam();
        v.solve();
    }
}