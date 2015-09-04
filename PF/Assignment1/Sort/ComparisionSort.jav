public class ComparisionSort {

	// to decide whether to go for bubble sort or quick sort
	int[] comparisionSort(int[] array, int length) {
		// if length is less than or equal to 10, opt for bubble sort else quick
		// sort
		if (length <= 10) {
			BubbleSort bubble = new BubbleSort();
			array = bubble.bubbleSort(array, length);
		} else {
			QuickSort quick = new QuickSort();
			array = quick.quickSort(array, 0, length - 1);
		}
		return array;
	}
}
