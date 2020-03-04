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

public class Ws3MapDictionaryTests {

	private static Dictionary md;

	@BeforeClass
	public static void setUp() throws FileNotFoundException, IOException {
		md = new MapDictionary("C:\\Users\\Administrator.PC-20190121EABW\\IdeaProjects\\JavaAssignments\\workSheet2_3\\src\\predictive\\words");
	}

	// Ex3 Test 1: Testing the signatureToWords when called with 4663 as signature.
	@Test
	public void ex3Test1() {

		Set<String> expected = new TreeSet<String>();

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

		Set<String> result = md.signatureToWords("4663");

		assertEquals(expected, result);

	}

	//Ex3 Test 2: Testing the signatureToWords when called with 843 as signature.
	@Test
	public void ex3Test2() {

		Set<String> expected = new TreeSet<String>();

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

		Set<String> result = md.signatureToWords("843");

		assertEquals(expected, result);

	}

	//Ex3 Test 3: Testing the signatureToWords when called with 329 as signature.
	@Test
	public void ex3Test3() {

		Set<String> expected = new HashSet<String>();

		expected.add("daw");
		expected.add("dax");
		expected.add("day");
		expected.add("dbw");
		expected.add("fax");
		expected.add("fay");
		expected.add("fcy");

		Set<String> result = md.signatureToWords("329");

		assertEquals(expected, result);

	}

	//Ex3 Test 4: Testing the signatureToWords when called with 999999999 as signature. 
	@Test
	public void ex3Test4() {
		
		Set<String> expected = new TreeSet<String>();

		Set<String> result = md.signatureToWords("999999999");

		assertEquals(expected, result);

	}

	//Ex3 Test 5: Testing the signatureToWords with the largest signature.  
	@Test
	public void ex3Test5() {

		Set<String> expected = new TreeSet<String>();
		expected.add("pneumonoultramicroscopicsilicovolcanoconiosis");

		Set<String> result = md.signatureToWords("763866668587264276726742745426865226626646747");

		assertEquals(expected, result);

	}


}
