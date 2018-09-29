import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main
{
    private static Scanner sread = new Scanner(System.in);
    private static Reader read = new Reader();
    private static Scanner fread = FileFactory.read();

    private static int[] arr;
    private static List<Integer>paginate;
    private static List< List<Integer> > list;

    public static void main(String[] args)
    {

        while(sread.hasNext())
        {
            int num = sread.nextInt();
            arr = new int[num];

            for(int i = 0; i < num; i++) arr[i] = sread.nextInt();
            int skip = sread.nextInt();
            int pageSize = sread.nextInt();
            int pageNumber = sread.nextInt();
            int sortOrder = sread.nextInt();

           int[] pg= Getfiltered(skip, pageSize, pageNumber, sortOrder);
        if(pg != null)
           for(int i=0;i<pg.length;++i)System.out.print(pg[i]+"  ");
            System.out.println();




        }







    }


    private static int[] Getfiltered(int skip, int pageSize, int pageNumber, int sortOrder)
    {
        list = new ArrayList<>();
        //System.out.println(skip);

        for(int i = skip; i < arr.length;)
        {
           // System.out.println("Done");
            int rang = pageSize + i - 1;

           // System.out.println(i);
            List<Integer> page = new ArrayList<Integer>();
            for(int j = i; j < arr.length && j <= rang ; ++j)
            {
               // System.out.print(arr[j] + " ");
                page.add(arr[j]);
            }
            i = rang + 1;
            //if(page.size() < pageSize)continue;
         //  System.out.println();
            list.add(page);

        }

       //System.out.println("==================");

        --pageNumber;
        if(pageNumber >= list.size()) return null;

        Collections.sort(list.get(pageNumber));
        int[] pg = new int[list.get(pageNumber).size()];
        if(sortOrder == 0)
        {
            for(int i = 0; i < list.get(pageNumber).size(); ++i)
            {
                pg[i] = list.get(pageNumber).get(i);
                
            }
        }
        else
        {

            /* for(int num : list.get(pageNumber)){
                System.out.print(num+"  ");
             }
             System.out.println();*/
            for(int i = list.get(pageNumber).size()-1,j=0; i >= 0; --i,++j)
            {
               // System.out.print(pg[i]+"  ");
                pg[j] = list.get(pageNumber).get(i);
            }

        }
/*
        for(int i = 0; i < list.size(); ++i)
        {
            for(Integer num : list.get(i))
            {
                System.out.print(num + "  ");
            }
            System.out.println();
        }
        System.out.println();*/
        return pg;

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