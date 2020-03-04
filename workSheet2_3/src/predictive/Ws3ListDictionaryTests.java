package predictive;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.BeforeClass;
import org.junit.Test;
/**
 * 
 * @author Alexandros Evangelidis
 *
 */

public class Ws3ListDictionaryTests {

	private static ListDictionary ld;
	
	@BeforeClass
	public static void setUp() throws FileNotFoundException, IOException {
		ld  = new ListDictionary("C:\\Users\\Administrator.PC-20190121EABW\\IdeaProjects\\JavaAssignments\\workSheet2_3\\src\\predictive\\words");
	}

	

	//Ex2 Test 1: Testing the signatureToWords when called with an empty signature.
	//Exception thrown also correct
	@Test
	public void ex2Test1() {
	
	
		Set<String> expected = new TreeSet<String>();
		
		Set<String> result = ld.signatureToWords("");
						
		assertEquals(expected, result);

	}
	
	//Ex2 Test 2: Testing the signatureToWords when called with 4663 as signature.
	//Expected: the correct set of words] [FULL MARKS]
	@Test
	public void ex2Test2() {
		

		Set<String> expected = new HashSet<String>();
	     
	     expected.add("good");
	     expected.add("gone");
	     expected.add("home");
	     expected.add("hone");
	     expected.add("hood");
	     expected.add("hoof");
	     expected.add("ioof");
	     expected.add("ione");
	     expected.add("inne");
	     expected.add("gome");
	     expected.add("gond");
	     expected.add("hond");
	     expected.add("goof");
		
		
	     Set<String> result = ld.signatureToWords("4663");
		
		assertEquals(expected, result);
	}
	
	
	//Testing the signatureToWords when called with 843 as signature.
	//Expected: the correct set of words] [FULL MARKS]
	@Test
	public void ex2Test3() {


		Set<String> expected = new HashSet<String>();

	     expected.add("thd");
	     expected.add("the");
	     expected.add("tid");
	     expected.add("tie");
	     expected.add("uhf");
	     expected.add("uid");
	     expected.add("vgf");
	     expected.add("vhd");
	     expected.add("vhf");
	     expected.add("vie");
	
		
	    Set<String> result = ld.signatureToWords("843");
		
	    assertEquals(expected, result);

	}
	
	
	//Testing the signatureToWords when called with 329 as signature.
	@Test
	public void ex2Test4() {
	

		Set<String> expected = new HashSet<String>();

	     expected.add("daw");
	     expected.add("dax");
	     expected.add("day");
	     expected.add("dbw");
	     expected.add("fax");
	     expected.add("fay");
	     expected.add("fcy");
	 
	   
	    Set<String> result = ld.signatureToWords("329");
		
	    assertEquals(expected, result);
		
	}

	//Testing the signatureToWords when called with 999999999 as signature
	//Exception thrown is fine as well.
	@Test
	public void ex2Test5() {
		
		Set<String> expected = new TreeSet<String>();
		
	    Set<String> result = ld.signatureToWords("999999999");
		
	    assertEquals(expected, result);

	}
	
	// Testing the signatureToWords with the largest signature. 
	@Test
	public void ex2Test6() {
	
		Set<String> expected = new TreeSet<String>();
		
		expected.add("pneumonoultramicroscopicsilicovolcanoconiosis");
		
	    Set<String> result = ld.signatureToWords("763866668587264276726742745426865226626646747");
		
	    assertEquals(expected, result);

	}
	
}

