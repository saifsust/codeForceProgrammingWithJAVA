import java.util.Scanner;
import java.util.*;


public class Main{



private static String reverse(String word)
{
   String reverseWord="";
   for(int i=word.length()-1;i>=0;i--)
   {
     reverseWord+=word.charAt(i);

   }
   return reverseWord;
}



public static void main(String[] args)
{
	Scanner read = new Scanner(System.in);
     while(read.hasNext()){
       
          
      String reverseLine="",line,word;    
       line = read.nextLine();
   
     int lineLength = line.length(),j,i;
      for(i=0;i<lineLength;i++)
      {

      	word="";
      	for( j=i;j<lineLength && line.charAt(j) !=' ' ; j++)
      	{
      		
      		word+=line.charAt(j);
      	}
      	i=j;
      
      reverseLine+=reverse(word);
      if(i<lineLength-1)
      reverseLine+=' ';

      }

     System.out.println(reverseLine);



     }
   read.close();
}

}