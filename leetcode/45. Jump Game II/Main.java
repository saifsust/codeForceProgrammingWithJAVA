import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{

    public static void main(String[] args)
    {


        Reader read = new Reader();
        int num ;
        while((num = read.nextInt()) != -1)
        {


            int[] nums = new int[num];

            for(int i = 0; i < num; ++i) nums[i] = read.nextInt();

            System.out.println(new Solution().jump(nums));

        }

    }

    static class Reader
    {

        private BufferedReader buffer ;
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
                    return "-1";

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


    }


}


class Solution
{
    public int jump(int[] nums)
    {


        int[] minJump = new int[nums.length];

        Arrays.fill(minJump, Integer.MAX_VALUE);
        minJump[0] = 0;
        for(int i = 0; i < nums.length; ++i)
        {
            for(int j = i + 1 ; j < nums.length && j <= nums[i] + i; ++j)
            {
                //System.out.println(minJump[i]+" "+i);
                minJump[j] = Math.min(minJump[i] + 1, minJump[j]);
            }
        }

        //for(int i = 0; i < nums.length; ++i)System.out.print(nums[i] + "   ");

        return minJump[nums.length - 1];
    }
}