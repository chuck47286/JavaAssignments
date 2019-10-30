public class Temperature {
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
