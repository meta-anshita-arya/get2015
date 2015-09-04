public class CountingSort {

	// for counting sort
	int[] countingSort(int[] array, int arraylength, int max) {
		int position = 0;
		int[] sorted = new int[max + 1];
		// to store in desired buckets
		for (position = 0; position < arraylength; position++) {
			sorted[array[position]]++;
		}
		int index = 0;
		// to store elements in sorted manner
		for (position = 0; position <= max; position++) {
			int countOfElement = sorted[position];
			while (countOfElement != 0) {
				array[index] = position;
				countOfElement--;
				index++;
			}
		}
		return array;
	}
}
