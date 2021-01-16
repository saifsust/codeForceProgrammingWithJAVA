/**
 *
 */
package codeForces_160A_twins;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * @author Saif_sust_2013331007
 *
 */
public class codeForce_160A_twins {

	private Scanner scanner = new Scanner(System.in);
	private int sum, array[], num, sum2, coinCounter;

	private void solution() throws Exception {

		while (scanner.hasNext()) {
			num = scanner.nextInt();
			array = new int[num];
			sum = 0;
			for (int i = 0; i < num; ++i) {
				array[i] = scanner.nextInt();
				sum += array[i];
			}
			Arrays.sort(array, 0, num);
			sum2 = 0;
			coinCounter = 0;
			for (int i = num - 1; i >= 0; i--) {
				if (sum2 > sum) {
					break;
				} else {
					sum -= array[i];
					sum2 += array[i];
					coinCounter++;
				}
			}
			System.out.println(coinCounter);

		}

	}

	public static void main(String[] args) {

		try {
			new codeForce_160A_twins().solution();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
