package NumberFrequence_1171;

import java.io.IOException;
import java.util.*;

public class Main {

	private static Scanner scanner = new Scanner(System.in);

	// private static Scanner scanner = fileFactory.scanner();
	private static class URI {
		private int num;
		private String str;
		private int[] array;
		private int[] counter = new int[2000 + 50];

		private void solve() {
			// while (scanner.hasNextLine()) {
			str = scanner.next();
			//if (str.equals("EOF") || str.equals("eof"))
				//break;
			num = Integer.parseInt(str);
			array = new int[num];
			Arrays.fill(counter, 0);
			int count = 0;
			for (int i = 0; i < num; i++) {
				int number = scanner.nextInt();
				if (counter[number] == 0) {
					array[count++] = number;
				}
				counter[number]++;
			}
			Arrays.sort(array, 0, count);
			for (int i = 0; i < count; i++) {
				System.out.println(array[i] + " aparece " + counter[array[i]] + " vez(es)");
			}

			// }

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
