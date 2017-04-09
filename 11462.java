/**
 *
 */
package apr;

import java.util.*;
import java.io.*;
import java.lang.*;

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
			new Sort().Solution();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class Sort {
	private int array[], size;

	protected void Solution() {
		while (scanner.hasNext()) {
			size = scanner.nextInt();
			if (size == 0)
				break;
			array = new int[size + 2];
			for (int i = 0; i < size; i++) {
				array[i] = scanner.nextInt();
			}
			Arrays.sort(array, 0, size);
			for (int i = 0; i < size; i++) {
				System.out.print(array[i]);
				if(i<size-1)
					System.out.print(" ");
			}
			System.out.println();

		}
	}

	// private Scanner scanner = new Scanner(System.in);
	private Scanner scanner = fileFactory.scanner();
}
