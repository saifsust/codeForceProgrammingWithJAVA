
import java.util.*;
import java.io.*;
public class Main
{

    private static Vector<Pair>G[];
    public static void main(String[] args)
    {

        Reader read = new Reader();
        int total_num_cell ;
        while((total_num_cell = read.nextInt()) != -1)
        {
            int exit = read.nextInt();
            int time = read.nextInt();
            int m = read.nextInt();
            G = new Vector[total_num_cell + 2];

            for(int i = 1; i <= total_num_cell; ++i)
            {
                G[i] = new Vector<Pair>();
            }

            for(int i = 0; i < m; i++)
            {
                int u = read.nextInt();
                int v = read.nextInt();
                int t = read.nextInt();
                G[u].add(new Pair(v, t));
            }

            int miceCounter = 0;
            for(int i = 1; i <= total_num_cell; ++i)
            {
                if(i == exit)continue;
                int tm = bfs(i, total_num_cell, exit);

                if(tm <= time)
                {
                    //System.out.println(tm + " " + time);
                    ++miceCounter;

                }
            }

            System.out.println(++miceCounter);
            // System.out.println(++miceCounter);



        }



    }



    private static int bfs(int init, int n, int dest)
    {
        int[] times = new int[n + 2];
        Arrays.fill(times, Integer.MAX_VALUE);
        Queue<Integer>Q = new LinkedList<Integer>();
        times[init] = 0;
        Q.add(init);

        while(!Q.isEmpty())
        {
            int head = Q.poll();
            for(Pair child : G[head])
            {
                int time = times[head] + child.getTime();
                if(time < times[child.getNode()])
                {
                    times[child.getNode()] = time;
                    Q.add(child.getNode());
                }
            }
        }
        return times[dest];
    }

    private static class Pair
    {
        private  int node, time;
        public Pair(int node, int time)
        {
            this.node = node;
            this.time = time;
        }

        public int getNode()
        {
            return this.node;
        }
        public int getTime()
        {
            return this.time;
        }

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