import java.util.*;
import java.lang.*;
import java.io.*;
//import java.math.*;

public class Main
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader rread = new Reader();

    private static long[] lucky;
    private static final int N = 1005;

    static
    {
        lucky = new long[N + 1];
        long digit_4 = 4;
        long digit_7 = 7;


        PriorityQueue<Long> Q4 = new PriorityQueue<>();

        PriorityQueue<Long> Q7 = new PriorityQueue<>();

        for(int i = 0; i <= N; ++i)
        {

            long next_lucky = Math.min(digit_4, digit_7);

            lucky[i] = next_lucky;

            if(digit_4 == next_lucky)
            {
                Q4.add(digit_4 * 10 + 4);
                Q4.add(digit_4 * 10 + 7);
                digit_4 = Q4.poll();

            }
            if(digit_7 == next_lucky)
            {
                Q7.add(digit_7 * 10 + 4);
                Q7.add(digit_7 * 10 + 7);
                digit_7 = Q7.poll();
            }

        }


    }




    public static void main(String[] args)
    {

       long num = rread.nextLong();
       boolean isAlmostLucky = false;
       for(int i=0;i<lucky.length && lucky[i]<=num;++i){
        if(num%lucky[i]==0){
            System.out.println("YES");
            isAlmostLucky=true;
            break;
        }
       }

       if(!isAlmostLucky)System.out.println("NO");


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