import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class hanoiTest {
	
	hanoi obj=new hanoi();

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
	public void test() {                                              //test for 1 disk
		
		        String a=obj.towerofhanoi(1,"A","B","C");
				String b="move 1 from A to C,";
				assertEquals(b,a);
	}

	@Test
	public void test1() {                                                //test for 2 disk
		
		    String a=obj.towerofhanoi(2,"A","B","C");
			String b="move 1 from A to B,move 2 from A to C,move 1 from B to C,";
			assertEquals(b,a);
		
	}

	@Test
	public void test2() {                                                    //test for 3 disk
		
		    String a=obj.towerofhanoi(3,"A","B","C");
			String b="move 1 from A to C,move 2 from A to B,move 1 from C to B,move 3 from A to C,move 1 from B to A,move 2 from B to C,move 1 from A to C,";
			assertEquals(b,a);
		
	}

}
