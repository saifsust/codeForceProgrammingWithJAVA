/**
 *@NAME SAIFUL ISLAM
 *@BATCH SUST CSE 2013-14
 *@Email : saiful.sust.cse@gmail.com
 *@Facebok : https://www.facebook.com/SaifulIslamLitonSust
*/


import java.util.*;
import java.io.*;
public class Main
{

    public static void main(String[] args)
    {

        //Scanner read = FileFactory.read();
        Reader read = new Reader();
        int n, a, b;
        while((n = read.nextInt()) != -1)
        {
            a = read.nextInt();
            b = read.nextInt();
            System.out.println(new Solution().nthMagicalNumber(n, a, b));
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



class Solution
{
    public int nthMagicalNumber(int N, int A, int B)
    {
        long lcm = (long) ((A * B) / gcd(A, B));
        long high = (long) Math.max(A, B) * N;
        //System.out.println(high);
        long mod = (long)1e9 + 7;
        long magicNum = binarySearch(0, high, (long)N, (long)A, (long)B, lcm);
        return (int) (magicNum % mod);

    }

    private long binarySearch(long low, long high, long searchKey, long a, long b, long lcm)
    {
        if(low < high)
        {
            long mid = (long)( (high + low) / 2);

            long nthNum = (long) (Math.floor(mid / a) + Math.floor(mid / b) - Math.floor(mid / lcm));
            if(nthNum == searchKey) return Math.max( a * (mid / a), b * (mid / b));
            else if(nthNum < searchKey) return binarySearch(mid + 1, high, searchKey, a, b, lcm);
            else return binarySearch(low, mid, searchKey, a, b, lcm);
        }
        // System.out.println(low + "  " + high);
        return low;

    }
    private int gcd(int m, int n)
    {
        if(m == 0)return n;
        return gcd(n % m, m);
    }


}