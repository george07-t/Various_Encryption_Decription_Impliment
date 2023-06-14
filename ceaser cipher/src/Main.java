
class ceaser_cipher{
    public void solve()
    {
        String message = "aBBCcZz";

        String cipher="", plain="";
        int key = 3;
        for ( int i=0;i<message.length();i++)
        {
            if(Character.isUpperCase(message.charAt(i)))
            {
                cipher += (char)(((int)message.charAt(i)+key)%(int)'A' + (int)'A');
            }
            else
            {
                cipher += (char)(((int)message.charAt(i)+key)%((int)'a')+ (int)'a');
            }
        }
        System.out.println(cipher);
        for ( int i=0;i<cipher.length();i++)
        {
            if(Character.isUpperCase(message.charAt(i)))
            {
                plain += (char)(((((int)cipher.charAt(i)-key)%(int)'A') + (int)'A')%(int)'A' + (int)'A');
            }
            else
            {
                plain += (char)(((((int)cipher.charAt(i)-key)%(int)'a') + (int)'a')%(int)'a' + (int)'a');
            }
        }
        System.out.println(plain);


    }
}
public class Main {
    public static void main(String[] args) {
        ceaser_cipher c = new ceaser_cipher();
        c.solve();

    }
}