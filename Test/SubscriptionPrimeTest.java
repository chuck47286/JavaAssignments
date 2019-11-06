import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YuCheng
 * @version 2019-11-05
 */
class SubscriptionPrimeTest {
    private SubscriptionPrime subscriptionPrime1;
    @BeforeEach
    void setUp() {
        subscriptionPrime1 = new SubscriptionPrime(
                "Science", "xxx@science.ac", 20, "home");
    }

    @Test
    void getAddress() {
        String expected = "home";
        String actual = subscriptionPrime1.getAddress();
        assertEquals(expected,actual);
    }

    @Test
    void getTitle() {
        String expected = "Science";
        String actual = subscriptionPrime1.getTitle();
        assertEquals(expected,actual);
    }

    @Test
    void getEmail() {
        String expected = "xxx@science.ac";
        String actual = subscriptionPrime1.getEmail();
        assertEquals(expected,actual);
    }

    @Test
    void getCost() {
        double expected = 20;
        double actual = subscriptionPrime1.getCost();
        assertEquals(expected,actual);
    }

    @Test
    void testToString() {
        String expected = "SubscriptionPrime includes" +
                " title= " + subscriptionPrime1.getTitle()  +
                ", email= " + subscriptionPrime1.getEmail() +
                ", cost= " + subscriptionPrime1.getCost() +
                ", deliveryAddress= " + subscriptionPrime1.getAddress()  +
                ".";
        String actual = subscriptionPrime1.toString();
        assertEquals(expected,actual);
    }
}