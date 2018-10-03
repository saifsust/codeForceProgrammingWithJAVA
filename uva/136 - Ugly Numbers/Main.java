import java.util.*;
import java.lang.*;
import java.io.*;
//import java.math.*;

public class Main
{
    //private static Scanner sread = new Scanner(System.in);
  //  private static Reader rread = new Reader();
    //private static Scanner fread = FileFactory.read();


    private static long[] ugly ;
    private static final int SIZE = 100000;


    static
    {


        int i2 = 0, i3 = 0, i5 = 0;

        long next_multiply_of_2 = 2;
        long next_multiply_of_3 = 3;
        long next_multiply_of_5 = 5;

        ugly = new long[SIZE + 1];
        ugly[0] = 1;
        for(int i = 1; i < SIZE; ++i)
        {

            long min = Math.min(next_multiply_of_2, Math.min(next_multiply_of_3, next_multiply_of_5));

            ugly[i] = min;
            if(next_multiply_of_2 == min)
            {
                ++i2;
                next_multiply_of_2 = ugly[i2] * 2;

            }

            if(next_multiply_of_3 == min)
            {
                ++i3;
                next_multiply_of_3 = ugly[i3] * 3;
            }
            if(next_multiply_of_5 == min)
            {
                ++i5;
                next_multiply_of_5 = ugly[i5] * 5;
            }


        }


    }


    public static void main(String[] args)
    {


        System.out.println("The 1500'th ugly number is "+ugly[1500-1]+".");


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