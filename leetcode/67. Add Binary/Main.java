import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        Scanner read = new Scanner(System.in);
        while(read.hasNext())
        {
            String a, b;
            a = read.next();
            b = read.next();
            System.out.println(sol.addBinary(a, b));
        }
        read.close();

    }

}

class Solution
{
    public String addBinary(String a, String b)
    {
        String sum = "";
        String min_str = "";
        if(a.length() < b.length())
        {
            min_str = a;
            a = b;
            b = min_str;
        }
        // System.out.println(a + " " + b);
        int carry = 0;
        for(int i = b.length() - 1, j = a.length() - 1; i >= 0 && j >= 0; i--, j--)
        {
            int binSum = carry + (int) b.charAt(i) - '0' + (int)a.charAt(j) - '0';
            sum += binSum % 2;
            carry = (int)binSum / 2;
            //System.out.println(a.charAt(j) + " " + b.charAt(i));
        }
        // System.out.println(carry);


        for(int i = a.length() - b.length() - 1; i >= 0; i--)
        {
            int binSum = carry + (int) a.charAt(i) - '0';
            sum += binSum % 2;
            carry = (int) binSum / 2;
        }

        if(carry == 1) sum += '1';

        return  reverse(sum);
    }
    private String reverse(String str)
    {
        String rev = "";
        boolean avoid = true;
        for(int i = str.length() - 1; i >= 0; i--)
        {
            if(str.charAt(i) == '0' && avoid)
            {
                continue;
            }
            avoid = false;
            rev += str.charAt(i);
        }
        if(rev.equals(""))return "0";

        return rev;
    }
}