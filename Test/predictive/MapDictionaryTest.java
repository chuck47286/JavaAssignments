package predictive;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * The class is to test the class MapDictionary.
 *
 * @author YuCheng
 * @version 2020-2-10
 */
public class MapDictionaryTest {
    MapDictionary md;
    @Before
    public void setUp() throws Exception {
        md = new MapDictionary();
    }

    @Test
    public void signatureToWords() {
        Set<String> actual = md.signatureToWords("329");
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

    @Test
    public void wordToSignature() {
        String actual = md.wordToSignature("home");
        String exp = "4663";
        assertEquals(actual, exp);
    }
}