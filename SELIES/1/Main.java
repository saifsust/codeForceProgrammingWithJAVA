import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader read = new Reader();
    private static Scanner fread = FileFactory.read();

    private static boolean isMatch ;
    private static String temp;

    public static void main(String[] args)
    {

        while(sread.hasNext())
        {

            String match = sread.next();
            // System.out.println(word.toLowerCase());
            String word = sread.next();
            isMatch = false;
            word = word.toLowerCase();
            match = match.toLowerCase();
            permute(0,match.length()-1,match,word);
            if(isMatch) System.out.println("True");
            else System.out.println("False");
            // System.out.println(swap(word,0,1));
            //permute(0, word.length() - 1, word, match);
        }





    }


    private static void permute(int first, int last, String word, String match)
    {

        if(first == last)
        {
            //System.out.println(word);
            boolean isM = true;
            if(match.contains(word))isMatch = true;
              
            //if(isM) isMatch = true;
            return;
        }

        for(int i = first; i <= last; ++i)
        {
            word = swap(word, first, i);
            permute(first + 1, last, word, match);
            word = swap(word, first, i);

        }



    }

    private static String swap(String word, int a, int b)
    {
        char temp;
        char[] arr = word.toCharArray();
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

        return String.valueOf(arr);

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