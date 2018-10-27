import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/**
 *
 *@NAME SAIFUL ISLAM
 *@BATCH SUST CSE 2013-14
 *@Email : saiful.sust.cse@gmail.com
 *@Facebok : https://www.facebook.com/SaifulIslamLitonSust
*/

public class Main
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader rread = new Reader();
    private static Scanner fread = FileFactory.read();



    // Complete the gridChallenge function below.
    static String gridChallenge(String[] grid)
    {


        char[][] arr = new char[grid.length][grid[0].length()];


        arr[0] = grid[0].toCharArray();
        Arrays.sort(arr[0]);

        for(int i = 1; i < grid.length; ++i)
        {

            arr[i] = grid[i].toCharArray();
            Arrays.sort(arr[i]);
            for(int j = 0; j < grid[0].length(); ++j)
            {
                if(arr[i - 1][j] > arr[i][j])return "NO";
            }

        }

        return "YES";

    }


    public static void main(String[] args)
    {


        while(fread.hasNext())
        {
            int num = fread.nextInt();
            String[] grid = new String[num];
            for(int i = 0; i < num; ++i) grid[i] = fread.next();
           // System.out.println();
            System.out.println(gridChallenge(grid));
        }


    }





    //faster input reader

    private static class Reader
    {
        private BufferedReader buffered;
        private StringTokenizer  tokenizer;
        public Reader()
        {
            this.buffered = new BufferedReader(new InputStreamReader(System.in), 31768);
            this.tokenizer = null;
        }

        public String nextLine()
        {
            try
            {
                return buffered.readLine();

            }
            catch(Exception ex)
            {
                return "eof";
            }
        }

        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                tokenizer = new StringTokenizer(nextLine());
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