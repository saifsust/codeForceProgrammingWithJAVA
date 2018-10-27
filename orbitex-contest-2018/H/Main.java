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
    // private static Scanner fread = FileFactory.read();
    private static Random rand = new Random();

    private static List<Integer> seq;

    private static boolean isWin()
    {

        for(int i = 1; i < seq.size(); ++i)
            if(seq.get(i) < seq.get(i - 1))return false;
        return true;
    }


    private static void takeNext()
    {
        int size = seq.size();

        for(int i = 0; i < seq.size(); ++i)
        {
            int avd[] = avoid();
            if(i == avd[0] || i == avd[1]) continue;
            int take = seq.get(i);
            seq.remove(i);

        }

        if(size == seq.size())
        {
            seq.remove(rand.nextInt(seq.size()));
        }

    }

    private static int[] avoid()
    {
        int avd[] = new int[2];
        for(int i = 0; i < seq.size(); ++i)
        {
            int take = seq.get(i);
            seq.remove(i);
            int in = search();
            if(in != -1)
            {
                seq.add(i, take);
                avd[0] = i;
                avd[1] = in;
                return avd;
            }
            seq.add(i, take);
        }
        Arrays.fill(avd, -1);
        return avd;
    }

    private static int  search()
    {
        for(int i = 0; i < seq.size(); ++i)
        {
            int take = seq.get(i);
            seq.remove(i);
            if(isWin())
            {
                seq.add(i, take);
                return i;
            }
            seq.add(i, take);
        }
        return -1;
    }

    static String solve()
    {
        boolean alice = true;

        while(!seq.isEmpty() && 1 < seq.size() )
        {
            for(int num : seq)
            {
                System.out.print(num + " ");
            }
            System.out.println();
            // System.out.println("Done "+seq.size());
            if(alice)
            {
                int in = search();
                if(in != -1) break;
                takeNext();
                alice = false;
            }
            else
            {
                int in = search();
                if(in != -1) break;
                takeNext();
                alice = true;
            }

        }

        // for(int i = 0; i < seq.size(); ++i)
        //   takeNext();
        // System.out.println(avoid());


        return alice == true ? "Alice" : "Bob";
    }

    public static void main(String[] args)
    {

        int testCase = rread.nextInt();

        for(int test = 1; test <= testCase; ++test)
        {
            int size = rread.nextInt();
            seq = new ArrayList<>();
            for(int i = 0; i < size; ++i)seq.add(rread.nextInt());

            System.out.println(solve());

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