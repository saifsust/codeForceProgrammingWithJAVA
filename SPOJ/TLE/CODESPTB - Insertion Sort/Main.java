/**
 *@NAME SAIFUL ISLAM
 *@BATCH SUST CSE 2013-14
 *@Email : saiful.sust.cse@gmail.com
 *@Facebok : https://www.facebook.com/SaifulIslamLitonSust
*/


import java.util.*;
import java.io.*;
public class Main
{
    private static int[] subNums ;
    private static int[] nums;
    private static int countOper;
    public static void main(String[] args)
    {

        //Scanner read = FileFactory.read();
        Reader read = new Reader();
        int testCase = read.nextInt();

        for(int test = 1; test <= testCase; ++test)
        {
            int size = read.nextInt();
            nums = new int[size];
            for(int i = 0; i < size; ++i) nums[i] = read.nextInt();
            countOper = 0;
            mergeSort(0, size - 1);
            System.out.println(countOper);
            /*  for(int i = 0; i < size; ++i)System.out.print(nums[i] + "  ");
              System.out.println();*/

        }
    }

    private static void mergeSort(int first, int last)
    {
        if(first < last)
        {
            int mid = (int)(first + last) / 2;
            mergeSort(first, mid) ;
            mergeSort(mid + 1, last);
            swapCounter(first, mid, last);

        }

    }
    private static void swapCounter(int first, int mid, int last)
    {
        System.gc();

        int leftElementNum = mid - first + 1;
        int rightElementNum = last - mid;
        int[] leftElement = new int[leftElementNum + 1];
        int[] rigthElement = new int[rightElementNum + 1];
        int i, j = 0;
        //System.out.println("\nL");
        /**
        * first copy left child elements
        *  then copy right child elements
        **/

        for(i = first, j = 0; i <= mid; ++i, ++j)
        {
            //System.out.print(nums[i] + "  ");
            leftElement[j] = nums[i];
        }
        //System.out.println("\nR");
        for( i = mid + 1, j = 0; i <= last; ++i, ++j)
        {
            //System.out.print(nums[i] + " ");
            rigthElement[j] = nums[i];
        }
        //System.out.println("\n\n");
        int left = 0, right = 0;
        j = first;
        while(left < leftElementNum && right < rightElementNum)
        {
            if(leftElement[left] > rigthElement[right])
            {
                nums[j++] = rigthElement[right++];
                countOper += leftElementNum - left;
            }
            else
            {
                nums[j++] = leftElement[left++];
            }
        }
        while(left < leftElementNum)nums[j++] = leftElement[left++];
        while(right < rightElementNum)nums[j++] = rigthElement[right++];
    }



    /// faster input reader
    private static class Reader
    {
        private BufferedReader buffer;
        private StringTokenizer tokenizer;

        public Reader()
        {
            this.buffer = new BufferedReader(new InputStreamReader(System.in), 31768);
            this.tokenizer = null;
        }

        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try
                {
                    tokenizer = new StringTokenizer(buffer.readLine());
                }
                catch(Exception ex)
                {
                    return "";
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt()
        {
            try
            {
                return Integer.parseInt(next());
            }
            catch(Exception ex)
            {
                return -1;
            }
        }

        public long nextLong()
        {
            try
            {
                return Long.parseLong(next());
            }
            catch(Exception ex)
            {
                return -1;
            }

        }
        public double nextDouble()
        {
            try
            {
                return Double.parseDouble(next());
            }
            catch(Exception ex)
            {
                return -1.0;
            }

        }


    }

}
