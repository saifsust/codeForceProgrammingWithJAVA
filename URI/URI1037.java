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
		 //while (scanner.hasNextLine()) {

		double num = scanner.nextDouble();
		if (num >= 0.0 && num <= 25.0) {
			System.out.println("Intervalo [0,25]");
		} else {
			if (num > 25.0 && num <= 50.0) {
				System.out.println("Intervalo (25,50]");
			} else {
				if (num > 50.0 && num <= 75.0) {
					System.out.println("Intervalo (50,75]");
				} else {
					if (num > 75.0 && num <= 100.0) {
						System.out.println("Intervalo (75,100]");
					} else {

						System.out.println("Fora de intervalo");

					}
				}
			}
		}
		 //}
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