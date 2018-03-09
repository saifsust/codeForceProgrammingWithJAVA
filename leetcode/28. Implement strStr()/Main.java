import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{

    public static void main(String[] args)
    {
        Main mn = new Main();
        Main.Solution sol = mn.new Solution();

        Scanner read = new Scanner(System.in);

        while(read.hasNext())
        {
            String haystack = read.next();
            String needle = read.next();
            System.out.println(sol.strStr(haystack, needle));
        }

        read.close();

    }




    class Solution
    {
        public int strStr(String haystack, String needle)
        {
            if(haystack.equals("") && needle.equals(""))return 0;

            for(int i = 0; i < haystack.length(); i++)
            {
                int match = 0;

                for (int j = 0, k = i; j < needle.length() && k < haystack.length(); j++, k++ )
                {
                    if(haystack.charAt(k) != needle.charAt(j))
                    {
                        break;
                    }
                    if(haystack.charAt(k) == needle.charAt(j))
                    {
                        match++;
                    }
                }

                if(needle.length()>haystack.length()-i)
                {
                    //System.out.println("DOME");
                    return -1;
                }
                if(match == needle.length() )
                {
                    return i;
                }
            }
            return -1;
        }

    }
}
