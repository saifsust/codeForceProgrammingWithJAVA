import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{

    private static final int N = 10000;
    private static int[] prime = new int[N + 2];
    private static List<Integer> primes = new ArrayList<>();
    static
    {
        int lmt = (int)Math.sqrt(N);
        prime[2] = 2;
        //  primes.add(2);
        for(int i = 3; i <= N; i += 2)
        {
            if(prime[i] == 0)
            {
                primes.add(i);
                prime[i] = i;
                if(i <= lmt)
                    for(int j = i * i; j <= N; j += i * 2)prime[j] = 1;
            }

        }
        /*for(int i = 3; i <= N; i++)
            if(prime[i] == 1 || prime[i] == 0)prime[i] = prime[i - 1];*/
    }
    public static void main(String[] args)
    {

        Scanner read = new Scanner(System.in);
        int testCase = read.nextInt();
        int x, pm;
        for(int test = 1; test <= testCase; test++)
        {
            int num = read.nextInt();
            int size = primes.size();
            int min = primes.get(size - 1) * N;
            pm = 0;
            x = 0;
            int diff = 0;
            for(int i = 0; i < size && primes.get(i) <= num; i++)
            {
                int xx = primes.get(i);
                pm = (int) num / xx;
                if(diff < num - pm * xx)
                {
                    diff = num - pm * xx;
                    x = xx;
                }

            }
            System.out.println(x);
        }

        read.close();

    }
}