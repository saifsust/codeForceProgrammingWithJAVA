import java.util.*;
class Main
{
    private static final int N = 1002;
    private static int[] primeList = new int[N];
    private static int[] index = new int[N];
    private static void sievePrime()
    {
        Arrays.fill(index, 1);
        int countIndex = 0;
        primeList[countIndex] = 1;
        primeList[++countIndex] = 2;
        index[1] = 0;
        index[2] = 1;
        for(int i = 4; i < N; i += 2) index[i] = 0;
        for(int i = 3; i < N; i += 2)
        {
            if(index[i] == 1)
            {
                primeList[++countIndex] = i;
                index[primeList[countIndex]] = countIndex;
                for(int j = i * i; j < N; j += i * 2)
                {
                    index[j] = 0;
                }
            }
        }

        for(int i = 2; i < N; i++)
            if(index[i] == 0) index[i] = index[i - 1];



    }


    public static void main(String[] args)
    {

        sievePrime();

        /* for(int i = 1; i < 50; i++)
             System.out.print(primeList[index[i]] + " ");*/

        Scanner read = new Scanner(System.in);

        while(read.hasNext())
        {
            int n = read.nextInt();
            int c = read.nextInt();
            System.out.print(n + " " + c + ":");
            int size = index[n] + 1;
            c *= 2;
            if(size % 2 == 1)c--;
            int center = (int) size / 2;
            int start = center - (int)c / 2;
            if(start < 0)
                for(int i = 0; i <= index[n] && i <= c; i++)
                    System.out.print(" " + primeList[i]);
            else
            {
                if(c % 2 == 0) c--;
                for(int i = start; i <= center + (int)c / 2; i++)
                    System.out.print(" " + primeList[i]);
            }

            System.out.printf("\n\n");


        }
        read.close();

    }

}