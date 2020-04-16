package pr1.uebung03;

import java.util.Scanner;

public class ArrayProperties {

	final static int MENU_EXIT = 0;
	final static int MENU_MAXIMUM_IN_ARRAY = 1;
	final static int MENU_ARRAY_SORTED_ASCENDING = 2;
	final static int MENU_ARRAY_SORTED_DESCENDING = 3;

	public static void main(String[] args) {
		boolean arrayAscendingSorted = true;
		int menuOption;
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
			}
		} while (menuOption != MENU_EXIT);

		scanner.close();
		System.out.println("\n>>> Programm beendet");

	}

	/**
	 * Generiert ein benutzerdefiniertes Array.
	 * 
	 * @param in Scanner für die Eingabe um das Array zu erstellen.
	 * @return Gibt ein <b>neu generiertes</b> Array zurück.
	 */
	static int[] arrayGenerator(Scanner in) {
		// Variablen deklarieren
		int userInput;
		int[] generatedArray;
		// Ausgabe Aufforderung
		System.out.println("Wie viele Zahlen wollen Sie in Ihr Array eingeben?");
		// Eingabewert des Benutzers
		userInput = in.nextInt();
		// Neues Array mit dem Eingabewert erstellen
		generatedArray = new int[userInput];
		// Werte dem Array zuweisen
		for (int position = 0; position < generatedArray.length; position++) {
			System.out.println("Geben Sie Ihre " + (position + 1) + ". Zahl ein:");
			userInput = in.nextInt();
			generatedArray[position] = userInput;
		}
		// Array zur�ckgeben
		return generatedArray;
	}

	/**
	 * Findet das Maximum im Array und gibt die Position zurück.
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
	 * Überprüft ein Array ob es aufsteigend oder absteigend sortiert ist.
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
	 * Auswahlmen�
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
		System.out.println("Wählen Sie Ihre Option:");

		return in.nextInt();
	}
}