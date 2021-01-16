/**
 * 
 */
package apr;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Saif_sust_2013331007
 *
 */
public class Main {

	/**
	 * @param args
	 */

	// private Scanner scanner = new Scanner(System.in);
	private Scanner scanner = fileFactory.scanner();
	private int testCase, array[], size;

	private void Solution() {
		testCase = scanner.nextInt();
		for (int TestCase = 1; TestCase <= testCase; TestCase++) {
			size = scanner.nextInt();
			array = new int[size];
			for (int i = 0; i < size; i++) {
				array[i] = scanner.nextInt();
			}
			int swap = 0;
			for (int i = 0; i < size - 1; i++) {
				for (int j = i + 1; j < size; j++) {
					if (array[i] > array[j]) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						swap++;
					}
				}
			}
			System.out.println("Optimal train swapping takes " + swap + " swaps.");

		}

	}

	public static void main(String[] args) throws Exception {
		try {
			new Main().Solution();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
