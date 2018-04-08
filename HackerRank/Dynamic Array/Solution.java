import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution
{

    /*
     * Complete the dynamicArray function below.
     */
    private  static final int N = 100001;
    private static   Vector<Integer> seq[] = new Vector[N];
    static
    {

        for(int i = 0; i < N; i++) seq[i] = new Vector<Integer>();
    }

    static int[] dynamicArray(int n, int[][] queries)
    {
        /*
         * Write your code here.
         */
        int lastAnswer = 0;
        Vector<Integer> result = new Vector<Integer>();
        for(int i = 0; i < queries.length; i++)
        {
            int query = queries[i][0];
            int x = queries[i][1];
            int y = queries[i][2];
            int index = (x ^ lastAnswer) % n;

            if(query == 1)
            {
                seq[index].add(y);
            }
            else
            {
                //System.out.println("ind " + index);
                //System.out.println(seq[index].size());
                int last = seq[index].size();
                //if(seq[index].isEmpty()) continue;
                System.out.println(y+" "+ last);
                int yy = seq[index].get(y % last);

                lastAnswer = yy ;
                System.out.println(yy + "  " + lastAnswer + "  " + seq[index].size());
                result.add(lastAnswer);
            }
            // System.out.println(lastAnswer + " " + y);
        }

        /*  for(int i = 0; i < 4; i++)
          {
              for(int j = 0; j < seq[i].size(); j++)
              {
                  System.out.print(i + " " + seq[i].get(j) + "  ");
              }
              System.out.println();
          }
        */
        int[] nums = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
        {
            nums[i] = result.get(i);
            //System.out.print(result.get(i) + " ");
        }
        return nums;

    }

    /*    private static final Scanner scanner = new Scanner(System.in);*/

    public static void main(String[] args) throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        Scanner scanner = FileFactory.read();
        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[][] queries = new int[q][3];

        for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++)
        {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++)
            {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = dynamicArray(n, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++)
        {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1)
            {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}