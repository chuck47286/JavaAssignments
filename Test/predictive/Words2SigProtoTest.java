package predictive;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The class to test the class Words2SigProto.
 *
 * @author YuCheng
 * @version 2020-2-10
 */
public class Words2SigProtoTest {
    PredictivePrototype pp;
    @Before
    public void setUp() throws Exception {
        pp = new PredictivePrototype();
    }

    @Test
    public void main() {
        String actual = PredictivePrototype.wordToSignature("home");
        String exp = "4663";
        assertEquals(exp, actual);
    }
}