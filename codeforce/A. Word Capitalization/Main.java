import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main
{

    public static void main(String[] args)
    {

        Reader read = new Reader();

        String word ;
        while(!(word = read.next()).equals("eof"))
        {
            String capitalization = "";
            for(int i = 0; i < word.length(); ++i)
            {
                if(i == 0)
                {
                    if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')
                        capitalization += (char)(word.charAt(i) + ('A' - 'a'));
                    else capitalization += word.charAt(i);
                    continue;
                }
                capitalization += word.charAt(i);
            }
            System.out.println(capitalization);

        }

    }


    // faster input reader

    private static class Reader
    {

        private BufferedReader buffer;
        private StringTokenizer tokenizer;

        public Reader()
        {
            this.tokenizer = null;
            this.buffer = new BufferedReader(new InputStreamReader(System.in), 31768);
        }

        public String nextLine()
        {
            try
            {
                return buffer.readLine();
            }
            catch(Exception ex)
            {
                return "-1";
            }
        }

        public String next()
        {

            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try
                {
                    tokenizer = new StringTokenizer(nextLine());
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

        public double nextDouble()
        {
            try
            {
                return Double.parseDouble(next());
            }
            catch(Exception ex)
            {
                return Double.MIN_VALUE;
            }
        }

    }

}