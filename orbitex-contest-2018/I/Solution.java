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

public class Solution
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader rread = new Reader();
    //private static Scanner fread = FileFactory.read();

    private static List<Long> E1, E;

    private static BitSet isVisit;

    private static long BIT(long dx, int i)
    {
        return dx >> i & 1;
    }

    static long findConnectedComponents(long[] d, int max)
    {

        E = new ArrayList<>();
        E1 = new ArrayList<>();
        long sum = 0;
        for(int i = 0; i < d.length - 1; ++i)
        {
            for(int j = i + 1; j < d.length; ++j)
            {
                if(BIT(d[i], i) == 1 && BIT(d[j], j) == 1)
                {
                    E.add(d[i]);
                    E1.add(d[j]);
                }
            }
        }

        isVisit = new BitSet();

        return 0;

    }

    private static void dfs(int start)
    {

    }


    public static void main(String[] args)
    {


        while(sread.hasNext())
        {
            int SIZE = sread.nextInt();

            long[] d = new long[SIZE + 1];
            long max = Long.MIN_VALUE;
            for(int i = 0; i < SIZE; ++i)
            {
                d[i] = sread.nextLong();
                if(max < d[i]) max = d[i];
            }

            System.out.println(findConnectedComponents(d, max));
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