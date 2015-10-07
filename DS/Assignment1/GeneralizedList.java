import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GeneralizedList {
	private List<Object> linkedList;
	private int index;

	// return the linkedList
	public List<Object> getLinkedList() {
		return linkedList;
	}

	// set the linkedList
	public void setLinkedList(List<Object> linkedList) {
		this.linkedList = linkedList;
	}

	// constructor to create generalized list
	public GeneralizedList(String inputList) {
		linkedList = new LinkedList<Object>();
		index = 1;
		String digit = "";
		while (index < inputList.length() - 1) {

			if (inputList.charAt(index) == '(') {
				index = index + 1;
				linkedList.add(createSubList(inputList));
				index = index + 1;
			} else if (inputList.charAt(index) == ',') {
				index = index + 1;
			} else if (inputList.charAt(index) != ')') {
				while (inputList.charAt(index) != ','
						&& inputList.charAt(index) != ')') {
					digit = digit + inputList.charAt(index);
					index++;
				}
				linkedList.add(Integer.parseInt(digit));
				digit = "";

			}
		}
	}

	// for generalized sub list
	private List<Object> createSubList(String inputList) {
		String digit = "";
		List<Object> linked = new LinkedList<Object>();
		while (inputList.charAt(index) != ')' && index < inputList.length()) {
			if (inputList.charAt(index) == ',') {
				index++;
			} else if (inputList.charAt(index) == '(') {
				index = index + 1;
				linked.add(createSubList(inputList));
				index = index + 1;
			} else {
				while (inputList.charAt(index) != ','
						&& inputList.charAt(index) != ')') {
					digit = digit + inputList.charAt(index);
					index++;
				}
				linked.add(Integer.parseInt(digit));
				digit = "";
			}
		}
		return linked;
	}

	@Override
	public String toString() {

		return "Generalized List is :" + linkedList;
	}

	// To calculate sum of list
	public int calculateSum() {
		int sum = 0;
		// iterating list
		Iterator<Object> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			// if it is sub linked list
			if (obj instanceof LinkedList) {
				sum = sum + calculateSubListSum(obj);
			} else {// if not list
				sum = sum + (Integer) obj;

			}
		}
		return sum;

	}

	// Calculating sum of sublist
	private int calculateSubListSum(Object linked) {
		int sum = 0;
		// iterating list
		Iterator<Object> iterator = ((List<Object>) linked).iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			// if it is sub linked list
			if (obj instanceof LinkedList) {
				sum = sum + calculateSubListSum(obj);
			} else {// if not list
				sum = sum + (Integer) obj;

			}
		}
		return sum;
	}

	// Function calculating maximum element of the list
	public int calculateMax() {
		// iterating list
		Iterator<Object> iterator = linkedList.iterator();
		int max = (Integer) linkedList.get(0);
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			// if it is sub linked list
			if (obj instanceof LinkedList) {
				int max1 = calculateSubListMax(obj);
				if (max < max1) {
					max = max1;
				}

			} else {// if not list
				if (max < (Integer) obj) {
					max = (Integer) obj;
				}
			}
		}
		return max;

	}

	// Function calculating maximum from a sublist
	private int calculateSubListMax(Object linked) {
		// iterating list
		Iterator<Object> iterator = ((List<Object>) linked).iterator();
		int max = (Integer) ((List<Object>) linked).get(0);
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			// if it is sub linked list
			if (obj instanceof LinkedList) {
				int max1 = calculateSubListMax(obj);
				if (max < max1) {
					max = max1;
				}

			} else {// if not list
				if (max < (Integer) obj) {
					max = (Integer) obj;
				}
			}
		}
		return max;
	}

	// Function to search an item
	public boolean searchValue(int value) {
		// iterating list
		Iterator<Object> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			// if it is sub linked list
			if (obj instanceof LinkedList) {
				if (searchSubForValue(obj, value) == true) {
					return true;
				}
			} else {// if not a list
				if (value == (Integer) obj) {
					return true;
				}

			}
		}
		return false;

	}

	// Function to search element in sublist
	private boolean searchSubForValue(Object linked, int value) {
		// iterating list
		Iterator<Object> iterator = ((List<Object>) linked).iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			// if it is sub linked list
			if (obj instanceof LinkedList) {
				if (searchSubForValue(obj, value) == true) {
					return true;
				}
			} else {// if not a list
				if (value == (Integer) obj) {
					return true;
				}
			}
		}
		return false;
	}

}
