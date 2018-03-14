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
            System.out.println(sol.climbStairs(num));
        }
        read.close();

    }
}
class Solution
{

    private int[] dp;
    public int climbStairs(int n)
    {
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++)
        {
            if(i == 2)dp[i] = 2;
            else dp[i] = dp[i - 1] +  dp[i - 2];
        }
        // print(dp[2]);
        return dp[n];
    }
    private void print(int[] nums)
    {
        for(int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i] + "  ");
        }
        System.out.println();
    }
}