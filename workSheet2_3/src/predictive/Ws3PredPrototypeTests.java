package predictive;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * 
 * @author Alexandros Evangelidis
 *
 */

public class Ws3PredPrototypeTests {

	// Testing the empty string
	// Exception thrown also correct
	@Test
	public void ex1Test1() {

		String expected = "";

		String result = PredictivePrototype.wordToSignature("");

		assertEquals(expected, result);

	}

	// Testing the wordToSignature when called with home as word.
	@Test
	public void ex1Test2() {

		String expected = "4663";

		String result = PredictivePrototype.wordToSignature("home");

		assertEquals(expected, result);

	}

	// Testing the wordToSignature when called with hom-e.
	// Expected: 466 3
	@Test
	public void ex1Test3() {

		String expected = "466 3";

		String result = PredictivePrototype.wordToSignature("hom-e");
		assertEquals(expected, result);

	}

	// Testing the wordToSignature when called with hom22-e.
	// Expected: 466 3. (non-alpha chars have been replaced with spaces)
	@Test
	public void ex1Test4() {

		String expected = "466   3";

		String result = PredictivePrototype.wordToSignature("hom22-e");

		assertEquals(expected, result);

	}

	@Test
	public void ex1Test6() {

		Set<String> expected = Collections.emptySet();

		Set<String> input = PredictivePrototype.signatureToWords("");
		boolean result = expected.equals(input);

		assertTrue(result);

	}

	// Testing the signatreToWords when called with 4663 as signature
	@Test
	public void ex1Test7() {

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

		Set<String> result = PredictivePrototype.signatureToWords("4663");

		assertEquals(expected, result);
	}

	// Test 8: Testing the signatureToWords when called with 843 as signature
	@Test
	public void ex1Test8() {

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

		Set<String> result = PredictivePrototype.signatureToWords("843");

		assertEquals(expected, result);

	}

	// Testing the signatureToWords when called with 329 as signature.
	@Test
	public void ex1Test9() {

		Set<String> expected = new HashSet<String>();

		expected.add("daw");
		expected.add("dax");
		expected.add("day");
		expected.add("dbw");
		expected.add("fax");
		expected.add("fay");
		expected.add("fcy");

		Set<String> result = PredictivePrototype.signatureToWords("329");
		assertEquals(expected, result);

	}

	// Testing the signatureToWords when called with 999999999 as signature
	// Exception thrown also correct
	@Test
	public void ex1Test10() {

		Set<String> expected = new HashSet<String>();

		Set<String> result = PredictivePrototype.signatureToWords("999999999");

		assertEquals(expected, result);

	}

	// Testing the signatureToWords with the largest signature.
	@Test
	public void ex1Test11() {

		Set<String> expected = new HashSet<String>();

		expected.add("pneumonoultramicroscopicsilicovolcanoconiosis");

		Set<String> result = PredictivePrototype.signatureToWords("763866668587264276726742745426865226626646747");

		assertEquals(expected, result);

	}

	


	}


