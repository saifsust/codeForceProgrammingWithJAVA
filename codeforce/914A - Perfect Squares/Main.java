import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{


    private Scanner scanner = new Scanner(System.in);
    private int arraySize,maximum,sqrt;
    private double num;
    private void solution()
    {

        while(scanner.hasNext())
        {

            arraySize = scanner.nextInt();
            maximum = -1000001;
            for(int i = 0; i < arraySize; i++)
            {
                num = scanner.nextDouble();
                if(num<0){
                	if(maximum<num)
                		maximum=(int)num;
                	continue;
                }
                sqrt =(int)Math.sqrt(num);
                if(sqrt*sqrt != num && num > maximum)
                {
                    maximum = (int)num;
                }


            }

            System.out.println(maximum);


        }
        scanner.close();


    }


    public static void main(String[] args)
    {
        new Main().solution();
    }

}