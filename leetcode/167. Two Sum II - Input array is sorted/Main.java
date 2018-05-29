import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner read = FileFactory.read();

        while(read.hasNext())
        {
            int _size = read.nextInt();
            int arr[] = new int[_size];
            for(int i = 0; i < _size; i++)
            {
                arr[i] = read.nextInt();
            }
            int target = read.nextInt();
            int indexs[] = new Solution().twoSum(arr, target);
            System.out.println();
            System.out.println(indexs[0] + "   " + indexs[1]);
        }
        read.close();
    }
}



class Solution
{
    public int[] twoSum(int[] numbers, int target)
    {
        int indexs[] = new int[2];


        for(int i = 0; i < numbers.length; i++)
        {
            indexs[0] = i+1;
            int search = target - numbers[i];
            int ind = binarySearch(numbers, search, i + 1, numbers.length - 1);
            if(ind == -1)continue;
            else
            {
                indexs[1] = ind+1;
                break;
            }
            //System.out.println(numbers[i]+" "+numbers[ind]);
        }

        return  indexs;
    }

    private int binarySearch(int nums[], int search, int first, int last)
    {
        if(first > last) return -1;
        int mid = (int)(first + last) / 2;
        if(nums[mid] == search) return mid;
        if(nums[mid] > search) return binarySearch(nums, search, first, mid - 1);
        else return binarySearch(nums, search, mid + 1, last);
    }

}