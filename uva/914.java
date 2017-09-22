import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
    private static final int N = 1000000;
    private static final int BIGGEST_DIFF = 114;
    private static int[] mark = new int[N + 2];
    private static int[] max = new int[BIGGEST_DIFF + 2];
    private static Vector<Integer> primeList = new Vector<Integer>();
    private static void sieve()
    {

        Arrays.fill(mark, 1);
        primeList.add(2);
        int limit = (int)Math.sqrt(N);
        for(int i = 4; i <= N; i += 2)mark[i] = 0;
        for(int i = 3; i <= N; i += 2)
        {
            if(mark[i] == 1)
            {
                primeList.add(i);
                if(i <= limit)
                    for(int j = i * i; j <= N; j += i * 2)mark[j] = 0;
            }
        }
    }

    private static int binarySearch(int firstIndex, int lastIndex, int num)
    {
        if(firstIndex >= primeList.size())return primeList.size() - 1;
        if(lastIndex < 0) return 0;
        int mid = (int) (firstIndex + lastIndex) / 2;
        if(primeList.get(mid) == num) return mid;
        else if(mid - 1 > 0 && primeList.get(mid) > num && primeList.get(mid - 1) < num) return mid - 1;
        else if(num < primeList.get(mid)) return binarySearch(firstIndex, mid - 1, num);
        else return binarySearch(mid + 1, lastIndex, num);
    }

    public static void main(String[] args) throws Exception
    {
        sieve();
    


        int size = primeList.size() - 1;
       Scanner read = new Scanner(System.in);
        /*Scanner  read = FileFactory.read();
        BufferedWriter write = FileFactory.write();*/
        int testCase = read.nextInt();
        for(int test = 1; test <= testCase; test++)
        {
            int lowerLimit = read.nextInt();
            int upperLimit = read.nextInt();
            int lowerIndex = binarySearch(0, size, lowerLimit);
            int upperIndex = binarySearch(0, size, upperLimit);
            if(primeList.get(lowerIndex) < lowerLimit) lowerIndex++;
            if(primeList.get(upperIndex) > upperLimit) upperIndex--;

            Arrays.fill(max, 0);
        
            int ans = 0, number;
            for(int i = lowerIndex + 1; i <= upperIndex; i++)
            {
                int index = primeList.get(i) - primeList.get(i - 1);
                max[index]++;
            }

            number = - 1;
            for(int i = 1; i <= BIGGEST_DIFF; i++)
            {
                //System.out.print(max[i]+" ");
                if(ans < max[i])
                {
                    ans = max[i];
                    number = i;
                }
                else if(ans == max[i])
                {
                    number = -1;
                }

            }
           // System.out.println();

            if(number == -1)
            {
                System.out.println("No jumping champion");
          /*      write.write("No jumping champion");
                write.write("\n");*/
            }
            else
            {
                /*write.write("The jumping champion is " + Integer.toString(number));
                write.write("\n");*/
                System.out.println("The jumping champion is " + number);
            }


        }
       /* FileFactory.close();*/
        read.close();

    }
}