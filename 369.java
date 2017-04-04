package apr;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			uva.Solver.Solution();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class uva {

	protected static class Solver {

		private static int N, M;

		protected static void Solution() {
			combinatory();
			// System.out.println(comb[100][5]);

			while (scanner.hasNextLine()) {
				N = scanner.nextInt();
				M = scanner.nextInt();
				if (N == 0 && M == 0)
					break;
				System.out.println(N + " things taken " + M + " at a time is " + comb[N][M] + " exactly.");

			}

			scanner.close();
			out.close();

		}
	}

	private static long comb[][];
	private static int size = 102;

	private static void combinatory() {
		comb = new long[size][size];

		for (int i = 0; i < size; i++) {
			comb[i][0] = 1;
			comb[i][i] = 1;
		}
		for (int i = 2; i < size; i++) {
			for (int j = 1; j < i; j++) {
				comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
			}

		}

	}

	/*
	 * output class
	 */
	private static PrintWriter out = new PrintWriter(System.out, true);
	// private static DataOutputStream out = new DataOutputStream(System.out);
	/*
	 * Input class
	 */
	// private static BufferedReader scanner = new BufferedReader(new
	// InputStreamReader(System.in));
	// private static DataInputStream scanner = new DataInputStream(System.in);
	//private static Scanner scanner = new Scanner(System.in);
	 private static Scanner scanner = fileFactory.scanner();
	// private static BufferedReader scanner = fileFactory.bufferedRader();
}
