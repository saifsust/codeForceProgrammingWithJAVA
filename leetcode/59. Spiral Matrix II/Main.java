import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main(String[] args)
    {

        Scanner read = new Scanner(System.in);

        while(read.hasNext())
        {

            int num = read.nextInt();

            int[][] arr = new Solution().generateMatrix(num);

            for(int row = 0 ; row < arr.length; ++row)
            {
                for(int col = 0; col < arr.length; ++col)
                {
                    System.out.print(arr[row][col] + "  ");
                }
                System.out.println();
            }
        }

    }
}

class Solution
{
    public int[][] generateMatrix(int n)
    {
        int[][] matrix = new int[n][n];

        int sqr = n * n;
        int lastRow, lastCol, startRow, startCol;
        lastRow = lastCol = n - 1;
        startRow = startCol = 0;
        for(int num = 1; num <= sqr;)
        {

            for(int col = startCol; col <= lastCol; ++col)
            {
                matrix[startRow][col] = num;
                ++num;
            }
            ++startRow;
            for(int row = startRow; row <= lastRow; ++row)
            {
                matrix[row][lastCol] = num;
                ++num;
            }
            --lastCol;
            for(int lcol = lastCol; lcol >= startCol; --lcol)
            {
                matrix[lastRow][lcol] = num;
                ++num;
            }
            --lastRow;
            for(int lrow = lastRow; lrow >= startRow; --lrow)
            {
                matrix[lrow][startCol] = num;
                ++num;
            }
            ++startCol;

        }
        return matrix;

    }
}