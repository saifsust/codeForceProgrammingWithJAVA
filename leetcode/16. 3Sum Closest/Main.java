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
            int target = read.nextInt();

            System.out.println(new Solution().threeSumClosest(nums, target));

        }
        read.close();

    }
}
class Solution
{
    public int threeSumClosest(int[] nums, int target)
    {

        //if(nums.length==)

        int min = Integer.MAX_VALUE, storeSum = 0;
        for(int i = 0; i < nums.length; ++i)
        {
            for(int j = i + 1; j <= nums.length - 1; ++j)
            {
                for(int k = j + 1; k <= nums.length - 1; ++k)
                {
                    // System.out.println("Done");
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == target)return sum;
                    else
                    {
                        int dist = 0;
                        // System.out.println(sum);
                        if(sum < target)dist = target - sum;
                        else dist = sum - target;
                        if(min > dist)
                        {
                            min = dist;
                            storeSum = sum;
                        }
                    }
                }
            }
        }
        return storeSum;
    }
}