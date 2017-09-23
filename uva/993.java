import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{

    private static List<Integer> divisorList = new ArrayList<Integer>();

    public static void main(String[] args) throws Exception
    {

       Scanner read = new Scanner(System.in);
    /*	Scanner read = FileFactory.read();
    	BufferedWriter write = FileFactory.write();*/
        int testCase = read.nextInt();
        for(int test = 1; test <= testCase; test++)
        {
            int num = read.nextInt();

            if(num < 10)
            {
            	/*write.write(Integer.toString(num));
            	write.write("\n");*/
                System.out.println(num);
                continue;
            }
             divisorList.clear();
            for(int i = 9; i > 1 && num > 1; i--)
            {
                while(num > 1)
                {
                    if(num % i != 0) break;
                    divisorList.add(i);
                    num /= i;
                }
            }
            if(num == 1)
            {
                Collections.sort(divisorList);
                for(int i = 0; i < divisorList.size(); i++)
                	/*write.write(Integer.toString(divisorList.get(i)));
                write.write("\n");*/
                    System.out.print(divisorList.get(i));
                System.out.println();
            }
            else System.out.println(-1);
          /*  write.write("-1\n");*/


        }
    /*    FileFactory.close();*/
        read.close();
    }

}