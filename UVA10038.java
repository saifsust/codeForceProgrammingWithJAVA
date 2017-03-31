package UVA10038;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UVA10038 {

	public static void main(String[] args) {
		new UVA10038().jully();
	}

	private static long[] array;
	private static long[] store;
	private Scanner scanner;
	private BufferedWriter writer;

	private void jully() {
		scanner = new Scanner(System.in);
		//scanner=fileConnectedFactory.scanner();
		//writer=fileConnectedFactory.writer();
		while (scanner.hasNextLine()) {
			try {
				int n = scanner.nextInt();
				if (n < 1)
					continue;
				array = new long[n + 50];
				for (int i = 0; i < n; i++) {
					array[i] = scanner.nextInt();
				}
				if (n == 1) {
					System.out.println("Jolly");
					continue;
				}
				store = new long[n + 50];
				for (int i = 0; i < n - 1; i++) {
					store[i] = Math.abs(array[i] - array[i + 1]);
				}
				boolean test = true;
				Arrays.sort(store, 0, n - 1);
				for (int i = 0; i < n - 1; i++) {
					if (store[i] != i + 1) {
						test = false;
						break;
					}
				}
				if (test) {
					System.out.println("Jolly");
				} else {
					System.out.println("Not jolly");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	public static class myScanner {
		private BufferedReader bf;
		private StringTokenizer st;

		public myScanner() {
			bf = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					String str = bf.readLine();
					if (str.equals("EOF") || str.equals("eof")) {
						close();
						System.exit(0);
					} else
						st = new StringTokenizer(str);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public float nextFloat() {
			return Float.parseFloat(next());
		}

		public String nextLine() {
			String str = "";
			try {
				str = bf.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		public void close() {
			try {
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// private static PrintWriter out;
}