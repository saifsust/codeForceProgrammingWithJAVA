// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    private static final int NN = 1000001;
    private static final int MOD = 1000000007;
    private static long dp[] = new long[NN];
    
     public Solution(){
         for(int i = 0; i< NN; i++) dp[i] = 0;
         dp[0]=dp[1] = 1;
         for(int i = 2; i<NN; i++){
             dp[i] = (dp[i-1] % MOD + (i-1) * dp[i - 2] % MOD) % MOD;
         }
     }
    
    public long countFriendsPairings(int n) 
    {
       return dp[n];
    }
}    
 
