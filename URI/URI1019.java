package URI;
import java.io.IOException;
import java.util.Scanner;

public class URI1019 {

	public static void main(String[] args) throws IOException {
		URI.problemSolve();
	}

}

class URI {

	public static void problemSolve() {

		int second = scanner.nextInt();
		final int h = 3600, m = 60;
		int hours = second / h;
		second %= h;
		int min = second / m;
		second %= m;
		System.out.printf("%d:%d:%d\n", hours,min,second);

	}

	private static Scanner scanner = new Scanner(System.in);
}
