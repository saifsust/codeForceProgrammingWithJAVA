package Programming;

import java.util.Scanner;

class TestClass {
   
private static String toggleString(String str) {

		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLowerCase(str.charAt(i))) {
				ans += Character.toUpperCase(str.charAt(i));
			} else {
				ans += Character.toLowerCase(str.charAt(i));
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
            String str = scan.next();
            System.out.println(toggleString(str));
	}

	private static Scanner scan = new Scanner(System.in);
}
