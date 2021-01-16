package UVA10327;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class UVA_10327 {

	private int min_steps_counter, arraySize;
	private int[] array, copy;

	private void solve() throws IOException {
		// scanner = fileConnectedFactory.scanner();
		// writer = fileConnectedFactory.writer();
		scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			arraySize = scanner.nextInt();
			min_steps_counter = 0;
			if (arraySize < 1)
				continue;
			array = new int[arraySize];
			copy = new int[arraySize];
			for (int i = 0; i < arraySize; i++) {
				array[i] = scanner.nextInt();
				copy[i] = array[i];
			}
			if (arraySize == 1 || isSorted(array, arraySize)) {
				// writer.write("Minimum exchange operations : "
				// +min_steps_counter+"\n");
				System.out.println("Minimum exchange operations : " + min_steps_counter);
				continue;
			}
			Arrays.sort(copy, 0, arraySize);
			for (int i = 0; i < arraySize; i++) {
				for (int j = 1; j <= arraySize; j++) {
					if (copy[i] == array[j - 1]) {
						for (int k = j - 1; k > i; k--) {
							if (array[k] < array[k - 1]) {
								swap(k, k - 1);
								min_steps_counter++;
							}
						}
					}
				}
			}
			/*
			 * for (int i = 0; i < arraySize; i++) { System.out.print(array[i] +
			 * " "); } System.out.print("\n");
			 */
			// writer.write("Minimum exchange operations : " + min_steps_counter
			// + "\n");
			System.out.println("Minimum exchange operations : " + min_steps_counter);

		}
		// writer.close();
		scanner.close();

	}

	private void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private boolean isSorted(int[] array, int arraySize) {
		for (int i = 0; i < arraySize - 1; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		try {
			new UVA_10327().solve();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private Scanner scanner;
	private BufferedWriter writer;
}
