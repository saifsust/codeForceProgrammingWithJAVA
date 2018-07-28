import java.util.*;
import java.io.*;
/**
 *
 *@NAME SAIFUL ISLAM
 *@BATCH SUST CSE 2013-14
 *@Email : saiful.sust.cse@gmail.com
 *@Facebok : https://www.facebook.com/SaifulIslamLitonSust
*/

public class Main
{
    public static void main(String[] args)
    {
        Reader read = new Reader();
        long n, m, a;
        while((n = read.nextLong()) != -1)
        {
            m = read.nextLong();
            a = read.nextLong();
            /** 
            * need to pave stone first line = m%a == 0 ? m/a :(m/a)+1;
            * require space n = n-a
            * need to pave next  al lines line = first line + first line * (n%a ==0 ? n/a :(n/a)+1 
            *
            **/
            long countStone = m % a == 0 ? m / a : (m / a) + 1;
            n -= a;
            if(n > 0)
            {
                long mul = n % a == 0 ? n / a : (n / a) + 1;
                // System.out.println(countStone + "  " + mul);
                countStone += mul * countStone;
            }
            System.out.println(countStone);



        }



    }
    static boolean isPossible(int w)
    {
        for(int i = 2; i < w; i += 2)
        {
            if( (w - i) != 0 &&  (w - i) % 2 == 0)return true;
        }
        return false;
    }

    //faster input
    static class Reader
    {

        private BufferedReader buffer ;
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