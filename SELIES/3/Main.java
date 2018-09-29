import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader read = new Reader();
    private static Scanner fread = FileFactory.read();

    public static void main(String[] args)
    {


        while(sread.hasNext())
        {
            String line = sread.next();
             int size = sread.nextInt();
            System.out.println(align(line,size));
        }




    }


    private static  String align(String line, int size)
    {

        String alignText = "";

        int spaceSize  = size - line.length();
        int leftSpace, rightSpace;
        leftSpace = spaceSize / 2;
        rightSpace = spaceSize / 2;
        if(spaceSize % 2 == 1) ++leftSpace;

        alignText += addSpace(leftSpace);
        alignText += line;
        alignText += addSpace(rightSpace);
        return alignText;

    }

    private static String addSpace(int size)
    {
        String space = "";
        for(int i = 1; i <= size; ++i) space += ' ';
        return space;
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