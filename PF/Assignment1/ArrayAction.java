package prg1;

import java.util.Arrays;

public class ArrayAction {
	int[] array;
	int actualSize;

	ArrayAction(int[] array, int actualSize) {
		this.array = array;
		this.actualSize = actualSize;
	}

	void menu() {
		System.out.println("enter choice");
		System.out.println("1 to add at end of array");
		System.out.println("2 to add at desired position");
		System.out
				.println("3 to retrive first occurance of element at given position");
		System.out.println("4 to find first occurance of given element");
		System.out.println("5 to to remove  element at given position");
		System.out.println("6 to remove given element ");
		System.out.println("7 to clear array");
		System.out.println("8 to reverse array ");
		System.out.println("9 to sort array ");
		System.out.println("10 to print array");
		System.out.println("11 to add another array");
		System.out.println("0 to exit ");
	}

	// to add at end of array
	void AddElement(int element) {

		array = Arrays.copyOf(array, array.length + 1);
		actualSize++;
		array[(array.length) - 1] = element;

	}

	// to add at desired position
	void AddElement(int element, int position) {
		int i;
		array = Arrays.copyOf(array, array.length + 1);
		actualSize++;
		for (i = actualSize - 1; i > position - 1; i--) {
			array[i] = array[i - 1];
		}
		array[position - 1] = element;

	}

	// to retrive first occurance of element at given position
	void RetrievingTheFirstOccurrence(int location) {
		int item = array[location - 1];
		int i = 0;
		while (array[i] != item && i < location) {
			i++;
		}
		System.out.println(" First Occurrence is at" + i + 1);
	}

	// to find first occurance of given element
	void RetrievingTheFirstIndex(int element) {
		int i, count = 0;
		for (i = 0; i < actualSize; i++) {
			if (element == array[i]) {
				count++;
				break;
			}
		}
		if (count != 0) {
			System.out.println("first index=" + i);
		} else {
			System.out.println("no such element found");
		}
	}

	// to to remove element at given position
	void RemovingAnItemOnLocation(int location) {
		int i;
		for (i = location - 1; i < actualSize - 1; i++) {
			array[i] = array[i + 1];
		}
		actualSize--;
	}

	// to remove given element
	void RemoveGivenItem(int item) {
		int i, count = 0;
		for (i = 0; i < actualSize; i++) {
			if (array[i] != item) {
				count++;

			} else {
				break;
			}

		}
		if (count < actualSize) {
			for (i = count; i < actualSize - 1; i++) {
				array[i] = array[i + 1];
			}
			actualSize--;
		} else {
			System.out.println("no such element found");
		}

	}

	// to clear array
	void ClearTheList() {
		array = null;
		actualSize = 0;
	}

	// to reverse array
	void ReverseTheArray() {
		int i;
		int[] tempArray = new int[actualSize];
		int count = 0;
		print();
		for (i = 0; i < actualSize; i++) {
			tempArray[i] = array[actualSize - 1 - i];
		}
		array = tempArray;
		System.out.println("reversed array is");
		print();
	}

	// to sort array
	void SortArray() {
		int temp;
		for (int i = 0; i < actualSize - 1; i++) {
			for (int j = 0; j < actualSize - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println("sorteded array is");
		print();
	}

	// to print array
	void print() {
		int i;

		for (i = 0; i < actualSize; i++) {
			System.out.println(array[i]);
		}
	}

	// to add another array
	void AddArray() {
		int[] array2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int count = 0;
		array = Arrays.copyOf(array, (array.length) + (array2.length));
		for (int i = actualSize; i < array.length; i++) {
			array[i] = array2[count];
			count++;
		}
		actualSize = array.length;
		print();
	}
}
