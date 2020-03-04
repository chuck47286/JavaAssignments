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

public class Ws3TreeDictionaryTests {

	private static Dictionary td;

	@BeforeClass
	public static void setUp() throws FileNotFoundException, IOException {
		td = new TreeDictionary("C:\\Users\\Administrator.PC-20190121EABW\\IdeaProjects\\JavaAssignments\\workSheet2_3\\src\\predictive\\words");
	}

	// Ex4 Test 1: Testing the signatureToWords when called with a non-numerical
	// signature. Throwing an exception is fine here.
	@Test
	public void ex4Test1() {

		Set<String> expected = new TreeSet<String>();
		Set<String> result = td.signatureToWords("words");

		assertEquals(expected, result);

	}

	// Ex4 Test 2: Testing the signatureToWords when called with 4663 as signature.
	@Test
	public void ex4Test2() {

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
		expected.add("gnof");
		expected.add("imme");
		expected.add("inme");
		expected.add("inod");
		expected.add("inof");
		expected.add("inoe");
		expected.add("hooe");
		expected.add("gooe");
		expected.add("gonf");
		expected.add("honf");

		Set<String> result = td.signatureToWords("4663");

		assertEquals(expected, result);

	}

	// Ex4 Test 3: Testing the signatureToWords when called with 843 as signature.
	@Test
	public void ex4Test3() {

		Set<String> expected = new TreeSet<String>();
		expected.add("thd");
		expected.add("the");
		expected.add("tid");
		expected.add("tie");
		expected.add("tif");
		expected.add("uhd");
		expected.add("uhf");
		expected.add("uid");
		expected.add("vgf");
		expected.add("vhd");
		expected.add("vhf");
		expected.add("vid");
		expected.add("vie");
		expected.add("vif");

		Set<String> result = td.signatureToWords("843");

		assertEquals(expected, result);
	}

	// Ex4 Test 4: Testing the signatureToWords when called with 329 as signature.
	@Test
	public void ex4Test4() {

		Set<String> expected = new HashSet<String>();

		expected.add("daw");
		expected.add("dax");
		expected.add("day");
		expected.add("daz");
		expected.add("dbw");
		expected.add("ecy");
		expected.add("ecz");
		expected.add("faw");
		expected.add("fax");
		expected.add("fay");
		expected.add("faz");
		expected.add("fcy");

		Set<String> result = td.signatureToWords("329");

		assertEquals(expected, result);

	}

	// Ex4 Test 5: Testing the signatureToWords when called with 999999999 as
	// signature.
	@Test
	public void ex4Test5() {
		Set<String> expected = new TreeSet<String>();
		Set<String> result = td.signatureToWords("999999999");

		assertEquals(expected, result);

	}

	// Ex4 Test 6: Testing the signatureToWords with the largest signature.
	@Test
	public void ex4Test6() {

		Set<String> expected = new TreeSet<String>();

		expected.add("pneumonoultramicroscopicsilicovolcanoconiosis");

		Set<String> result = td.signatureToWords("763866668587264276726742745426865226626646747");

		assertEquals(expected, result);

	}

	// Ex4 Test 7: Testing the signatureToWords when called with 222 as signature.
	@Test
	public void ex4Test7() {

		Set<String> expected = new TreeSet<String>();

		expected.add("aaa");
		expected.add("aab");
		expected.add("aac");
		expected.add("aba");
		expected.add("abb");
		expected.add("abc");
		expected.add("aca");
		expected.add("acb");
		expected.add("acc");
		expected.add("baa");
		expected.add("bab");
		expected.add("bac");
		expected.add("bba");
		expected.add("bbb");
		expected.add("bbc");
		expected.add("bcb");
		expected.add("bcc");
		expected.add("caa");
		expected.add("cab");
		expected.add("cac");
		expected.add("cbc");
		expected.add("cca");
		expected.add("ccc");

		Set<String> result = td.signatureToWords("222");

		assertEquals(expected, result);

	}

	//Ex4 " + "Test 8: Testing the signatureToWords when called with 56332 as signature.
	//(This signature would have returned the empty set if called with one of the other classes)
	@Test
	public void ex4Test8() {

		Set<String> expected = new TreeSet<String>();

		expected.add("jodea");
		expected.add("kneeb");
		expected.add("kneec");

		Set<String> result = td.signatureToWords("56332");

		assertEquals(expected, result);

	}





}
