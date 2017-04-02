package programming;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	//private static Scanner scanner = fileFactory.scanner();
	 private static Scanner scanner = new Scanner(System.in);

	private static class UVA {
		String first, second;

		private void solve() {

			while (scanner.hasNext()) {
				first = scanner.next();
				second = scanner.next();
				if (first.equals("0") && second.equals("0"))
					break;
				if (first.length() < second.length()) {
					String temp = "";
					temp = first;
					first = second;
					second = temp;
				}
				// System.out.println(first + " " + second);
				int carry = 0;
				int carryCounter = 0;
				for (int i = first.length() - 1, j = second.length() - 1; i >= 0; i--, j--) {

					if (j < 0 && carry == 0)
						break;

					if (j < 0 && carry > 0) {
						int sum = first.charAt(i) - '0' + carry;
						if (sum / 10 > 0) {
							carryCounter++;
							carry = sum / 10;
						} else {
							carry = 0;
						}
					} else {
						if (i >= 0 && j >= 0) {
							int sum = first.charAt(i) - '0' + second.charAt(j) - '0' + carry;
							if (sum / 10 > 0) {
								carryCounter++;
								carry = sum / 10;
							} else {
								carry = 0;
							}
						} else {
							continue;
						}

					}

				}

				if (carryCounter == 0) {

					System.out.println("No carry operation.");
				} else {
					if (carryCounter == 1) {
						System.out.println(carryCounter + " carry operation.");
					} else
						System.out.println(carryCounter + " carry operations.");
				}
			}
			scanner.close();

		}
	}

	public static void main(String[] args) throws IOException {

		try {
			new UVA().solve();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
