import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{

    public static void main(String[] args)
    {

        Solution sol = new Solution();
        List<List<Integer>> tg = sol.generate(10);
        for(int i = 0; i < tg.size(); i++)
        {
            for(int j = 0; j < tg.get(i).size(); j++)
            {
                System.out.print(tg.get(i).get(j) + "  ");
            }
            System.out.println();
        }

    }
}

class Solution
{
    public List<List<Integer>> generate(int numRows)
    {


        List<List<Integer> > triangle = new ArrayList<>();
        if(numRows == 0 )return triangle;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        triangle.add(list);

        for(int i = 1; i < numRows; i++)
        {
            for(int j = 0; j <= i + 1; j++)
            {
                list = new ArrayList<>();

                for(int k = 0; k <= triangle.get(i - 1).size(); k++)
                {
                    if(k == 0)
                    {
                        list.add(triangle.get(i - 1).get(k));
                        continue;
                    }
                    if(k == triangle.get(i - 1).size())
                    {
                        list.add(triangle.get(i - 1).get(k - 1));
                        continue;
                    }

                    list.add(triangle.get(i - 1).get(k) + triangle.get(i - 1).get(k - 1));
                }

            }
            triangle.add(list);
        }

        return triangle;
    }
}