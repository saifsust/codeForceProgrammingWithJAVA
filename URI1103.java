

import java.io.IOException;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) throws IOException {
		URI.problemSolve();
	}

}

class URI {

	public static void problemSolve() {

		final int hourMod = 24,minMod=59;
		int h1, m1, h2, m2;
		while (true) {
			h1 = scanner.nextInt();
			m1 = scanner.nextInt();
			h2 = scanner.nextInt();
			m2 = scanner.nextInt();
			if (h1 == 0 && m1 == 0 && h2 == 0 && m2 == 0)
				break;
			int countMin1 = 0, countMin2 = 0;
			if(h1==0) countMin1=24*60+m1;
			else countMin1=h1*60+m1;
			if(h2==0) countMin2=24*60+m2;
			else countMin2=h2*60+m2;
			System.out.printf("%d\n",countMin2>countMin1? countMin2-countMin1: 24*60-countMin1+countMin2);
		}

	}

	private static Scanner scanner = new Scanner(System.in);
}
