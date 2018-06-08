import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{


    private static int[] rx = { 0, 1,  0,  -1};
    private static int[] cy = { -1, 0, 1, 0};
    private static  Queue<Pair> Q ;
    private static boolean[][] visited ;
    private static int row, col;

    public static void main(String[] args)
    {
       // Scanner read = FileFactory.read();
       Scanner read = new Scanner(System.in);
        /*    char a = read.next().charAt(0);
            System.out.println(a);*/
        int testCase = read.nextInt();
        for(int test = 1 ; test <= testCase; test++)
        {
            col = read.nextInt();
            row = read.nextInt();
            int iniCol = -1, iniRow = -1;
            char matrix[][] = new char[row][col];
            visited = new boolean[row][col];
            read.nextLine();
            for(int i = 0; i < row; i++)
            {

                String strLine = read.nextLine();
                for(int j = 0; j < strLine.length(); j++)
                {
                    matrix[i][j] = strLine.charAt(j);
                    if(matrix[i][j] == '@')
                    {
                        iniCol = j;
                        iniRow = i;
                    }
                }

                /*   for(int j = 0; j < col; j++)
                   {
                       matrix[i][j] = read.next().charAt(0);
                       if(matrix[i][j] == '@')
                       {
                           iniCol = j;
                           iniRow = i;
                       }
                   }*/
            }

            if(iniCol < 0 && iniRow < 0)
            {
                System.out.println("Case " + test + ": 0");
                //if(test < testCase)System.out.println();
                continue;
            }
            //// fresh visited
            fresh();
            int ans = bfsTravel(matrix, iniRow, iniCol);
            System.out.println("Case " + test + ": " + ans);
            //if(test < testCase)System.out.println();
            //view(matrix);


        }
        read.close();
    }

    private static void view(char[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }

    }

    // refresh visited

    private static void fresh()
    {
        for(int i = 0; i < visited.length; i++)
        {
            Arrays.fill(visited[i], false);
        }
    }

    //BFS Solution of The Problem

    private static int bfsTravel(char[][] matrix, int iniRow, int iniCol)
    {


        Q = new LinkedList<Pair>();
        int dist = 1;
        Q.add(new Pair(iniRow, iniCol));
        visited[iniRow][iniCol] = true;
        while(!Q.isEmpty())
        {
            Pair head = Q.poll();
            // System.out.println(head);
            for(int i = 0; i < rx.length; i++)
            {
                int x = head.getRow() + rx[i];
                int y = head.getCol() + cy[i];
                if(x >= 0 && x < row && y >= 0 && y < col)
                {
                    if(matrix[x][y] == '.'  &&  !visited[x][y])
                    {
                        //System.out.println(matrix[x][y]);
                        visited[x][y] = true;
                        Q.add(new Pair(x, y));
                        dist++;
                    }
                }

            }

        }

        return dist;
    }



    // Pair Class


    private static class Pair
    {
        private int row, col;
        public Pair(int row, int col)
        {
            this.row = row;
            this.col = col;
        }

        public int getRow()
        {
            return this.row;
        }
        public int getCol()
        {
            return this.col;
        }
        public String toString()
        {
            return "[ row : " + this.row + " | col : " + this.col + " ] \n";
        }
    }



    //Main class

}

