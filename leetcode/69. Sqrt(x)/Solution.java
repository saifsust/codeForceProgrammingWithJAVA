import java.util.*;
class Solution {
 
  public static void main(String[] args){
   Scanner read = new Scanner(System.in);
   while(read.hasNext()){
   	int num =read.nextInt();
   	System.out.println(mySqrt(num));
   }
   read.close();
  }
    public static  int mySqrt(int x) {
        return (int)Math.sqrt(x);
        
    }
}