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

public class Solution
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader rread = new Reader();
    private static Scanner fread = FileFactory.read();

    private static Set<Long> nums;



    public static void main(String[] args)
    {


        int testCase  = rread.nextInt();

        for(int test = 1; test <= testCase; ++test)
        {
            int n = rread.nextInt();
            int k = rread.nextInt();
            String seqs = rread.nextLine();
            nums = new HashSet<>();
            StringTokenizer tokens = new StringTokenizer(seqs);

            List<Long> seqNum = new ArrayList<>();
            while(tokens.hasMoreTokens())
            {
                seqNum.add(Long.parseLong(tokens.nextToken()));
            }

            long first_num = seqNum.get(0) / k;
            long last_num = seqNum.get(seqNum.size() - 1) / k;

            nums.add(first_num);
            nums.add(last_num);

            long diff = 0;
            for(int i = 1;  diff <= last_num && i < seqNum.size() - 1; ++i)
            {  
                int a = seqNum.get(0)-first_num;
                diff = seqNum.get(i) - a;
                if(diff<0 || diff >=last_num)break;
                nums.add(diff);

            }

            for(long num : nums)
            {
                System.out.print(num + " ");
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