import java.util.*;
class Main
{
    private static  final int N = 1000000;
    private static int[] mark = new int[N + 2];
    private static Vector<Integer> primeList = new Vector<Integer>();
    private static void sieve()
    {
        Arrays.fill(mark, 1);
        mark[1] = 0;
        mark[0] = 0;
        primeList.add(2);
        int limit = (int)Math.sqrt(N);
        for(int i = 4; i <= N; i += 2)mark[i] = 0;
        for(int i = 3; i <= N; i += 2)
        {
            if(mark[i] == 1)
            {
                primeList.add(i);
                if(i <= limit)
                    for(int j = i * i; j <= N; j += i * 2) mark[j] = 0;
            }
        }
    }
    public static void main(String[] args)
    {

        sieve();
        // for(int i = 0; i < 50; i++)System.out.print(primeList.get(i) + " ");
        //System.out.println(primeList.size());
        Scanner read = new Scanner(System.in);
        int a, b, max, subtract, ansA, ansB;
        while(read.hasNext())
        {
            int even = read.nextInt();
            max = 0;
            ansA = 0;
            ansB = 0;
            boolean check=false;
            for(int i = 0; i < primeList.size(); i++)
            {
                a = primeList.get(i);
                b = even - a;
                subtract = b - a;
               // System.out.println(a + " " + b);
                if(subtract < 0)break;
                if(mark[b] == 0){
                    check=true;
                    continue;

                }
                if(max <= subtract)
                {
                    ansA = a;
                    ansB = b;
                    max = b - a;
                }

            }
            if(!check)System.out.println("Goldbach's conjecture is wrong.");
            else System.out.println(even + " = " + ansA + " + " + ansB);

        }
        read.close();

    }

}