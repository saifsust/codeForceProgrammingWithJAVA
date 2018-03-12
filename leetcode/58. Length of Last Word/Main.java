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
            String str = read.nextLine();
            System.out.println(sol.lengthOfLastWord(str));
        }
        read.close();

    }

}

/**** solution *****/
class Solution
{
    public int lengthOfLastWord(String s)
    {
        int len = 0;
        // if(s.equals(" "))return 0;
        boolean firstChar = false;
        for(int i = s.length() - 1; i >= 0; i--)
        {

            if(s.charAt(i) == ' ' && firstChar)break;
            if(((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' )) && !firstChar)
            {
                len = 0;
                firstChar = true;
            }



            len++;
        }
        if(!firstChar)return 0;

        return len;
    }
}