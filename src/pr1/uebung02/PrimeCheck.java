package pr1.uebung02;

import java.util.Scanner;

public class PrimeCheck {

	public static void main(String[] args) {
		// Variablen deklarieren
		int primeCap, divisor;
		boolean isPrime;
		// Tastatureingabe
		Scanner in = new Scanner(System.in);
		// Anleitung zum Eingeben einer ganzen Zahl
		System.out.println("Ermittlung aller Primzahlen von 2 bis n.\nGeben Sie eine Zahl n ein:");
		// Eingabe, Int-Wert auslesen
		primeCap = in.nextInt();
		// Eingabebestätigung
		System.out.println("Falls möglich, werden alle Zahlen von 2 bis " + primeCap + " �berpr�ft.");
		// Berechnungsschleife
		for (int potPrimeNumber = 2; potPrimeNumber <= primeCap; potPrimeNumber++) {
			// Angenommen jede Zahl ist eine Primzahl
			isPrime = true;
			// Teiler auf 2 gesetzt, da die kleinstmögliche Primzahl 2 ist
			divisor = 2;
			// Primzahl Überprüfung
			while (isPrime && (divisor <= potPrimeNumber / 2)) {
				if (potPrimeNumber % divisor == 0) {
					isPrime = false;
				}
				divisor++;
			}
			// Ausgabe wenn eine Primzahl gefunden wurde
			if (isPrime) {
				System.out.println(potPrimeNumber);
			}
		}
		System.out.println(">>> Programm beendet");
		in.close();
	}
}