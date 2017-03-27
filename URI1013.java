package URI;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		URI1013.greatest();
	}

}

class URI1013 {

	public static void greatest() {
		int A, B, C;
		A = scanner.nextInt();
		B = scanner.nextInt();
		C = scanner.nextInt();
		int maxAB= (A+B+Math.abs(A-B))/2; 
		int max = (maxAB+C+Math.abs(maxAB-C))/2;
		System.out.printf("%d eh o maior\n",max);
		
	}
	private static Scanner scanner = new Scanner(System.in);
}
