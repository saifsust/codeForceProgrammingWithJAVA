import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{

    private static final int N = 1000000;
    private static int[] prime = new int[N + 2];
    private static Vector<Integer> primeList = new Vector<Integer>();
    static
    {
        Arrays.fill(prime, 1);
        prime[1] = 0;
        for(int i = 4; i <= N; i += 2)prime[i] = 0;
        int limit = (int)Math.sqrt(N);
        primeList.add(2);
        for(int i = 3; i <= N; i += 2)
        {
            if(prime[i] == 1)
            {
                if(i <= limit)
                    for(int j = i * i; j <= N; j += i * 2)prime[j] = 0;
                primeList.add(i);
            }
        }

    }

    public static void main(String[] args) throws Exception
    {

        //for(int i = 0; i <= 50; i++)System.out.print(primeList.get(i) + " ");
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            String temp = read.readLine();
            int even = Integer.parseInt(temp);
            if(even == 0) break;
            System.out.println(even + ":");
            int pm1 = 0, pm2 = 0, maxPm1 = 0, maxPm2 = 0, max = 0;
            boolean check = false;
            for(int i = 0; i < primeList.size() && primeList.get(i) <= (int) even / 2; i++)
            {
                pm1 = primeList.get(i);
                if(prime[even - pm1] == 1)
                {
                    pm2 = even - pm1;
                    if(max <= pm2 - pm1)
                    {
                        check = true;
                        max = pm2 - pm1;
                        maxPm1 = pm1;
                        maxPm2 = pm2;
                    }

                }
            }
            if(!check)
                System.out.println("NO WAY!");
            else
                System.out.println(maxPm1 + "+" + maxPm2);


        }
        read.close();

    }
}