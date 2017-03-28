import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		URI.problemSolve();
	}
}

class URI {

	public static void problemSolve() {
		// while(scanner.hasNextDouble()){
		double note = scanner.nextDouble();
		System.out.println("NOTAS:");
		System.out.printf("%d nota(s) de R$ 100.00\n", (int) (note / 100.0));
		note %= 100.0;
		System.out.printf("%d nota(s) de R$ 50.00\n", (int) (note / 50.0));
		note %= 50.0;
		System.out.printf("%d nota(s) de R$ 20.00\n", (int) (note / 20.0));
		note %= 20.0;
		System.out.printf("%d nota(s) de R$ 10.00\n", (int) (note / 10.0));
		note %= 10.0;
		System.out.printf("%d nota(s) de R$ 5.00\n", (int) (note / 5.0));
		note %= 5.0;
		System.out.printf("%d nota(s) de R$ 2.00\n", (int) (note / 2.0));
		note %= 2.0;

		System.out.println("MOEDAS:");

		System.out.printf("%d moeda(s) de R$ 1.00\n", (int) (note / 1.0));
		note *= 100.0;
		note %= 100.0;
		System.out.printf("%d moeda(s) de R$ 0.50\n", (int) (note / 50.0));
		note %= 50.0;
		System.out.printf("%d moeda(s) de R$ 0.25\n", (int) (note / 25.0));
		note %= 25.0;
		System.out.printf("%d moeda(s) de R$ 0.10\n", (int) (note / 10.0));
		note %= 10.0;
		System.out.printf("%d moeda(s) de R$ 0.05\n", (int) (note / 5.0));
		note %= 5.0;
		System.out.printf("%d moeda(s) de R$ 0.01\n", (int) (note / 1.0));
		// }
	}

	//private static Scanner scanner = fileConnectionFactory.getScanner();
	 private static Scanner scanner = new Scanner(System.in);
}

interface pathString {
	public static final String path = "res/uri.txt";
}

class fileConnectionFactory implements pathString {

	private fileConnectionFactory() {
		try {
			reader = new FileReader(path);
			buffer = new BufferedReader(reader);
			scanner = new Scanner(buffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Scanner getScanner() {
		return instance.scanner;
	}

	public static void close() {
		try {
			instance.reader.close();
			instance.buffer.close();
			instance.scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static fileConnectionFactory instance = new fileConnectionFactory();
	private Scanner scanner;
	private FileReader reader;
	private BufferedReader buffer;
}