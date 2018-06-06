import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner read = FileFactory.read();

        while(read.hasNext())
        {
            int _size = read.nextInt();
            int[] prices = new int[_size];
            for(int i = 0; i < _size; i++) prices[i] = read.nextInt();
            int anw = new Solution().maxProfit(prices);
            System.out.println(anw);
        }
        read.close();

    }
}
class Solution
{


    public int maxProfit(int[] prices)
    {
        int maxProfit = 0;
        for(int i = 0; i < prices.length - 1; i++)
        {
            for(int j = i + 1; j < prices.length; j++)
            {
                int profit = prices[j] - prices[i];
                if(maxProfit < profit)maxProfit = profit;
            }
        }
        return maxProfit;

    }
}