package URI;

import java.io.IOException;
import java.util.Scanner;

public class URI1017 {

	public static void main(String[] args) throws IOException {
		URI.problemSolve();
	}

}

class URI {

	private static double x1, y1, x2, y2;

	public static void problemSolve() {

		int time = scanner.nextInt();
        int speed = scanner.nextInt();
		System.out.printf("%.3f\n",(double)((time*speed)/12.0));

	}

	private static Scanner scanner = new Scanner(System.in);
}
