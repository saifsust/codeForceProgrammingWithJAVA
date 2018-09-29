import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader read = new Reader();
    private static Scanner fread = FileFactory.read();

    private static int[] score ;
    private static int sum;
    private static boolean isFind;
    public static void main(String[] args)
    {


        while(sread.hasNext())
        {

            int num = sread.nextInt();

            score = new int[num];
            sum = 0;
            for(int i = 0; i < num; ++i)
            {
                score[i] = sread.nextInt();
                sum += score[i];
            }

            isFind = false;

            permutation(0, num - 1);

            if(isFind) System.out.println("YES");
            else System.out.println("No");




        }


    }

    private static void permutation(int first, int last)
    {
        if(first == last)
        {
            //for(int i = 0; i < score.length; ++i)System.out.print(score[i] + "  ");
            //System.out.println();

            int tempSum = 0;
            for(int i = 0; i < score.length; ++i)
            {
                tempSum += score[i];
                if( Math.abs(tempSum - Math.abs(tempSum - sum)) <= 1)
                {
                 ///   System.out.println(tempSum-sum);
                    isFind = true;
                    break;
                }
            }

        }

        for(int i = first; i <= last; ++i)
        {
            swap(first, i);
            permutation(first + 1, last);
            swap(first, i);
        }

    }

    private static void swap(int a, int b)
    {
        int temp = score[a];
        score[a] = score[b];
        score[b] = temp;
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