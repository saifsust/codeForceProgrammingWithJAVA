/**
 *@NAME SAIFUL ISLAM
 *@BATCH SUST CSE 2013-14
 *@Email : saiful.sust.cse@gmail.com
 *@Facebok : https://www.facebook.com/SaifulIslamLitonSust
*/


import java.util.*;
import java.io.*;
import java.math.*;
public class Main
{
    private static int[] subNums ;
    private static int[] nums;
    private static int countOper;
    private static final int inf = (int) 1e15;
    public static void main(String[] args)
    {

        Scanner read = new Scanner(System.in);//FileFactory.read();
        // Reader read = new Reader();
        int testCase = read.nextInt();

        for(int test = 1; test <= testCase; ++test)
        {
            String numA = read.next();
            String numB = read.next();
            System.out.println(BigGCD(new BigInteger(numA), new BigInteger(numB)));


        }
    }


    private static BigInteger BigGCD(BigInteger a, BigInteger b)
    {
        if(a.equals(new BigInteger("0")))return b;
        return BigGCD(b.mod(a), a);
    }

    /*  /// faster input reader
      private static class Reader
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


      }*/

}
