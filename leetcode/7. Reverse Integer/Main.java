import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{


    static class Solution
    {
       
        public int reverse(int x)
        {

            long sum = 0,mod=0;
            while(true)
            {
                  mod = x % 10;
               if(mod==0 && x==0 || mod==-0 && x==0)break;
              
                x /= 10;
                sum *= 10;
                  /*System.out.println(sum);*/
                sum += mod;
                //System.out.println(sum+" "+x);


            }
            
            if(sum>Integer.MAX_VALUE)return 0;
            if(sum<Integer.MIN_VALUE)return 0;

            return (int)sum;

        }
    }


    public static void main(String[] args)
    {

         Solution sol = new Solution();
        Scanner read = new Scanner(System.in);
       // System.out.println(Math.pow(2,31));
        while(read.hasNext()){
            int num = read.nextInt();
             System.out.println(sol.reverse(num));

        }
        read.close();
      
    }

}