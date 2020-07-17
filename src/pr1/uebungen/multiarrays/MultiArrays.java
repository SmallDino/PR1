package pr1.uebungen.multiarrays;

public class MultiArrays {

	public static void main(String[] args) {
		// Mehrdimensionale Arrays deklarieren & initialisieren
		int[][] mArray = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// 3 Arrays der Länge 5
		int[][] mArray2 = new int[3][5];
		
		// Wertzuweisung, iteriert über ein Mehrdimensionales Array
		for (int i = 0; i < mArray2.length; i++) {
			for (int j = 0; j < mArray2[1].length; j++) {
				mArray2[i][j] = j;
			}
		}
		
		// Ausgabe von Werten
		for (int i = 0; i < mArray2.length; i++) {
			for (int j = 0; j < mArray2[1].length; j++) {
				System.out.println(i + ". Dimension" + " | Wert an Stelle " + j + ": " + mArray2[i][j]);
			}
		}

		//System.out.println(mArray[0][7]);
		//System.out.println(mArray2[0][0]);
	}
}