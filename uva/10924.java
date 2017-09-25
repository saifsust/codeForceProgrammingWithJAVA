import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
    private static final int N = 1042;
    private static int[] prime = new int[N + 2];
    private static int[] charValue = new int[123];
    static
    {
        int limit = (int)Math.sqrt(N);
        prime[0] = 1;
        for(int i = 4; i <= N; i += 2)prime[i] = 1;
        for(int i = 3; i <= N; i += 2)
        {
            if(prime[i] == 0)
            {
                if(i <= limit)
                    for(int j = i * i; j <= N; j += i * 2) prime[j] = 1;
            }
        }


        for(int ch = 'a' , j = 1; ch <= 'z'; ch++, j++)charValue[ch] = j;
        for(int ch = 'A', j = 27; ch <= 'Z'; ch++, j++)charValue[ch] = j;

    }
    public static void main(String[] args) throws Exception
    {

        Scanner read = new Scanner(System.in);
        //Scanner read = FileFactory.read();
        //BufferedWriter write = FileFactory.write();
        while(read.hasNext())
        {
            String word = read.next();
            int sum = 0;
            for(int i = 0; i < word.length(); i++)sum += charValue[word.charAt(i)];
            if(prime[sum] == 0)
                //write.write("It is a prime word.\n");
                System.out.println("It is a prime word.");
            else System.out.println("It is not a prime word.");
            // write.write("It is not a prime word.\n");
        }
        //FileFactory.close();
        read.close();
    }
}