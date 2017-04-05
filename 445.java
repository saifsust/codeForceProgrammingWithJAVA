/**

 *
 */
package apr;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * @author Saif_sust_2013331007
 *
 */
public class Main {

	/**
	 * @param args
	 */
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
		private static String str;

		protected static void Solution() {
			int count = 0;
			while (scanner.hasNext()) {
				str = scanner.nextLine();
				if (str.length()==0) {
					System.out.println();
					continue;
				}
				int arr[];
				for (int i = 0; i < str.length(); i++) {
					if (Character.isDigit(str.charAt(i))) {
						arr = findNumber(str, i);
						if (arr[0] == -1)
							continue;
						i = arr[1];
						for (int j = 1; j <= arr[0]; j++) {
							if (str.charAt(arr[1]) == 'b') {
								System.out.print(" ");
							} else {
								if (str.charAt(arr[1]) == '!') {
									System.out.println();
								} else {
									if (Character.isAlphabetic(str.charAt(arr[1])) || str.charAt(arr[1]) == '*') {
										System.out.print(str.charAt(arr[1]));
									} else {
										int k = 0;
										for (k = arr[1]; k < str.length(); k++) {
											if (Character.isAlphabetic(str.charAt(k))) {
												break;
											}

										}
										System.out.print(str.charAt(k));
									}
								}
							}
						}

					} else {
						if (str.charAt(i) == '!') {
							System.out.println();
						}
					}

				}
				if (scanner.hasNext())
					System.out.println();

			}
			scanner.close();

		}
	}

	private static int[] findNumber(String str, int startIndex) {
		int[] array = new int[2];
		int i = startIndex;
		int sumOfDigit = 0;
		for (; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				sumOfDigit += (int) (str.charAt(i) - '0');
			} else
				break;
		}

		if (i == str.length() || sumOfDigit == 0) {
			array[0] = -1;
			array[1] = -1;
		} else {
			array[0] = sumOfDigit;
			array[1] = i;
		}
		return array;
	}

	 private static Scanner scanner = new Scanner(System.in);
	//private static Scanner scanner = fileFactory.scanner();
}
