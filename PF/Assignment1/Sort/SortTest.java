import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//test class
public class SortTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// test bubble sort for normal values
	@Test
	public void NormalBubbleSortTest() {
		BubbleSort bubble = new BubbleSort();
		int[] array = { 45, 87, 54, 9, 0 };
		int[] result = { 0, 9, 45, 54, 87 };
		assertArrayEquals(result, bubble.bubbleSort(array, 5));
	}

	// test bubble sort for duplicate values
	@Test
	public void DuplicateBubbleSortTest() {
		BubbleSort bubble = new BubbleSort();
		int[] array = { 45, 87, 54, 9, 0, 9 };
		int[] result = { 0, 9, 9, 45, 54, 87 };
		assertArrayEquals(result, bubble.bubbleSort(array, 6));
	}

	// test bubble sort for negative values
	@Test
	public void NegativeBubbleSortTest() {
		BubbleSort bubble = new BubbleSort();
		int[] array = { 45, 87, 54, -9, 0, 9 };
		int[] result = { -9, 0, 9, 45, 54, 87 };
		assertArrayEquals(result, bubble.bubbleSort(array, 6));
	}

	// test quick sort for normal values
	@Test
	public void NormalQuickSortTest() {
		QuickSort quick = new QuickSort();
		int[] array = { 45, 87, 54, 9, 0 };
		int[] result = { 0, 9, 45, 54, 87 };
		assertArrayEquals(result, quick.quickSort(array, 0, 4));
	}

	// test quick sort for duplicate values
	@Test
	public void DuplicateQuickSortTest() {
		QuickSort quick = new QuickSort();
		int[] array = { 45, 87, 54, 9, 0, 9 };
		int[] result = { 0, 9, 9, 45, 54, 87 };
		assertArrayEquals(result, quick.quickSort(array, 0, 5));
	}

	// test quick sort for negative values
	@Test
	public void NegativeQuickSortTest() {
		QuickSort quick = new QuickSort();
		int[] array = { 45, 87, 54, -9, 0, 9 };
		int[] result = { -9, 0, 9, 45, 54, 87 };
		assertArrayEquals(result, quick.quickSort(array, 0, 5));
	}

	// test counting sort for normal values
	@Test
	public void NormalCountingSortTest() {
		CountingSort counting = new CountingSort();
		int[] array = { 45, 87, 54, 9, 0 };
		int[] result = { 0, 9, 45, 54, 87 };
		assertArrayEquals(result, counting.countingSort(array, 5, 87));
	}

	// test counting sort for duplicate values
	@Test
	public void DuplicateCountingSortTest() {
		CountingSort counting = new CountingSort();
		int[] array = { 45, 87, 54, 9, 0, 9 };
		int[] result = { 0, 9, 9, 45, 54, 87 };
		assertArrayEquals(result, counting.countingSort(array, 6, 87));
	}

	// test radix sort for normal values
	@Test
	public void NormalRadixSortTest() {
		RadixSort raddix = new RadixSort();
		int[] array = { 45, 870, 54, 9, 0 };
		int[] result = { 0, 9, 45, 54, 870 };
		assertArrayEquals(result, raddix.radixSort(array, 5, 3));
	}

	// test radix sort for duplicate values
	@Test
	public void DuplicateRadixSortTest() {
		RadixSort raddix = new RadixSort();
		int[] array = { 45, 8700, 54, 9, 0, 9 };
		int[] result = { 0, 9, 9, 45, 54, 8700 };
		assertArrayEquals(result, raddix.radixSort(array, 6, 4));
	}

}
