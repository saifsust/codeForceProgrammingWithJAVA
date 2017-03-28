import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		URI.problemSolve();
	}
}

class URI {

	public static void problemSolve() {
		while (scanner.hasNextInt()) {

			double[] code = { 4.00, 4.50, 5.00, 2.00, 1.50 };
			int codeNum = scanner.nextInt();
			double amount = scanner.nextDouble();
			System.out.printf("Total: R$ %.2f\n", code[codeNum - 1] * amount);

		}
	}

	 private static Scanner scanner = fileConnectionFactory.getScanner();
	//private static Scanner scanner = new Scanner(System.in);
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