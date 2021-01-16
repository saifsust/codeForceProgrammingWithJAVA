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
	private int m, n, sum;

	private void solve() {

		while (scanner.hasNext()) {
 
			m=scanner.nextInt();
			n=scanner.nextInt();
			int c= n-1;
			int r= n*(m-1);
			System.out.println(c+r);
			
			
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
