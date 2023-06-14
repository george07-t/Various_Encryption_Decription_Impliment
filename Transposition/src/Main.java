import java.util.ArrayList;

class withSring{
    public void solve()
    {
        String m ="Hi this is abrar! Can yop";
        int window_size=4,len=m.length();
        int row = (int)Math.ceil(len/(double)window_size), col= window_size;
        char[][] a = new char[row][col];

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(i*window_size+j < len)
                {
                    a[i][j]= m.charAt(i*window_size+j);
                }
                else {
                    a[i][j]='0';
                }

            }
        }

        char [][] cipher = new char[col][row];

        for(int i=0;i<col;i++)
        {
            for(int j=0;j<row;j++)
            {
                cipher[i][j] = a[j][i];
            }
        }

        String c="";

        for(int i=0;i<col;i++)
        {
            for(int j=0;j<row;j++)
            {

                c+=cipher[i][j];

            }

        }

        // Decipher

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(c.charAt(j*row+i) != '0')
                    System.out.print(c.charAt(j*row+i));
            }
        }

        System.out.print("\n");




        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {

                System.out.print(a[i][j]);

            }
            System.out.print("\n");
        }

        for(int i=0;i<col;i++)
        {
            for(int j=0;j<row;j++)
            {

                System.out.print(cipher[i][j]);

            }
            System.out.print("\n");
        }


    }

}

class withArray{

    public void solve()
    {
        String s = "Hello World";
        ArrayList<ArrayList<Character>>a = new ArrayList<>();
        ArrayList<Character>t=new ArrayList<>();
        int window_size=4;
        for(int i=0;i<s.length();i++)
        {
            if(i%window_size==0 && i!=0)
            {
                a.add(new ArrayList<>(t));
                t.clear();
                t.add(s.charAt(i));

            }
            else
            {
                t.add(s.charAt(i));
            }
        }
        if(s.length()%window_size!=0)
        {

            for(int i=0;window_size>t.size();i++)
            {
                System.out.println(window_size-t.size()+" "+i);
                t.add('0');
            }
            a.add(new ArrayList<>(t));

        }

        ArrayList<ArrayList<Character>> cipher = new ArrayList<>();
        t.clear();
        for(int i=0;i<window_size;i++)
        {
            for(int j=0;j<a.size();j++)
            {
                t.add(a.get(j).get(i));
            }
            cipher.add(new ArrayList<>(t));
            t.clear();
        }


        ArrayList<ArrayList<Character>> decipher = new ArrayList<>();
        t.clear();
        for(int i=0;i<cipher.get(0).size();i++)
        {
            for(int j=0;j<cipher.size();j++)
            {
                t.add(cipher.get(j).get(i));
            }
            decipher.add(new ArrayList<>(t));
            t.clear();
        }

        for(int i=0;i<a.size();i++)
        {
            for (int j=0;j<a.get(i).size();j++)
            {
                System.out.print(a.get(i).get(j)+"");
            }
            System.out.print("\n");
        }



        for(int i=0;i<cipher.size();i++)
        {
            for (int j=0;j<cipher.get(i).size();j++)
            {
                System.out.print(cipher.get(i).get(j)+"");
            }
            System.out.print("\n");
        }

        for(int i=0;i<decipher.size();i++)
        {
            for (int j=0;j<decipher.get(i).size();j++)
            {
                if(decipher.get(i).get(j) != '0')
                    System.out.print(decipher.get(i).get(j)+"");
            }

        }

    }

}

public class Main {
    public static void main(String[] args) {

        withSring a = new withSring();
        a.solve();




    }
}