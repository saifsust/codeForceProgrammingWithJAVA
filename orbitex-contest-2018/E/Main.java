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



    static int restaurant(int l, int b)
    {
        int area = l * b;
        int size = 1;
        for(int i = 1;  i * i <= area; ++i)
        {
            int sqr = i * i;
            if(area % sqr == 0 && l%i == 0 && b%i == 0 )
            {
                size = area / sqr;
            }
        }

        return size;

    }



    public static void main(String[] args)
    {

      while(sread.hasNext()){
        int l = sread.nextInt();
        int b = sread.nextInt();

        System.out.println(restaurant(l,b));
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