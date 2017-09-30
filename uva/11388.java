import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{

    private static int GCD(int a, int b)
    {
        if(a == 0) return b;
        return GCD(b % a, a);
    }
    public static void main(String[] args) throws Exception
    {
        Scanner read = new Scanner(System.in);


        int testCase = read.nextInt();
        for(int test = 1; test <= testCase; test++)
        {
            int gcd = read.nextInt();
            int lcm = read.nextInt();
            if(lcm % gcd == 0)System.out.println(gcd + " " + lcm);
            else System.out.println(-1);

        }

        read.close();
    }
}