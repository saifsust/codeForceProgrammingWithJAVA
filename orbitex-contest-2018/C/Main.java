import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/**
 *
 *@NAME SAIFUL ISLAM
 *@BATCH SUST CSE 2013-14
 *@Email : saiful.sust.cse@gmail.com
 *@Facebok : https://www.facebook.com/SaifulIslamLitonSust
*/

public class Main
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader rread = new Reader();
    private static Scanner fread = FileFactory.read();



    private static Set<String> palindroms, uniqueWords ;
    // Complete the solve function below.
    static double solve(String s)
    {

        // palindroms = new ArrayList<>();


        return 0.0;

    }


    private static void permute(  String word, int firstPos, int lastPos)
    {


        if(firstPos == lastPos)
        {
            // System.out.println(word);
            uniqueWords.add(word);

            for(int i = 0, j = word.length() - 1; i < j; ++i, --j)
            {
                if(word.charAt(i) != word.charAt(j)) return;
            }
            palindroms.add(word);
            return;
        }
        for(int i = firstPos; i <= lastPos; ++i)
        {
            word = swap(word, firstPos, i);
            permute(word, firstPos + 1, lastPos);

            word = swap(word, firstPos, i);

        }

    }

    private static String swap(String word, int posX, int posY)
    {

        char[] arr = word.toCharArray();

        char temp = arr[posX];
        arr[posX] = arr[posY];
        arr[posY] = temp;
        return String.valueOf(arr);
    }


    public static void main(String[] args)
    {
        String temp = "cbaabbb";
        //System.out.println(swap("ABCD", 0, 1));
        palindroms = new HashSet<>();
        uniqueWords = new HashSet<>();
        permute(temp, 0, temp.length() - 1);

        for(String str : palindroms)
        {
            System.out.println(str);
        }

        System.out.println("Total Palindrome : "+palindroms.size());

        for(String word : uniqueWords){
            System.out.println(word);
        }

        System.out.println();
        System.out.println("Total Word : "+uniqueWords.size());




    }





    //faster input reader

    private static class Reader
    {
        private BufferedReader buffered;
        private StringTokenizer  tokenizer;
        public Reader()
        {
            this.buffered = new BufferedReader(new InputStreamReader(System.in), 31768);
            this.tokenizer = null;
        }

        public String nextLine()
        {
            try
            {
                return buffered.readLine();

            }
            catch(Exception ex)
            {
                return "eof";
            }
        }

        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                tokenizer = new StringTokenizer(nextLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt()
        {
            try
            {
                return Integer.parseInt(next());
            }
            catch(Exception ex)
            {
                return -1;
            }
        }

        public long nextLong()
        {
            try
            {
                return Long.parseLong(next());
            }
            catch(Exception ex)
            {
                return -1;
            }
        }

        public double nextDouble()
        {
            try
            {
                return Double.parseDouble(next());
            }
            catch(Exception ex)
            {
                return -1.0;
            }
        }


    }
}