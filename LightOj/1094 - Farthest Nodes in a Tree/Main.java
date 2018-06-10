import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    private static final int MAX_SIZE = 30000;

    public static void main(String[] args)
    {
        InputReader read = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        //Scanner read = FileFactory.read();
        int testCase = read.nextInt();

        for(int test = 1; test <= testCase; test++)
        {
            System.gc();
            int num = read.nextInt();
            Vector<Pair>[] adj = new Vector[num];
            for(int i = 0; i < num; i++) adj[i] = new Vector<Pair>();
            for(int i = 1; i < num; i++)
            {
                int u = read.nextInt();
                int v = read.nextInt();
                int w = read.nextInt();
                adj[u].add(new Pair(v, w));
                adj[v].add(new Pair(u, w));
            }
            int ans = 0;
            Pair  xx = bfs(adj, 0);
            Pair an = bfs(adj, xx.getV());
            //out.println(xx);
            //out.println(an);
            out.println("Case " + test + ": " + an.getW());

        }
       // read.close();
        out.close();

    }


    private static Pair bfs(Vector<Pair>[]  adj, int init)
    {
        System.gc();
        Queue<Integer> Q = new LinkedList<Integer>();
        int[] pnt = new int[adj.length];
        int[] dist = new int[adj.length];
        Q.add(init);
        dist[init] = 0;
        pnt[init] = -1;
        Pair max = new Pair(-1, Integer.MIN_VALUE);
        while(!Q.isEmpty())
        {
            int parent = Q.poll();
           // System.out.println(parent);
            for(Pair child : adj[parent])
            {
                int w = dist[parent] + child.getW();
                if(w > dist[child.getV()] && pnt[parent] != child.getV())
                {
                    pnt[child.getV()] = parent;
                    dist[child.getV()] = w;
                    Q.add(child.getV());
                    if(max.getW() < w)
                    {
                        max.set(child.getV(), w);
                    }
                }
            }
        }
        return max;
    }



    /** pair class **/
    private static class Pair
    {
        private int v, w;
        public Pair(int v, int w)
        {
            this.v = v;
            this.w = w;
        }
        public int getV()
        {
            return this.v;
        }
        public int getW()
        {
            return this.w;
        }
        public void set(int v, int w)
        {
            this.v = v;
            this.w = w;
        }
        public String toString()
        {
            return "[ Node : " + getV() + " | Weight : " + getW() + " ]";
        }
    }


    /** input Reader class **/


    private static class InputReader
    {
        private BufferedReader reader;
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
                    tokenizer = new StringTokenizer(this.reader.readLine());
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
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