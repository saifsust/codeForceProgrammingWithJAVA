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
        int testCase = read.nextInt();

        for(int test = 1; test <= testCase; ++test)
        {
            String word = read.next();
            if(word.length() - 1 <10) System.out.println(word);
            else
            {
                int length = word.length() - 1;
                System.out.println(word.charAt(0) + "" + (length - 1) + "" + word.charAt(length));
            }
        }


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
                    return null;
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