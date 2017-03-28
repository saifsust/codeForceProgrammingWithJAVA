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
			double[] array = new double[4];
			for (int i = 0; i < array.length - 1; i++) {
				array[i] = scanner.nextDouble();
			}
			try {

				double D = (array[1] * array[1]) - (4.0 * array[0] * array[2]);
				double R1 = (-array[1] + Math.sqrt(D)) / (2.0 * array[0]);
				double R2 = (-array[1] - Math.sqrt(D)) / (2.0 * array[0]);
				if (D < 0 || array[0] == 0.0) {
					System.out.println("Impossivel calcular");
				} else {
					DecimalFormat df = new DecimalFormat("#.#####");
					System.out.print("R1 = " + df.format(R1) + "\nR2 = " + df.format(R2) + "\n");
				}
			} catch (Exception ex) {
				System.out.println("Impossivel calcular");
			}

	//	}
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