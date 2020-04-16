package pr1.uebung06;

import java.util.Scanner;

public class Application {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static String promptInput(String prompt) {
		System.out.println(prompt);
		return scanner.nextLine();
	}

	public static void main(String[] args) {
		String query = promptInput("Please enter the query: ");
		String filterStr = promptInput("Please enter the filter: ");
		
		Filter filter = FilterFactory.getFilter(filterStr);
		
		QueryResolver resolver = new QueryResolver();
		int count = resolver.where(query).matches(filter).count();
		
		boolean once = resolver.where(query).matches(filter).once();
		boolean one = resolver.where(query).matches(filter).one();
		boolean any = resolver.where(query).matches(filter).any();
		boolean none = resolver.where(query).matches(filter).none();
		boolean every = resolver.where(query).matches(filter).every();
		
		System.out.printf("Results for \"%s\" in \"%s\"\n", filter, query);
		System.out.println("Once = " + once);
		System.out.println("One = " + one);
		System.out.println("Any = " + any);
		System.out.println("None = " + none);
		System.out.println("Every = " + every);
		System.out.println("Count = " + count);				
	}
}