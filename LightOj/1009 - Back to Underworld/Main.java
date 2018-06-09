import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.BitSet;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
public class Main
{

    private static final int SIZE = 20000;

    public static void main(String[] args)
    {

        InputReader read = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        //Scanner read = FileFactory.read();
        int testCase = read.nextInt();
        for(int test = 1 ; test <= testCase ; test++)
        {
            System.gc();
            BitSet colors = new BitSet(SIZE);
            BitSet visited = new BitSet(SIZE);
            BitSet isNode = new BitSet(SIZE);
            int num = read.nextInt();
            Vector<Integer>[] adj = new Vector[SIZE];
            for(int i = 0; i < SIZE; i++)adj[i] = new Vector<Integer>();


            for(int i = 0; i < num; i++)
            {
                int u = read.nextInt() - 1;
                int v = read.nextInt() - 1;
                adj[u].add(v);
                adj[v].add(u);
                isNode.set(u, true);
                isNode.set(v, true);
            }


            int ans = 0;
            for(int i = 0; i < SIZE; i++)
            {
                if(!visited.get(i) && isNode.get(i))
                {
                    int[] counts = {0, 0};
                    ans += bfs(i, adj, colors, visited, counts);
                }
            }
            out.println("Case " + test + ": " + ans);


        }
        out.close();


    }


    static int bfs(int init, List<Integer>[] adj, BitSet colors, BitSet visited, int[] counts)
    {
        Deque<Integer> Q = new LinkedList<Integer>();
        Q.addLast(init);
        colors.set(init, true);
        visited.set(init, true);
        while(!Q.isEmpty())
        {
            int parent = Q.removeFirst();
            counts[colors.get(parent) ? 1 : 0]++;
            for(int child : adj[parent])
            {
                if(!visited.get(child))
                {
                    colors.set(child, !colors.get(parent));
                    visited.set(child, true);
                    Q.addLast(child);
                }
            }
        }
        return Math.max(counts[0], counts[1]);
    }







    // faster  input class

    static class InputReader
    {

        private BufferedReader reader ;
        private StringTokenizer tokenizer;
        public InputReader(InputStream stream)
        {
            this.reader = new BufferedReader(new InputStreamReader(stream), 32768);
            this.tokenizer = null;
        }

        // read String
        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try
                {
                    tokenizer = new StringTokenizer(this.reader.readLine());
                }
                catch(IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
            return tokenizer.nextToken();
        }

        // read Integer
        public int nextInt()
        {
            return Integer.parseInt(next());
        }

    }

}