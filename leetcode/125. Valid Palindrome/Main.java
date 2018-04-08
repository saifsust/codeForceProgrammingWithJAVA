import java.util.*;
import java.lang.*;
import java.io.*;
public class Main

{

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(sol.isPalindrome("race a car"));
        //System.out.println(sol.isPalindrome("0P"));
    }
}
class Solution
{
    public boolean isPalindrome(String s)
    {
        s = s.toLowerCase();
        //System.out.println(s);
        //System.out.println(Character.isAphabetic())
        for(int i = 0, j = s.length() - 1; i < j;)
        {
            if(!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i)))
            {
                i++;
                continue;
            }
            if(!Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j)))
            {
                j--;
                continue;
            }

            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;


        }
        return true;
    }
}