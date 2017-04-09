/**
 * 
 */
package apr;

import java.lang.*;
import java.util.*;
import java.io.*;

/**
 * @author Saif_sust_2013331007
 *
 */
public class Main {

	/**
	 * @param args
	 */
	private void Solution() {

		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			str = separateWord(str);
			StringTokenizer token = new StringTokenizer(str);

			int counter = 0;
			while (token.hasMoreTokens()) {
				// System.out.println(token.nextToken());
				if (IsWord(token.nextToken())) {
					counter++;
				}
			}
			System.out.println(counter);

		}
	}

	private String separateWord(String line) {
		String str = "";
		for (int i = 0; i < line.length(); i++) {
			if (!Character.isAlphabetic(line.charAt(i))) {
				str += " ";
			} else {
				str += line.charAt(i);
			}
		}
		return str;
	}

	private boolean IsWord(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (Character.isAlphabetic(word.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {

		try {
			new Main().Solution();
		} catch (Exception ex) {

		}
	}

	// private Scanner scanner = new Scanner(System.in);
	private Scanner scanner = fileFactory.scanner();

}
