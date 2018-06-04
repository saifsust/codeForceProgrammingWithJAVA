import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{


    public static void main(String[] args) throws Exception
    {
        //Scanner read = new Scanner(System.in);
        Scanner read = FileFactory.read();
        while(read.hasNext())
        {
            int _size = read.nextInt();
            int[] nums = new int[_size];
            for(int i = 0; i < nums.length; i++)
                nums[i] = read.nextInt();

            int k = read.nextInt();
            new Solution().rotate(nums, k);
        }


        read.close();
    }
}

class Solution
{
    public void rotate(int[] nums, int k)
    {

        for(int i = 1; i <= k; i++)
        {
            int last = nums[nums.length - 1];
             for(int j=nums.length-2;j>=0;j--){
                nums[j+1]=nums[j];
             }
            nums[0] = last;
        }
        for(int i = 0; i < nums.length; i++)System.out.print(nums[i] + "  ");
        System.out.println();

    }
}

