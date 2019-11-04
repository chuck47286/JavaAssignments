/**
 * A class Temperature without field variables, but has a static function
 * witch is to count the first coldest day of the common year.
 *
 * @version 2019-10-30
 * @author Yu Cheng
 */
public class Temperature {
    /**
     * Get the coldest day of the common year appeared at first time.
     * @param temperatures The degree of the each day in the common year.
     * @return The first coldest day of the year.
     */
    public static int coldest(double[] temperatures) {
        double coldest = Double.MAX_VALUE;
        int day = 0;
        for (int i = 0; i < temperatures.length; i++) {
            if (coldest > temperatures[i]) {
                coldest = temperatures[i];
                day = i + 1;
            }
        }
        return day;
    }
}
