package apr;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

	public static void main(String[] args) throws Exception {

		try {
			new uva.Solver().Solution();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

class uva {

	protected static class Solver {
		String str;

		protected void Solution() throws IOException {

			while (scanner.hasNext()) {
				str = scanner.next();
				if(str==null) continue;
				if (str.equals("0")) {
					break;
				}
				int decimalNumber = 0;
				//System.out.println(str.charAt(0)-'0');
				for (int i = str.length() - 1, k = 1; i >= 0; i--, k++) {
					decimalNumber += ((int)str.charAt(i)-'0')*(Math.pow(2, k)-1);
				}
				System.out.println(decimalNumber);

			}
			scanner.close();
			out.close();

		}

	}

	/*
	 * output class
	 */
	// private static DataOutputStream out = new DataOutputStream(System.out);
	private static PrintWriter out = new PrintWriter(System.out, true);

	/*
	 * Input class
	 */
	// private static BufferedReader scanner = new BufferedReader(new
	// InputStreamReader(System.in));
	// private static DataInputStream scanner = new DataInputStream(System.in);
	 private static Scanner scanner = new Scanner(System.in);
	//private static Scanner scanner = fileFactory.scanner();
	 //private static BufferedReader scanner = fileFactory.bufferedRader();
}
