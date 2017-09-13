

import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class Main{


public static boolean checkSequence(String s,String t)
{
	int index=0,count=0;
	for(int i=0;i<s.length();i++)
	{
		for(int j=index;j<t.length();j++)
		{
           if(s.charAt(i)==t.charAt(j))
           {
           	count++;
           	index=j;
           	index++;
           	break;
           }
		}
	}

	return count==s.length();
}

public static void main(String[] args)
{

Scanner read = new Scanner(System.in);
String s,t;
while(read.hasNext())
{
   s= read.next();
   t=read.next();

   if(checkSequence(s,t)){
   	System.out.println("Yes");
   }else{
   	System.out.println("No");
   }
   

}
read.close();

}

}