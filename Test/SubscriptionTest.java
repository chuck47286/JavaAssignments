import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YuCheng
 * @version 2019-11-05
 */
class SubscriptionTest {
    private Subscription subscription1;
    @BeforeEach
    void setUp() {
        subscription1 = new Subscription("IEEE", "xxx@science.ac", 20);
    }

    @Test
    void getTitle() {
        String expected = "IEEE";
        String actual = subscription1.getTitle();
        assertEquals(expected,actual);
    }

    @Test
    void getEmail() {
        String expected = "xxx@science.ac";
        String actual = subscription1.getEmail();
        assertEquals(expected,actual);
    }

    @Test
    void getCost() {
        int expected = 10;
        int actual = subscription1.getCost();
        assertEquals(expected,actual);
    }

    @Test
    void testToString() {
        String expected = "Subscription includes title= IEEE, email= xxx@science.ac, cost= 10.";
        String actual = subscription1.toString();
        assertEquals(expected,actual);
    }
}