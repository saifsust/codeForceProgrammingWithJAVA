import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{

    private static final int SIZE = 1301;
    private static  Vector<Integer>[] adj ;

    static
    {
        System.gc();

        adj = new Vector[SIZE];
        for(int i = 0; i < SIZE; i++)adj[i] = new Vector<Integer>();
        for(int i = 2; i < SIZE; i++)primeFactorize(i);

    }



    public static void main(String[] args) throws Exception
    {

        //Scanner read = FileFactory.read();
        //BufferedWriter writer = FileFactory.write();
        InputReader read = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCase = read.nextInt();
        for(int test = 1; test <= testCase; test++)
        {
            System.gc();
            int s = read.nextInt();
            int t = read.nextInt();
            int ans = bfs(s, t);
            //String ansStr = "Case " + test + ": " + ans;
            //writer.write(ansStr);
            // writer.newLine();
            out.println("Case " + test + ": " + ans);
        }
        //writer.close();
        out.close();


    }
    static class Comp implements Comparator<Integer>
    {
        public int compare(Integer first, Integer last)
        {
            return   first-last;
        }
    }

    private static int bfs(int s, int t)
    {
        System.gc();
        PriorityQueue<Integer> Q = new PriorityQueue<Integer>(SIZE,new Comp());
        //Queue<Integer> Q = new LinkedList<Integer>();
        int[] dist = new int[SIZE];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        Q.add(s);

        while(!Q.isEmpty())
        {
            int to = Q.poll();
            for(int from  : adj[to])
            {
                int terget = to + from;
                if(terget <= t && dist[terget] > 1 + dist[to])
                {

                    dist[terget] = 1 + dist[to];
                    Q.add(terget);
                    //if(terget == t) return dist[t];
                }
            }
        }
        return dist[t] == Integer.MAX_VALUE ? -1 : dist[t];


    }

    private static void primeFactorize(int s)
    {

        int div = 2;
        int index = s;
        int add = 0;
        while(s > 1)
        {
            add = 0;
            while(s % div == 0)
            {
                add = div;

                s /= div;
            }
            div++;
            if(add > 1) adj[index].add(add);
        }
        if(add == index)adj[index].clear();

    }




    private static class InputReader
    {
        private BufferedReader reader ;
        private StringTokenizer tokenizer;
        public InputReader(InputStream stream)
        {

            this.reader = new BufferedReader(new InputStreamReader(stream), 32768);
            this.tokenizer = null;
        }

        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try
                {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                catch(IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
            return tokenizer.nextToken();
        }


        public int nextInt()
        {
            return Integer.parseInt(next());
        }


    }





}

