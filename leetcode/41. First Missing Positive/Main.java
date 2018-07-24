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
            System.out.println(new Solution().firstMissingPositive(nums));

        }
        read.close();
    }
}
class Solution
{
    private final int MISS_SIZE = 1000000;
    public int firstMissingPositive(int[] nums)
    {
        if(nums == null || nums.length < 1) return 1;
        int MIN_R = Integer.MAX_VALUE, MAX_R = Integer.MIN_VALUE;
        BitSet isHave = new BitSet(1000000);
        for(int i = 0; i < nums.length; ++i)
        {
            if(nums[i] < 0) continue;
            isHave.set(nums[i], true);
            MIN_R = Math.min(nums[i], MIN_R);
            MAX_R = Math.max(nums[i], MAX_R);
        }
        if(MIN_R > 1)return 1;
        for(int i = MIN_R + 1; i <= MAX_R; ++i)
        {
            if(!isHave.get(i))return i;
        }

        return MAX_R + 1;

    }
}