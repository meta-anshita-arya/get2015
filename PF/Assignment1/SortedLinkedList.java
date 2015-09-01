import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//to implement sorted link list
public class SortedLinkedList {

	List<Integer> node = new LinkedList<Integer>();

	// to add element
	void addElement(int element) {
		node.add(element);
		Collections.sort(node);
	}

	// to add element in sorted list
	public void addElements(int index, int element) {
		Iterator<Integer> itr1 = node.iterator();
		if (itr1.hasNext()) {
			int output = node.get(index);
			if (output <= element) {
				index++;
				addElements(index, element);
			} else {
				node.add(index, element);
				return;
			}
		}
	}

	// to print
	public void display() {
		if (node.size() == 0) {
			System.out.println("list empty");
		} else {
			Iterator<Integer> itr = node.iterator();
			while (itr.hasNext()) {
				Object a = itr.next();
				System.out.println(a);
			}

		}

	}
}
