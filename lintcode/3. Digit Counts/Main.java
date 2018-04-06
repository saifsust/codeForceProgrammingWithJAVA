import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.digitCounts(0, 19));
    }

}
class Solution
{
    /*
     * @param : An integer
     * @param : An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n)
    {
        int count = 0;
        for(int i = 0; i <= n; i++)
        {
            int num = i;
            if(num == 0 && k == 0) count++;
            while(num != 0)
            {
                if(num % 10 == k)count++;
                num /= 10;
            }

        }
        return count;
    }
}