import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader read = new Reader();
    private static Scanner fread = FileFactory.read();

    private static final int RANGE = 100000000;
    private static int[] isPrime ;
    private static List<Integer>primes;


    static
    {

        isPrime = new int[RANGE];
        primes = new ArrayList<Integer>();
        primes.add(2);

        for(int i = 4; i < RANGE; i += 2) isPrime[i] = 1;
        isPrime[1] = 1;
        int sqrt = (int)Math.sqrt(RANGE);
        for(int i = 3; i < RANGE; i += 2)
        {
            if(i <= sqrt )
            {
                if(isPrime[i] == 0)
                {
                    for(int j = i * i; j < RANGE; j += i * 2)isPrime[j] = 1;
                    primes.add(i);
                }
            }

        }

    }


    public static void main(String[] args)
    {


        //for(int i = 0; i < 100; i++)System.out.print(primes.get(i) + "  ");

        while(sread.hasNext())
        {
            int num = sread.nextInt();
            boolean isPoss = false;
            for(int i = 0; i < primes.size() &&  primes.get(i) < num; ++i)
            {
                int num1 = num - primes.get(i);
                if(isPrime[num1] == 0)
                {
                    System.out.println("Yes can be expressed ! Nums are below ");
                    System.out.println( num1 + " " + primes.get(i));
                    isPoss = true;
                    break;
                }

            }
            if(!isPoss)System.out.println("Num can't be expressed !");



        }



    }


    private static void solve()
    {



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