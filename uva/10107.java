import java.util.*;
import java.lang.*;
public class Main{
	public static void main(String[] args)
	{
		Vector<Integer>list = new Vector<Integer>();
		Scanner read = new Scanner(System.in);
        while(read.hasNext())
        {
          int num = read.nextInt();
          list.add(num);
          Collections.sort(list);
          if(list.size()%2==1)System.out.println(list.get(list.size()/2));
          	else System.out.println((int)(list.get(list.size()/2)+list.get(list.size()/2-1) )/2);
      
        }
		read.close();

	}
}