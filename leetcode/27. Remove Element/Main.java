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
            int[] nums = new int[num];
            for(int i = 0; i < num; i++)nums[i] = read.nextInt();
            //show(nums)
            int val =read.nextInt();
            System.out.println(sol.removeElement(nums, val));

        }


        read.close();


    }

}

class Solution
{
    private final int MAX_VALUE = Integer.MAX_VALUE;
    public int removeElement(int[] nums, int val)
    {
        Arrays.sort(nums);
        int len = 0;
        boolean check = true;
        for(int i = 0; i < nums.length ; i++)
        {
            if(val == nums[i])
            {
                len++;
                nums[i] = MAX_VALUE;
            }
        }

        Arrays.sort(nums);
        //show(nums);
        return nums.length - len;
    }

    public void show(int[] nums)
    {
        for(int i = 0; i < nums.length; i++)System.out.print(nums[i] + "  ");
        System.out.println();
    }
}