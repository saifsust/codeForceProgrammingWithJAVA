
import java.util.*;
import java.io.*;
public class Main
{
    private static final int RANGE = (int)1e5;
    private static final int FIRST = 1000;
    private static final int LAST = 10000;
    private static BitSet isPrime;
    private static Vector<Integer>primes;
    private static Vector<Integer>G[];


    // primes finding blocks
    static
    {
        isPrime = new BitSet(RANGE + 2);
        primes = new Vector<Integer>();
        isPrime.set(2, false);
        isPrime.set(1, true);
        primes.add(2);
        System.out.println(RANGE);
        for(int i = 4; i <= RANGE; i += 2)isPrime.set(i, true);

        for(int i = 3; i <= RANGE; i += 2)
        {
            if(!isPrime.get(i))
            {
                if(i <= (int)Math.sqrt(RANGE))
                {
                    for(int j = i * i; j <= RANGE; j += i * 2)isPrime.set(j, true);
                }
                primes.add(i);
            }
        }

        G = new Vector[LAST + 2];
        for(int i = FIRST; i <= LAST; ++i) G[i] = new Vector<Integer>();

    }

    // main method implementation

    public static void main(String[] args)
    {

        Reader read = new Reader();
        /* for(int i = 0; i < primes.size(); ++i) System.out.print(primes.get(i) + "  ");
         System.out.println();*/
        //int testCase = read.nextInt();
        /*  for(int test = 1; test <= testCase; ++test)
          {
              int num = read.nextInt();
          }*/

        int num ;

        //System.out.println(isPrime.get(2));
        //System.out.println(getMaximum(1213, 4));
        while((num = read.nextInt()) != -1)
        {
            //int target = read.nextInt();


            permutation(num, 1000);

            System.out.println("====================");

            for(int i = 0; i < G[9280].size(); ++i)System.out.print(G[9280].get(i) + "  ");

            //System.out.println(shortestPath(num, target));




        }


    }

    /// permutation

    private static void permutation(int num, int mod)
    {

        if(num < 1000) return;
        //System.out.println(num);
        if(mod == 0) return;

        for(int i = 0; i <= 9; i++)
        {
            int child;
            if(mod != 1)
            {

                child = (((num / mod) / 10) * 10 + i) * mod + num % mod;
                if(child >= 1000)
                {
                    G[num].add(child);
                    G[child].add(num);
                }
                permutation(child, mod / 10);
            }
            else
            {
                child = (num / 10) * 10 + i;
                if(child >= 1000)
                {
                    G[num].add(child);
                    G[child].add(num);
                }
                permutation(child, 0);
            }
            //permutation((num / mod) * mod + i * 10 + ((num % mod) % 10), mod / 10);
        }
        //G[num].add()


    }


    // bfs

    private static int shortestPath(int init, int des)
    {
        int[] dist = new int[LAST + 2];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[init] = 0;
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(init);
        while(!Q.isEmpty())
        {
            int head = Q.poll();
            System.out.println(head);
            for(Integer child : G[head])
            {
                if(!isPrime.get(child))
                {
                    int d = 1 + dist[head];
                    if(d < dist[child])
                    {
                        //if(!isPrime.get(child))
                        dist[child] = d;
                        Q.add(child);

                    }
                }
            }

        }
        return dist[des];

    }



    // maximum possible number method
    private static int getMaximum(int num, int pos)
    {
        int result, tempR, mod;
        switch(pos)
        {
        case 1:
            //2431%1000 = 431
            // 9000+431=9431
            mod = num % 1000;
            return 9000 + mod;
        case 2:
            // 2431/1000 =2
            result = num / 1000;
            // 2431 %1000 = 431
            mod = num % 1000;
            // 431%100 = 31
            mod = mod % 100;
            // 900+31 = 931
            mod = 9 * 100 + mod;
            result *= 1000;
            result += mod;
            return result;
        case 3:
            // 2431/100=24
            result = num / 100;
            // 2431 %100 =31
            mod = num % 100;
            // 31/10 = 3
            tempR = mod / 10;
            // 90 + 31 % 10 = 91
            mod = 9 * 10 + mod % 10;
            // 2400 + 91 = 2491
            result *= 100;
            result += mod;
            return result;
        case 4:
            // 2431/10=243
            result = num / 10;
            // 2431 %10 =1
            mod = 9;
            // 243*10 = 2430+9
            result *= 10;
            result += mod;
            return result;
        }
        return -1;
    }

    /// binary Search for finding Primes
    private static int binarySearch(int first, int last, int key, int pos)
    {
        if(first > last) return -1;
        if(last < 0) return -1;
        int mid = (int) (first + last) / 2;
        if(primes.get(mid) < 1000) return -1;
        if(primes.get(mid) == key) return mid;
        if(mid + 1 < LAST && primes.get(mid) < key && primes.get(mid + 1) > key)
        {
            int gp = getPosition(pos);
            if(key % gp == primes.get(mid) % gp) return mid;
            else if( key % gp == primes.get(mid + 1) % gp)return mid + 1;
            else if( mid - 1 >= 0 && key % gp == primes.get(mid - 1) % gp)return mid - 1;
            else
            {
                key = key % gp;
                int result = primes.get(mid) / gp;
                --result;
                result *= gp;
                result += key;
                System.out.println(result);
                return binarySearch(0, mid - 1, result, pos);
            }


        }
        else if(key < primes.get(mid)) return binarySearch(first, mid - 1, key, pos);
        else return binarySearch(mid + 1, last, key, pos);

    }

    private static int getPosition(int pos)
    {
        switch(pos)
        {
        case 1 :
            return 1000;
        case 2 :
            return 100;
        case 3 :
            return 10;
        }
        return -1;

    }

    // faster input

    static class Reader
    {
        private BufferedReader buffer;
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
                    return "";
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