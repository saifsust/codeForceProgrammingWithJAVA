import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        Scanner read  = new Scanner(System.in);
        while(read.hasNext())
        {
            int num = read.nextInt();


            System.out.println(sol.countPrimes(num));
        }
        read.close();

    }
}

class Solution
{

    private static final int RANGE = 100000000;
    private static int[] primes = new int[RANGE + 1];
    private static int[] isPrime = new int[RANGE + 1];
    static
    {
        Arrays.fill(primes, 1);
        primes[1] = 0;
        primes[0] = 0;
        for(int i = 4; i < RANGE; i += 2) primes[i] = 0;

        int sqrt = (int)Math.sqrt(RANGE);
        for(int i = 3; i <= sqrt; i += 2)
        {
            for(int j = i * i; j < RANGE; j += i * 2)primes[j] = 0;
        }

        for(int i = 1; i < RANGE; i++)
        {
            if(primes[i] == 1)isPrime[i] = 1;
            primes[i] += primes[i - 1];
        }

    }

    public int countPrimes(int n)
    {

        if(n <= 2)return 0;
        if(isPrime[n] == 1)return primes[n - 1];
        return primes[n];
    }
}