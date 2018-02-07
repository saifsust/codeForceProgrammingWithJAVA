import java.util.*;
import java.lang.*;
import java.io.*;
public  class Main
{

    private int n, m;
    private final int N = 52;
    private char[][] matrix = new char[N][N];

    private void solution()
    {
        Scanner read = new Scanner(System.in);

        while(read.hasNext())
        {
            n = read.nextInt();
            m = read.nextInt();
            for(int i = 0; i < N; i++)
                Arrays.fill(matrix[i], '.');


            for(int i = 0; i < n; i++)
            {
                if(i % 2 == 0)
                {
                    for(int j = 0; j < m; j++)matrix[i][j] = '#';
                }
                else
                {
                    if((i + 1) % 4 == 0)
                    {
                        matrix[i][0] = '#';
                    }else matrix[i][m-1]='#';
                }

            }

            for(int i=0;i<n;i++){
            	for(int j=0;j<m;j++){
            		System.out.print(matrix[i][j]);
            	}
            	System.out.println();
            }




        }
        read.close();



    }
    public static void main(String[] args)
    {
        try
        {
            new Main().solution();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }


}