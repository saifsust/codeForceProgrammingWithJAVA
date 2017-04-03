package UVA;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	/*
	 * Scanner
	 */
	// private Scanner scanner = fileFactory.scanner();
	private Scanner scanner = new Scanner(System.in);
	// private BufferedReader scanner = new BufferedReader(new
	// InputStreamReader(System.in));
	// private DataInputStream scanner = new DataInputStream(System.in);
	/*
	 * Printer
	 */
	private PrintWriter out = new PrintWriter(System.out, true);

	// private DataOutputStream out = new DataOutputStream(System.out);

	/*
	 * Varible Declarartion
	 */
	private int[][] array;
	private int testCase, num;

	private void solution() throws Exception {

		testCase = scanner.nextInt();
		for (int test = 1; test <= testCase; test++) {
			num = scanner.nextInt();
			array = new int[num + 1][4];
			for (int row = 0; row < num; row++) {
				for (int col = 0; col < 3; col++) {
					array[row][col] = scanner.nextInt();
				}
			}

			int sumOfMultiply = 0;
			for (int row = 0; row < num; row++) {
				sumOfMultiply += array[row][0] * array[row][2];
			}
			out.println(sumOfMultiply);
		}

	}

	/*
	 * Main Method
	 * 
	 */
	public static void main(String[] args) throws Exception {
		try {
			new Main().solution();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
