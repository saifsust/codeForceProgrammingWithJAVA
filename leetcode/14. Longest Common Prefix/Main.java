import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{

    class Solution
    {
        public String longestCommonPrefix(String[] strs)
        {
            String longestCommonPrefix = "";
            if(strs.length < 1)return "";
            if(strs.length == 1)return strs[0];
            int maxLength = 1000000000;
            String temp = strs[0];

            for(int i = 1; i < strs.length; i++)
            {
                String temp2 = strs[i];
                int length = 0;
                String prefix = "";
                for(int j = 0; j < temp2.length() && j < temp.length(); j++)
                {
                    if(temp.charAt(j) == temp2.charAt(j))
                    {
                        length++;
                        prefix += temp.charAt(j);

                    }
                    else break;
                }
                if(maxLength > length)
                {
                    maxLength = length;
                    longestCommonPrefix = prefix;
                }
            }

            return longestCommonPrefix;
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
            String strs[] = new String[num];
            for(int i = 0; i < num; i++ )strs[i] = read.next();

            System.out.println(sol.longestCommonPrefix(strs));


        }

        read.close();



    }

}