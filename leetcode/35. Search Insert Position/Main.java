import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{

    public static void main(String[] args)
    {
        Main mn = new Main();
        Main.Solution sol = mn.new Solution();

        Scanner read = new Scanner(System.in);
        while(read.hasNext())
        {

            int num = read.nextInt();
            int nums[] = new int[num];
            for(int i = 0; i < num; i++)nums[i] = read.nextInt();
            int target = read.nextInt();
            System.out.println(sol.searchInsert(nums, target));

        }

        read.close();

    }

    class Solution
    {
        public int searchInsert(int[] nums, int target)
        {
            return binnarySearch(nums, 0, nums.length - 1, target);
        }

        private int binnarySearch(int[] nums , int first, int last, int target)
        {
            int mid = (int)(first + last) / 2;
            if(first >= nums.length)return nums.length;
            if(last < 0)return 0;
            if(nums[mid] == target)return mid;
            else if( mid + 1 < nums.length &&  nums[mid] < target && nums[mid + 1] > target)return mid + 1;
            else if(nums[mid] < target)return binnarySearch(nums, mid + 1, last, target);
            else return binnarySearch(nums, first, mid - 1, target);

        }
    }



}