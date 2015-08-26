package prg3;

//node class
public class Node<T> {
	public T nodeValue;
	public Node<T> next;

	Node() {
		nodeValue = null;
		next = null;
	}

	Node(T item) {
		nodeValue = item;
		next = null;
	}

}
