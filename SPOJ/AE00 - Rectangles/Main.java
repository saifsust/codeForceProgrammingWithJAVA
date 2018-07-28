import java.util.*;
import java.io.*;
public class Main
{


    public static void main(String[] args)
    {

        Reader read = new Reader();
        int num ;//= read.nextInt();
        while((num = read.nextInt()) != -1)
        {
            int rectangle = num;

            for(int i = 2; i * i <= num; ++i)
            {
                for(int j = i * i; j <= num; j += i)++rectangle;
            }
            System.out.println(rectangle);

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