import java.util.*;
import java.io.*;
import java.lang.*;

public class FileFactory
{

    private final String IN = "in.txt";
    private final String OUT = "out.txt";
    private BufferedReader buffered;
    private FileReader freader;
    private Scanner scanner;
    private FileWriter fwriter;
    private BufferedWriter writer;

    private static FileFactory instance = new FileFactory();

    private FileFactory()
    {
        try
        {
            this.freader = new FileReader(IN);
            this.buffered = new BufferedReader(freader);
            this.scanner = new Scanner(buffered);
            this.fwriter = new FileWriter(OUT);
            this.writer = new BufferedWriter(fwriter);

        }
        catch(Exception ex)
        {
            System.out.println("File Exception : " + ex.getMessage());
        }
    }

    public static Scanner read ()
    {
        return instance.scanner;
    }

    public static BufferedWriter writer()
    {
        return instance.writer;
    }
}