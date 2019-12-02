import javafx.application.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The class is for the purpose of test.
 *
 * @version 2019-11-29
 * @author YuCheng
 */
class PieTest {
    Pie pie;
    @BeforeEach
    void setUp() {
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
        Arrays.sort(expenditures, (Expenditure exp1, Expenditure exp2) ->
                exp2.getValue() - exp1.getValue());
        int maximum = 8;
        pie = new Pie(expenditures,maximum);

    }
    @Test
    void start() {
        Application.launch(pie.getClass());
    }
}