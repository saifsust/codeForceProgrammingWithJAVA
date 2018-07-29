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
        String first;
        //System.out.println(('S' - 's'));
        while(!(first = read.next()).equals(""))
        {
            String second = read.next();

            boolean isFirstGreater = false, isSame = true;
            for(int i = 0; i < first.length(); ++i)
            {
                int w = first.charAt(i) - second.charAt(i);
                if(w == 0 || w == 32 || w == -32)continue;
                isSame = false;
                if( charWeight(first.charAt(i)) < charWeight( second.charAt(i)))
                {
                    isFirstGreater = true;
                    break;
                }
                else break;

            }


            if(isSame)System.out.println(0);
            else if(isFirstGreater) System.out.println(-1);
            else System.out.println(1);

        }
    }

    private static int charWeight(char chr)
    {
        for(char ch = 'A', lch = 'a'; ch <= 'Z'; ++ch, ++lch)
        {
            if(ch == chr || lch == chr) return lch;

        }
        return -1;
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