package predictive;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * The class is to test the class WordSig.
 *
 * @author YuCheng
 * @version 2020-2-10
 */
public class WordSigTest {
    WordSig ws1;
    WordSig ws2;

    @Before
    public void setUp() throws Exception {
        ws1 = new WordSig("home", "4663");
        ws2 = new WordSig("day", "329");

    }

    @Test
    public void getWords() {
        String actual = ws1.getWords();
        String exp = "home";
        assertEquals(exp, actual);
    }

    @Test
    public void getSignature() {
        String actual = ws1.getSignature();
        String exp = "4663";
        assertEquals(exp, actual);
    }

    @Test
    public void compareTo() {
        int actual = ws1.compareTo(ws2);
        int exp = 1;
        assertEquals(actual, exp);
    }
}