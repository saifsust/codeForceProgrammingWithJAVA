/**
 * 
 */
package UVA_11332;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Saif_sust_2013331007
 *
 */
public class UVA_11332 {

	private Scanner scanner = new Scanner(System.in);
	private int num, counter;

	private void solve() throws Exception {

		while (scanner.hasNext()) {
			num = scanner.nextInt();
			if (num == 0)
				break;

			while (num > 9) {

				counter = 0;
				while (num > 0) {
					counter += num % 10;
					num /= 10;
				}
				num = counter;

			}
			System.out.println(num);

		}
		scanner.close();
	}

	public static void main(String[] args) {

		try {
			new UVA_11332().solve();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
