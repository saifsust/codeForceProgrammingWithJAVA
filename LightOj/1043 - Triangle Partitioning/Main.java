import java.util.*;
import java.lang.*;
import java.io.*;
 public class Main
{

    /**
    * @author SAIFUL ISLAM
    * @BATCH 2013-14
    * @mail : saiful.sust.cse@gmail.com
     **/
    /**
    *       A
    *       ^
    *     / | \
    *   D - |- E
    *   /   |   \
    * B -------- C
    **/


    public static void main(String[] args) throws Exception
    {

        Reader read = new Reader();
        //Scanner read = FileFactory.read();
        int testCase = read.nextInt();

        for(int test = 1 ; test <= testCase; ++test)
        {
            double datas[] = new double[4];
            for(int i = 0; i < datas.length; ++i)
            {
                datas[i] = read.nextDouble();
            }

            // datas[0]=ab,datas[1]=ac,datas[2]=bc,datas[3]=ratio
            double areaOfABC = areaOfTriangle(datas[0], datas[2], datas[1]);
            /**
             * ADE/BDEC = ADE/ABC-ADE = ABC/ADE - 1 = 1/ratio
             * ABC/ADE = 1+ 1/ratio
             * ABC/ADE = (ratio+1)/ratio
             * again,
             *  ABC/ADE = BC^2/DE^2 = (ratio+1)/ratio
             *  BC/DE = sqrt(ratio+1)/sqrt(ratio)
             * again
             * AB/AD = BC/DE = sqrt(ratio+1)/sqrt(ratio)
             * AD = AB*(sqrt(ratio)/sqrt(ratio+1))
             */

            System.out.printf("Case %d: %.12f\n",test,datas[0] * (Math.sqrt(datas[3]) / Math.sqrt(datas[3]+1)));

        }

    }

    private static double areaOfTriangle(double ab, double bc, double ca)
    {
        double halfRange, sum = 0.0, areaOfABC;
        sum = ab + bc + ca;
        halfRange = sum / 2.0;
        return  Math.sqrt(halfRange * (halfRange - ab) * (halfRange - bc) * (halfRange - ca));
    }






    // fast Input Class

    private static class Reader
    {
        private BufferedReader buffer;
        private StringTokenizer tokenizer;

        public Reader()
        {
            this.buffer = new BufferedReader( new InputStreamReader(System.in), 31768);
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