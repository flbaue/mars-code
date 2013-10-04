/**
 * FLorian Bauer
 * fbaue@posteo.de
 * 03.10.2013
 */
package fbaue.ad.messreihe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This program demonstrates two ways to calculate "Mittelwert" and "Varianz".
 * it can also be used through the static mathods mittelwertBerechnen(..) and
 * varianzBerechnen(..).
 * 
 * @author Florian Bauer
 * 
 * 
 */
public class Messreihe {

	private static final String PROGRAM_END = "ende";
	private static final String MITTELWERT = "m";
	private static final String VARIANZ = "v";

	/**
	 * Program start.
	 * 
	 * @param args
	 *            are not used
	 */
	public static void main(String[] args) {

		new Messreihe().run();

	}

	/**
	 * Start routine with main menu on the console.
	 */
	private void run() {
		System.out.println("Wählen Sie einen Modus:");
		System.out.println("1: Normal");
		System.out.println("2: Optimiert");
		System.out.print("Modus: ");
		int modus = Integer.parseInt(readLineFromConsole());
		System.out.println("ende: Programm beenden");
		System.out.println("m: Mittelwert");
		System.out.println("v: Varianz");

		if (modus == 1) {
			normal();
		}
		if (modus == 2) {
			optimiert();
		}

	}

	/**
	 * The optimized version of the program.
	 */
	private void optimiert() {

		final List<Double> werte = new ArrayList<>();
		int i = 1;

		while (true) {
			System.out.print("Wert " + i + ": ");
			String input = readLineFromConsole();

			if (input.equalsIgnoreCase(PROGRAM_END)) {
				System.out.println("Mittelwert: " + mittelwert(werte));
				System.out.println("Varianz: " + varianz(werte));
				System.out.println("Ende.");
				break;
			} else if (input.equalsIgnoreCase(MITTELWERT)) {
				System.out.println("Mittelwert: " + mittelwert(werte));
			} else if (input.equalsIgnoreCase(VARIANZ)) {
				System.out.println("Varianz: " + varianz(werte));
			} else {
				try {
					werte.add(Double.valueOf(input));
					i++;
				} catch (NumberFormatException e) {
					i--;
					System.out.println("Die Eingabe ist ungültig.");
				}
			}
		}

	}

	/**
	 * Calculates the "Varianz". Is part of the optimized version.
	 * 
	 * @param werte
	 *            list of input values
	 * @return the "Varianz"
	 */
	private double varianz(final List<Double> werte) {
		double sum = 0;
		final double avg = mittelwert(werte);
		final double factor = 1.0 / (werte.size() - 1);
		for (Double wert : werte) {
			sum += Math.pow((wert - avg), 2);
		}

		return Math.sqrt(factor * sum);
	}

	/**
	 * Calculates the "Mittelwert". Is part of the optimized version.
	 * 
	 * @param werte
	 *            list of input values
	 * @return the "Mittelwert"
	 */
	private double mittelwert(final List<Double> werte) {
		double sum = 0;
		final int n = werte.size();
		for (Double wert : werte) {
			sum += wert;
		}
		return (1.0 / n) * sum;
	}

	/**
	 * The unoptimized ("naive") implementation of the program
	 * 
	 */
	private void normal() {
		double varianzSum = 0;
		double mittelwertSum = 0;
		int i = 1;
		while (true) {
			System.out.print("Wert " + i + ": ");
			String input = readLineFromConsole();
			if (input.equalsIgnoreCase(PROGRAM_END)) {
				break;
			} else if (input.equalsIgnoreCase(MITTELWERT)) {
				double mittelwert = 1.0 / (i - 1) * mittelwertSum;
				System.out.println("Mittelwert: " + mittelwert);
			} else if (input.equalsIgnoreCase(VARIANZ)) {
				double varianz = Math.sqrt(1.0 / (i - 2) * varianzSum);
				System.out.println("Varianz: " + varianz);
			} else {
				try {
					double wert = Double.parseDouble(input);
					mittelwertSum += wert;
					double mittelwert = 1.0 / i * mittelwertSum;
					varianzSum += Math.pow(wert - mittelwert, 2);
					i++;
				} catch (NumberFormatException e) {
					i--;
					System.out.println("Die Eingabe ist ungültig.");
				}
			}

		}
	}

	/**
	 * Utility method to read a text input line from the console.
	 * 
	 * @return the input line as {@link String}
	 */
	private String readLineFromConsole() {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line = "";
		try {
			line = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return line;
	}

	/**
	 * Public static method to calculate the "Mittelwert". For use in other
	 * programs. This methode uses the optimized calculation.
	 * 
	 * @param werte
	 *            a list of double values
	 * @return the "Mittelwert" as double
	 */
	public static double mittelwertBerechnen(List<Double> werte) {
		Messreihe messreihe = new Messreihe();
		return messreihe.mittelwert(werte);
	}

	/**
	 * Public static method to calculate the "Varianz". For use in other
	 * programs. This methode uses the optimized calculation.
	 * 
	 * @param werte
	 *            a list of double values
	 * @return the "varianz" as double
	 */
	public static double varianzBerechnen(List<Double> werte) {
		Messreihe messreihe = new Messreihe();
		return messreihe.varianz(werte);
	}
}
