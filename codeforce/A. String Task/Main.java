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

        String string;
        while(!(string = read.next()).equals(""))
        {
            String temp = "";
            for(int i = 0; i < string.length(); ++i)
            {
                if(isVowel(string.charAt(i)))continue;
                char chr = isUppercase(string.charAt(i));
                if(chr != '.')
                {
                    temp += "." + chr;
                    continue;
                }
                temp += "." + string.charAt(i);

            }
            System.out.println(temp);
        }



    }


    private static char isUppercase(char chr)
    {
        for(char ch = 'A', lch = 'a'; ch <= 'Z'; ++ch, ++lch)
        {
            if(chr == ch) return lch;
        }
        return '.';
    }

    private static boolean isVowel(char chr)
    {
        switch(chr)
        {
        case 'a':
        case 'A':
        case 'e':
        case 'E':
        case 'i':
        case 'I':
        case 'o':
        case 'O':
        case 'U':
        case 'u':
        case 'Y':
        case 'y':
            return true;
        }
        return false;

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
    }
}