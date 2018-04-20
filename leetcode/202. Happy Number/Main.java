import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {

        Solution sol = new Solution();
        Scanner read = new Scanner(System.in);
        System.out.println("==================== INPUT  =====================");
        while(read.hasNext())
        {

            int num = read.nextInt();
            System.out.println("================== OUTPUT ===================");

            System.out.println(sol.isHappy(num));
            System.out.println("==================== INPUT  =====================");
        }
        read.close();


    }
}
class Solution
{
    public boolean isHappy(int n)
    {

        //List<Integer> nums = new ArrayList<Integer>();
        int prev = n;
        int count = 0;
        while(n != 1)
        {
            //System.out.println(n);
            // nums.clear();

            //if(count == 100)return false;
            int num = n;
            n = 0;


            while(num != 0)
            {
                //nums.add(num % 10);
                int m = num % 10;
                n += m * m;
                num /= 10;
            }
            //if(n == 1)return true;
            if(n > 1 && n < 9 && n != 7 || n == 0)return false;
            //count++;
            //if(prev == n)return false;


        }
        return true;
    }
}