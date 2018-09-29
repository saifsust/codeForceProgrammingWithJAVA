import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader read = new Reader();
    private static Scanner fread = FileFactory.read();

    private static final double mod = 1e12 * 1.0;
    private static final double diff = 0.0000000001;
    private static final double rang = 10000000000.0;
    public static void main(String[] args)
    {


        while(sread.hasNext())
        {

            double num = sread.nextDouble();
            System.out.println(Math.floor(sqrt(0, num, num) * rang) / rang);

        }




    }


    private static void solve()
    {



    }

    private static double sqrt(double first, double last, double num)
    {

        if(first >= last) return last;
        if (last < 0) return -1.0;

        double mid = (first + last) / 2.0;

        //System.out.println(first + " " + mid + " " + last);
        double sqt = Math.floor(mid * mid * mod);

        if(sqt / mod == num) return mid;
        else if(sqt / mod < num) return sqrt(mid + diff, last, num);
        else  return sqrt(first, mid - diff, num);



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