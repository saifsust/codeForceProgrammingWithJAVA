import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        //Scanner read = new Scanner(System.in);
        Scanner read = FileFactory.read();
        while(read.hasNext())
        {
            int m = read.nextInt();
            int n = read.nextInt();
            int[] nums1 = new int[m + n + 1];
            int[] nums2 = new int[n];
            for(int i = 0; i < m; i++)nums1[i] = read.nextInt();
            for(int i = 0; i < n; i++)nums2[i] = read.nextInt();
            sol.merge(nums1, m, nums2, n);

        }
        read.close();
    }
}


class Solution
{
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {

        //print(nums1,m,0);
        //print(nums2,0,n);
        int i = m - 1, j = n - 1, k = m + n-1;
        while(i >= 0 && j >= 0)
        {
            if(nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
         //System.out.println(i+" "+j+" "+k);
        if(i < 0)while(j >= 0)nums1[k--] = nums2[j--];

        if(j < 0)while(i >= 0)nums1[k--] = nums1[i--];

        print(nums1, m, n);

    }

    private void print(int[] nums, int m, int n)
    {
        for(int i = 0; i < m + n; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
    }
}