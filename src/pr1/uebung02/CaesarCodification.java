package pr1.uebung02;

import java.util.Scanner;

public class CaesarCodification {

	public static void main(String[] args) {
		// Variablen deklarieren
		String inputString;
		char charInString;
		// Tastatureingabe
		Scanner in = new Scanner(System.in);
		// Anleitung
		System.out.println("Geben Sie eine Zeichenkette ein: ");
		// Erwartete Zeichenkette - Eingabe durch die Tastatur
		inputString = in.nextLine();
		// Verschlüsselungsschleife
		for (int position = 0; position < inputString.length(); position++) {
			// Zeichen in der Zeichenkette vergleichen
			charInString = inputString.charAt(position);			
			// Abfrage ob das eingegebene Zeichen zwischen A und Y liegt
			if (charInString >= 'A' && charInString <= 'Y' || charInString >= 'a' && charInString <= 'y') {
				// Zeichenwert wird um 1 erh�ht (Erhöhung auf das nächste folgende Zeichen)
				charInString++;
				// Abfrage ob das eingegebene Zeichen ein Z ist
			} else if (charInString == 'Z') {
				charInString = 'A';
			} else if (charInString == 'z') {
				charInString = 'a';
			}
			// Die Verschlüsselung wird ohne zu speichern direkt ausgegeben
			System.out.print(charInString);
		}
		System.out.println("\n>>> Programm beendet");
		in.close();
	}
}