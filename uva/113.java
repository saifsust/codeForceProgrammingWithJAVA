package codeForce_A_Key_races;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner read = new Scanner(System.in);
		while (read.hasNext()) {
			double n = read.nextDouble();
			double p = read.nextDouble();
			double floor = Math.floor(10.0 * Math.pow(p, 1.0 / n)) / 10.0;
			double ceil = Math.ceil(floor);

			System.out.println((int)(ceil - floor <= 0.5 ? ceil : Math.floor(floor)));

		}

	}

}
