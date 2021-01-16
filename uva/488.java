package apr;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		try {

			new uva.ProblemSolution().Solution();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class uva {
	public static class ProblemSolution {
		private static int testCase, amplitude, frequency;
		public void Solution() {
			testCase = scanner.nextInt();
			for (int test = 1; test <= testCase; test++) {
				amplitude = scanner.nextInt();
				frequency = scanner.nextInt();
				String str = makeTriangleWave(amplitude);
				for (int i = 1; i <= frequency; i++) {
					System.out.print(str);
					if (i < frequency)
						System.out.println('\n');
				}
				if (test < testCase)
					System.out.println("\n");
				else
					System.out.println();

			}
			scanner.close();
		}

	}

	private static String makeTriangleWave(int amplitude) {

		String str = "";
		int back, backCounter = 0;
		for (int i = 1; i <= amplitude * 2 - 1; i++) {
			if (i <= amplitude) {
				back = i;
			} else {
				backCounter += 2;
				back = i - backCounter;
			}
			for (int j = 1; j <= back; j++) {
				if (i <= amplitude) {
					str += i;
				} else {
					str += i - backCounter;
				}
			}
			if (i <= 2 * amplitude - 2) {
				str += '\n';
			}
		}

		return str;
	}
	/*
	 * Printer
	 */

	// private static PrintWriter out = new PrintWriter(System.out, true);
	// private static DataOutputStream out = new DataOutputStream(System.out);

	/*
	 * scanner
	 */

	// private static DataInputStream scanner = new DataInputStream(System.in);
	// private static BufferedReader scanner = new BufferedReader( new
	// InputStreamReader(System.in));
	private static Scanner scanner = new Scanner(System.in);
	// private static Scanner scanner = fileFactory.scanner();
	// private static BufferedReader scanner = fileFactory.bufferedRader();
}