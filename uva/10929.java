
import java.util.*;
import java.lang.*;

public class Main{
/*

 alternation sum of 31415 is 3-1+4-1+5 = 10

*/
public static void main(String[] args)
{
	Scanner read = new Scanner(System.in);
	while(read.hasNext())
	{

		String num = read.next();
		if(num.equals("0")) break;
         int alternatingSum=0;
         for(int i=0;i<num.length();i++)
         {
         	int digit=num.charAt(i)-'0';
         	if(i%2==0)
         	{
              alternatingSum+=digit;
           	}else alternatingSum-=digit;
         }

         if(alternatingSum%11==0)
         System.out.println(num+" is a multiple of 11.");
         else System.out.println(num+" is not a multiple of 11.");
	}
	read.close();

}

}