package pr1.uebung05;

import java.util.*;

public class MathematicalAlgorithm {

	public static void main(String[] args) {
		// Variablen deklarieren
		int multiplicand, multiplier, result;
		boolean schleife = true;
		
		Scanner scanner = new Scanner(System.in);
		
		// Dauerschleife zum Berechnen
		while(schleife) {
			System.out.println("Geben Sie den ersten Faktor ein: ");
			multiplicand = scanner.nextInt();
			
			System.out.println("Geben Sie den zweiten Faktor ein: ");
			multiplier = scanner.nextInt();
			
			result = multiplyNumbers(multiplicand, multiplier);
			System.out.println("Ergebnis: " + result + "\n");
		}
		
		scanner.close();
		System.out.println("\n >>> Programm beendet");
	}
	
	/**
	 * Multiplys 2 Numbers after the eqyptian multiplication
	 * 
	 * @param multiplicand First Factor
	 * @param multiplier Second Factor
	 * @return The result of the calculation. If the lower limit is reached, it returns 0.
	 */
	static int multiplyNumbers(int multiplicand, int multiplier) {
		// Variablen deklieren
		int result = 0;
		
		// Abfrage ob Multiplikant oder Multiplizierer 0 sind
		if (multiplicand == 0 || multiplier == 0) {
			return result;
		}
		
		// Berechnungsschleife bis Multiplizirer kleiner als 1 ist
		while(multiplier >= 1) {
			if(multiplier % 2 == 1) {
				result += multiplicand;
			}
			
			if(result < 0) {
				System.out.println("Datentyp Grenze überschritten.");
			}
			
			System.out.println("x = " + multiplicand + ", y = " + multiplier);			
			multiplicand *= 2;
			multiplier /= 2;
		}		
		return result;
	}
}