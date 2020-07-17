package pr1.uebungen.linearlist;


public class LinearList {
	ListElement first;

	// TO-DO: Weitere Methoden der LinearList programmieren
	
	public void addFirst(int value) {
		ListElement n = new ListElement(value, first);
		first = n;
	}
	
	public void output() {
		ListElement n = first;
		
		System.out.print("\n( ");
		while (n != null) {
			System.out.print(n.content + " ");
			n = n.next;
		}
		System.out.println(")");		
	}
}