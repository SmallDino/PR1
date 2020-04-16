package pr1.uebung01;

import java.util.Scanner;

public class Fahrenheit {

	public static void main(String[] args) {
		// Variablen deklarieren
		double epsilon = 0.005;
		double c = 0.0, f;	
		
		// Tastatureingabe
		Scanner in = new Scanner(System.in);	
		
		// Berechnungsschleife 
		do {
			// Anleitung / Textausgabe
			System.out.println("Programm endet durch Eingabe von 1");
			System.out.println("Eingabe der Fahrenheit-Temperatur: ");
			// Benutzereingabe, Double-Wert einlesen
			f = in.nextDouble();
			// Umrechnen in Celsius
			c = (f - 32.0) / (9.0/5.0);
			// Ausgabe der Umrechnung
			System.out.println("... in Celsius: " + c + " Grad. \n");
		// Schleife durch Eingabe von 1 verlassen
		} while (Math.abs(f - 1) > epsilon);
		
		System.out.println("... und tschüss");
		in.close();
	}
}