import java.util.List;

import static java.lang.Math.log;

/**
 * @author Yu Cheng
 * @description The class solution11 is to draw the char which to show how the regression works
 *  *           as the alpha and epochs changes. And the alpha and epochs is depended on the test.
 * @date 2020-02-27 22:31
 */
class solution22 {

    private static double w0 = 0;
    private static double w1 = 0;
    private static double w2 = 0;
    private static double alpha = 0.1;
    private static int epochs = 10000;
    private static final List<List<Double>> data = Data.dataFrom("data/MacdonellDF.csv");
//    private static final List<List<Double>> data = Data.dataFrom("C:\\Users\\Administrator.PC-20190121EABW\\IdeaProjects\\JavaAssignments\\src\\MacdonellDF1.csv");

    public static void main(String[] args) throws InterruptedException {
        Plot plot = new Plot("Graphic", "x1", "x2", data);
        Thread.sleep(500);
        // the loop size is depended on epochs, and the wo, w1 and w2 could change as the epochs changes
        for (int i = 0; i < epochs; i++) {
            double cost = 0;
            int m = data.get(0).size();
            for (int j = 0; j < data.get(0).size(); j++) {
                double x1_j = data.get(0).get(j);
                double x2_j = data.get(1).get(j);
                double y_j = data.get(2).get(j);
                double z = w0 + w1 * x1_j + w2 * x2_j;
                double prediction = 1 / (1 + Math.pow(Math.E, -z));
                cost += y_j * log(prediction) + (1 - y_j) * (log(1 - prediction));
                w0 += alpha * (y_j - prediction);
                w1 += alpha * (y_j - prediction) * x1_j;
                w2 += alpha * (y_j - prediction) * x2_j;
//                System.out.println(prediction);
            }
            cost = cost / -m;
            System.out.println("Current Cost: " + cost/data.get(0).size());
            HypothesisFunction h_x = (x) -> (-w1 * x - w0) / w2;
            plot.updatePlot(h_x);
            Thread.sleep(50);
        }

        System.out.println("Final Equation: h(x) = (" + w2 + " * x2) +(" + w1 + " * x1) + " + w0);

    }
}
