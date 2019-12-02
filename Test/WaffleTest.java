import javafx.application.Application;
import javafx.application.HostServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.stream.ImageInputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The class is for the purpose of test.
 *
 * @version 2019-11-29
 * @author YuCheng
 */
class WaffleTest {
    Waffle waffle;
    @BeforeEach
    void setUp() {
        waffle = new Waffle();

    }

    @Test
    void start() {

        Expenditure[] expenditures = new Expenditure[]{
                new Expenditure("Salaries", 11000),
                new Expenditure("Paper", 2000),
                new Expenditure("Rent", 5000),
                new Expenditure(
                        "Most popular books on Java etc.",
                        10000),
                new Expenditure("Heating", 3000),
                new Expenditure("Coffee/Tea", 7000),
                new Expenditure("Biscuits", 8000),
                new Expenditure("Travel", 18000),
                new Expenditure("Electricity", 1000),
                new Expenditure("Pencils", 3000)
        };
        int maximum = 8;
        Application.launch(waffle.getClass());
    }
}