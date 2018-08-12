import java.util.*;
import java.math.*;
import java.io.*;
public class Main
{


    public static void main(String[] args)
    {

        Reader read = new Reader();

        int vl;
        String num;

        while((vl = read.nextInt()) != 0 && !(num = read.next()).equals("0"))
        {

            String temp = "";
            for(int i = 0; i < num.length(); ++i)
            {
                if(num.charAt(i) - '0' == vl) continue;
                temp += num.charAt(i);
            }
            System.out.println(removeZero(temp));

        }

    }
    private static String removeZero(String num)
    {

        String temp = "";
        boolean firstZero = true;
        for(int i = 0; i < num.length(); ++i)
        {
            if(num.charAt(i) - '0' == 0 && firstZero)continue;
            else
            {
                firstZero = false;
                temp += num.charAt(i);
            }
        }
        //System.out.println(temp);
        return temp.equals("") ? "0" : temp;
    }

    // faster input Reader
    private static class Reader
    {
        private BufferedReader buffer ;
        private StringTokenizer tokenizer;
        public Reader()
        {
            this.buffer = new BufferedReader(new InputStreamReader(System.in), 31768);
            this.tokenizer = null;

        }

        public String nextLine()
        {
            try
            {
                return buffer.readLine();
            }
            catch(Exception ex)
            {
                return null;
            }
        }

        public String next()
        {
            try
            {
                while( tokenizer == null || !tokenizer.hasMoreTokens())
                {
                    tokenizer = new StringTokenizer(nextLine());
                }
                return tokenizer.nextToken();
            }
            catch(Exception ex)
            {
                return "eof";
            }
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
