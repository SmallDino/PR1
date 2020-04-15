import java.util.Scanner;

/* 
 * Programm zum Summieren aller geraden natürlichen Zahlen
 * sowie zum Aufsummieren aller gültigen Eingaben
 */
public class Aufrechner {

	public static void main(String[] args) {
		// Benötigte Variablen deklarieren
		int input, sum = 0, inputCounter = -1;
		// Für die Eingabe der Tastatur
		Scanner in = new Scanner(System.in);
		// Anleitung
		System.out.println("Das Programm endet durch die Eingabe einer Zahl kleiner als 0.");
		// Berechnungsschleife
		do {
			System.out.println("Geben Sie eine Zahl ein:");
			// Eingabe, Int-Wert auslesen
			input = in.nextInt();
			// Filterung auf positive gerade Zahlen
			if (input % 2 == 0 && input > 0) {
				sum += input;
			}
			// Eingabenzähler wird um 1 erhöht
			inputCounter++;
			// Schleife wird durch alle negativen Zahlen verlassen
		} while (input >= 0);

		// Ausgabe der Summe aller geraden Zahlen und Zähler der Eingaben, mit Außnahme
		// der letzten Eingabe
		System.out.println("Summe aller geraden Zahlen: " + sum + '.');
		System.out.println("Insgesamt haben sie " + inputCounter + "-mal eine gültige Zahl eingebeben.");
		in.close();
	}
}
