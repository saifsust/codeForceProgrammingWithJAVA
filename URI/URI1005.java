package CoinChange;

import java.util.Scanner;

public class URI1005 {

	public static void main(String[] args) {

		average.getAverage();
	}

}

class average {
	private static final double weightA = 3.5;
	private static final double weightB = 7.5;
	private static final double totalWeight = weightA + weightB;

	public static void getAverage() {

		double A = scanner.nextDouble();
		double B = scanner.nextDouble();
		System.out.printf("MEDIA = %.5f\n", (A * weightA + B * weightB) / totalWeight);
	}

	private static Scanner scanner = new Scanner(System.in);
}
