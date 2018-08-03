/**
 *@NAME SAIFUL ISLAM
 *@BATCH SUST CSE 2013-14
 *@Email : saiful.sust.cse@gmail.com
 *@Facebok : https://www.facebook.com/SaifulIslamLitonSust
*/


import java.util.*;
import java.io.*;
import java.math.*;
public class Main
{
    private static int[] subNums ;
    private static int[] nums;
    private static int countOper;
    private static final int inf = (int) 1e15;
    public static void main(String[] args)
    {

        Scanner read = new Scanner(System.in);//FileFactory.read();
        //Reader read = new Reader();

        String num;
        while(!(num = read.nextLine()).equals("eof"))
        {
            System.out.println(new Solution().myAtoi(num));

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
class Solution
{
    public int myAtoi(String str)
    {
        long num = 0, sign = 0;
        int m = (int) 1e9;
        boolean isSign = false, isDigit = false, isChar = false, isSpace = false;
        for(int i = 0; i < str.length(); ++i)
        {

            if(str.charAt(i) == '-'  || str.charAt(i) == '+' )
            {
                if(sign == 0) sign = 1;
                if(isDigit) return (int)(num * sign);
                if(isSign) return 0;
            }
            if(str.charAt(i) == '.')
            {
                if(sign == 0) sign = 1;
                return (int)(num * sign);
            }

            if(Character.isAlphabetic(str.charAt(i)))
            {
                isChar = true;
                break;
            }

            if(str.charAt(i) == '+')
            {
                if(sign == 0) sign = 1;
                if(isDigit) return (int) (num * sign);
                sign = 1;
                isSpace = true;
                isSign = true;
                continue;

            }

            if(str.charAt(i) == ' ' )
            {


                if(isDigit)
                {
                    if(sign == 0) sign = 1;
                    return (int) (num * sign);

                }
                if(sign == -1) return 0;
                if(sign == 1) return 0;
                isSpace = true;

                continue;
            }
            if(str.charAt(i) == '-')
            {
                if(isDigit) return 0;

                sign = -1;
                isSign = true;
                continue;
            }
            if(str.charAt(i) == '+')
            {
                isSign = true;
                continue;
            }
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9')
            {

                isSpace = false;
                isDigit = true;
                num *= 10;
                num += (int)(str.charAt(i) - '0');
                //System.out.println(num);
            }
            if(num * sign <= Integer.MIN_VALUE)
            {
                return Integer.MIN_VALUE ;

            }
            if(num * sign >= Integer.MAX_VALUE)
            {
                return Integer.MAX_VALUE;
            }
        }
        if(sign == 0) sign = 1;
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Integer.MIN_VALUE);
        return (int) (num * sign);

    }
}