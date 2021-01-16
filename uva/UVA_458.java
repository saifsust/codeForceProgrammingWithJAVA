package UVA;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	//private static Scanner scanner = fileFactory.scanner();
	// private static Scanner scanner = new Scanner(System.in);
	//private static PrintWriter out = new PrintWriter(System.out, true);
	//private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	private static class UVA {

		private DataInputStream inp = new DataInputStream(System.in);
		private DataOutputStream out = new DataOutputStream(System.out);

		private void solve() throws IOException {
			int ch;
			while ((ch = inp.read()) != -1) {
				out.write((Character.isSpace((char) ch) ? ch : (ch - 7)));
			}
		}
	}

	public static void main(String[] args) throws IOException {

		try {
			new UVA().solve();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
