import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{


    private  class Solution
    {
        public boolean isPalindrome(int x)
        {
        	int xx=0;
        	if(x<0) xx=-1*x;
        	else xx=x;

            if(x == reverse(xx))
                return true;
            else return false;


        }

        private int reverse(int x)
        {
            long rev = 0, mod;

            while(x != 0)
            {
                rev *= 10;
                rev += x % 10;
                x /= 10;
            }
            return (int)rev;
        }

    }



    public static void main(String[] args)
    {

        Main mn = new Main();
        Main.Solution sol = mn.new Solution();
        Scanner read = new Scanner(System.in);

        while(read.hasNext())
        {
            int num = read.nextInt();
            System.out.println(sol.isPalindrome(num));
        }

        read.close();


    }


}