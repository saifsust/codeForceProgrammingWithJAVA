package URI;

import java.io.IOException;
import java.util.Scanner;

public class URI1018 {

	public static void main(String[] args) throws IOException {
		URI.problemSolve();
	}

}

class URI {

	public static void problemSolve() {

		int note = scanner.nextInt();
		System.out.println(note);
		System.out.printf("%d nota(s) de R$ 100,00\n", note / 100);
		note %= 100;
		System.out.printf("%d nota(s) de R$ 50,00\n", note / 50);
		note %= 50;
		System.out.printf("%d nota(s) de R$ 20,00\n", note / 20);
		note %= 20;
		System.out.printf("%d nota(s) de R$ 10,00\n", note / 10);
		note %= 10;
		System.out.printf("%d nota(s) de R$ 5,00\n", note / 5);
		note %= 5;
		System.out.printf("%d nota(s) de R$ 2,00\n", note / 2);
		note %= 2;
		System.out.printf("%d nota(s) de R$ 1,00\n", note / 1);

	}

	private static Scanner scanner = new Scanner(System.in);
}
