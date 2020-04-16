package pr1.uebung03;

import java.util.Scanner;

public class AdvancedArrayOptions {

	final static int MENU_EXIT = 0;
	final static int MENU_MAXIMUM_IN_ARRAY = 1;
	final static int MENU_ARRAY_SORTED_ASCENDING = 2;
	final static int MENU_ARRAY_SORTED_DESCENDING = 3;
	final static int MENU_SQUARE_NUMBERS = 4;
	final static int MENU_NEW_ARRAY = 5;
	final static int MENU_EXPAND_ARRAY = 6;

	public static void main(String[] args) {
		// Variablen deklarieren
		int menuOption;
		boolean arrayAscendingSorted = false;
		Scanner scanner = new Scanner(System.in);
		int[] array = arrayGenerator(scanner);

		do {
			menuOption = menuOptions(scanner);

			if (menuOption == MENU_MAXIMUM_IN_ARRAY) {
				int maximumInArray = maximumInArray(array);
				System.out.println("Der Maximalwert im Array befindet sich an Position: " + (maximumInArray + 1));

			} else if (menuOption == MENU_ARRAY_SORTED_ASCENDING) {
				arrayAscendingSorted = true;

				if (isArraySorted(array, arrayAscendingSorted)) {
					System.out.println("Das Array ist aufsteigend sortiert!");
				} else {
					System.out.println("Das Array ist NICHT aufsteigend sortiert");
				}

			} else if (menuOption == MENU_ARRAY_SORTED_DESCENDING) {
				arrayAscendingSorted = false;

				if (isArraySorted(array, arrayAscendingSorted)) {
					System.out.println("Das Array ist absteigend sortiert!");
				} else {
					System.out.println("Das Array ist NICHT absteigend sortiert");
				}

			} else if (menuOption == MENU_SQUARE_NUMBERS) {
				int[] squareRootArray = squareNumberIntoArray(array);

				System.out.println("Alle Quadratzahlen im Array:");

				if (squareRootArray.length > 0) {
					for (int counter = 0; counter < squareRootArray.length; counter++) {
						System.out.print(squareRootArray[counter] + " ");
					}
				} else {
					System.out.print("Keine Quadratzahl vorhanden vorhanden!");
				}
				System.out.println();

			} else if (menuOption == MENU_NEW_ARRAY) {
				array = arrayGenerator(scanner);
				System.out.println("Ihr neues Array wurde angelegt.");

			} else if (menuOption == MENU_EXPAND_ARRAY) {
				array = expandArray(scanner, array);
				System.out.println("Ihr Array wurde erweitert.");

			}
		} while (menuOption != MENU_EXIT);

		scanner.close();
		System.out.println("\n>>> Programm beendet");
	}

	/**
	 * Generiert ein benutzerdefiniertes Array
	 * 
	 * @param in Scanner für die Eingabe um das Array zu erstellen.
	 * @return Gibt ein <b>neu generiertes</b> Array zurück.
	 */
	static int[] arrayGenerator(Scanner scanner) {
		// Variablen deklarieren
		int userInput;
		int[] generatedArray;
		// Ausgabe Aufforderung
		System.out.println("Wie viele Zahlen wollen Sie in Ihr Array eingeben?");
		// Eingabewert des Benutzers
		userInput = scanner.nextInt();
		// Neues Array mit dem Eingabewert erstellen
		generatedArray = new int[userInput];
		// Werte dem Array zuweisen
		for (int position = 0; position < generatedArray.length; position++) {
			System.out.println("Geben Sie Ihre " + (position + 1) + ". Zahl ein:");
			userInput = scanner.nextInt();
			generatedArray[position] = userInput;
		}
		// Array zurückgeben
		return generatedArray;
	}

	/**
	 * Findet das Maximum im Array und gibt die Position zur�ck.
	 * 
	 * @param array muss die Länge > 0 haben.
	 * @return Gibt die <b>Position</b> des Maximalwertes im Array zurück.
	 */
	static int maximumInArray(int[] array) {
		// Variablen deklarieren
		int maxValue = array[0];
		int maxPosition = 0;
		// Den Maximalwert mit jedem Element im Array vergleichen
		for (int position = 1; position < array.length; position++) {
			// Falls der Maximalwert im Array größer ist, als der Initialwert
			if (array[position] >= maxValue) {
				maxValue = array[position];
				maxPosition = position;
			}
		}
		return maxPosition;
	}

	/**
	 * Überprüft ein Array ob es Aufsteigend oder Absteigend sortiert ist.
	 * 
	 * @param array Array welches auf die "Sortiert" Eigenschaft überprüft wird
	 * @return Gibt einen <b>boolean</b>-Wert zurück, ob das Array
	 *         <b>aufsteigend</b> oder <b>absteigend</b> sortiert ist.
	 */
	static boolean isArraySorted(int[] array, boolean arrayAscendingSorted) {
		int startValue = array[0];

		for (int position = 1; position < array.length; position++) {
			if ((arrayAscendingSorted && array[position] < startValue)
					|| (!arrayAscendingSorted && array[position] > startValue)) {
				return false;
			}
			startValue = array[position];

		}
		return true;

	}

