import java.util.*;
import java.io.*;
class Main
{
    private static final int N = 1000000;
    private static int[] mark = new int[N + 2];
    private static int[] pow = new int[N + 2];
    private static int[] ans = new int[N + 2];
    private static Vector<Integer> primeList = new Vector<Integer>();
    private static void seive()
    {
        Arrays.fill(mark, 1);
        mark[1] = 0;
        primeList.add(2);
        int limit = (int) Math.sqrt(N);
        pow[2] = 1;
        for(int i = 3; i <=N; i += 2)
        {
            if(mark[i] == 1)
            {
                primeList.add(i);
                pow[i] = 1;
                if(i<=limit)
                    for(int j = i * i; j <= N; j += i * 2)
                    {
                        // pow[j] = pow[i] + pow[j / i];
                        mark[j] = 0;
                    }
            }
        }

        for(int i = 0; i < primeList.size(); i++)
        {
            int p = primeList.get(i);
            if(p<=limit+2)
            for(int j = p * p; j <= N; j += p)
            {
                pow[j] = pow[j / p] + 1;
            }
        }



    }


    private static void factorialPow()
    {
        ans[2] = 1;
        for(int i = 3; i <=N; i++)
            ans[i] = ans[i - 1] + pow[i];
    }

    public static void main(String[] args) throws Exception
    {
        seive();
        factorialPow();
        int n = 100;
            Scanner read = new Scanner(System.in);
           //  Scanner read = FileFactory.read();
            // BufferedWriter write =FileFactory.write();
             while(read.hasNext())
             {

             	int num = read.nextInt();
             	//write.write(Integer.toString(ans[num]));
             	//write.write("\n");
             	System.out.println(ans[num]);
             }
             //FileFactory.close();
             read.close();

    }

static class FileFactory {

	private FileFactory() {
		try {

			reader = new FileReader("in.txt");
			buffer = new BufferedReader(reader);
			scanner = new Scanner(buffer);
			writer = new FileWriter("out.txt");
			bufferWriter = new BufferedWriter(writer);

		} catch (Exception ex) {
			System.out.println(ex.getCause());
		}

	}

	public static Scanner read() {
		return instanceFactory.scanner;
	}

	public static BufferedWriter write() {
		return instanceFactory.bufferWriter;
	}

	public static void close() {

		try {

			instanceFactory.scanner.close();
			instanceFactory.buffer.close();
			instanceFactory.reader.close();
			instanceFactory.bufferWriter.close();
			instanceFactory.writer.close();

		} catch (Exception ex) {
			System.out.println(ex.getCause());
		}

	}

	private static FileFactory instanceFactory = new FileFactory();
	private FileReader reader;
	private BufferedReader buffer;
	private Scanner scanner;
	private FileWriter writer;
	private BufferedWriter bufferWriter;

}


}