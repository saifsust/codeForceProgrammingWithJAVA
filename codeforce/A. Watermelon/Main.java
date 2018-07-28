import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        Reader read = new Reader();

        int weight ;
        while((weight = read.nextInt()) != -1)
        {
            if( weight > 2 && weight % 2 == 0)System.out.println("YES");
            else if(isPossible(weight))System.out.println("YES");
            else System.out.println("NO");
        }



    }
    static boolean isPossible(int w)
    {
        for(int i = 2; i < w; i += 2)
        {
            if( (w - i) != 0 &&  (w - i) % 2 == 0)return true;
        }
        return false;
    }

    //faster input
    static class Reader
    {

        private BufferedReader buffer ;
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