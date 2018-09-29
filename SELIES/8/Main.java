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

            String num = sread.next();
            String num2 = sread.next();
            //System.out.println(reduceZero(num));
            //System .out.println(add(num, num2));
            System.out.println(multply(num, num2));

        }





    }

    private static String reduceZero(String num)
    {
        String temp = "";
        boolean isZero = true;


        for(int i = 0; i < num.length(); ++i)
        {
            if(num.charAt(i) != '0' && isZero) isZero = false;
            if(num.charAt(i) == '0' && isZero)
                continue;
            temp += num.charAt(i);
        }
        if(temp.equals(""))return "0";
        return temp;
    }


    private static String multply(String num, String num2)
    {
        int mult, carry = 0;

        String sumNum = "", temp = "";

        for(int i = num2.length() - 1; i >= 0 ; --i)
        {

            temp = "";

            for(int j = num.length() - 1; j >= 0 ; --j)
            {

                mult =  (num.charAt(j) - '0') * (num2.charAt(i) - '0') + carry;
                carry = mult / 10;
                temp += mult % 10;
            }

            if(carry != 0) temp += carry;
            carry = 0;
            temp = reverse(temp);
            temp += addZero(num2.length() - 1 - i);

            if(temp.length() > sumNum.length())
                sumNum = add(temp, sumNum);
            else sumNum = add(sumNum, temp);
        }
        return reduceZero(sumNum);
    }


    private static String reverse(String num)
    {
        String rev = "";
        for(int i = num.length() - 1; i >= 0; --i)
        {
            rev += num.charAt(i);
        }
        return rev;
    }




    private static String addZero(int size)
    {
        String zero = "";
        for(int i = 1; i <= size; ++i) zero += '0';
        return zero;
    }

    private static String add(String num, String num2)
    {

        String sumNum = "";

        int sum, carry = 0;
        for(int i = num.length() - 1, j = num2.length() - 1; i >= 0 ; --i, --j)
        {

            if(j < 0)
            {
                sum = num.charAt(i) - '0' + carry;
                carry = sum / 10;
                sumNum += sum % 10;
            }
            else
            {
                sum = num.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
                sumNum += sum % 10;
                carry = sum / 10;
            }

        }

        if(carry != 0 ) sumNum += carry;

        return reverse(sumNum);
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