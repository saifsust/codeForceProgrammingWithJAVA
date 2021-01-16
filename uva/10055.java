

import java.util.Scanner;

public class Main {

	private void solve() {
		String str;
		while (scanner.hasNext()) {
			str = scanner.next();
			if (str.equals("EOF") || str.equals("eof")) break;
			long first = Long.parseLong(str);
			long second = scanner.nextLong();
			System.out.println(Math.abs(second - first));
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

	// private Scanner scanner = fileFactory.scanner();
	private Scanner scanner = new Scanner(System.in);

}
