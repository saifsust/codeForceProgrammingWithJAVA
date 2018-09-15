import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main
{

    public static void main(String[] args)
    {

        Reader read = new Reader();

        long num;
        while((num = read.nextLong()) != -1)
        {
            long num2 = read.nextLong();
            System.out.println((factorial(num) + factorial(num2)));
        }


    }

    private static long factorial(long num)
    {
        if(num == 0) return 1;
        return num * factorial(num - 1);

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

    }

}