import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/**
 *
 *@NAME SAIFUL ISLAM
 *@BATCH SUST CSE 2013-14
 *@Email : saiful.sust.cse@gmail.com
 *@Facebok : https://www.facebook.com/SaifulIslamLitonSust
*/

public class Main
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader rread = new Reader();
    private static Scanner fread = FileFactory.read();



    static List<Integer> solve(int[] a,  int maxSize, int gSum)
    {

        List<Integer> busSizes = new ArrayList<>();

        for(int i = maxSize; i <= gSum; i++)
        {
            int s = 0;
            boolean isPoss = true;
            int sum = 0;
            for(int  j = s; j < a.length; ++j)
            {
                if(sum < i)
                    sum += a[j];
                if(sum == i)
                    sum = 0;
                if(sum > i) break;
            }

            if(sum == 0) busSizes.add(i);

        }
        return busSizes;

    }



    public static void main(String[] args)
    {


        while(fread.hasNext())
        {
            int size = fread.nextInt();
            int nums[] = new int[size];
            int maxSize = Integer.MIN_VALUE;
            int gSum = 0;
            for(int i = 0; i < size; ++i)
            {
                nums[i] = fread.nextInt();
                if(maxSize < nums[i])maxSize = nums[i];
                gSum += nums[i];
            }

            for(int num : solve(nums, maxSize, gSum))
            {
               System.out.print(num+" ");
            }
            System.out.println();
        }


    }





    //faster input reader

    private static class Reader
    {
        private BufferedReader buffered;
        private StringTokenizer  tokenizer;
        public Reader()
        {
            this.buffered = new BufferedReader(new InputStreamReader(System.in), 31768);
            this.tokenizer = null;
        }

        public String nextLine()
        {
            try
            {
                return buffered.readLine();

            }
            catch(Exception ex)
            {
                return "eof";
            }
        }

        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                tokenizer = new StringTokenizer(nextLine());
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