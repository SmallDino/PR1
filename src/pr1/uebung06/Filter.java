package pr1.uebung06;

public class Filter {
	private String letters;

	protected Filter(String letters) {
		this.letters = letters != null ? letters : "";
	}

	/**
	 * Checks if a character is in the filter.
	 * 
	 * @param character the character which is checked in the filter
	 * @return true if the character is in the filter, else false.
	 */
	public boolean contains(char character) {
		
		for (int i = 0; i < letters.length(); i++) {
			
			if(letters.charAt(i) == character) {
				return true;
			}
		}		
		return false;
	}

	public String toString() {
		return letters;
	}	
}