package predictive;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * The class Sigs2WordsTreeTest is to test the class Sigs2WordsTree.
 *
 * @author YuCheng
 * @version 2020-2-10
 */
public class Sigs2WordsTreeTest {
    TreeDictionary td;
    @Before
    public void setUp() throws Exception {
        td = new TreeDictionary("/usr/share/dict/words");
    }

    @Test
    public void main() {
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