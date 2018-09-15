import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main
{

    public static void main(String[] args)
    {

        Reader read = new Reader();
        int a, b;
        int testCase = read.nextInt();
        for(int test = 1; test <= testCase; ++test)
        {
            a = read.nextInt();
            b = read.nextInt();
            System.out.println(GCD(a, b));
        }



    }
    private static int GCD(int a, int b)
    {
        if(a == 0)return b;
        return GCD(b % a, a);
    }


    // faster input reader

    private static class Reader
    {

        private BufferedReader buffer;
        private StringTokenizer tokenizer;

        public Reader()
        {
            this.tokenizer = null;
            this.buffer = new BufferedReader(new InputStreamReader(System.in), 31768);
        }

        public String nextLine()
        {
            try
            {
                return buffer.readLine();
            }
            catch(Exception ex)
            {
                return "-1";
            }
        }

        public String next()
        {

            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try
                {
                    tokenizer = new StringTokenizer(nextLine());
                }
                catch(Exception ex)
                {
                    return "eof";
                }
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

        public double nextDouble()
        {
            try
            {
                return Double.parseDouble(next());
            }
            catch(Exception ex)
            {
                return Double.MIN_VALUE;
            }
        }

    }

}