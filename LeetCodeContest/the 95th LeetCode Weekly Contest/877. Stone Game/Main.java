import java.util.*;


class Main
{

    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
        while(read.hasNext())
        {
            int size = read.nextInt();

            int[] nums = new int[size];
            for(int i = 0; i < size; ++i) nums[i] = read.nextInt();

            System.out.println(new Solution().stoneGame(nums));
        }
    }
}

class Solution
{
    public boolean stoneGame(int[] piles)
    {
        int alex = 0, lee = 0;
        if(piles.length <= 2) return true;
        boolean on = true;

        for(int i = 0, j = piles.length - 1; i < j;)
        {
            if(on)
            {
                int mx = Math.max(piles[i + 1], piles[j]);
                int mx2 = Math.max(piles[i], piles[j - 1]);
                if(mx < mx2)
                {
                    alex += piles[i++];
                }
                else alex += piles[j--];
                continue;
            }
            if(!on)
            {
                int mx = Math.max(piles[i + 1], piles[j]);
                int mx2 = Math.max(piles[i], piles[j - 1]);
                if(mx < mx2)
                {
                    lee += piles[i++];
                }
                else lee += piles[j--];
                continue;
            }


        }

        return alex > lee;

    }
}