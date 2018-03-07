import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{


    private void solution()
    {


        Scanner read = new Scanner(System.in);

        int testCase = 1;
        while(read.hasNext())
        {
            String temp = read.next();


            if(temp.equals("*"))break;
            if(temp.equals("Hajj"))
                System.out.println("Case " + testCase + ": Hajj-e-Akbar");
            else System.out.println("Case " + testCase + ": Hajj-e-Asghar");
            testCase++;



        }


        read.close();




    }


    public static void main(String[] args)
    {

        new Main().solution();


    }

}