import java.util.Random;

/**
 * The class is it to generate n randomly value typed double in the range between a and b. If a is greater than b or n is not positive,
 * method should throw an IllegalArgumentException.
 *
 * @author YuCheng
 * @version 2020/5/21 14:18
 */
public class Computation {
    public static double[] generateTestValues(int n, double a, double b) {
        double[] res = new double[n];
        if (n < 0 || a > b) throw new IllegalArgumentException();
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            res[i] = a + random.nextDouble() * (b - a);
        }
        return res;
    }
    public static void main(String[] args) {
        double[] generateTestValues1 = generateTestValues(10, 1.0, 9.0);
        for (double value : generateTestValues1) {
            System.out.print(value + "\t");
        }
        System.out.println();

        double[] generateTestValues2 = generateTestValues(10, 1.1, 1.1);
        for (double value : generateTestValues2) {
            System.out.print(value + "\t");
        }
        System.out.println();

        double[] generateTestValues3 = generateTestValues(0, 1.0, 9.0);
        for (double value : generateTestValues3) {
            System.out.print(value + "\t");
        }
        System.out.println();

        double[] generateTestValues4 = generateTestValues(10, 11.0, 9.0);
        for (double value : generateTestValues4) {
            System.out.print(value + "\t");
        }

    }
}
