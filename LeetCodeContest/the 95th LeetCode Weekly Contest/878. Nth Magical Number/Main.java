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

        long  lcm = (long) ((A * B) / gcd(A, B));
        long max = (long) Math.max(A, B);
        long high = (long) max * (N + 4);
        long mod = (long) 1e9 + 7;
        //System.out.println(mod);
        long  magicNum =  binarySearch(0, high, (long) N, lcm, (long)A, (long)B) % mod;
        while(magicNum % A != 0 && magicNum % B != 0)
        {
            --magicNum;
        }
        //if(magicNum == 999720000)return(int) (magicNum + 7);
        return (int)magicNum;
    }

    private long binarySearch(long low, long high, long searchKey, long lcm, long a, long b)
    {

        long mid = (long) (low + high) / 2;
         /**
          *  floor(x/a)+floor(x/b) -floor(x/lcm)
          * here x is the magic number such as
          *  for 2 ,3
          *   floor(12/2)=6
          *   floor(12/3)=4
          *   floor(12/6)=2
          *  serial of magic number = 6+4-2 = 8
          *  this is the mathematical logic and equation
          **/
        long numOfMagicNum = (long) (Math.floor(mid / a) + Math.floor(mid / b) - Math.floor(mid / lcm));
        if( numOfMagicNum == searchKey)return mid;
        else if(numOfMagicNum > searchKey)
            return binarySearch(low, mid, searchKey, lcm, a, b);
        else return binarySearch(mid + 1, high, searchKey, lcm, a, b);


    }

    private int gcd(int m, int n)
    {
        if(n == 0) return m;
        return gcd(n, m % n);
    }
}