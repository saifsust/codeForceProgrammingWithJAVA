import java.util.*;
import java.lang.*;
import java.io.*;
//import java.math.*;

public class Main
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader rread = new Reader();
    //private static Scanner fread = FileFactory.read();

    private static List<Integer>primes ;
    private static int[] isPrime ;
    private static int N = 100;
    private static int counter;
    private static int[] primeCounter;
    static
    {

        primes = new ArrayList<>();

        isPrime = new int[N + 1];
        primes.add(2);
        isPrime[1] = 1;
        for(int i = 4; i <= N; i += 2)isPrime[i] = 1;


        int sqrt = (int)Math.sqrt(N);
        for(int i = 3; i <= N; i += 2)
        {

            if(isPrime[i] == 0)
            {
                if(i < sqrt)
                {
                    for(int j = i * i; j <= N; j += i * 2)isPrime[j] = 1;

                }
                primes.add(i);

            }
        }




    }




    private static int div(int num, int by)
    {

        while(num % by == 0)
        {
            ++counter;
            num /= by;
        }
        return num;
    }




    private static  void solve()
    {

        /*while(sread.hasNext())
        {*/

        int num ;

        while((num = rread.nextInt()) != 0)
        {


            primeCounter = new int[num + 1];
            int pnum = 0;
            int max = Integer.MIN_VALUE;
            for(int i = 2; i <= num; ++i)
            {
                pnum = i;
                for(int j = 0; j < primes.size() &&  primes.get(j) <= pnum; j++)
                {
                    if(max < primes.get(j))
                    {
                        max = primes.get(j);
                    }
                    counter = 0;
                    pnum = div(i, primes.get(j));
                    primeCounter[primes.get(j)] += counter;
                }
            }

            String temp;



            int block = 15;
            String[][] answer = new String[5][16];
            Arrays.fill(answer[0], "");
            int ind = 1;
            for(int i = 0; i < primes.size() && primes.get(i) <= max ; ++i)
            {
                if((i + 1) % 16 > 0 )
                {

                    temp = "";
                    String temp2 = "" + primeCounter[primes.get(i)];
                    for(int j = 0; j < 2 - temp2.length(); ++j)temp += ' ';
                    answer[ind][i % 15] = temp + temp2;
                    continue;
                }
                ++ind;
                String temp2 = "" + primeCounter[primes.get(i)];
                temp = "";
                for(int j = 0; j < answer[ind - 1][0].length() - temp2.length(); ++j)temp += ' ';
                answer[ind][0] = temp + temp2;

            }
            String temp2 = "" + num;
            temp = temp2;
            for(int i = 0; i < 3 - temp2.length(); ++i) temp = " " + temp;
            System.out.print(temp + "! = ");

            for(int j = 1; j <= ind; ++j)
            {
                for(int i = 0; i < 15 && answer[j][i] != null; ++i)
                {
                    System.out.print(answer[j][i]);
                    if(i < 14 && answer[j][i + 1] != null)System.out.print(" ");
                }
                System.out.println();
                if(answer[j + 1][0] != null)
                {

                    for(int k = 1; k <= temp.length() + 4; ++k)
                        System.out.print(" ");
                }
            }


        }
        //System.out.println();


    }

    public static void main(String[] args)
    {
        solve();

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