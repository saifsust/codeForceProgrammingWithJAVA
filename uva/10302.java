import java.util.Scanner;
import java.lang.Math;
public class Main{



 public static void main(String[] args)
 {

   Scanner read = new Scanner(System.in);
   while(read.hasNext())
   {

     long num = read.nextInt();
      long ans =(long) Math.pow(num,2)*(long)Math.pow((num+1),2)/4;
     System.out.println(ans);

   }
 }

}