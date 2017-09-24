import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
    private static final int N = 1000000000;
    private static final int SIZE = (int)Math.sqrt(N);
    private static int[] mark = new int[SIZE + 2];
    private static Vector<Integer> primes = new Vector<Integer>();
    static
    {

        primes.add(2);
        for(int i = 3; i <= SIZE; i += 2)
        {
            if(mark[i] == 0)
            {
                primes.add(i);
                for(int j = i * i; j <= SIZE; j += i * 2)mark[j] = 1;
            }
        }

    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            try
            {
                String StrNum = read.readLine();
                if(StrNum.equals("EOF") || StrNum.equals("eof")) break;
                int num = Integer.parseInt(StrNum);
                int limit = (int)Math.sqrt(num);
                for(int i = 0; i < primes.size() && primes.get(i) <= limit; i++)
                {
                	int pm = primes.get(i);
                }

            }
            catch(Exception ex)
            {
                break;
            }


        }
        read.close();

    }
}