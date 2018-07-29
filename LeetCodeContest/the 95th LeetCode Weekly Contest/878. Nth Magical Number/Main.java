import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner  read = new Scanner(System.in);
        while(read.hasNext())
        {
            System.out.println(new Solution().nthMagicalNumber(read.nextInt(), read.nextInt(), read.nextInt()));
        }
    }
}
class Solution
{

    public int nthMagicalNumber(int N, int A, int B)
    {

        long  lcm = (long) A / gcd(A, B) * B;
        // System.out.println(lcm);
        long max = (long) Math.max(A, B);
        long high = (long) 1e15; //(long) max * (N + 4);
        long mod = (long) 1e9 + 7;
        //System.out.println(mod);
        long  magicNum =  binarySearch(0, high, (long) N, lcm, (long)A, (long)B) % mod;
        /*while(magicNum % A != 0 && magicNum % B != 0)
        {
            --magicNum;
        }*/
        //if(magicNum == 999720000)return(int) (magicNum + 7);
        /* long low = 0;
         while(low < high)
         {
             long mid = low + (high - low) / 2;
            // System.out.println(mid);
             long numOfMagicNum = (long)Math.floor(mid / A) + (long)Math.floor(mid / B) - (long)Math.floor(mid / lcm);
             if(numOfMagicNum < N) low = mid + 1;
             else high = mid;

         }*/
        //System.out.println(low);

        return(int)(magicNum % mod); //(int)(low % mod);
    }

    private long binarySearch(long low, long high, long searchKey, long lcm, long a, long b)
    {

        if(low < high)
        {

            long mid = (long) (low + ( high - low) / 2);
            /**
             *  floor(x/a)+floor(x/b) -floor(x/lcm)
             * here x is the magic number such as
             *  for 2 ,3
             *   floor(12/2)=6
             *   floor(12/3)=4
             *   floor(12/6)=2
             *  serial of magic number = 6+4-2 = 8
             *  this is the mathematical logic and equation
             * numofMagicNum is equal or less than N
             */
            long numOfMagicNum = (long) (Math.floor(mid / a) + Math.floor(mid / b) - Math.floor(mid / lcm));
            if(numOfMagicNum < searchKey)
                return binarySearch(mid + 1, high, searchKey, lcm, a, b);
            else return binarySearch(low, mid, searchKey, lcm, a, b);
        }
        return low;
    }

    private int gcd(int m, int n)
    {
        if(n == 0) return m;
        return gcd(n, m % n);
    }
}