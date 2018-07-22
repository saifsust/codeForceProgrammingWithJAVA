import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{

    public static void main(String[] args)
    {

        Scanner read = new Scanner(System.in);
        while(read.hasNext())
        {
            int size = read.nextInt();
            int[] nums = new int[size];
            for(int i = 0; i < size; ++i)
            {
                nums[i] = read.nextInt();
            }

            System.out.println(new Solution().maxArea(nums));

        }
        read.close();

    }
}
class Solution
{
    public int maxArea(int[] height)
    {
        if(height.length == 1)return height[0];
        int maxWater = 0;

        for(int i = 0; i < height.length; ++i)
        {
            for(int j = height.length - 1; j > i; --j)
            {
                int Height = Math.min(height[i], height[j]);
                int Wide = Math.abs(i - j);
                ///System.out.println(Height + "  " + Wide);
                int area = Height * Wide;
                if(maxWater < area)
                {
                    maxWater = area;
                }
            }

        }
        return maxWater;

    }
}