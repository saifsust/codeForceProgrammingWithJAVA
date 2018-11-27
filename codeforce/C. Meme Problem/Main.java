import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main
{

    //Scanner read = FileFactory.read();
    Reader read = new Reader();
    //FasterReader read = new FasterReader();
    //Scanner read = new Scanner(System.in);
    
      final double incremental = 0.000000000001D;
      final double cutter =      1000000000000.0D;


    double binarySearch(double first, double last,double num)
    {

        //System.out.println(first +" "+last);

        if(first >last) return -1.0;


       double mid = (first+last)/2.0000000000D;


        
       double mult = (num-mid)*mid;



        mult *= cutter;

        mult = Math.floor(mult);

        mult /=cutter;
        

       /// System.out.println(mid+" === "+ mult);

       if(Math.abs(mult - num) <= 0.00000001) return mid;
       else if(mult<num) return binarySearch(mid+incremental,last,num);
       else return binarySearch(first,mid-incremental,num);
    }

    // main method
    void  main() throws Exception
    {

        int testCases = read.nextInt();

        for(int testCase =1;testCase<=testCases;++testCase){

           double num = read.nextDouble();

           double ans= binarySearch(0.0,num,num);

           //ans *= 1000000000.0;

           //ans = Math.floor(ans);

           //ans/=1000000000.0;

           //System.out.println(ans);

           if(ans ==-1) System.out.println("N");
           else System.out.printf("Y %.9f %.9f\n",Math.max(ans,num-ans),Math.min(ans,num-ans));
        }


    }


    // Main method

    public static void main(String[] args) throws Exception
    {
        new Main().main();
    }

    // faster input reader

    private class Reader
    {
        private BufferedReader buffered;
        private StringTokenizer tokenizcer;

        public Reader()
        {
            this.tokenizcer = null;
            buffered = new BufferedReader(new InputStreamReader(System.in), 31768);
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
            while(tokenizcer == null || !tokenizcer.hasMoreTokens())
            {
                tokenizcer = new StringTokenizer(nextLine());
            }
            return tokenizcer.nextToken();
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

    // fatest Input Reader

    private static class FasterReader
    {

        private final int BUFFER_SIZE = 1 << 16;
        private DataInputStream dataInputStream;
        private byte[]  buffer;
        private int inputPointer, byteRead;

        public FasterReader()
        {
            dataInputStream = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            inputPointer = byteRead = 0;
        }

        private void fillBuffer() throws Exception
        {
            byteRead = dataInputStream.read(buffer, inputPointer = 0, BUFFER_SIZE);
            if(byteRead == -1) buffer[0] = -1;
        }

        private byte read() throws Exception
        {
            if(inputPointer == byteRead) fillBuffer();
            return buffer[inputPointer++];
        }

        public String readLine() throws Exception
        {
            byte[] bytes = new byte[64];
            int cnt = 0, c;

            while((c = read()) != -1)
            {
                if(c == '\n')break;
                bytes[cnt++] = (byte)c;
            }
            return new String(bytes, 0, cnt);
        }

        public int nextInt() throws Exception
        {
            int ret = 0;
            byte c = read();

            while(c <= ' ')c = read();

            boolean neg = (c == '-');
            if(neg) c = read();

            do
            {

                ret *= 10;
                ret += c - '0';

            }
            while((c = read()) >= '0' && c <= '9');
            if(neg) return -ret;
            return ret;

        }


    }

}