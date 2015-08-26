package prg4;

import java.util.Scanner;
import java.util.Scanner;

//to perform operatin on linked list
public class DoubleLinkedListOperations<T> {

	// to create node
	public NodeDouble<T> createDoublyLinkedList(T item1, T item2) {
		NodeDouble<T> first = null, p, q;
		p = new NodeDouble<T>(item1);
		q = new NodeDouble<T>(item2);
		first = p;
		p.next = q;
		q.prev = p;
		return first;
	}

	// to insert node at a given location
	public NodeDouble<T> insertAtPosition(String element, int position,
			NodeDouble<T> first, int n) {
		NodeDouble newNode = new NodeDouble(element);
		NodeDouble<T> current = first;
		if (position == 0) {
			first = newNode;
			newNode.next = current;
			newNode.prev = null;
			return first;

		} else if (position > 0 && position < n - 1) {
			for (int i = 1; i < position; i++) {
				current = current.next;
			}
			current.next.prev = newNode;
			newNode.next = current.next;
			newNode.prev = current;
			current.next = newNode;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			newNode.prev = current;
		}
		return first;

	}

	// to delete node
	public NodeDouble<T> deleteAtValue(NodeDouble<T> first, String value, int n) {
		NodeDouble<T> current = first;
		NodeDouble<T> previous = first;
		if (current.nodeValue.equals(value)) {
			first = current.next;
		} else {

			while (current.next != null) {
				previous = current;
				current = current.next;
				if (current.nodeValue.equals(value)) {
					previous.next = current.next;
					if (current.next != null)
						current.next.prev = previous;
				}

			}
		}
		return first;
	}

	// to delete node at a given location
	public NodeDouble<T> deleteAtPosition(int position, NodeDouble<T> first,
			int n) {
		NodeDouble<T> current = first;
		NodeDouble<T> previous = first;
		int i;
		if (position == 0) {
			first = first.next;
			return first;
		}

		else if (position > 0 && position < n - 1) {
			for (i = 0; i < position; i++) {
				previous = current;
				current = current.next;
			}
			previous.next = current.next;
			current.next.prev = previous;
			return previous;
		}

		else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = null;
		}
		return first;

	}

	// to retrive node from a given position
	public T retrieveAtPosition(int position, NodeDouble<T> first) {
		NodeDouble<T> current = first;
		for (int i = 0; i < position; i++) {
			current = current.next;
		}
		return current.nodeValue;
	}

	// to display
	public void display(NodeDouble<T> first) {
		NodeDouble<T> current = first;
		while (current != null) {
			System.out.println(current.nodeValue);
			current = current.next;

		}
	}

	// to reverse
	public NodeDouble<T> reverseDoublyLinkedList(NodeDouble<T> first, int n) {
		NodeDouble<T> tempNode1 = first, tempNode2 = first;
		String temp;
		while (tempNode2.next != null) // apply simple sorting to sort the
										// elements
		// of Linked list
		{
			tempNode2 = tempNode2.next;
		}

		for (int i = 0; i < n / 2; i++) // apply simple sorting to sort the
										// elements
										// of Linked list
		{
			temp = (String) tempNode1.nodeValue;
			tempNode1.nodeValue = tempNode2.nodeValue;
			tempNode2.nodeValue = (T) temp;
			tempNode1 = tempNode1.next;
			tempNode2 = tempNode2.prev;
		}
		return first;
	}

	// sorting
	NodeDouble<T> sort(NodeDouble<T> first) {
		NodeDouble<T> tempNode1 = first, tempNode2;
		String temp;
		while (tempNode1 != null) // apply simple sorting to sort the elements
									// of Linked list
		{
			tempNode2 = first;
			while (tempNode2.next != null) {
				if (((String) tempNode2.nodeValue)
						.compareTo((String) tempNode2.next.nodeValue) > 0) {
					temp = (String) tempNode2.nodeValue;
					tempNode2.nodeValue = tempNode2.next.nodeValue;
					tempNode2.next.nodeValue = (T) temp;
				}
				tempNode2 = tempNode2.next;
			}
			tempNode1 = tempNode1.next;
		}
		return first;
	}

	// to calculate length
	public int calculateLength(NodeDouble<T> first) {
		int count = 1;
		NodeDouble<T> current = first;
		while (current.next != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	// main function
	public static void main(String args[]) {
		DoubleLinkedListOperations<String> object = new DoubleLinkedListOperations<String>();
		Scanner sc = new Scanner(System.in);
		int choice;
		int position;
		NodeDouble<String> second = null;
		String input = new String();

		do {
			System.out.println("1) Creation of linked list");
			System.out
					.println("2) Add the particular item in the linked list at the particular location");
			System.out.println("3) Removal of an item based on its value ");
			System.out.println("4) Removal of an item based on its index");
			System.out.println("5) Retrieval of an item of particular index");
			System.out.println("6) Reversal of linked list");
			System.out.println("7) Sorting of linked list");
			do {// Validation
				System.out.println("Please enter a positive number!");
				while (!sc.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					sc.next(); // this is important!
				}
				choice = sc.nextInt();
			} while (choice <= 0);

			switch (choice) {
			case 1:
				System.out
						.println("Enter a generic value to create a linked list");
				String line1 = sc.next();
				String line2 = sc.next();
				second = object.createDoublyLinkedList(line1, line2);
				System.out.println("After node creation");
				object.display(second);
				break;

			case 2:

				System.out.println("Enter a string to be inserted");
				input = sc.next();
				System.out.println("Enter position of string to be inserted");
				position = sc.nextInt();
				System.out.println("After inserting at required position");
				second = object.insertAtPosition(input, position, second,
						object.calculateLength(second));
				object.display(second);

				break;

			case 3:
				System.out.println("Enter string to be deleted");
				second = object.deleteAtValue(second, sc.next(),
						object.calculateLength(second));
				object.display(second);
				break;

			case 4:
				System.out.println("Enter position of string to be deleted");
				position = sc.nextInt();
				System.out.println("After deleting at required position");
				second = object.deleteAtPosition(position, second,
						object.calculateLength(second));
				object.display(second);
				break;

			case 5:
				System.out.println("To retrieve at a particular position");
				System.out.println("Enter position of string to be retrieved");
				position = sc.nextInt();
				String str = object.retrieveAtPosition(position, second);
				System.out.println(str);
				break;
			case 6:
				System.out.println("Reverse Linked list");
				second = object.reverseDoublyLinkedList(second,
						object.calculateLength(second));
				System.out.println("Reverse Linked list");
				object.display(second);
				break;
			case 7:
				System.out.println("Sorting Linked list");
				second = object.sort(second);
				object.display(second);
				break;
			default:
				System.out.println("Enter Correct Choice");
			}
			do {// validation
				System.out.println("Do you want to continue(Y/N)"); // continuing
																	// the
																	// procedure
				while (!sc.hasNext()) {
					System.out.println("That's not a character!");
					sc.next(); // this is important!

				}
				choice = sc.next().toUpperCase().charAt(0);
				if (choice == 'N')
					System.exit(0);
			} while (choice != 'Y');

		} while (choice == 'Y');
		sc.close();
	}

}
