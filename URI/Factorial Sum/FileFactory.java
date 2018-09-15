import java.util.*;
import java.io.*;
/**
 *
 *@NAME SAIFUL ISLAM
 *@BATCH SUST CSE 2013-14
 *@Email : saiful.sust.cse@gmail.com
 *@Facebok : https://www.facebook.com/SaifulIslamLitonSust
*/

public class FileFactory {

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