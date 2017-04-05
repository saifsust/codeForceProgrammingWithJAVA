package apr;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		try {
			uva.solver.Solution();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class uva {

	protected static class solver {
		protected static void Solution() throws Exception {
			int testCase, num;
			int[] array;
			testCase = scanner.nextInt();
			for (int testcase = 1; testcase <= testCase; testcase++) {

				num = scanner.nextInt();
				array = new int[num];
				for (int i = 0; i < num; i++) {
					array[i] = scanner.nextInt();
				}
				 Arrays.sort(array, 0, num);
				int min_dist = 0;
				for (int i = 0; i < num; i++) {
					min_dist += Math.abs(array[num>>1] - array[i]);
				}
				System.out.println(min_dist);
			}

		}
	}

	// private static Scanner scanner = new Scanner(System.in);
	private static Scanner scanner = fileFactory.scanner();
}