	/**
	 * Fügt 2 Arrays zusammen.
	 * 
	 * @param arrayOne Erstes Array welches zusammengeführt werden soll
	 * @param arrayTwo Zweites Array welches zusammengeführt werden soll
	 * @return Gibt ein zusammengesetztes Array zurück, welches die beiden Arrays
	 *         enthält
	 */
	static int[] assembleArrays(int[] arrayOne, int[] arrayTwo) {
		// Neues Array mit der genauen Länge der beiden Arrays, welche zusammengeführt
		// werden
		int[] newArray = new int[arrayOne.length + arrayTwo.length];

		// Kopiere das 1. Array in das neue Array
		for (int counter = 0; counter < arrayOne.length; counter++) {
			newArray[counter] = arrayOne[counter];
		}

		// Kopiere das 2. Array in das neue Array
		for (int counter = 0; counter < arrayTwo.length; counter++) {
			newArray[counter + arrayOne.length] = arrayTwo[counter];
		}

		return newArray;

	}

	/**
	 * Liest Werte ein, die an das bestehende Array angehängt werden *
	 * 
	 * @param in Scanner für die Eingabe um das Array zu erstellen.
	 * @param generatedArray liest das zuvor erstellte Array ein.
	 * @return Gibt ein <b>neues und erweitertes Array</b> zurück.
	 */
	static int[] expandArray(Scanner scanner, int[] array) {
		// Lese ein neues Array ein und füge es zum bisher eingelesenen hinzu
		int[] newValues = arrayGenerator(scanner);
		int[] newArray = assembleArrays(array, newValues);

		return newArray;
	}

	/**
	 * Überprüft ob eine übergebene Zahl eine Quadratzahl ist
	 * 
	 * @param number übergebene Zahl wird auf eine Quadratzahl überprüft
	 * @return true falls Quadratzahl, ansonsten false
	 */
	static boolean isSquareNumber(int number) {
		// Variablen deklarieren
		double epsilon = 0.001;
		double root = Math.sqrt(number);
		double roundedRoot = Math.floor(root);

		// Alle negativen Zahlen abfangen
		if (number < 0) {
			return false;
		}

		// Überprüfen auf Quadratzahl
		if (Math.abs(root - roundedRoot) > epsilon) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Kopiert alle gefunden Quadratzahlen in ein neues Array
	 * 
	 * @param array Original Array welches überprüft werden soll
	 * @return gibt ein neues Array mit Quadratzahlen zurück
	 */
	static int[] squareNumberIntoArray(int[] array) {
		// Variablen deklarieren
		int[] squareRootArray;
		int squareRootCounter = 0;
		boolean[] foundSquareRoot = new boolean[array.length];

		// Quadratzahlen z�hlen
		for (int counter = 0; counter < array.length; counter++) {
			if (isSquareNumber(array[counter])) {
				squareRootCounter += 1;
				foundSquareRoot[counter] = true;
			}
		}
		// Neue Länge für das Quadratzahlarray festlegen
		squareRootArray = new int[squareRootCounter];

		for (int counter = 0; counter < foundSquareRoot.length; counter++) {
			if (foundSquareRoot[counter]) {
				squareRootArray[squareRootArray.length - squareRootCounter] = array[counter];

				squareRootCounter -= 1;
			}
		}
		return squareRootArray;
	}

	/**
	 * Auswahlmenü
	 * 
	 * @param in Eingabe um die Menüpunkte auszuwählen
	 * @return Gibt die getroffene Auswahl zurück
	 */
	static int menuOptions(Scanner in) {
		System.out.println("\n---------- MENÜ ----------");
		System.out.println(MENU_EXIT + ": Beenden des Programms.");
		System.out.println(MENU_MAXIMUM_IN_ARRAY + ": Maximum im Array ermitteln.");
		System.out.println(MENU_ARRAY_SORTED_ASCENDING + ": Array auf eine aufsteigene Sortierung überprüfen.");
		System.out.println(MENU_ARRAY_SORTED_DESCENDING + ": Array auf eine absteigende Sortierung überprüfen.");
		System.out.println(MENU_SQUARE_NUMBERS + ": Array auf Quadratzahlen überprüfen.");
		System.out.println(MENU_NEW_ARRAY + ": Ein neues Array anlegen.");
		System.out.println(MENU_EXPAND_ARRAY + ": Vorhandenes Array erweitern.");
		System.out.println("Wählen Sie Ihre Option:");

		return in.nextInt();
	}
}