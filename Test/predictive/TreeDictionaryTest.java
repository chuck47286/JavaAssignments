package predictive;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * The class is to test the method of class TreeDictionary.
 *
 * @author YuCheng
 * @version 2020-2-10
 */
public class TreeDictionaryTest {
    TreeDictionary td;
    @Before
    public void setUp() throws Exception {
        td = new TreeDictionary();
    }

    @Test
    public void wordToSignature() {
        String actual = td.wordToSignature("home");
        String exp = "4663";
        assertEquals(actual,exp);
    }

    @Test
    public void signatureToWords() {
        Set<String> actual = td.signatureToWords("329");
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