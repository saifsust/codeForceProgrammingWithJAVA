import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main(String[] args)throws IOException
    {

        Reader read = new Reader();
        //Scanner read = FileFactory.read();
        //BufferedWriter writer = FileFactory.write();
        //int testCase = read.nextInt();
        System s = null;
        int test = 0;
        while(true)
        {
            int num = read.nextInt();
            int query = read.nextInt();

            if(num == 0 && query == 0 )break;

            int[] merbels = new int[num];
            for(int i = 0; i < num; ++i)  merbels[i] = read.nextInt();

            s.out.println("CASE# " + ++test + ":");
           // writer.write("CASE# " + ++test + ":");
            //writer.newLine();
            Arrays.sort(merbels);
           /* for(int i = 0; i < num; ++i)System.out.print(merbels[i] + "  ");
            System.out.println();*/
            for(int i = 0; i < query; ++i)
            {
                int q = read.nextInt();
                int isFound = binarySearch(merbels, q, 0, num - 1);
                if(isFound < 0)
                {
                    System.out.println(q + " not found");
                   //writer.write(q + " not found");
                }
                //System.out.println()
                else
                {
                    int tempFount = isFound;
                    while(isFound > -1)
                    {

                        isFound = binarySearch(merbels, q, 0, isFound - 2);
                        if(tempFount > isFound && isFound > -1)
                        {
                            tempFount = isFound;
                        }

                    }
                    System.out.println(q + " found at " + tempFount);
                    //writer.write(q + " found at " + tempFount);
                }
                //writer.newLine();
            }

            // System.out.println(binarySearch(merbels, querys[0], 0, num - 1));
            // int [] isFound = new int[10002];
            ///int found;
            /*for(int q = 0; q < query; ++q)
            {

                found = binarySearch(merbels, querys[q], 0, num - 1);
                if(found == -1) writer.write(querys[q] + " not found");  //s.out.println(querys[q] + " not found");
                else
                {

                    int temp = found, min = found;
                    // System.out.println(temp);
                    if(isFound[querys[q]] == 0)
                    {
                        while(0 <= temp)
                        {

                            temp = binarySearch(merbels, querys[q], 0, temp - 2);
                            //System.out.println(temp);
                            if(min > temp && temp != -1)
                            {
                                min = temp;
                            }
                        }
                    }
                    else
                    {
                        min = Integer.MAX_VALUE;
                        temp = num - 1;
                        //System.out.println(isFound[querys[q]]);
                        boolean on = false;
                        while(0 <= temp)
                        {

                            if(on) temp -= 2;
                            temp = binarySearch(merbels, querys[q], isFound[querys[q]], temp);
                            // System.out.println(temp);
                            on = true;
                            if(min > temp && temp > isFound[querys[q]])
                            {
                                min = temp;
                            }
                        }
                    }
                    if(min == Integer.MAX_VALUE) writer.write(querys[q] + " not found");  //s.out.println(querys[q] + " not found");
                    else
                    {
                        isFound[querys[q]] = min;
                        writer.write(querys[q] + " found at " + min);
                        //s.out.println(querys[q] + " found at " + min);
                    }
                }
                //if(q < query - 1)System.out.println();

                writer.newLine();
            }
            */
        }
       // writer.close();


    }

    // binarySearch for finding merbels


    private static int binarySearch(int[] merbels, int queryMerbel, int first, int last)
    {
        if(first > last) return -1;
        if(last < 0)     return -1;
        int mid = (int)((first + last) / 2);
        //System.out.println(mid);
        if(merbels[mid] == queryMerbel)return mid + 1;
        else if(queryMerbel < merbels[mid]) return binarySearch(merbels, queryMerbel, first, mid - 1);
        else return binarySearch(merbels, queryMerbel, mid + 1, last);
    }


    /// faster input class
    private  static class Reader
    {

        private BufferedReader buffer ;
        private StringTokenizer tokenizer;
        public Reader()
        {
            this.buffer = new BufferedReader(new InputStreamReader(System.in), 31768);
            this.tokenizer = null;
        }

        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try
                {
                    tokenizer = new StringTokenizer(buffer.readLine());
                }
                catch(Exception ex)
                {
                    return "eof";
                }

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
    }

}