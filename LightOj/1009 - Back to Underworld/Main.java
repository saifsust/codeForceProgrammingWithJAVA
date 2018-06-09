import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{

    private static int counts[] = new int[3];
    private static int maxFight[] ;


    public static void main(String[] args)
    {

        Scanner read = FileFactory.read();
        //Scanner read = new Scanner(System.in);
        int testCase = read.nextInt();

        for(int test = 1; test <= testCase ; test++)
        {
            int max = Integer.MIN_VALUE;
            int dualFightNum = read.nextInt();
            maxFight = new int[20002];
            counts[1] = 0;
            counts[2] = 0;
            for(int i = 0; i < dualFightNum; i++)
            {
                int u = read.nextInt();
                int v = read.nextInt();
                if(maxFight[u] == 0 && maxFight[v] == 0)
                {
                    maxFight[u] = 1;
                    maxFight[v] = 2;
                    counts[maxFight[u]]++;
                    counts[maxFight[v]]++;
                    continue;
                }
                if(maxFight[u] == 0)
                {
                    if(maxFight[v] == 1)maxFight[u] = 2;
                    else maxFight[u] = 1;
                    counts[maxFight[u]]++;
                    continue;
                }
                if(maxFight[v] == 0)
                {
                    if(maxFight[u] == 1)maxFight[v] = 2;
                    else maxFight[v] = 1;
                    counts[maxFight[v]]++;
                    continue;

                }



                /*  if(max < u)max = u;
                  if(max < v) max = v;*/
            }
            /*
                        maxFight = new int[max + 1];
                        // int ans = bfs(U[0]);


                        int ans = dfs(U[0]);*/
            System.out.println("Case " + test + ": " + Math.max(counts[1], counts[2]));


        }

        read.close();

    }

    /// recursive

    // private static



    // dfs solution
/*
    private static int dfs(int init)
    {

        S = new Stack<Integer>();
        counts[1] = 1;
        counts[2] = 0;
        maxFight[init] = 1;
        S.push(init);
        while(!S.isEmpty())
        {

            int father = S.peek();
            S.pop();
            for(int i = 0; i < V.length; i++)
            {
                if(father == U[i])
                {
                    int child = V[i];
                    if(maxFight[child] == 0)
                    {
                        if(maxFight[father] == 1)maxFight[child] = 2;
                        else maxFight[child] = 1;
                        counts[maxFight[child]]++;
                        //dfs(child);
                        S.push(child);
                    }
                }
                else
                {
                    if(father == V[i])
                    {
                        int child = U[i];
                        if(maxFight[child] == 0)
                        {
                            if(maxFight[father] == 1)maxFight[child] = 2;
                            else maxFight[child] = 1;
                            counts[maxFight[child]]++;
                            //dfs(child);
                            S.push(child);
                        }
                    }

                }
            }
        }
        return Math.max(counts[1], counts[2]);
    }
*/

    // bfs traverse


    /* private static int bfs(int init)
     {
         Q = new LinkedList<Integer>();

         Q.add(init);

         maxFight[init] = 1;
         counts[1] = 1;
         counts[2] = 0;
         while(!Q.isEmpty())
         {
             int father = Q.poll();
             for(int i = 0; i < V.length; i++)
             {
                 if(father == U[i])
                 {
                     int child = V[i];
                     if(maxFight[child] == 0)
                     {

                         if(maxFight[father] == 1) maxFight[child] = 2;
                         else maxFight[child] = 1;
                         counts[maxFight[child]]++;
                         Q.add(child);
                     }
                 }
                 else
                 {
                     if(father == V[i])
                     {
                         int child = U[i];
                         if(maxFight[child] == 0)
                         {

                             if(maxFight[father] == 1) maxFight[child] = 2;
                             else maxFight[child] = 1;
                             counts[maxFight[child]]++;
                             Q.add(child);
                         }

                     }
                 }
             }
         }

         return Math.max(counts[1], counts[2]);

     }*/



    //Main

}