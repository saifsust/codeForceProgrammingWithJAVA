import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{

    private final int AMOUNT = 30001;
    private long numberOfCoins[];
    private int coins[] = {1, 5, 10, 25, 50}, amount;

    private void solver() throws Exception
    {

        predictionCoins();
        //view(11);

        Scanner read =FileFactory.read();
        while(read.hasNext())
        {

            amount = read.nextInt();

            System.out.println( numberOfCoins[amount] > 1 ?
                                "There are " + numberOfCoins[amount] + " ways to produce " + amount + " cents change." :
                                "There is only 1 way to produce " + amount + " cents change.");

        }
        read.close();


    }



    private void view(int numy)
    {

        for(int j = 0; j <= numy; j++)
            System.out.print(numberOfCoins[j] + " ");
    }

    private void clear(int amount)
    {

        Arrays.fill(numberOfCoins, 0);
    }
    /*
        private long ways(int amount, int coins[], int selectedIndex)
        {
            if(selectedIndex < 0) return 0;
            if(amount < 0) return 0;
            if(amount == 0) return 1;
            if(numberOfCoins[coins[selectedIndex]][amount] != 0) return numberOfCoins[coins[selectedIndex]][amount];
            return numberOfCoins[coins[selectedIndex]][amount] = ways(amount - coins[selectedIndex], coins, selectedIndex) + ways(amount, coins, selectedIndex - 1);
        }

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

    private void  predictionCoins()
    {

        numberOfCoins = new long[AMOUNT];
        for(int i = 0; i < coins.length; i++)
        {
            for(int amnt = coins[i]; amnt < AMOUNT; amnt++)
            {
                if(coins[i] == amnt) numberOfCoins[amnt]++;
                else numberOfCoins[amnt] += numberOfCoins[amnt - coins[i]];
            }
        }


    }
}