
import java.util.*;


public class Main{


	public static void main(String[] args)
	{

		Scanner read = new Scanner(System.in);
	double a,b,c,angle;
       while(read.hasNext())
       {

       
       	a=read.nextDouble();
       	b=read.nextDouble();
       	c=read.nextDouble();
       if(a==0 && b==0 && c==0) break;

          if(Math.pow(c,2)== Math.pow(a,2)+Math.pow(b,2) || Math.pow(a,2)== Math.pow(c,2)+Math.pow(b,2) || Math.pow(b,2)== Math.pow(a,2)+Math.pow(c,2)   )
          {
          	System.out.println("right");
          }else System.out.println("wrong");

       }
		read.close();

	}
}