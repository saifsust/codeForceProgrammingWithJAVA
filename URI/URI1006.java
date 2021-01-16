package URI;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
     average.getAverage();
	}

}

class average {
	private static final double weightA = 2.0;
	private static final double weightB = 3.0;
	private static final double weightC = 5.0;
	private static final double totalWeight = weightA + weightB+weightC;

	public static void getAverage() {

		double A = scanner.nextDouble();
		double B = scanner.nextDouble();
		double C= scanner.nextDouble();
		System.out.printf("MEDIA = %.1f\n", (A * weightA + B * weightB+C*weightC) / totalWeight);
	}

	private static Scanner scanner = new Scanner(System.in);
}
