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
	public static void main(String[] args) throws Exception {
		try {
			new UVA().new Solver().Solution();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

class UVA {

	private int peterSmoke(int n, int k) {
		if (n < k)
			return 0;
		return n / k + peterSmoke(n / k + n % k, k);
	}

	protected class Solver {
		protected void Solution() {

			int n, k;
			while (scanner.hasNext()) {
				n = scanner.nextInt();
				k = scanner.nextInt();
				System.out.println(peterSmoke(n, k) + n);
			}
		}

	}

	// private BufferedReader scanner = new BufferedReader(new
	// InputStreamReader(System.in));
	// private DataInputStream scanner = new DataInputStream(System.in);
	// private Scanner scanner = fileFactory.scanner();
	private Scanner scanner = new Scanner(System.in);
}
