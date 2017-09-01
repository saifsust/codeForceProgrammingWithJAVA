
import java.util.Scanner;

public class Main{


private static String reverse(String num)
{
	String rev="";
	for(int i=num.length()-1;i>=0;i--)
	{
		rev+=num.charAt(i);
	}
	return rev;
}

public static void main(String[] args)
{
	Scanner read = new Scanner(System.in);

    String outNum;

	while(read.hasNext())
	{

		int num = read.nextInt();
		if(num<=-1) break;
          if(num==0)
          {
          	System.out.println(0);
          	continue;
          }

         outNum="";
        while(true)
        {

           if(num==0 & num%3==0) break;
        	outNum+=num%3;
        	num/=3;

        }
        System.out.println(reverse(outNum));

	}

}

}