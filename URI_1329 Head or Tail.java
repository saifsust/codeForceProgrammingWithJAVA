package NumberFrequence_1171;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	// private static Scanner scanner = fileFactory.scanner();
	private static Scanner scanner = new Scanner(System.in);

	private static class URI {

		private int[] counter = new int[2];

		private void solve() {

			while (scanner.hasNext()) {
				int num = scanner.nextInt();
				if (num == 0)
					break;
				Arrays.fill(counter, 0);
				for (int i = 0; i < num; i++) {
					int winOrloss = scanner.nextInt();
					counter[winOrloss]++;
				}

				System.out.println("Mary won " + counter[0] + " times and John won " + counter[1] + " times");

			}
			scanner.close();

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
