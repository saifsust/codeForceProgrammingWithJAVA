import java.util.*;
import java.io.*;
public class Main
{

    public static void main(String[] args)
    {

        Reader read = new Reader();
        double withdraw, balance;
        while((withdraw = read.nextDouble()) != -1.0)
        {
            balance = read.nextDouble();
            if(withdraw % 5 == 0)
            {
                if(balance >= withdraw + 0.5)balance -= (withdraw + 0.5);
            }
            System.out.println(balance);

        }

    }



    /// faster reader input
    private static class Reader
    {
        private BufferedReader buffer;
        private StringTokenizer tokenizer ;
        public Reader()
        {
            this.buffer = new BufferedReader( new InputStreamReader(System.in), 31768);
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