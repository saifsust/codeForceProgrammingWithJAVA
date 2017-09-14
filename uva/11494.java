 import java.util.*;

public class Main{
	private static  int N=9,M=9;
    private static int[][] chessBoard = new int[N][M];
    private static int[] dx={1,1,1,0,-1,-1,-1,0};
    private static int[] dy={-1,0,1,1,1,0,-1,-1};
    private static void dfs(int startX,int startY,int incrX,int incrY)
    {
        if(startX>8 || startX<0 || startY>8 || startY<0 ) return;
    	chessBoard[startY][startX]=1;
    	dfs(startX+incrX,startY+incrY,incrX,incrY);
    }

	public static void main(String[] args)
	{

      Scanner read = new Scanner(System.in);


     int startX,startY,endX,endY;
     while(read.hasNext())
     {
     	startX=read.nextInt();
     	startY=read.nextInt();
     	endX=read.nextInt();
     	endY=read.nextInt();
     	if(startX==0 && startY==0 && endX==0 && endY==0) break;

         if(startX==endX && startY==endY)
         {
         	System.out.println("0");
         	continue;
         }
         
        for(int i=0;i<N;i++)
        {
        	Arrays.fill(chessBoard[i],0);
        }

        for(int i=0;i<dx.length;i++)
        {
        	dfs(startX,startY,dx[i],dy[i]);
        }
       
        if(chessBoard[endY][endX]==1) 
        	System.out.println("1");
        else System.out.println("2");





     }

      read.close();
    
	}
}