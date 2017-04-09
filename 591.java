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

	private int stack[], numOfStack, total, set;

	private void Solution() throws Exception {
		set = 1;
		while (scanner.hasNext()) {
			numOfStack = scanner.nextInt();
			if (numOfStack == 0)
				break;
			stack = new int[numOfStack];
			total = 0;
			for (int i = 0; i < numOfStack; i++) {
				stack[i] = scanner.nextInt();
				total += stack[i];
			}
			int sameSize = total / numOfStack;
			Arrays.sort(stack, 0, numOfStack);
			int counter = 0;
			for (int i = numOfStack - 1; i >= 0; i--) {
				if (stack[i] > sameSize) {
					counter += stack[i] - sameSize;
				}
			}
			System.out.println("Set #" + set++);
			System.out.println("The minimum number of moves is " + counter + ".\n");

		}
	}

	public static void main(String[] args) throws Exception {
		try {
			new Main().Solution();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// private Scanner scanner = new Scanner(System.in);
	private Scanner scanner = fileFactory.scanner();

}
