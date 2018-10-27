import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main
{

    private static Scanner sread = new Scanner(System.in);

    private static Scanner fread = FileFactory.read();

    private static int[] isSame;
    private static final int N = 100002;

    private static long[][] bicom;

    private static List<Integer> astr[], sames[];

    static
    {
        bicom = new long[N + 1][3];

        bicom[0][0] = 1;
        for(int i = 1; i <= N; ++i)
        {
            for(int j = 0; j <= 2; ++j)
            {
                if(j == 0 || j == i)bicom[i][j] = 1;
                else bicom[i][j] = bicom[i - 1][j] + bicom[i - 1][j - 1];
            }
        }

    }




    static long journeyToMoon(int n)
    {


        long comb = bicom[n][2];
        if(n == 1) return 0;

        for(int i = 0; i < n; ++i)
        {
            if(isSame[i] == 0)
            {
                dfs(i, i);
            }

            comb -= bicom[sames[i].size()][2];
            //System.out.println(sames[i].size());

        }

        /*  for(int xx : astr[0])
          {
              System.out.print(xx + " ");
          }*/

        return (comb <=0? 0: comb);

    }

    private static void dfs(int start, int i)
    {

        sames[i].add(start);
        isSame[start] = 1;
        // System.out.println(start);
        for(int xx : astr[start])
        {
            if(isSame[xx] == 0)
            {
                dfs(xx, i);
            }

        }
    }

    public static void main(String[] args)
    {



        while(fread.hasNext())
        {
            int n = fread.nextInt();
            int p = fread.nextInt();

            // System.out.println(bicom[n][2]);

            //int[][] astronaut = new int[p][2];

            isSame = new int[n];

            astr = new ArrayList[n + 1];
            sames = new ArrayList[n + 1];

            isSame = new int[n + 1];

            for(int i = 0; i <= n; ++i)
            {
                astr[i] = new ArrayList<>();
                sames[i] = new ArrayList<>();
            }

            for(int i = 0; i < p; ++i)
            {
                int u = fread.nextInt();
                int v = fread.nextInt();
                /*   astronaut[i][0] = u;
                   astronaut[i][1]  = v;*/
                astr[u].add(v);
                astr[v].add(u);

            }

            System.out.println(journeyToMoon(n));


        }

    }





}
