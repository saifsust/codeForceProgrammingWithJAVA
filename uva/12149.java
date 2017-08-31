package CodeforcesRound_383_Div_2;

import java.util.Scanner;

public class Main {

	private static int square(int N) {
		if (N == 1)
			return 1;
		return N * N + square(N - 1);
	}

	public static void main(String[] args) throws Exception {

		Scanner read = new Scanner(System.in);
		int N;
		while (read.hasNext()) {
			N = read.nextInt();
			if (N == 0)
				break;

			int ans = 0;

//			for (int i = N; i >= 1; i--) {
//				ans += i * i;
//
//			}
			System.out.println(square(N));

		}
		read.close();

	}

}
