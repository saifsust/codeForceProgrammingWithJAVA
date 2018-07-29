import java.util.*;
import java.io.*;
public class Main
{

    public static void main(String[] args)
    {

        Reader read = new Reader();
        final int col = 3;
        int problemNum;
        while((problemNum = read.nextInt()) != -1)
        {

            int[][] solutions = new int[problemNum][col];
            for(int i = 0; i < problemNum; ++i)
            {
                for(int j = 0; j < col; ++j)solutions[i][j] = read.nextInt();
            }
            int ans = 0;
            for(int i = 0; i < problemNum; ++i)
            {
                int sumOfSol = 0;
                for(int j = 0; j < col; ++j)sumOfSol += solutions[i][j];
                if(sumOfSol >= 2)++ans;
            }
            System.out.println(ans);
        }


    }




    /// faster input reader
    private static class Reader
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

        public long nextLong()
        {
            try
            {
                return Long.parseLong(next());
            }
            catch(Exception ex)
            {
                return -1;
            }

        }
        public double nextDouble()
        {
            try
            {
                return Double.parseDouble(next());
            }
            catch(Exception ex)
            {
                return -1.0;
            }

        }


    }
}