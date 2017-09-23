import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{

    private static final int SIZE = 1000000;
    private static int[] mark = new int[SIZE + 2];
    private static void sieve()
    {
        mark[1] = 1;
        int limit = (int)Math.sqrt(SIZE);
        for(int i = 4; i <= SIZE; i += 2)mark[i] = 1;
        for(int i = 3; i <= SIZE; i += 2)
        {
            if(mark[i] == 0)
            {
                if(i <= limit)
                    for(int j = i * i; j <= SIZE; j += i * 2)mark[j] = 1;
            }
        }

    }
    public static void main(String[] args) throws Exception
    {
        sieve();
        Scanner read = new Scanner(System.in);
     /*   Scanner read = FileFactory.read();
        BufferedWriter write = FileFactory.write();*/
        while(read.hasNext())
        {
            int num = read.nextInt();

            if(mark[num] == 0)
            {
                int rev = 0, mod = num;
                while(mod > 0)
                {
                    rev *= 10;
                    rev += mod % 10;
                    mod /= 10;
                }
                if(mark[rev]==0 && num != rev)/*write.write(Integer.toString(num)+" is emirp.\n");*/
                	System.out.println(num+" is emirp.");
                else/* write.write(Integer.toString(num)+" is prime.\n");*/
                System.out.println(num + " is prime.");
            }
            else System.out.println(num + " is not prime.");
          /*  write.write(Integer.toString(num)+" is not prime.\n");*/


        }
      /*  FileFactory.close();*/
        read.close();
    }
}