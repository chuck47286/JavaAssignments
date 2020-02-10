package predictive;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * The class is to the class Sigs2WordsProto.
 *
 * @author YuCheng
 * @version 2020-2-10
 */
public class Sigs2WordsProtoTest {
    PredictivePrototype pp;
    @Before
    public void setUp() throws Exception {
        pp = new PredictivePrototype();
    }

    @Test
    public void main() {
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