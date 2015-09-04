public class LinearSort {

	// to decide whether to go for radix sort or counting sort
	int[] linearsorting(int[] array, int length) {
		int max = 0;
		for (int position = 0; position < length; position++) {
			if (array[position] > max) {
				max = array[position];
			}
		}
		int noofdigit = 1;
		int forCount = max;
		while (forCount / 10 != 0) {
			noofdigit++;
			forCount = forCount / 10;
		}
		if (noofdigit > 2) {// in number of digit greater than 2 opt radix sort
							// else counting sort
			RadixSort raddix = new RadixSort();
			array = raddix.radixSort(array, length, noofdigit);
		} else {
			CountingSort counting = new CountingSort();
			array = counting.countingSort(array, length, max);
		}
		return array;
	}
}
