import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{

    private static final double pi = 2.0 * Math.acos(0.0);
    public static void main(String[] args)
    {

        Reader read = new Reader();

        int testCase = read.nextInt();
        for(int test = 1; test <= testCase; ++test)
        {
            double redius = read.nextDouble() ;

            System.out.printf("Case %d: %.2f\n", test, Math.pow(2.0 * redius, 2) -  pi * Math.pow(redius, 2));

        }

    }


    public static class Reader
    {
        private BufferedReader buffer;
        private StringTokenizer tokenizer;

        public Reader()
        {
            this.buffer = new BufferedReader(new InputStreamReader(System.in), 31768);
            this.tokenizer = null;
        }
        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try
                {
                    tokenizer = new StringTokenizer(buffer.readLine());
                }
                catch(Exception ex)
                {
                    return "EOF";
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
                return -1.0;
            }
        }

    }

}