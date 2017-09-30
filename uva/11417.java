import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{

    private static final int SIZE = 501;
    private static   int[] dp = new int[SIZE + 2];

    private static int gcd(int a, int b)
    {
        if(a == 0)return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args)
    {

        Scanner read = new Scanner(System.in);
        while(read.hasNext())
        {
            int num = read.nextInt();
            if(num==0)break;
            int sum = num - 1;
            for(int i = 2; i < num; i++)
                for(int j = i + 1; j <= num; j++)sum += gcd(i, j);
            System.out.println(sum);

        }
        read.close();
    }
}