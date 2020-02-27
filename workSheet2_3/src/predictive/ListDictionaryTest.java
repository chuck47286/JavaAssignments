package predictive;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * The class is to test the class ListDictionary.
 *
 * @author YuCheng
 * @version 2020-2-10
 */
public class ListDictionaryTest {
    ListDictionary ld;
    @Before
    public void setUp() throws Exception {
        ld = new ListDictionary("/usr/share/dict/words");
    }

    @Test
    public void wordToSignature() {
        String actual = ld.wordToSignature("home");
        String exp = "4663";
        assertEquals(actual, exp);
    }

    @Test
    public void signatureToWords() {
        Set<String> actual = ld.signatureToWords("329");
        Set<String> exp = new HashSet<>();
        exp.add("dbw");
        exp.add("dax");
        exp.add("daw");
        exp.add("fax");
        exp.add("day");
        exp.add("fcy");
        exp.add("fay");
        assertEquals(exp, actual);
    }


}