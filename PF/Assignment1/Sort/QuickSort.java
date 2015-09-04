
public class QuickSort {
	
	//for quick sort
	int[] quickSort(int array[], int start, int end) {
		int position, index, pivot, forSwap = 0;
		if (start <= end) {
			position = start;
			index = end;
			pivot = start; // Assigning pivot with start index of array
			while (position < index) {
				while (array[position] <= array[pivot] && position < end) {
					position++;
				}
				while (array[index] > array[pivot] && index >= start) {
					index--;
				}
				if (position < index) // Swapping values of i and j
				{
					forSwap = array[position];
					array[position] = array[index];
					array[index] = forSwap;
				}
			}
			forSwap = array[index]; // Swapping pivot with value of j when i and j cross
							// each other
			array[index] = array[pivot];
			array[pivot] = forSwap;
			quickSort(array, start, index - 1); // Recursive call
			quickSort(array, index + 1, end);
		}
		return array;
	}

}
