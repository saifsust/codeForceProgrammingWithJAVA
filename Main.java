package Programming;

import java.util.Scanner;

public class Main {

	private static int BearAndBigBrother(int Limak, int Bob) {

		int countYears = 0;
		while (Limak <= Bob) {
			Limak = Limak * 3;
			Bob = Bob * 2;
			countYears++;

		}
		return countYears;
	}

	public static void main(String[] args) {

		
		int a,b;
		a= scan.nextInt();
		b= scan.nextInt();
		System.out.println(BearAndBigBrother(a,b));
	}

	private static Scanner scan = new Scanner(System.in);
}