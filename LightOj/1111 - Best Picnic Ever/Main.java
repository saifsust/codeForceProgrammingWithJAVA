import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{


    public static void main(String[] args) throws Exception
    {
        //Scanner read = FileFactory.read();
        InputReader read = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCase = read.nextInt();
        //BufferedWriter writer = FileFactory.write();
        for(int test = 1; test <= testCase; test++)
        {
            System.gc();
            int K = read.nextInt();
            int N = read.nextInt();
            int M = read.nextInt();

            Queue<Pair> Q = new LinkedList<Pair>();
            int[] cnt = new int[N + 1];
            boolean[][] visited = new boolean[N + 1][K + 1];
            Vector<Integer>[] roads = new Vector[N + 1];

            for(int i = 1; i <= N; i++) roads[i] = new Vector<Integer>();


            for(int i = 0; i < K; i++)
            {
                int node = read.nextInt();
                Q.add(new Pair(node, i));
                visited[node][i] = true;
            }



            for(int i = 0; i < M; i++)
            {
                int u = read.nextInt();
                int v = read.nextInt();
                roads[u].add(v);
            }
            int reachable = bfs(roads, Q, cnt, visited, K);

            String str = "Case " + test + ": " + reachable;
            //writer.write(str);
            //writer.newLine();
            out.println(str);

        }
        //read.close();
        //writer.close();
        out.close();

    }
    private static void view(int[] visited, int N)
    {
        for(int i = 1; i <= N; i++)
        {

            System.out.print(visited[i] + "  ");
        }
        System.out.println();
    }

    private static int bfs(Vector<Integer>[] roads, Queue<Pair> Q, int[] cnt, boolean[][] visited, int K)
    {
        while(!Q.isEmpty())
        {
            Pair peek = Q.poll();
            cnt[peek.getNode()]++;
            for(int child : roads[peek.getNode()])
            {
                if(!visited[child][peek.getIndex()])
                {
                    visited[child][peek.getIndex()] = true;
                    Q.add(new Pair(child, peek.getIndex()));
                }
            }
        }
        int result = 0;
        for(int i = 1; i < cnt.length; i++)result += (cnt[i] == K ? 1 : 0);
        return result;
    }


    private static class Pair
    {

        private int node, index;
        public Pair(int node, int index)
        {
            this.node = node;
            this.index = index;

        }

        public int getNode()
        {
            return this.node;
        }

        public int getIndex()
        {
            return this.index;
        }
        public String toString()
        {
            return "[ Node : " + getNode() + " | Index : " + getIndex() + " ]";
        }
    }

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