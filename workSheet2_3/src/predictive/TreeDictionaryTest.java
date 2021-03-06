package predictive;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

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
        td = new TreeDictionary("/usr/share/dict/words");
//        td = new TreeDictionary("C:\\Users\\Administrator.PC-20190121EABW\\IdeaProjects\\JavaAssignments\\src\\predictive\\words");
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
        exp.add("ecy");
        exp.add("daw");
        exp.add("daz");
        exp.add("fax");
        exp.add("faw");
        exp.add("day");
        exp.add("ecz");
        exp.add("fcy");
        exp.add("fay");
        exp.add("faz");
        assertEquals(exp, actual);
    }
}