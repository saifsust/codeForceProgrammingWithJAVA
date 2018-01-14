import java.util.*;
import java.lang.*;
import java.io.*;
/**
 *
 *@NAME SAIFUL ISLAM
 *@BATCH SUST CSE 2013-14
 *@Email : saiful.sust.cse@gmail.com
 *@Facebok : https://www.facebook.com/SaifulIslamLitonSust
*/

class Main
{

    /*
    properties declaration
    */
    private final int MAX_NUMBER = 300004;
    private final int empty = 12;
    private long[][] numberOfWay = new long[empty][MAX_NUMBER];
    private int coins[] = {5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000}, amount;


    //------- main Function -------
    public static void main(String[] args)
    {
        try
        {
            new Main().solver();

        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    //---- start ----


    private void solver() throws Exception
    {


        Scanner read = FileFactory.read();//new Scanner(System.in);//
       // BufferedWriter write = FileFactory.write();
        clear();
        while(read.hasNext())
        {

            double num = read.nextDouble();
            if(num == 0.00) break;
            //System.out.println(num+" "+(int)Math.floor(num*1000.0));
            amount = (int)Math.floor(num * 10000.0);
            // System.out.println(amount);
            amount /= 100;
            long answer = coinChange(amount, coins, coins.length - 1);

            System.out.printf("%6.2f%17d\n", num, coinChange(amount, coins,coins.length-1));


        }
       // write.close();
        read.close();


    }

    private long coinChange(int amount, int[] coins, int indexOfCoins)
    {
        if(indexOfCoins < 0) return 0;
        if(amount < 0) return 0;
        if(amount == 0) return 1;
        //  System.out.println(amount + " " + coins[indexOfCoins]);
        if(numberOfWay[indexOfCoins][amount] != -1) return numberOfWay[indexOfCoins][amount];
        return numberOfWay[indexOfCoins][amount] = coinChange(amount - coins[indexOfCoins], coins, indexOfCoins) + coinChange(amount, coins, indexOfCoins - 1);

    }


    private void clear()
    {
        for(int i = 0; i < empty; i++)
        {
            Arrays.fill(numberOfWay[i], -1);
        }
    }

    //--------end------

}