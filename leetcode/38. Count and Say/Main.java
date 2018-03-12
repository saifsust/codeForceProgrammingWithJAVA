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
            int num = read.nextInt();
            System.out.println(sol.countAndSay(num));
        }


        read.close();

    }

}


class Solution
{
    public String countAndSay(int n)
    {
        if(n == 1) return "1";
        String tmp = "1", str;
        for(int k = 1; k < n; k++)
        {
            str = "";

            for(int i = 0; i < tmp.length(); i++)
            {
                int _same = 0,j=0;
                for(j=i; j < tmp.length(); j++)
                {
                    if(tmp.charAt(i) == tmp.charAt(j))_same++;
                    else break;
                }
                i=j-1;
                str += _same;
                str += tmp.charAt(i);
            }

            tmp = str;
        }

        return tmp;
    }
}