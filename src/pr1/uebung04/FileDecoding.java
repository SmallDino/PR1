package pr1.uebung04;

import java.io.*;

public class FileDecoding {

	static final int lettersInAlphabet = 26;

	/*
	 * Run -> Run Configurations -> ClassName -> Arguments
	 * DEFAULT-WERTE VON (String[] args): 
	 * args[0] = ./Files/OriginalFile.txt/
	 * args[1] = ./Files/DecodedFile.txt/
	 * args[2] = ZAHL zwischen 0 und 25
	 * 
	 * EINZELNE Argumente sind mit einem LEERZEICHEN getrennt.
	 */
	public static void main(String[] args) throws IOException {
		// Abfrage ob die richtige Anzahl an Argumenten übergeben wurden
		if (args.length != 3) {
			System.out.println("Anzahl der Argumente muss 3 sein!\nEingabe Datei, Ausgabe Datei, Verschlüsselung");
			return;
		}
		// Dateien einlesen und zuweisen
		File inputFile = new File(args[0]);
		File outputFile = new File(args[1]);
		int encryption = Integer.parseInt(args[2]);
		// Abfrage ob die Verschlüsselung im gültigen Bereich liegt
		if (encryption < 0 || encryption > 25) {
			System.out.println("Die Verschlüsselung muss zwischen 0 und 25 liegen!");
			return;
		}
		// Dateistrom zur Quell- und Zieldatei öffnen
		FileReader inputStream = new FileReader(inputFile);
		FileWriter outputStream = new FileWriter(outputFile);
		// Einzelnen Character in der Datei einlesen
		int characterInFile = inputStream.read();
		// Verarbeitungsschleife, solange noch Zeichen in der Datei vorhanden sind
		while (characterInFile != -1) {
			outputStream.write(characterEncryption(characterInFile, encryption));
			characterInFile = inputStream.read();
		}
		System.out.println("Datei wurde verschlüsselt.");
		inputStream.close();
		outputStream.close();

		System.out.println("\n>>> Programm beendet");
	}

	/**
	 * Verschlüsselt ein Zeichen mit einem variablen Versatz zwischen 0 und 25
	 * 
	 * @param characterInFile Zeichen welches verschlüsselt werden soll
	 * @param encryption Verschlüsselungsgrad von 0 bis 25
	 * 
	 * @return Gibt das Verschlüsselte Zeichen wieder zurück
	 */
	static int characterEncryption(int characterInFile, int encryption) {		
		if (characterInFile >= 'a' && characterInFile <= 'z') {
			return (((characterInFile - 'a') + encryption) % lettersInAlphabet) + 'a';

		} else if (characterInFile >= 'A' && characterInFile <= 'Z') {
			return (((characterInFile - 'A') + encryption) % lettersInAlphabet) + 'A';
		} else {
			return characterInFile;
		}
	}
}