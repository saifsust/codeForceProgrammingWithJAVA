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
            int size = read.nextInt();
            int[] arr = new int[size];
            for(int i = 0; i < size; i++)arr[i] = read.nextInt();
            System.out.println(sol.removeDuplicates(arr));

        }

        read.close();
    }


    class Solution
    {
        private int same = -100000;
        public int removeDuplicates(int[] nums)
        {
            int len = nums.length ;

            for(int i = 1; i < nums.length; i++)
            {

                if(nums[i] == nums[i - 1])
                {
                    int in = 0;
                    for(int j = i; j < nums.length; j++)
                    {
                        if(nums[j] != nums[i - 1])
                        {
                            in = j;
                            break;
                        }
                    }
                    int p = in;
                    if(in == 0)continue;
                    // System.out.println("p " + p);
                    for(int k = i; k < nums.length; k++)
                    {
                        if(p < nums.length)
                        {
                            nums[k] = nums[p++];
                        }
                        else nums[k] = same;


                    }


                }

            }
            int all = 0;

            for(int i = 1; i <= nums.length; i++)
            {
                if( i < nums.length && nums[i - 1] == nums[i])all++;
                if(nums[i - 1] == same)
                {
                    return i - 1;
                }
                else if(i < nums.length && nums[i] == nums[i - 1])
                {

                    return i;
                }


                //  System.out.print(nums[i] + " ");

            }
            //System.out.println();
            if(all == nums.length)return 1;
            return len;
        }
    }


}