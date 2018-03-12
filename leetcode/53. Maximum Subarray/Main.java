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
            int _size = read.nextInt();
            int nums[] = new int[_size];
            for(int i = 0; i < _size; i++)nums[i] = read.nextInt();
            System.out.println(sol.maxSubArray(nums));
        }
        read.close();

    }

}

class Solution
{


    public int maxSubArray(int[] nums)
    {
        return sumArrayTree(nums, 0, nums.length - 1);
    }



    private int sumArrayTree(int[] nums, int first, int last)
    {
        if(first == last)return nums[first];
        int mid = (int)(first + last) / 2;

        return Math.max(sumArrayTree(nums, first, mid), Math.max(sumArrayTree(nums, mid + 1, last), sumOfInterval(nums, first, mid, last)));
    }

    private int sumOfInterval(int[] nums, int first, int mid, int last )
    {
        int sumOfLeft = 0;
        int left_min = Integer.MIN_VALUE;
        for(int i = mid; i >= first; i--)
        {
            sumOfLeft += nums[i];
            if(sumOfLeft > left_min)left_min = sumOfLeft;
        }

        int sumOfRight = 0;
        int right_min = Integer.MIN_VALUE;
        for(int i = mid + 1; i <= last; i++)
        {
            sumOfRight += nums[i];
            if( sumOfRight > right_min)right_min = sumOfRight;
        }



        return left_min + right_min;
        //return Math.max(sumOfLeft, Math.max(sumOfRight, wholeSum));
    }


}
