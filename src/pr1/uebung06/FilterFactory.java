package pr1.uebung06;

import java.util.*;

public class FilterFactory {

	private static Map<String, Filter> filterMap = new HashMap<String, Filter>();

	/**
	 * Returns a filter object for the given filter string.
	 * 
	 * @param letters - The letters which the filter should cover.
	 * @return A Filter object based on the given filter string.
	 */
	public static Filter getFilter(String letters) {
		Filter instance = filterMap.get(letters);
		
		if(instance == null) {
			instance = new Filter(letters);
			filterMap.put(letters, instance);
		}		
		return instance;
	}
}