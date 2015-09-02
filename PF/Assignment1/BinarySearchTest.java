import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//test case class
public class BinarySearchTest {
	BinarySearch object = new BinarySearch();

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

	@Test
	// to test For Array With Identical Numbers
	public void testForArrayWithIdenticalNumbers() {

		int[] arr = { 1, 1, 1, 1, 1 };
		int num = 1;
		int index = object.binarySearch(num, 0, 4, arr);
		int left = object.leftmostOccurance(arr, index);
		int right = object.rightmostOccurance(arr, index);
		assertEquals(2, index);
		assertEquals(0, left);
		assertEquals(4, right);
	}

	@Test
	// to test for Number Not Found
	public void testNumberNotFound() {
		int[] arr = { 1, 1, 1, 1, 1 };
		int num = 2;
		int index = object.binarySearch(num, 0, 4, arr);
		assertEquals(-1, index);
	}

	@Test
	// to test for empty array
	public void testEmptyArray() {
		int[] arr = new int[5];
		int index = object.binarySearch(5, 0, 4, arr);
		assertEquals(-1, index);
	}

	@Test
	// negative test
	public void NegativeTest() {
		int[] arr = { 1, 1, 1, 1, 1 };
		int num = 1;
		int index = object.binarySearch(num, 0, 4, arr);
		int left = object.leftmostOccurance(arr, index);
		int right = object.rightmostOccurance(arr, index);
		assertNotEquals(3, index);
		assertNotEquals(4, left);
		assertNotEquals(1, right);
	}

}
