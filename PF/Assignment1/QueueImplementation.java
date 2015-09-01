import java.util.LinkedList;
import java.util.Scanner;

//class to implement queue
public class QueueImplementation {
	LinkedList arr = new LinkedList();

	// to add element
	public void add(String element) {
		arr.addLast(element);
		System.out.println(arr.size());
	}

	// to remove element
	public void remove() {
		if (arr.size() == 0) {
			System.out.println("no element to be removed");

		} else {
			arr.removeFirst();
		}

	}

	// to get begining of queue
	public void getBegining() {
		if (arr.size() == 0) {
			System.out.println("no element ");

		} else {
			System.out.println("First element = " + arr.getFirst());
			;
		}

	}

	// to clear
	public void clear() {
		System.out.println("list cleared");
		arr.clear();
	}

}
