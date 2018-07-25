import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{

    private static final int N = 108;
    private static int[][] sum;
    private static int[][] matrix;

    public static void main(String[] args)
    {
        Scanner read = FileFactory.read(); //new Scanner(System.in);

        while(read.hasNext())
        {

            int size = read.nextInt();
            sum = new int[size + 1][size + 1];
            matrix = new int[size + 1][size + 1];
            int maxSum = Integer.MIN_VALUE;
            for(int row = 1; row <= size; ++row)
            {
                for(int col = 1; col <= size; ++col)
                {
                    matrix[row][col] = read.nextInt();
                    sum[row][col] = sum[row][col - 1] + matrix[row][col];

                    maxSum = Math.max( sum[row][col], Math.max(maxSum, matrix[row][col]));
                }
            }

            System.out.println(UVa108(matrix, sum, size, maxSum));

        }

    }

    private static int UVa108(int[][] matrix, int[][] sum, int size, int maxSum)
    {
       /*   for(int i = 1; i <= size; ++i)
          {
              for(int j = 1; j <= size; ++j)
              {
                  System.out.print(sum[i][j] + "  ");
              }
              System.out.println();
          }*/

        for(int index = 1; index <= size; ++index)
        {
            for(int frow = 1; frow <= size; ++frow)
            {
                for(int col = index; col <= size; ++col)
                {
                    int s = 0;
                    for(int srow = frow; srow <= size; ++srow)
                    {
                        if(index == 1)
                        {
                            s += sum[srow][col];
                        }
                        else
                        {
                            s += sum[srow][col] - sum[srow][col - 1];
                        }
                        maxSum = Math.max(s, maxSum);

                    }
                }

            }
        }
        // System.out.println(maxSum);


        return maxSum;

    }

}