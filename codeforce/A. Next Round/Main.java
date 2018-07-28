import java.util.*;
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
    public static void main(String[] args)
    {
        Reader read = new Reader();
        int num, kth;
        while((num = read.nextInt()) != -1)
        {
            kth = read.nextInt();
            int[] scrore = new int[num + 1];
            for(int i = 1; i <= num; ++i) scrore[i] = read.nextInt();
            int kthScore = scrore[kth];
            int advaced = 0;
            for(int i = 1; i <= num; ++i)
            {
                if(kthScore == 0 && scrore[i] == 0) continue;
                if(scrore[i] >= kthScore) ++advaced;
                else break;
            }
            System.out.println(advaced);
        }



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
                    return null;
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
    }
}