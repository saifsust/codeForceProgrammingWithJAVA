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
    properties declarartion
    */
    private final int MAX_AMOUNT = 40001;
    private long ways[];
    private int coins[] = {1, 5, 10, 25, 50}, amount;

    /*
        main function
    */
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

    /*
     solution process
    */

    private void solver() throws Exception
    {

         predictSolution();

        Scanner read = new Scanner(System.in);//FileFactory.read();

        while(read.hasNext())
        {
        	amount=read.nextInt();
        	System.out.println(ways[amount]);
        }

        read.close();

    }

    private void predictSolution()
    {
        ways = new long[MAX_AMOUNT];
        for(int cnt = 0; cnt < coins.length; cnt++)
        {
            for(int amnt = coins[cnt]; amnt < MAX_AMOUNT; amnt++)
            {
                if(amnt == coins[cnt]) ways[amnt]++;
                else ways[amnt] += ways[amnt - coins[cnt]];
            }
        }

    }






}