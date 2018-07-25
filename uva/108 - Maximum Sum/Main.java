import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{

    public static void main(String[] args)
    {

        //Scanner read = FileFactory.read(); //new Scanner(System.in);

        Reader read = new Reader();
        int size = 0;
        while((size = read.nextInt()) != -1)
        {

            int[][] matrix = new int[size][size];
            for(int row = 0; row < size; ++row)
            {
                for(int col = 0; col < size; ++col)
                {
                    matrix[row][col] = read.nextInt();
                }
            }
            System.out.println(uva_108_Solve(matrix));
        }

    }

    private static int uva_108_Solve(int[][] matrix)
    {

        int  maxSum = 0;
        int sizeOfMatrx = matrix.length;

        for(int posLeft = 0; posLeft < sizeOfMatrx; ++posLeft)
        {
            int[] sumArray = new int[sizeOfMatrx];
            for(int posRight = posLeft; posRight < sizeOfMatrx; ++posRight)
            {
                for(int rowPos = 0; rowPos < sizeOfMatrx; ++rowPos)
                {
                    sumArray[rowPos] += matrix[rowPos][posRight];
                }
                int sumOfKadane = kadaneAlgoMaxSum(sumArray);
                if(maxSum < sumOfKadane)
                {
                    maxSum = sumOfKadane;
                }
            }
        }
        return maxSum;

    }

    // Kadane's Algorithm Implementation for max summation of the sub array
    private static int kadaneAlgoMaxSum(int[] subArray)
    {

        int tempSum = 0, maxSum = subArray[0];
        for(int i = 0; i < subArray.length; ++i)
        {
            tempSum += subArray[i];
            if(maxSum < tempSum)
            {
                maxSum = tempSum;
            }
            if(tempSum < 0)
            {
                tempSum = 0;
            }

        }
        return maxSum;
    }


    static class Reader
    {

        private BufferedReader buffer ;
        private StringTokenizer tokenizer;
        public Reader()
        {
            this.buffer = new BufferedReader(new InputStreamReader(System.in), 31768);
            this.tokenizer = null;
        }

        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try
                {
                    tokenizer = new StringTokenizer(buffer.readLine());
                }
                catch(Exception ex)
                {
                    throw new RuntimeException(ex);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt()
        {
            try
            {
                return Integer.parseInt(next());
            }
            catch(Exception ex)
            {
                return -1;
            }

        }

    }


}