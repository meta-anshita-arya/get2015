import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class permutationTest {
	
	permutation obj=new permutation();

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
	public void test() {                                                 //test for "ABC"
		
		        String a=obj.generatePermutations("","ABC");
				String b=" ABC ACB BAC BCA CAB CBA";
				assertEquals(b,a);
	}

	@Test
	public void test1() {                                                    //test for "ABCD"
		
		    String a=obj.generatePermutations("","ABCD");
			String b=" ABCD ABDC ACBD ACDB ADBC ADCB BACD BADC BCAD BCDA BDAC BDCA CABD CADB CBAD CBDA CDAB CDBA DABC DACB DBAC DBCA DCAB DCBA";
			assertEquals(b,a);
		
	}

}
