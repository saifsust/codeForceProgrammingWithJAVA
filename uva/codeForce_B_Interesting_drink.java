/**
 *
 */
package C;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Saif_sust_2013331007
 *
 */
public class codeForce_B_Interesting_drink {

	private Scanner scanner = new Scanner(System.in);
	private int arr[], a, b, x;

	private int binarySearch(int first, int last, int value) {

		if (first <= last) {
			int m = (int) (first + last) / 2;
			if (m + 1 < a) {
				if (arr[m] <= value && arr[m + 1] > value) {
					// System.out.println(arr[m]);
					return m;
				} else {
					if (arr[m] < value) {
						/// System.out.println(" Greater " + m);
						return binarySearch(m + 1, last, value);
					} else {
						if (arr[m] > value) {
							return binarySearch(first, m - 1, value);
						} else {
							if (arr[m] == value) {
								return binarySearch(m + 1, last, value);
							}
						}
					}
				}
			} else {
				if (arr[m] == value) {
					// System.out.println(m);
					return m;
				}
			}
		}
		// System.out.println("ok");
		return -1;
	}

	private void solve() throws Exception {

		a = scanner.nextInt();
		arr = new int[a];
		for (int i = 0; i < a; i++) {
			arr[i] = scanner.nextInt();
		}
		b = scanner.nextInt();
		Arrays.sort(arr, 0, a);
		int counter = 0;

		/*
		for (int i = 0; i < a; i++) {
			System.out.print(arr[i] + " ");
		}*/

		System.out.println();
		for (int i = 0; i < b; i++) {
			x = scanner.nextInt();
			if (x >= arr[a - 1]) {
				System.out.println(a);
			} else {
				counter = binarySearch(0, a - 1, x);
				if (counter == -1) {
					System.out.println(0);
				} else {
					System.out.println(++counter);
				}
			}
		}
		scanner.close();
	}

	public static void main(String[] args) {
		try {
			new codeForce_B_Interesting_drink().solve();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
