/**
 * 
 */
package apr;

import java.util.Scanner;

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
			new uva.Solver().new Solution().ProblemSolve();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class uva {
	protected static class Solver {
		protected class Solution {

			private long first, last, x, y;

			public void ProblemSolve() {

				int TestCase = scanner.nextInt();
				for (int testCase = 1; testCase <= TestCase; testCase++) {
					first = scanner.nextLong();
					last = scanner.nextLong();
					if (last > first || (first + last) % 2 == 1) {
						System.out.println("impossible");
						continue;

					}
					x = (first + last) / 2;
					y = (first - last) / 2;
					// System.out.println(x + " " + y);
					System.out.println(Math.max(x, y) + " " + Math.min(x, y));

				}

			}
		}
	}

	// private static Scanner scanner = new Scanner(System.in);
	private static Scanner scanner = fileFactory.scanner();
}