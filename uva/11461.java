import java.util.*;
public class Main{


   private static int RANGE=100000;
   private static int[] squareNum = new int[RANGE+10];
   private static void findSquare()
   {

     Arrays.fill(squareNum,0);
    for(int i=1;i*i<=RANGE;i++)
    {
      squareNum[i*i]=1;
    }

   }



	public static void main(String[] args)
	{
		findSquare();
		Scanner read = new Scanner(System.in);


     int num_a,num_b;
     while(read.hasNext())
     {
     	num_a=read.nextInt();
     	num_b=read.nextInt();
     	if(num_a==0 && num_b==0) break;

        int count=0;
     	for(int i=num_a;i<=num_b;i++)
     	{
            if(squareNum[i]==1)
            	count++;
     	}
     	System.out.println(count);

     }
     read.close();

	}
}