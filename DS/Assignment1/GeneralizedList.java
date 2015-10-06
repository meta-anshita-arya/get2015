package list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GeneralizedList {
	List<Object> linkedList = new LinkedList<Object>();
	int index = 1;

	// return the linkedList
	public List<Object> getLinkedList() {
		return linkedList;
	}

	// set the linkedList
	public void setLinkedList(List<Object> linkedList) {
		this.linkedList = linkedList;
	}

	// to generate linked list
	public GeneralizedList(String inputList) {
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

	// to generate sub-linked list
	private List<Object> createSubList(String inputList) {
		String digit = "";
		List<Object> linked = new LinkedList<Object>();
		while (inputList.charAt(index) != ')' && index < inputList.length()) {

			if (inputList.charAt(index) == ',') {
				index++;

			} else if (inputList.charAt(index) == '(') {
				index = index + 1;

				linked.add(createSubList(inputList));

				index++;
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

		return "linkedList=" + linkedList;
	}

	// to calculate sum
	public int calculateSum() {
		int sum = 0;
		Iterator<Object> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			if (obj instanceof LinkedList) {
				sum = sum + calculateSubListSum(obj);
			} else {
				sum = sum + (Integer) obj;

			}
		}
		return sum;

	}

	// to calculate sub-list sum
	private int calculateSubListSum(Object linked) {
		int sum = 0;
		Iterator<Object> iterator = ((List<Object>) linked).iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			if (obj instanceof LinkedList) {
				sum = sum + calculateSubListSum(obj);

			} else {
				sum = sum + (Integer) obj;

			}
		}
		return sum;
	}

	// to find greatest number
	public int calculateMax() {
		Iterator<Object> iterator = linkedList.iterator();
		int max = (int) linkedList.get(0);
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			if (obj instanceof LinkedList) {
				int max1 = calculateSubListMax(obj);

				if (max < max1) {

					max = max1;

				}

			} else {
				if (max < (Integer) obj) {
					max = (Integer) obj;
				}

			}
		}
		return max;

	}

	// to find greatest number in sub list
	private int calculateSubListMax(Object linked) {
		Iterator<Object> iterator = ((List<Object>) linked).iterator();
		int max = (int) ((List<Object>) linked).get(0);
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			if (obj instanceof LinkedList) {
				int max1 = calculateSubListMax(obj);
				if (max < max1) {
					max = max1;
				}
			} else {
				if (max < (Integer) obj) {
					max = (Integer) obj;
				}
			}
		}

		return max;
	}

	// to search
	public boolean searchValue(int value) {
		Iterator<Object> iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			if (obj instanceof LinkedList) {
				if (searchSubForValue(obj, value) == true) {
					return true;
				}

			} else {
				if (value == (Integer) obj) {
					return true;
				}

			}
		}
		return false;

	}

	// to search in sub list
	private boolean searchSubForValue(Object linked, int value) {
		Iterator<Object> iterator = ((List<Object>) linked).iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			if (obj instanceof LinkedList) {
				if (searchSubForValue(obj, value) == true) {
					return true;
				}

			} else {
				if (value == (Integer) obj) {
					return true;
				}
			}
		}
		return false;
	}

}
