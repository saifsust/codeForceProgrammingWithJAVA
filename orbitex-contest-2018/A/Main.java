import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/**
 *
 *@NAME SAIFUL ISLAM
 *@BATCH SUST CSE 2013-14
 *@Email : saiful.sust.cse@gmail.com
 *@Facebok : https://www.facebook.com/SaifulIslamLitonSust
*/

public class Main
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader rread = new Reader();
    private static Scanner fread = FileFactory.read();


    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password)
    {

        int requireChar[] = new int[6];

        for(int i = 0; i < password.length(); ++i)
        {
            char chr = password.charAt(i);
            //System.out.println(chr);
            requireChar[isDigit(chr)]++;
            requireChar[isUpperCase(chr)]++;
            requireChar[isLowerCase(chr)]++;
            requireChar[isSpecialChar(chr)]++;
        }

        int counter = 0;
        for(int  i = 0; i < 4; ++i)
        {
            if(requireChar[i] == 0)++counter;
            //System.out.println(requireChar[i]+ " ");

        }

        int minAdd = 0;
        if(counter != 0 && n >= 6) return counter;
        if(counter != 0 && n < 6) return n + counter >= 6 ? counter :   +counter+(6-counter - n);
        if(n<6) return 6-n;
        return 0;

    }

    static int isDigit(char chr)
    {
        if(Character.isDigit(chr))return 0;
        return 5;
    }

    static int isUpperCase(char chr)
    {
        if(chr >= 'A'  && chr <= 'Z')return 3;
        return 5;
    }

    static int isLowerCase(char chr)
    {
        if(chr >= 'a'  && chr <= 'z')return 2;
        return 5;
    }

    static int isSpecialChar(char chr)
    {

        switch(chr)
        {
        case '!' :
        case '@' :
        case '#' :
        case '$' :
        case '%' :
        case '^' :
        case '&' :
        case '*' :
        case '(' :
        case ')' :
        case '-' :
        case '+':
            return 1;
        default :
            return 5;
        }
    }




    public static void main(String[] args)
    {

        while(sread.hasNext())
        {
            int num = sread.nextInt();
            //sread.next();
            String pass = sread.next();
            System.out.println(minimumNumber(num, pass));

        }



    }





    //faster input reader

    private static class Reader
    {
        private BufferedReader buffered;
        private StringTokenizer  tokenizer;
        public Reader()
        {
            this.buffered = new BufferedReader(new InputStreamReader(System.in), 31768);
            this.tokenizer = null;
        }

        public String nextLine()
        {
            try
            {
                return buffered.readLine();

            }
            catch(Exception ex)
            {
                return "eof";
            }
        }

        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                tokenizer = new StringTokenizer(nextLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt()
        {
            try
            {
                return Integer.parseInt(next());
            }
            catch(Exception ex)
            {
                return -1;
            }
        }

        public long nextLong()
        {
            try
            {
                return Long.parseLong(next());
            }
            catch(Exception ex)
            {
                return -1;
            }
        }

        public double nextDouble()
        {
            try
            {
                return Double.parseDouble(next());
            }
            catch(Exception ex)
            {
                return -1.0;
            }
        }


    }
}