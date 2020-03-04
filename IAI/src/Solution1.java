import java.util.List;

/**
 * @author Yu Cheng
 * @description The class solution11 is to draw the char which to show how the regression works
 *              as the alpha and epochs changes. And the alpha and epochs is depended on the test.
 *
 * @date 2020-02-27 22:31
 */
class solution11 {
    private static double w0 = 0;
    private static double w1 = 0;
    private static double w2 = 0;
    private static double alpha = 0.00000001;
    private static int epochs = 100000;
    private static final List<List<Double>> data = Data.dataFrom("data/MacdonellDF.csv");
//    private static final List<List<Double>> data = Data.dataFrom("C:\\Users\\Administrator.PC-20190121EABW\\IdeaProjects\\JavaAssignments\\src\\MacdonellDF.csv");

    public static void main(String[] args) throws InterruptedException {
        Plot plot = new Plot("Graphic", "x", "y", data);
        Thread.sleep(500);
        // the loop size is depended on epochs, and the wo, w1 and w2 could change as the epochs changes
        for (int i = 0; i < epochs; i++) {
            double cost = 0;
            for (int j = 0; j < data.get(0).size(); j++) {
                double x_j = data.get(0).get(j);
                double y_j = data.get(1).get(j);
                double prediction = w0 + w1 * x_j + w2 * x_j * x_j;
                cost = cost + (y_j - prediction) * (y_j - prediction);
                w0 = w0 + alpha * (y_j - prediction);
                w1 = w1 + alpha * (y_j - prediction) * x_j;
                w2 = w2 + alpha * (y_j - prediction) * x_j * x_j;
//                System.out.println(prediction);
            }
            System.out.println("Current Cost: " + cost/data.get(0).size());
            HypothesisFunction h_x = (x) -> w0 + w1 * x + w2 * x * x;
            plot.updatePlot(h_x);
            Thread.sleep(1);
        }

        System.out.println("Final Equation: h(x) = " + w2 + "x^2 " + w1 + " * x + " + w0);

    }


}