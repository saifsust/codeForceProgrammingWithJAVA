import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{

    private static final int N = 20000000;
    private static int[] mark = new int[N + 2];
    private static Vector<Pair> primePair = new Vector<Pair>();
    private static Vector<Integer> primeList = new Vector<Integer>();

    static  class Pair
    {
        private int first, last;
        public Pair(int first, int last)
        {
            this.first = first;
            this.last = last;
        }
        public int getFirst()
        {
            return this.first;
        }
        public int getLast()
        {
            return this.last;
        }
        public String toString()
        {
            return "(" + Integer.toString(this.first) + ", " + Integer.toString(this.last) + ")";
        }
    }


    static
    {

        mark[1] = 1;
        int limit = (int)Math.sqrt(N);
        for(int i = 4; i <= N; i += 2)mark[i] = 1;
        primeList.add(2);
        for(int i = 3; i <= N; i += 2)
        {
            if(mark[i] == 0)
            {
                if(i <= limit)
                    for(int j = i * i; j <= N; j += i * 2)mark[j] = 1;
                if(i - primeList.lastElement() == 2)
                    primePair.add(new Pair(primeList.lastElement(), i));
                primeList.add(i);


            }
        }

    }

    public static void main(String[] args)
    {

       /* for(int i = 0; i < 50; i++)System.out.println(primePair.get(i));*/

        Scanner read = new Scanner(System.in);
        while(read.hasNext())
        {

            int num = read.nextInt();
            System.out.println(primePair.get(num - 1));

        }
        read.close();

    }

}