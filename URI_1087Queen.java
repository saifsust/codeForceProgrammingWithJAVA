package NumberFrequence_1171;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	 private static Scanner scanner = new Scanner(System.in);
	//private static Scanner scanner = fileFactory.scanner();

	private static class URI {

		private int[] dxx = { -1,-1,-1,0,1,1,1,0};
		private int[] dyy = { -1,0,1,1,1,0,-1,-1};
		private boolean[][] visited = new boolean[10][10];
		private int startX, startY, endX, endY;

		private void dfs(int startX, int startY, int dx, int dy) {
			visited[startX][startY] = true;
			int xx = startX + dx;
			int yy = startY + dy;
			//System.out.println(xx+" "+yy);
			if (xx >= 1 && xx <= 8 && yy >= 1 && yy <= 8) {
				if (!visited[xx][yy]) {
					dfs(xx, yy, dx, dy);
				}
			}

		}

		private void solve() {

			while (scanner.hasNext()) {
				startX = scanner.nextInt();
				startY = scanner.nextInt();
				endX = scanner.nextInt();
				endY = scanner.nextInt();
				if (startX == 0 && startY == 0 && endX == 0 && endY == 0)
					break;
				if (startX == endX && startY == endY) {
					System.out.println(0);
					continue;
				}
				for (int i = 0; i < visited.length; i++) {
					Arrays.fill(visited[i], false);
				}
				for (int i = 0; i < dxx.length; i++) {
					dfs(startX, startY, dxx[i], dyy[i]);
				}
				if (visited[endX][endY]) {
					System.out.println(1);
				} else
					System.out.println(2);

			}
			scanner.close();

		}

	}

	public static void main(String[] args) throws IOException {
		try {
			new URI().solve();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
