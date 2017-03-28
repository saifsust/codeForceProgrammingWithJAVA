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
		// while(scanner.hasNextInt()){
		int[] array = new int[5];
		for (int i = 0; i < array.length - 1; i++) {
			array[i] = scanner.nextInt();
		}
		int count = 0;
		if (array[1] > array[2]) {
			count++;
			if (array[3] > array[0]) {
				count++;
				if (array[2] + array[3] > array[0] + array[1]) {
					count++;
					if (array[2] >= 0 && array[3] >= 0) {
						count++;
						if (array[0] % 2 == 0) {
							count++;
						}
					}
				}
			}
		}
		//System.out.println(count);
		switch (count) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			System.out.println("Valores nao aceitos");
			break;
		case 5:
			System.out.println("Valores aceitos");
			break;

		}

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