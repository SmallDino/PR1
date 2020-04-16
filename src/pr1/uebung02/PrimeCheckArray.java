package pr1.uebung02;

import java.util.Scanner;

public class PrimeCheckArray {

	public static void main(String[] args) {
		// Variablen deklarieren
		int primeCap;
		boolean[] numberCancled;
		// Tastatureingabe
		Scanner in = new Scanner(System.in);
		// Eingabeaufforderung
		System.out.println("Ermittlung aller Primzahlen von 2 bis n.\nGeben Sie eine Zahl n ein:");
		// Eingabe, Int-Wert auslesen
		primeCap = in.nextInt();
		// Ausgabe der Primzahlen
		System.out.println("Primzahlen:");
		// Zahlensieb anlegen
		numberCancled = new boolean[primeCap + 1];
		// Jedes Feld das NICHT "true" ist, ist eine Primzahl
		for (int position = 2; position <= primeCap; position++) {
			if (!numberCancled[position]) {
				System.out.println(position + " ist eine Primzahl!");
				// Filterschleife, Vielfache von einer Primzahl werden herausgefiltert indem die
				// Felder des Arrays als "true" makiert werden
				for (int positionMultiple = position; positionMultiple <= primeCap; positionMultiple += position) {
					numberCancled[positionMultiple] = true;
				}
			}
		}
		System.out.println(">>> Programm beendet");
		in.close();
	}
}