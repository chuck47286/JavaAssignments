import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalariesTest {
    private Salaries sal1;
//    Salaries sal2;
//    Salaries sal3;
//    Salaries sal4;
//    Salaries sal5;

    @BeforeEach
    void setUp() {
        sal1 = new Salaries();
//        sal1.allSalaries = new ArrayList<double[]>();

        double[] employeeSalaries1;
        employeeSalaries1 = new double[12];
        employeeSalaries1[0] = 1000;
        employeeSalaries1[1] = 1000;
        employeeSalaries1[2] = 2000;
        employeeSalaries1[3] = 2000;
        sal1.add(employeeSalaries1);

//        sal2 = new Salaries();
//        sal2.allSalaries = new ArrayList<double[]>();
        double[] employeeSalaries2 = new double[12];
        employeeSalaries2[0] = 1000;
        employeeSalaries2[1] = 1000;
        employeeSalaries2[2] = 1000;
        sal1.add(employeeSalaries2);
//        sal3 = new Salaries();
//        sal3.allSalaries = new ArrayList<double[]>();
        double[] employeeSalaries3 = new double[12];
        employeeSalaries3[0] = 1000;
        employeeSalaries3[1] = 2000;
        employeeSalaries3[2] = 2000;
        employeeSalaries3[3] = 2000;
        sal1.add(employeeSalaries3);

//        sal4 = new Salaries();
//        sal4.allSalaries = new ArrayList<double[]>();
        double[] employeeSalaries4 = new double[12];
        employeeSalaries4[0] = 1000;
        employeeSalaries4[1] = 1500;
        employeeSalaries4[2] = 2000;
        employeeSalaries4[3] = 2000;
        sal1.add(employeeSalaries4);

//        sal5 = new Salaries();
//        sal5.allSalaries = new ArrayList<double[]>();
        double[] employeeSalaries5 = new double[12];
        employeeSalaries5[0] = 103;
        employeeSalaries5[1] = 1500;
        employeeSalaries5[2] = 2000;
        employeeSalaries5[3] = 2000;
        sal1.add(employeeSalaries5);
    }

    @Test
    void average1() {
        double[] Salary = { 1000, 1000, 2000, 2000, 0, 0, 0, 0, 0, 0, 0, 0 };
        double expected = 1500.0;
        sal1.add(Salary);
        double actual = sal1.average(Salary);
        assertEquals(expected,actual,"Error");
    }
    @Test
    void average2() {
        double[] Salary = { 1000, 1000, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        double expected = 1000.0;
        double actual = sal1.average(Salary);
        assertEquals(expected,actual,"Error");
    }
    @Test
    void average3() {
        double[] Salary = { 1000, 2000, 2000, 2000, 0, 0, 0, 0, 0, 0, 0, 0 };
        double expected = 1750.0;
        double actual = sal1.average(Salary);
        assertEquals(expected,actual,"Error");
    }
    @Test
    void average4() {
        double[] Salary = { 1000, 1500, 2000, 2000, 0, 0, 0, 0, 0, 0, 0, 0 };
        double expected = 1625.0;
        double actual = sal1.average(Salary);
        assertEquals(expected,actual,"Error");
    }
    @Test
    void average5() {
        double[] Salary = { 103, 1500, 2000, 2000, 0, 0, 0, 0, 0, 0, 0, 0 };
        double expected = 1400.75;
        double actual = sal1.average(Salary);
        assertEquals(expected,actual,"Error");
    }


    @Test
    void averageSalaries() {
        ArrayList<Double> expected = new ArrayList<>();
        expected.add(1500.0);
        expected.add(1000.0);
        expected.add(1750.0);
        expected.add(1625.0);
        expected.add(1400.75);
        ArrayList<Double> actual = sal1.averageSalaries();
        assertEquals(expected,actual);
    }

    @Test
    void not3TimesHigher() {
        boolean expected = true;
        boolean actual = sal1.not3TimesHigher();
        assertEquals(expected,actual);
    }
}