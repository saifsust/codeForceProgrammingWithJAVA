package URI;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		URI1015.problemSolve();
	}

}

class URI1015 {

	private static  double x1, y1, x2, y2;

	public static void problemSolve() {

		x1 = scanner.nextDouble();
		y1 = scanner.nextDouble();
		x2 = scanner.nextDouble();
		y2 = scanner.nextDouble();
		System.out.printf("%.4f\n",Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2)));

	}

	private static Scanner scanner = new Scanner(System.in);
}
