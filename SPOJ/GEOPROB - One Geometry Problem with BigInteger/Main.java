/**
 *@NAME SAIFUL ISLAM
 *@BATCH SUST CSE 2013-14
 *@Email : saiful.sust.cse@gmail.com
 *@Facebok : https://www.facebook.com/SaifulIslamLitonSust
*/


import java.util.*;
import java.io.*;
import java.math.*;
public class Main
{
    private static int[] subNums ;
    private static int[] nums;
    private static int countOper;
    private static final int inf = (int) 1e15;
    public static void main(String[] args)
    {

        //Scanner read = FileFactory.read();
        Reader read = new Reader();
        int testCase = read.nextInt();

        for(int test = 1; test <= testCase; ++test)
        {
            String b = read.next();
            String c = read.next();
            String d = read.next();
            BigInteger BigB = new BigInteger(b);
            BigInteger BigC = new BigInteger(c);
            BigInteger BigD = new BigInteger(d);
            BigInteger m = new BigInteger("2");
            BigInteger _2OfBigC = BigC.multiply(m);
            BigInteger _subtract_2OfBigC = _2OfBigC.subtract(BigB);
            BigInteger ans = _subtract_2OfBigC.subtract(BigD);
            System.out.println(ans);

        }
    }




    /// faster input reader
    private static class Reader
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
                    return "";
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
