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

        Reader read = new Reader();
        int numOfStat ;//= read.nextInt();
        while((numOfStat = read.nextInt()) != -1)
        {
            Stack<String>statement = new Stack<String>();

            for(int i = 0; i < numOfStat; ++i)
            {
                statement.push(read.next());
            }
            int x = 0;
            while(!statement.isEmpty())
            {
                String stat = statement.peek();
                statement.pop();
                if(stat.equals("++x") || stat.equals("x++") || stat.equals("++X") || stat.equals("X++"))
                {
                    ++x;
                }
                else --x;
            }
            System.out.println(x);
            //
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