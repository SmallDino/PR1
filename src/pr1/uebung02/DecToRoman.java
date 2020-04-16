package pr1.uebung02;

import java.util.Scanner;

public class DecToRoman {

	public static void main(String[] args) {
		// Variablen deklarieren
		int arabianNumber, position = 0;
		// Arrays deklarieren
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] arabian = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		// Tastatureingabe
		Scanner in = new Scanner(System.in);
		// Anleitung
		System.out.println("Umwandlung von Dezimal auf Römisch.\nGeben sie eine Zahl zwischen 1 und 3999 ein:");
		// Arabische Nummer eingeben
		arabianNumber = in.nextInt();
		// Umwandlung & Fehler abfangen
		if (arabianNumber <= 0 || arabianNumber >= 4000) {
			System.out.println("Keine gültige Eingabe!\nDer Wert liegt außerhalb des Bereichs");
		} else {
			System.out.print("Ausgabe: ");
			do {
				// Die eingegebene Zahl von Groß nach Klein durchsuchen
				if (arabianNumber >= arabian[position]) {
					arabianNumber -= arabian[position];
					System.out.print(roman[position]);
				} else {
					position++;
				}
			} while (arabianNumber > 0);
		}
		System.out.println("\n>>> Programm beendet");
		in.close();
	}
}