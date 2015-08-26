package prg4;

//double linkedlist node class
public class NodeDouble<T> {
	public T nodeValue;
	public NodeDouble<T> next;
	public NodeDouble<T> prev;

	NodeDouble() {
		nodeValue = null;
		next = null;
		prev = null;
	}

	NodeDouble(T item) {
		nodeValue = item;
		next = null;
		prev = null;
	}

}
