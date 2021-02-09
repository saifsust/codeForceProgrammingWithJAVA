import java.util.*;

public class Main {
   public static void main(String...args){
       List<Integer> nums = Arrays.asList(8,5,3,6,4,7,2);
       for(Integer num : nums){
           System.out.printf("%d ", num);
       }
       System.out.println();
        nums.stream()
        .map((item) ->{
         return item * 2;
       }).filter(item ->{
         return item % 4 == 0;
       })
       .sorted()
       .forEach(item -> {
        System.out.printf("%d ",item);
       });

       Integer num = nums.stream()
      .map(item -> item * 2)
      .filter( item ->{
        return item % 4 == 0;    
      })
      .reduce(1,(var , item) ->{
          System.out.printf("%d %d\n",var,item);
          return item + var;
      });
      System.out.println();
      System.out.println(num);
      
   } 
}
