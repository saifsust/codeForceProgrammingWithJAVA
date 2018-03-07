import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{



    private class Solution
    {



        public int romanToInt(String s)
        {

            int num = 0, nums[];
            nums = new int[s.length()];
            int lastIn = s.length() - 1;
            for(int i = s.length() - 1; i >= 0 ; i--)
            {
                if(s.length()>=2 && i<lastIn){
                    if(value(s.charAt(i))<value(s.charAt(i+1))){
                        num-=value(s.charAt(i));
                        continue;
                    }
                }
                num+=value(s.charAt(i));

            }

            return num;

        }
        private int value(char ch)
        {
            int num = 0;
            switch(ch)
            {
            case  'I':
                return 1;

            case  'V':
                return 5;
            case  'X':
                return 10;

            case  'L':
                return 50;
            case  'C':
                return 100;
            case 'D' :
                return 500;
            case  'M':
                return 1000;
            default :
                return 0;

            }

        }


    }

    public static void main(String[] args)
    {

        Main mn = new Main();
        Main.Solution sol = mn.new Solution();
        Scanner read = new Scanner(System.in);

        while(read.hasNext())
        {
            String num = read.next();
            System.out.println(sol.romanToInt(num));

        }
        read.close();

    }

}