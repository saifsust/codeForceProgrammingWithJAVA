import java.util.*;
import java.lang.*;
import java.io.*;
 public class Main
{
    private int alpha;
    private int[] check = new int[500];
    private void solution()
    {

        Scanner read = new Scanner(System.in);
        while(read.hasNext())
        {
            int num = read.nextInt();
            read.nextLine();
            String str = read.nextLine();
             boolean answer =true;
             Arrays.fill(check,0);
             str=str.toLowerCase();
             for(int i=0;i<str.length();i++)
             	check[str.charAt(i)-'a']=1;
             for(int i=0;i<26;i++)
             {
             	if(check[i]!=1){

                answer=false;
                break;
             	}
             }
             if(answer)System.out.println("YES");
             else System.out.println("NO");


        }
        read.close();


    }
    public static void main(String[] args)
    {

        try
        {
            new Main().solution();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }


}