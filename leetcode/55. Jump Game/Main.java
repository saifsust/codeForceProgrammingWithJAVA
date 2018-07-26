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
            for(int i = 0; i < size; ++i)nums[i] = read.nextInt();
            System.out.println(new Solution().canJump(nums));
        }
    }
}
class Solution
{
    public boolean canJump(int[] nums)
    {
        if(nums.length > 1 && nums[0] == 0)return false;

        int[] canJump = new int[nums.length];

        Arrays.fill(canJump, Integer.MAX_VALUE);
        canJump[0] = 0;
        for(int reach = 0; reach < nums.length; ++reach)
        {
            for(int jump = reach + 1; jump < nums.length && jump <= nums[reach] + reach; ++jump)
            {
                canJump[jump] = Math.min(canJump[reach] + 1, canJump[jump]);
            }
        }
        // for(int i = 0; i < nums.length; ++i)System.out.print(canJump[i] + "  ");
        return  canJump[nums.length - 1] >= 0  && canJump[nums.length - 1] < Integer.MAX_VALUE;
    }
}