import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        List<Integer> list = sol.getRow(30);

        for(int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + "  ");

    }
}
class Solution
{
    public List<Integer> getRow(int rowIndex)
    {
        List<Integer> result = new ArrayList<Integer>();
       

        int[][] tri = new int[rowIndex + 2][10000];

        tri[0][0] = 1;

        for(int i = 1; i <= rowIndex; i++)
        {
            for(int j = 0; j <= tri.length ; j++)
            {
                if(j == 0)
                {
                    tri[i][j] = tri[i - 1][0];
                    continue;
                }
                tri[i][j] = tri[i - 1][j] + tri[i - 1][j - 1];

            }

        }

        /*    for(int i = 0; i <= rowIndex; i++)
            {
                for(int j = 0; j < tri.length && tri[i][j] !=0; j++)
                {
                    System.out.print(tri[i][j] + "  ");
                }
                System.out.println();
            }
        */
        for(int i = 0; i < tri[rowIndex].length && tri[rowIndex][i] != 0 ; i++)result.add(tri[rowIndex][i]);


        return result;
    }
}