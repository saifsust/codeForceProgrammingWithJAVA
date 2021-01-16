package apr;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		try {
			new uva().new ProblemSolution().solution();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

class uva {

	public class ProblemSolution {

		private int testCase;
		private String str, str2;
		private Stack<Character> stack = new Stack<>();

		public void solution() throws Exception {
			str2 = scanner.readLine();
			testCase = Integer.parseInt(str2);
			for (int test = 1; test <= testCase; test++) {
				str = "";
				str = scanner.readLine();
				// out.println(str);
				if (str == null) {
					out.println("Yes");
					continue;
				}
				if (str.length() == 1) {
					out.println("No");
					continue;
				}

				stack.clear();
				boolean Test = false;
				int i;
				for (i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '(' || str.charAt(i) == '[') {
						// out.println(str.charAt(i));
						stack.push(str.charAt(i));
					} else {
						if (str.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
							stack.pop();
						} else {
							if (str.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[') {
								stack.pop();
							} else {
								if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '['
										|| str.charAt(i) == ']') {
									out.println("No");
									Test = true;
									break;
								}
							}
						}
					}
				}

				if (Test)
					continue;

				if (stack.isEmpty() && i >= str.length()) {
					out.println("Yes");
				} else {
					out.println("No");
				}

			}
			scanner.close();
		}

	}
	/*
	 * output class
	 */

	// private DataOutputStream out = new DataOutputStream(System.out);
	private PrintWriter out = new PrintWriter(System.out, true);

	/*
	 * input class
	 */

	// private DataInputStream scanner =new DataInputStream(System.in);
	private BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
	// private Scanner scanner = new Scanner(System.in);
	// private Scanner scanner = fileFactory.scanner();
	// private BufferedReader scanner = fileFactory.bufferedRader();
}
