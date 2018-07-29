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
        String currSituation;
        while(!(currSituation = read.next()).equals(""))
        {
            int playerCount = 1;
            char curr = currSituation.charAt(0);
            boolean isDangerous = false;
            for(int i = 1; i < currSituation.length(); ++i)
            {
                if(curr == currSituation.charAt(i))
                {
                    ++playerCount;
                }
                else
                {
                    playerCount = 1;
                    curr = currSituation.charAt(i);

                }
                if(playerCount >= 7)
                {
                    isDangerous = true;
                    break;
                }
            }
            if(isDangerous)System.out.println("YES");
            else System.out.println("NO");
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