import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main
{

    public static void main(String[] args)
    {

        Reader read = new Reader();

        int num ;
        while((num = read.nextInt()) != -1)
        {
            String colorConv = read.next();
            String temp = "";
            int colorCount = 0;
            int start = 0;
            for(int i = start; i < colorConv.length(); ++i)
            {
                if(i == colorConv.length() - 1)
                {
                    if(temp.length() == 0)
                    {
                        temp += colorConv.charAt(i);
                        continue;
                    }
                    if(temp.charAt(temp.length() - 1) == colorConv.charAt(i)) continue;
                    else
                    {
                        temp += colorConv.charAt(i);
                        continue;
                    }
                }
                if(colorConv.charAt(i) == colorConv.charAt(i + 1))
                {
                    ++colorCount;
                    continue;
                }
                temp += colorConv.charAt(i);
            }

            System.out.println(colorConv.length() - temp.length());
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
                    return "-1";
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

    }

}