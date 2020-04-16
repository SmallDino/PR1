package pr1.uebungen.linearlist;
public class ListElement {
	
	int content;
	ListElement next;
	ListElement prev;
	
	ListElement(int value, ListElement nextNode) {
		content = value;
		next = nextNode;
	}
}