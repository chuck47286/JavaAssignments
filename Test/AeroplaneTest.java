import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YuCheng
 * @version 2019-11-05
 */
class AeroplaneTest {
    private Aeroplane aeroplane1;
    @BeforeEach
    void setUp() {
        aeroplane1 = new Aeroplane(180, 780, 100);
    }

    @Test
    void setPassengerNumber() {
        int expected = 880;
        aeroplane1.setPassengerNumber(880);
        assertEquals(expected, aeroplane1.getPassengerNumber());
    }

    @Test
    void setMaxSpeed() {
        int expedted = 190;
        aeroplane1.setMaxSpeed(190);
        assertEquals(expedted, aeroplane1.getMaxSpeed());
    }

    @Test
    void getPassengerNumber() {
        int expected = 180;
        int actual = aeroplane1.getPassengerNumber();
        assertEquals(expected,actual);
    }

    @Test
    void getMaxSpeed() {
        int expected = 780;
        int actual = aeroplane1.getMaxSpeed();
        assertEquals(expected,actual);
    }

    @Test
    void getFuelConsumption() {
        double expected = 100;
        double actual = aeroplane1.getFuelConsumption();
        assertEquals(expected,actual);
    }

    @Test
    void setFuelConsumption() {
        double expected = 120;
        aeroplane1.setFuelConsumption(120);
        assertEquals(expected, aeroplane1.getFuelConsumption());
    }

    @Test
    void testToString() {
        String expected = "Aeroplane has fuelConsumption= 100.0, and Aircraft has " +
                "passengerNumber= 180, maxSpeed= 780";
        String actual = aeroplane1.toString();
        assertEquals(expected,actual);
    }
}