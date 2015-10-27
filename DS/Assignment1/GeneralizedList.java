package list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GeneralizedList {
	List<Object> linkList = null;
	private int index;

	/**
	 * @return the linkList
	 */
	public List<Object> getLinkList() {
		return linkList;
	}

	/**
	 * @param linkList
	 *            the linkList to set
	 */
	public void setLinkList(List<Object> linkList) {
		this.linkList = linkList;
	}

	// constructor to create generalized list
	public GeneralizedList(String inputList) {

		index = 0;
		String digit = "";
		while (index < inputList.length()) {

			if (inputList.charAt(index) == '(') {
				index = index + 1;
				linkList = createSubList(inputList);
				index = index + 1;
			} else if (inputList.charAt(index) == ',') {
				index = index + 1;
			} else if (inputList.charAt(index) != ')') {
				while (inputList.charAt(index) != ','
						&& inputList.charAt(index) != ')') {
					digit = digit + inputList.charAt(index);
					index++;
				}
				linkList.add(Integer.parseInt(digit));
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

		return "Generalized List is :" + linkList;
	}

	// To calculate sum of list
	public int calculateSum(Object linked) {
		int sum = 0;
		// iterating list
		Iterator<Object> iterator = ((List<Object>) linked).iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			// if it is sub linked list
			if (obj instanceof LinkedList) {
				sum = sum + calculateSum(obj);
			} else {// if not list
				sum = sum + (Integer) obj;

			}
		}
		return sum;

	}

	// Function calculating maximum from list
	public int calculateMax(Object linked) {
		// iterating list
		Iterator<Object> iterator = ((List<Object>) linked).iterator();
		int max = (Integer) ((List<Object>) linked).get(0);
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			// if it is sub linked list
			if (obj instanceof LinkedList) {
				int max1 = calculateMax(obj);
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

	// Function to search element in list
	public boolean searchForValue(Object linked, int value) {
		// iterating list
		Iterator<Object> iterator = ((List<Object>) linked).iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			// if it is sub linked list
			if (obj instanceof LinkedList) {
				if (searchForValue(obj, value) == true) {
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
