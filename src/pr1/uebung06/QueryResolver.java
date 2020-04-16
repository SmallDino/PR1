package pr1.uebung06;

public class QueryResolver {
	private String query;
	private Filter filter;

	/**
	 * Configures the query resolver to use the given query and returns it.
	 * 
	 * @param query - The string that is being queried.
	 * @return The query resolver.
	 */
	public QueryResolver where(String query) {
		this.query = (query != null ? query : "");
		return this;
	}


	/**
	 * Configures the query resolver to use the given filter and returns it.
	 * 
	 * @param filter - The filter to use for the query resolver.
	 * @return The query resolver.
	 */
	public QueryResolver matches(Filter filter) {
		this.filter = (filter != null ? filter : FilterFactory.getFilter(""));
		return this;
	}

	/**
	 * Returns the number of characters in the query, that are part of the filter.
	 * 
	 * @return the number of characters in the query, that are part of the filter.
	 */
	public int count() {
		int count = 0;

		for (int i = 0; i < this.query.length(); i++) {
			if (filter.contains(query.charAt(i))) {
				count += 1;
			}
		}
		return count;
	}

	/**
	 * Checks if only one single character in the query has a match in the filter.
	 * 
	 * @return true if there is excatly one match, otherwise false.
	 */
	public boolean once() {
		return count() == 1;
	}

	/**
	 * Checks if only one of the characters in the filter matches the query one or multiple times.
	 * 
	 * @return true if only one of the characters in the filter matches the query one or multiple times, otherwise false.
	 */
	public boolean one() {
		boolean isMatched = true;
		char zwischenspeicher = ' ', anfangswert = ' ';

		for (int i = 0; i < query.length(); i++) {
			if (filter.contains(query.charAt(i)) && isMatched) {
				isMatched = false;
				zwischenspeicher = query.charAt(i);
			}

			if (filter.contains(query.charAt(i))) {
				if (zwischenspeicher == query.charAt(i)) {

				} else {
					return false;
				}
			}

		}

		if ((zwischenspeicher == anfangswert) && isMatched == false) {
			return true;
		} else if ((zwischenspeicher == anfangswert) && isMatched == true) {
			return false;
		} else if (zwischenspeicher != anfangswert) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if at least one character in the query has a match in the filter.
	 * 
	 * @return true if there is at least one match, otherwise false
	 */
	public boolean any() {
		return count() >= 1;
	}

	/**
	 * Checks if no characters in the query have a match in the filter.
	 * 
	 * @return true if there are no matches, otherwise false.
	 */
	public boolean none() {
		return count() == 0;
	}

	/**
	 * Checks if every character in the query is part of the filter.
	 * 
	 * @return true if every character in the query is part of the filter, otherwise false.
	 */
	public boolean every() {
		return count() == this.query.length();
	}
}