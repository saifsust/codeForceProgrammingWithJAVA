import java.util.*;
import java.lang.*;

public class Main{

public static void main(String args[])
{
    Scanner read = new Scanner(System.in);

    while(read.hasNext())
    {
    	String num="";
    	String telephoneNum = read.nextLine();
    	for(int i=0;i<telephoneNum.length();i++)
    		{
              char ch=telephoneNum.charAt(i);
              if(ch>='A' && ch<='C')
              	num+='2';
              else if(ch>='D' && ch<='F')
              	num+='3';
              else if(ch>='G' && ch<='I')
              	num+='4';
              else if(ch>='J' && ch<='L')
              	num+='5';
              else if(ch>='M' && ch<='O')
              	num+='6';
              else if(ch>='P' && ch<='S') num+='7';
              else if(ch>='T' && ch<='V') num+='8';
              else if(ch>='W' && ch<='Z') num+='9';
              else num+=ch;

    		}
    		System.out.println(num);


    }

    read.close();
}

}