import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{


    private double point, time, a, b, c, d, misha, vasya,tm,tv;

    private void solution()
    {

        Scanner read = new Scanner(System.in);


        while(read.hasNext())
        {

            a = read.nextDouble();
            b = read.nextDouble();
            c = read.nextDouble();
            d = read.nextDouble();
            tm=(c*3.1416)/180.0;
            tv=(d*3.1416)/180.0;
            misha =Math.max((3.0*a)/10.0,a-(a/250.0)*c);
            vasya=Math.max((3.0*b)/10.0,b-(b/250.0)*d);

            if(misha==vasya)System.out.println("Tie");
            else if(misha>vasya)System.out.println("Misha");
            else System.out.println("Vasya");

        }
        //read.close();

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