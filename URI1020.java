package URI;
import java.io.IOException;
import java.util.Scanner;

public class URI1020 {

	public static void main(String[] args) throws IOException {
		URI.problemSolve();
	}

}

class URI {

	public static void problemSolve() {

		int days = scanner.nextInt();
		final int yearDay = 365, m = 30;
		int years = days / yearDay;
		days %= yearDay;
		int months = days / m;
		days %= m;
		System.out.printf("%d ano(s)\n%d mes(es)\n%d dia(s)\n", years,months,days);

	}

	private static Scanner scanner = new Scanner(System.in);
}
