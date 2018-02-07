import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{

    private int[][] matrix ;


    private void solution()
    {

        Scanner read = new Scanner(System.in);


        while(read.hasNext())
        {
            int num = read.nextInt();
            matrix = new int[num][num];


            for(int i = 0; i < num; i++)
            {
                matrix[0][i] = 1;
                matrix[i][0] = 1;
            }
            for(int i = 1; i < num; i++)
            {
                for(int j = 1; j < num; j++)
                {
                   matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];

                }
            }

            System.out.println(matrix[num-1][num-1]);

        }

        read.close();

    }

    public static void main(String[] args)
    {


        new Main().solution();

    }


}