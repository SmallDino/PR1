package pr1.uebung04;

import java.io.*;

public class KeyFinder {

	static final int lettersInAlphabet = 26;

	public static void main(String[] args) throws IOException {
		// Abfrage ob die richtige Anzahl an Argumenten übergeben wurden
		if (args.length != 1) {
			System.out.println("Anzahl der Argumente muss 1 sein!\nEingabe Datei muss als Argument übergeben werden.");
			return;
		}

		File inputFile = new File(args[0]);

		FileReader inputStream = new FileReader(inputFile);

		int[] letterFrequency = letterFrequencyInFile(inputStream);

		int maxLetter = findMaxIndex(letterFrequency);

		System.out.println("Häufigster Buchstabe: " + ((char) ('a' + maxLetter)));
		System.out.println("Verschiebung zu E: " + (maxLetter - ('e' - 'a') + lettersInAlphabet) % lettersInAlphabet);

		inputStream.close();

		System.out.println("\n>>> Programm beendet");
	}

	/**
	 * Calculates the frequency for all letters from A - Z
	 * 
	 * @param inputStream File to calculate the letter frequency
	 * @return Array with 26 elements, Contains the frequency for all possible letters in alphabetical order
	 */
	static int[] letterFrequencyInFile(FileReader inputStream) throws IOException {
		int[] letterFrequency = new int[lettersInAlphabet];
		
		int characterInFile = inputStream.read();
		// Häufigkeitsanalyse	
		while(characterInFile != -1) {
			if (characterInFile >= 'a' && characterInFile <= 'z') {
				letterFrequency[characterInFile - 'a'] += 1;
			} else if (characterInFile >= 'A' && characterInFile <= 'Z') {
				letterFrequency[characterInFile - 'A'] += 1;
			}
			
			characterInFile = inputStream.read();
		}		
		return letterFrequency;
	}
	
	/**
	 * Finds the letter with the most frequency
	 * 
	 * @param array Array that has to be atleast the length > 0
	 * @return Index with the most frequency letter in it
	 */
	static int findMaxIndex(int[] array) {
		int max = 0;
		
		for (int position = 1; position < array.length; position++) {
			if(array[position] > array[max]) {
				max = position;
			}
		}		
		return max;
	}
}