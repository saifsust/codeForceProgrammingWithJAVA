import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {


        Reader read = new Reader();
        int testCase = read.nextInt();

        for(int test = 1; test <= testCase; ++test)
        {
            String text = read.nextLine();
            if(text == null)break;
            String temp = "";
            for(int i = 0; i < text.length(); ++i)
            {
                if(Character.isAlphabetic(text.charAt(i)))
                {
                    int chr = (int) text.charAt(i);
                    chr += 3;
                    char ch = (char)chr;
                    temp += ch;
                    continue;
                }
                temp += text.charAt(i);
            }
            //String rev = reverse(temp);
            //System.out.println(temp);
            int mid = (int)((temp.length() - 1) / 2);
            String temp2 = "";
            for(int i = 0; i < temp.length(); ++i)
            {
                if(i <= mid)
                {
                    int chr = (int) temp.charAt(i);
                    chr -= 1;
                    temp2 += (char)chr;
                    continue;
                }
                temp2 += temp.charAt(i);
            }
            //System.out.println(temp2);
            System.out.println(reverse(temp2));
        }

    }

    private static String reverse(String text)
    {
        String temp = "";
        for(int i = text.length() - 1; i >= 0; --i)
        {
            temp += text.charAt(i);
        }
        return temp;
    }






    /// faster Reader

    private static class Reader
    {
        private BufferedReader buffer;
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
                return  buffer.readLine();
            }
            catch(Exception ex)
            {
                return "";
            }


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

    }

}