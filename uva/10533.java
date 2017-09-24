import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{

    private static final int N = 1000000;
    private static int[] mark = new int[N + 2];
    private static int[] digit = new int[N + 2];
    static
    {
        int limit = (int)Math.sqrt(N);
        mark[1] = 1;
        mark[2] = 0;
        digit[2] = 1;
        for(int i = 4; i <= N; i += 2)mark[i] = 1;
        for(int i = 3; i <= N; i += 2)
        {
            if(mark[i] == 0)
            {
                if(i <= limit)
                    for(int j = i * i; j <= N; j += i * 2)mark[j] = 1;
                int num = i, sum = 0;
                while(num > 0)
                {
                    sum += num % 10;
                    num /= 10;
                }
                if(mark[sum] == 0)digit[i] = 1;

            }
        }

        for(int i = 2; i <= N; i++)digit[i] += digit[i - 1];

    }



    public static void main(String[] args) throws Exception
    {
       
        // faster input class than Scanner 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(read.readLine());
        for(int test = 1; test <= testCase; test++)
        {
            String temp[] = read.readLine().split(" ");
            int lowerNum = Integer.parseInt(temp[0]);
            int upperNum = Integer.parseInt(temp[1]);
            int num =digit[upperNum] - digit[lowerNum-1];
            System.out.println(num);

        }
    }
}
