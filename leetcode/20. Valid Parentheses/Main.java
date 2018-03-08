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
            String str = read.nextLine();

            System.out.println(sol.isValid(str));

        }


        read.close();



    }

    class Solution
    {

        private Stack<Character> stack = new Stack<Character>();

        public boolean isValid(String s)
        {
            stack.clear();
            for(int i = 0; i < s.length(); i++)
            {

                if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                {
                    stack.push(s.charAt(i));
                }
                else
                {
                    switch(s.charAt(i))
                    {
                    case ')':
                        if(stack.empty())return false;
                        else if(stack.peek() == '(')stack.pop();
                        else return false;
                        break;
                    case '}':
                        if(stack.empty())return false;
                        else if(stack.peek() == '{')stack.pop();
                        else return false;
                        break;
                    case ']' :
                        if(stack.empty())return false;
                        else if(stack.peek() == '[')stack.pop();
                        else return false;
                        break;
                    default :
                        break;
                    }
                }

            }

            if(stack.empty())return true;
            return false;

        }
    }


}