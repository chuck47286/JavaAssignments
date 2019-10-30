import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexandros Evangelidis
 * @version 2019-10-28
 */

public class SalariesTests {
	public static final double TOLERANCE = 0.0000000001;
	private Salaries salaries;

	@BeforeEach
	public void init() {
		salaries = new Salaries();
		double[] johnSalary = { 1000, 1000, 2000, 2000, 0, 0, 0, 0, 0, 0, 0, 0 };
		double[] marySalary = { 1000, 1000, 2000, 2000, 1320, 2110, 1350, 1400, 1600, 2200, 1100, 1450 };
		double[] jackSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1400 };
		double[] anneSalary = { 0, 1000, 0, 2000, 0, 2110, 1350, 1400, 0, 0, 0, 0 };
		salaries.add(johnSalary);
		salaries.add(marySalary);
		salaries.add(jackSalary);
		salaries.add(anneSalary);
	}

	@Test
	public void test1() {
		double[] johnSalary = { 1000, 1000, 2000, 2000, 0, 0, 0, 0, 0, 0, 0, 0 };
		double expectedAverage = 1500.;
		double actualAverage = Salaries.average(johnSalary);
		assertEquals(expectedAverage, actualAverage, TOLERANCE);
	}

	@Test
	public void test2() {
		double[] marySalary = { 1000, 1000, 2000, 2000, 1320, 2110, 1350, 1400, 1600, 2200, 1100, 1450 };
		double expectedAverage = 1544.1666666666;
		double actualAverage = Salaries.average(marySalary);
		assertEquals(expectedAverage, actualAverage, TOLERANCE);
	}

	@Test
	public void test3() {
		double[] jackSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1400 };
		double expectedAverage = 1400;
		double actualAverage = Salaries.average(jackSalary);
		assertEquals(expectedAverage, actualAverage, TOLERANCE);
	}

	@Test
	public void test4() {
		double[] anneSalary = { 0, 1000, 0, 2000, 0, 2110, 1350, 1400, 0, 0, 0, 0 };
		double expectedAverage = 1572.;
		double actualAverage = Salaries.average(anneSalary);
		assertEquals(expectedAverage, actualAverage, TOLERANCE);
	}

	@Test
	public void test5() {
		double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		assertThrows(IllegalArgumentException.class, () -> {
			Salaries.average(noSalary);
		});
	}

	@Test
	public void test6() {

		ArrayList<Double> expectedAverageSalaries = new ArrayList<>();
		expectedAverageSalaries.add(1500.0);
		expectedAverageSalaries.add(1544.1666666666);
		expectedAverageSalaries.add(1400.0);
		expectedAverageSalaries.add(1572.);
		ArrayList<Double> actualAverageSalaries = salaries.averageSalaries();

		for (int i = 0; i < actualAverageSalaries.size(); i++) {
			assertEquals(expectedAverageSalaries.get(i), actualAverageSalaries.get(i), TOLERANCE);
		}
	}

	@Test
	public void test7() {
		double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		ArrayList<Double> expectedAverageSalaries = new ArrayList<>();
		expectedAverageSalaries.add(1500.0);
		expectedAverageSalaries.add(1544.1666666666);
		expectedAverageSalaries.add(1400.0);
		expectedAverageSalaries.add(1572.);
		expectedAverageSalaries.add(0.);
		salaries.add(noSalary);
		ArrayList<Double> actualAverageSalaries = salaries.averageSalaries();

		for (int i = 0; i < actualAverageSalaries.size(); i++) {
			assertEquals(expectedAverageSalaries.get(i), actualAverageSalaries.get(i), TOLERANCE);

		}
	}

	@Test
	public void test8() {
		double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		double[] timSalary = { 2500, 1542, 1345, 2415, 1246, 1876, 0, 0, 0, 0, 0, 0 };
		ArrayList<Double> expectedAverageSalaries = new ArrayList<>();
		expectedAverageSalaries.add(1500.0);
		expectedAverageSalaries.add(1544.1666666666);
		expectedAverageSalaries.add(1400.0);
		expectedAverageSalaries.add(1572.);
		expectedAverageSalaries.add(1820.666666666666);

		salaries.add(noSalary);
		salaries.add(timSalary);
		ArrayList<Double> actualAverageSalaries = salaries.averageSalaries();

		for (int i = 0; i < actualAverageSalaries.size(); i++) {
			assertEquals(expectedAverageSalaries.get(i), actualAverageSalaries.get(i), TOLERANCE);

		}
	}

	@Test
	public void test9() {
		double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		double[] timSalary = { 2500, 1542, 1345, 2415, 1246, 1876, 0, 0, 0, 0, 0, 0 };
		salaries.add(noSalary);
		salaries.add(timSalary);
		assertTrue(salaries.not3TimesHigher());
	}

	@Test
	public void test10() {
		double[] nickySalary = { 100000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		salaries.add(nickySalary);
		assertFalse(salaries.not3TimesHigher());
	}

	@Test
	public void test11() {
		double[] nickySalary = { 1000, 2200, 3300, 4200, 0, 0, 0, 0, 0, 0, 0, 0 };
		salaries.add(nickySalary);
		assertTrue(salaries.not3TimesHigher());
	}

	@Test
	public void test12() {
		double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Salaries salaries2 = new Salaries();
		salaries2.add(noSalary);
		assertTrue(salaries2.not3TimesHigher());
	}
	
	@Test
	public void test13() {
		double[] johnSalary = { 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Salaries salaries2 = new Salaries();
		salaries2.add(johnSalary);
		assertTrue(salaries2.not3TimesHigher());
	}
}
