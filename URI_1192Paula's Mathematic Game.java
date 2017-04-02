

import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	 //private static Scanner scanner = fileFactory.scanner();

	private static class URI {
		private int testCase;
		private String str;
		private int first, second, index;
		private char alpha;

		private void solve() throws Exception {

			testCase = scanner.nextInt();
			for (int t = 1; t <= testCase; t++) {
				str = "";
				str = scanner.next();
				if (str.length() < 1)
					continue;
				index = getIndex(str);
				first = Integer.parseInt(str.substring(0, index));
				alpha = str.charAt(index);
				second = Integer.parseInt(str.substring(index + 1, str.length()));
				if (alpha >= 'A' && alpha <= 'Z') {
					if (first != second) {
						System.out.println(second - first);
					} else {
						System.out.println(second * first);
					}
				} else {
					if (first != second) {
						System.out.println(second + first);
					} else {
						System.out.println(second * first);
					}
				}

			}

		}

		private int getIndex(String str) {
			for (int i = 0; i < str.length(); i++) {
				if (Character.isAlphabetic(str.charAt(i))) {
					return i;
				}
			}
			return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		try {
			new URI().solve();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
