package pr1.fuebung01;

import java.util.*;

public class Exponentialfunktion {

	public static void main(String[] args) {
		double x, e, sum;
		Scanner scanner = new Scanner(System.in);
		//System.out.println("Geben Sie Ihr Argument \"x\" ein:");
		//x = scanner.nextDouble();
		//System.out.println("Geben Sie Ihr Argument \"epsilon\" ein:");
		//e = scanner.nextDouble();
		
		//System.out.println("Berechneter Wert: " + x + "\nBerechneter Wert mit Math.exp: " + Math.exp(x));
		
		/*
		for (int i = 0; i < 5; i++) {
			sum = exp(i, 0.0001);
			System.out.println("Exponentialfunktion von " + i + ": " + sum);
			sum = 0;
		}
		*/
		
		sum = exp(4, 0.001);
		System.out.println("Exponentialfunktion von " + 4 + ": " + sum);
		
		
		System.out.println("-------------------------------------------------------");
		
		for (int i = 0; i < 5; i++) {
			sum = Math.exp(i);
			System.out.println("Exponentialfunktion von " + i + ": " + sum);
			sum = 0;			
		}
		
		//sum = faculty(x);
		//sum = exp(x, e);
		//System.out.println("Summe: " + sum);
		//System.out.println("Fakultät von " + x + ": " + sum);
		
		scanner.close();
	}
	
	/**
	 * Exponentialfunktion selbst berechnen
	 * 
	 * @param x
	 * @param e
	 * @return
	 */
	public static double exp(double x, double e) {
		int counter = 1;
		double f = 0, f0 = 0;
		double sum = 1, sum2 = 1;
		double testo = 0;
		double exponent = x;
		
		for (int i = 1; i <= x; i++) {
			sum += ((exponent * x) / fakultaet(i));
			exponent *= x;
		}
		
		/*
		//do {
		for (int i = 1; i <= x; i++) {
			sum += (exponent / fakultaet(counter));
			// Zähler erhöhen
			//counter++;
			// Summe zuweisen
			f0 = sum2 = sum;
			//System.out.println(counter + ". Schritt - Summe 1: " + sum);
			// Erweiterter Rechenschritt
			exponent *= x;
			sum2 += (exponent / fakultaet(counter));
			// Erweiterte Summe zuweisen
			f = sum2;
			//System.out.println(counter + ". Schritt - Summe 2: " + sum2);
			testo = Math.abs((f-f0)/f0);
			//System.out.println(testo);
		}
		//while(counter <= x);
		 * 
		 */
		return sum;
	}
	
	/**
	 * Berechnet die Fakultät des übergebenen Parameters.
	 * 
	 * @param number gibt an, bis zu welcher Zahl die Fakultät berechnet wird.
	 * @return Gibt die berechnete Fakultät zurück.
	 */
	public static double fakultaet(double number) {
		// Variablen deklarieren
		double sum = 1;
		// Fakultät berechnen
		for (int i = 1; i <= number; i++) {
			sum *= i;
		}
		return sum;
	}
}