import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{



    private int plane[], num;

    private void solution() throws Exception
    {


        Scanner read = new Scanner(System.in);

        while(read.hasNext())
        {


            num = read.nextInt();
            plane = new int[num + 1];
            for(int i = 1; i <= num; i++)
            {
                plane[i] = read.nextInt();
            }

            boolean checker = false;
            /*if(  num < 3 || plane[1] > num || plane[plane[1]] == plane[1] || plane[plane[1]] > num ||  plane[plane[plane[1]]] == plane[plane[1]] || plane[plane[plane[1]]] > num || plane[plane[plane[plane[1]]]] == plane[plane[plane[1]]] || plane[plane[plane[plane[1]]]] != firstPerson)
            {
                System.out.println("NO");
                continue;
            }*/
            if(num<3){
            	System.out.println("NO");
            	continue;
            }

            int prev[] = new int[5];
            for(int i = 1; i <= num; i++)
            {
            	if(plane[i]>num)continue;
            	Arrays.fill(prev,0);
                  boolean brk=false;
                for(int j = 1, k = plane[i]; j <= 4 && k <= num; j++, k = plane[k])
                {
                    prev[j] = plane[k];
                   // System.out.println("prev ="+prev[j] +" plane= "+plane[k]);
                    if(prev[j] == prev[j - 1]){
                    	brk=true;
                    	break;
                    }
                }
                if(prev[1] == prev[4] && brk==false)
                {
                	//System.out.println(prev[1]+" * "+prev[4]);
                    checker = true;
                    break;
                }

            }

            if(checker)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }


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