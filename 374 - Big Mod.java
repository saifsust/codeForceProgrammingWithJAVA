/**
 *
 */
package A;

import java.util.*;

/**
 * @author Saif_sust_2013331007
 *
 */
public class Main {

	private Scanner scanner = new Scanner(System.in);
	private int B, P, M, sum, c;

	private long square(long x) {
		return (x%M) * (x%M);
	}

	private long bigMod(long B, long P, long M) {
		if (P == 0)
			return 1;
		if (P % 2 == 0) {
			return square(bigMod(B, P / 2, M)) % M;

		} else {
			return ((B % M) * bigMod(B, P - 1, M))%M;
		}

	}

	private void solve() {

		while (scanner.hasNext()) {
			B = scanner.nextInt();
			P = scanner.nextInt();
			M = scanner.nextInt();

			System.out.println(bigMod(B, P, M));

		}
		scanner.close();

	}

	public static void main(String[] args) {
		try {

			new Main().solve();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
