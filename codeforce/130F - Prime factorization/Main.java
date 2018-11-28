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

    static final int MAX_SIZE = 252;
    static int isPrime[];
    static List<Integer>primes;

    static
    {
        primes = new ArrayList<>();

        isPrime = new int[MAX_SIZE];

        for(int i = 4; i < MAX_SIZE; i += 2) isPrime[i] = 1;
        isPrime[1] = 1;
       
        primes.add(2);

        int sqrt = (int) Math.sqrt(MAX_SIZE);

        for(int i = 3; i < MAX_SIZE; i += 2)
        {
            if(isPrime[i] == 0)
            {
                for(int j = i * i; j < MAX_SIZE; j += i * 2)isPrime[j] = 1;
                primes.add(i);
            }

        }


    }


     


    // main method
    void  main() throws Exception
    {

        int num = read.nextInt();

        List<Integer>factors = new ArrayList<>();

        for(int i=0;i<primes.size() && primes.get(i)<=num;++i){

            while(num%primes.get(i)==0){
                factors.add(primes.get(i));
                num/=primes.get(i);
            }

        }

        for(int i=0 ; i<factors.size();i++){
            System.out.print(factors.get(i));

            if(i<factors.size()-1)System.out.print(" ");
        }

        System.out.println();


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