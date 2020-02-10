package predictive;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * The class
 *
 * @author YuCheng
 * @version 2020-2-10
 */
public class PredictivePrototypeTest {
    PredictivePrototype pp1;
    @Before
    public void setUp() throws Exception {
        pp1 = new PredictivePrototype();
    }

    @Test
    public void wordToSignature() {
        String actual = PredictivePrototype.wordToSignature("home");
        String exp = "4663";
        assertEquals(exp, actual);
    }

    @Test
    public void signatureToWords() {
        Set<String> actual = PredictivePrototype.signatureToWords("329");
        Set<String> exp = new HashSet<>();
//        [dbw, dax, daw, fax, day, fcy, fay]
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