import java.util.*;
import java.io.BufferedReader;
import java.lang.*;

public class UVA_10189 {

	private static class mineSweeper {
		private static int[] dxx = { -1, -1, -1, 0, 1, 1, 1, 0 };
		private static int[] dyy = { -1, 0, 1, 1, 1, 0, -1, -1 };
		private static long[][] mineGrid;

		public static void problemSolve(String[] Grid, int n, int m) {

			mineGrid = new long[n + 50][m + 50];
			for (int i = 0; i < mineGrid.length; i++) {
				Arrays.fill(mineGrid[i], 0);
			}

			for (int i = 2; i <= n + 1; i++) {
				for (int j = 1; j <= m; j++) {
					if (Grid[i - 1].charAt(j - 1) == '*') {
						mineGrid[i - 1][j - 1] = '*';
						gridCalculation(j - 1, i - 1, n, m);
					}

				}
				// System.out.println();
			}

		}

		public static void show(int n, int m) {
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < m; j++) {
					if (mineGrid[i][j] == 42) {
						System.out.print("*");

					} else
						System.out.print(mineGrid[i][j]+"");
				}
				System.out.println();
			}
		}

		private static void gridCalculation(int x, int y, int n, int m) {
			for (int i = 0; i < dxx.length; i++) {
				int xx = dxx[i] + x;
				int yy = dyy[i] + y;
				if (xx >= 0 && xx < m && yy >= 1 && yy <= n) {
					if (Grid[yy].charAt(xx) == '.') {
						mineGrid[yy][xx]++;
					}
				}

			}
		}

	}

	public static void main(String[] args) throws Exception {

		long testCase = 0;
		// while(scanner.hasNextLine()){
		while (true) {
			int ny = scanner.nextInt();
			int mx = scanner.nextInt();
			if (ny == 0 && mx == 0)
				break;
			testCase++;
			for (int i = 0; i <= ny; i++) {
				Grid[i] = scanner.nextLine();
			}
			mx = Grid[1].length();
			mineSweeper.problemSolve(Grid, ny, mx);
			if(testCase>1) System.out.println();
			System.out.println("Field #" + testCase + ":");
			mineSweeper.show(ny, mx);
		}

	}

	 private static Scanner scanner = new Scanner(System.in);
	private static String[] Grid = new String[100 + 50];
	//private static Scanner scanner = fileConnectedFactory.getScanner();
}
