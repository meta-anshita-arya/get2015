public class BubbleSort {

	// for bubble sort
	int[] bubbleSort(int[] array, int length) {
		int forSwap = 0;
		for (int position = 0; position < length; position++) {
			for (int index = 1; index < (length - position); index++) {

				if (array[index - 1] > array[index]) {
					// swap the elements!
					forSwap = array[index - 1];
					array[index - 1] = array[index];
					array[index] = forSwap;
				}

			}
		}
		return array;
	}
}
