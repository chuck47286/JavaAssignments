import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YuCheng
 * @version 2019-11-05
 */
class AircraftTest {
    private Aircraft aircraft1;
    @BeforeEach
    void setUp() {
        aircraft1 = new Aircraft(180,780);
    }

    @Test
    void setPassengerNumber() {
        int expected = 190;
        aircraft1.setPassengerNumber(190);
        assertEquals(expected, aircraft1.getPassengerNumber());
    }

    @Test
    void setMaxSpeed() {
        int expected = 880;
        aircraft1.setMaxSpeed(880);
        assertEquals(expected, aircraft1.getMaxSpeed());
    }

    @Test
    void getPassengerNumber() {
        int expected = 180;
        assertEquals(expected, aircraft1.getPassengerNumber());
    }

    @Test
    void getMaxSpeed() {
        int expected = 780;
        assertEquals(expected, aircraft1.getMaxSpeed());
    }

    @Test
    void testToString() {
        String expected = "Aircraft has passengerNumber= 180, maxSpeed= 780";
        String actual = aircraft1.toString();
        assertEquals(expected, actual);
    }
}