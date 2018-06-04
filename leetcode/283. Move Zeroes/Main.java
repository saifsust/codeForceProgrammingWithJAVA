import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)throws Exception
    {

        Scanner read = FileFactory.read();
        while(read.hasNext())
        {
            int _size = read.nextInt();
            int nums[] = new int[_size];
            for(int i = 0; i < _size; i++)nums[i] = read.nextInt();
            new Solution().moveZeroes(nums);

        }

        read.close();

    }
}

class Solution
{
    public void moveZeroes(int[] nums)
    {

        int last = 0;
        for(int i = 0; i < nums.length-last;)
        {
            if(nums[i] == 0)
            {
                for(int j = i; j <nums.length - 1; j++)
                {

                    nums[j] = nums[j + 1];
                }
               // System.out.println("okk");
               // i=0;
                last++;
                nums[nums.length - 1] = 0;
            }else i++;
            //System.out.println(last+" "+i);


        }

        for(int i=0;i<nums.length;i++)System.out.print(nums[i]+"  ");
        	System.out.println();

    }
}