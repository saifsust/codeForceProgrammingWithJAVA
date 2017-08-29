package codeForce_A_Key_races;

import java.util.Scanner;

public class Main  {

	private static class KeyRace {
		private double s, firstV, secondV, firstT, secondT;

		public KeyRace(double s, double firstV, double secondV, double firstT, double secondT) {
			super();
			this.s = s;
			this.firstV = firstV;
			this.secondV = secondV;
			this.firstT = firstT;
			this.secondT = secondT;
		}

		private double getFirstTypingTime() {
			return this.s * this.firstV + 2.0 * this.firstT;

		}

		private double getSecondTypingTime() {

			return this.s * this.secondV + 2.0 * this.secondT;

		}

		public boolean Draw() {
			return getFirstTypingTime() == getSecondTypingTime();
		}

		public boolean FirstWinner() {
			return getFirstTypingTime() < getSecondTypingTime();
		}

	}

	public static void main(String[] args) throws Exception {

		Scanner read = new Scanner(System.in);
		
		while (read.hasNext()) {

			KeyRace keyRace = new KeyRace(read.nextDouble(), read.nextDouble(), read.nextDouble(), read.nextDouble(),
					read.nextDouble());

			if (keyRace.FirstWinner()) {
				System.out.println("First");
			} else if (keyRace.Draw()) {
				System.out.println("Friendship");

			} else
				System.out.println("Second");

		}

	}

}
