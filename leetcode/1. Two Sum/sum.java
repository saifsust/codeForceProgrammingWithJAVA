import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{



    private static class Solution
    {
        int sum[];
        public int[] twoSum(int[] nums, int target)
        {
            sum = new int[2];

            for(int i = 0; i < nums.length - 1; i++)
            {
                for(int j = i + 1; j < nums.length; j++)
                {
                    if(nums[i] + nums[j] == target)
                    {
                        sum[0] = i;
                        sum[1] = j;
                        return sum;
                    }

                }
            }

            return sum;

        }
    }

    public static void main(String[] args)
    {

        Scanner read = new Scanner(System.in);
        Solution sol = new Solution();

        while(read.hasNext())
        {
            int num = read.nextInt();

            int[] nums = new int[num + 1];
            for(int i = 0; i < num; i++)nums[i] = read.nextInt();
            int target = read.nextInt();
            int[] sum = sol.twoSum(nums, target);
            for(int i = 0; i < sum.length; i++)System.out.print(sum[i] + " ");
            System.out.println();




        }


        read.close();

    }

}