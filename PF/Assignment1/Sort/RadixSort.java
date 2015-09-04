public class RadixSort {

	// for radix sort
	int[] radixSort(int[] array, int length, int noOfDigit) {

		int forQuotient = 0;
		while (noOfDigit != 0) {
			String[] store = new String[10];
			int quotient, position;

			// to extract digit and store accordingly in array store
			for (position = 0; position < length; position++) {
				int power = (int) Math.pow(10, forQuotient);
				quotient = array[position] / power;
				int digitSorted = quotient % 10;
				if (store[digitSorted] == null) {
					store[digitSorted] = array[position] + ",";
				} else {
					store[digitSorted] = store[digitSorted] + array[position]
							+ ",";
				}
			}

			// to re-arrange contents of array according to position
			int index = 0;
			for (position = 0; position < 10; position++) {
				if (store[position] != null) {
					String[] bucket = store[position].split(",");
					for (int j = 0; j < bucket.length; j++) {
						array[index] = Integer.parseInt(bucket[j]);
						index++;
					}
				}
			}
			noOfDigit--;
			forQuotient++;
		}
		return array;
	}
}
