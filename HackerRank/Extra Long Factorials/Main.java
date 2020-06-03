import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Solution{


 private static BigInteger fractorial(BigInteger num){
	if(num.equals( new BigInteger("0"))) return new BigInteger("1");
	return num.multiply(fractorial(num.subtract(new BigInteger("1"))));
	
 }

 public static void main(String[] arg){
    
   Scanner read = new Scanner(System.in);
   
   while(read.hasNext()){
   
   BigInteger num = read.nextBigInteger();
   
   System.out.println(fractorial(num));
   
   
   }
 
 }
}
