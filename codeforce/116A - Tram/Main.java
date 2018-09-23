import java.util.*;
import java.math.*;
import java.io.*;
/**
 *
 *@NAME SAIFUL ISLAM
 *@BATCH SUST CSE 2013-14
 *@Email : saiful.sust.cse@gmail.com
 *@Facebok : https://www.facebook.com/SaifulIslamLitonSust
*/

public class Main
{
    private static final int SIZE = 5;
    private static int minCapacity[];

    public static void main(String[] args)
    {
        Reader read = new Reader();

        int num ;

        while((num = read.nextInt()) != -1)
        {
            minCapacity = new int[num + 1];
            read.nextInt();
            minCapacity[0] = read.nextInt();
            int min = minCapacity[0];
            for(int i = 1; i < num; ++i)
            {
                int a = read.nextInt();
                minCapacity[i] = minCapacity[i - 1] - a;
                minCapacity[i] += read.nextInt();
                if(min < minCapacity[i])min = minCapacity[i];

            }
            System.out.println(min);

            //for(int i = 0; i <= num; ++i)System.out.print(minimumCars[i] + " ");

        }



    }


    // faster Reader

    private static class Reader
    {

        private BufferedReader buffer;
        private StringTokenizer tokenizer;

        public Reader()
        {
            this.buffer = new BufferedReader(new InputStreamReader(System.in), 31768);
            this.tokenizer = null;
        }


        public String nextLine()
        {
            try
            {
                return buffer.readLine();
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
                try
                {
                    tokenizer = new StringTokenizer(buffer.readLine());
                }
                catch(Exception ex)
                {
                    return "eof";
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