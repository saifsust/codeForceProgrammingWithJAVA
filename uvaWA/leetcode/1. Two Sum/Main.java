import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{



    public int[] twoSum(int[] nums, int target)
    {
        int[] twoSum = new int[2];
        int copy[] = Arrays.copyOf(nums, nums.length);

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++)
        {
            int firstNum = nums[i];
            twoSum[0] = nums[i];
            int findNum = target - firstNum;
            int index = binnarySearch(0, nums.length - 1, findNum, nums);
            System.out.println(index);
            if(index == i)continue;
            if(index < 0)continue;
            twoSum[1] =nums[index];
            for(int j = 0; j < nums.length; j++)
            {
                if(twoSum[0] == copy[j])
                {
                    twoSum[0] = j;
                    continue;
                }else

                if(twoSum[1] == copy[j])twoSum[1] = j;
            }
            Arrays.sort(twoSum);
            return twoSum;


        }
        twoSum[0] = 0;
        twoSum[1] = 0;

        return twoSum;

    }

    private int binnarySearch(int first, int last, int value, int[] nums)
    {

        int mid = (int)((first + last) / 2);
        if(first > last)return -1;
        if(last < 0)return -1;
        if(first >= nums.length)return -1;
        if(nums[mid] == value)return mid;
        else if(nums[mid] < value) return binnarySearch(mid + 1, last, value, nums);
        else return binnarySearch(first, mid - 1, value, nums);
    }



    private void solution()
    {
        int nums[] = {150,24,79,50,88,345,3};
        Scanner read = new Scanner(System.in);
        int target = read.nextInt();

        int[] twoSum = this.twoSum(nums, target);
        for(int i = 0; i < twoSum.length; i++)
        {
            System.out.print(twoSum[i] + "  ");
        }
        System.out.println();
        System.out.println(binnarySearch(0, nums.length - 1,target, nums));



        read.close();



    }

    public static void main(String[] args)
    {
        new Main().solution();
    }

}