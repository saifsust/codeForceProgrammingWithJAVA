import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        Scanner read = FileFactory.read();
        //Reader read = new Reader();
        int testCase = 0;
        int num ;
        int totalProperties = 0;
        double totalConsumes = 0.0;

        //BufferedWriter writer = FileFactory.write();
        while((num = read.nextInt()) != 0)
        {
            totalProperties = 0;
            totalConsumes = 0.0;

            List<Pair> residents = new ArrayList<Pair>();
            int[] sumProperties = new int[205];
            for(int i = 1; i <= num; ++i)
            {
                int property = read.nextInt();
                double consume = read.nextDouble();
                totalProperties += property;
                totalConsumes += consume;
                Pair pair = new Pair(property, consume);
                residents.add(pair);
                sumProperties[pair.getConsume()] += pair.getProperty();
            }

            Collections.sort(residents);
            if(testCase > 0)
            {
                System.out.println();
          /*      writer.newLine();*/
            }

            System.out.println("Cidade# " + (++testCase) + ":");
         /*   writer.write("Cidade# " + (testCase) + ":");
            writer.newLine();*/
            String ans = sumProperties[residents.get(0).getConsume()] + "-" + residents.get(0).getConsume();
            sumProperties[residents.get(0).getConsume()] = -1;
            for(int i = 1; i < residents.size(); ++i)
            {
                if(sumProperties[residents.get(i).getConsume()] == -1) continue;
                ans += ' ';
                ans += sumProperties[residents.get(i).getConsume()] + "-" + residents.get(i).getConsume();
                sumProperties[residents.get(i).getConsume()] = -1;
            }
            System.out.println(ans);
            /*writer.write(ans);
            writer.newLine();*/

            double aver = Math.floor(((totalConsumes / (double)totalProperties) * 1000.0));
            aver = Math.floor(aver / 10.0);
            System.out.printf("Consumo medio: %.2f m3.\n", aver/100.0);
            /* DecimalFormat format = new DecimalFormat("0.##");
             //System
             writer.write("Consumo medio: " + format.format(aver) + " m3.");
             writer.newLine();*/

        }
       /* writer.close();*/

    }


    private static class Pair implements Comparable<Pair>
    {
        private int property;
        private int consume;
        public Pair(int property, double consume)
        {
            this.property = property;
            this.consume = (int) (consume / (double) property);
        }

        public int getProperty()
        {
            return this.property;
        }
        public int getConsume()
        {
            return this.consume;
        }

        public String toString()
        {
            return getProperty() + "-" + getConsume();
        }

        public int compareTo(Pair pair)
        {
            return this.consume - pair.getConsume();
        }
    }


    // faster

    private static class Reader
    {
        private BufferedReader buffered;
        private StringTokenizer tokenizer;

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
                throw new RuntimeException(ex);
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
            return Integer.parseInt(next());
        }
        public double nextDouble()
        {
            return Double.parseDouble(next());
        }

    }

}