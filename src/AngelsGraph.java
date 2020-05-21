import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

import java.util.function.Function;

/**
 * The class is to draw the picture looks like angles 10 and 45 degree, and it is implemented only by Line and Polyline classes.
 *
 * @author YuCheng
 * @version 2020/5/21 17:06
 */
public class AngelsGraph extends Application {
    /**
     * X_SIZE is the width of the panel in pixels. Set to 1200.
     */
    public static final int X_SIZE = 1200;
    /**
     * Y_SIZE the height of the panel in pixels. Set to 500.
     */
    public static final int Y_SIZE = 500;
    /**
     * DISTANCE is the distance between two circle segment.
     */
    public static final int DISTANCE = 600;
    /**
     * Both polyline1 and polyline2 will be the approximation of the circle segment and be displayed.
     */
    private static Polyline polyline1, polyline2;
    /**
     * The polyline will be the approximation of the circle segment and be displayed.
     */
//    private static Polyline polylines;
    /**
     * Radius is the radius of both circles.
     */
    private static final double Radius = 400.0;
    /**
     * Center_x1 is the x of the center of the first circle in the panel.
     */
    private static final int CenterX = 500;
    /**
     * Center_y1 is the x of the center of the first circle in the panel.
     */
    private static final int CenterY = 450;
    /**
     * Center_x2 is the x of the center of the second circle in the panel.
     */
    private static final int Center_x2 = 1100;
    /**
     * Center_y2 is the x of the center of the second circle in the panel.
     */
    private static final int Center_y2 = 450;
    /**
     * The pointer[] is the array to store x and y of the two pointer.
     */
//    private static double pointer[] = new double[4];
    /**
     * The number of the pointer by which angle should be formed.
     */
//    private static int p_index = 0;
    /**
     * The pointerX[] would be marked by the x of the point in the circle segment.
     */
    private static double pointerX[] = new double[2];
    /**
     * The pointerY[] would be marked by the y of the point in the circle segment.
     */
    private static double pointerY[] = new double[2];
    /**
     * The pointer_x2 would be marked by the x of the point in the second circle segment.
     */
//    private static double pointer_x2;
    /**
     * The pointer_y2 would be marked by the y of the point in the second circle segment.
     */
//    private static double pointer_y2;


    /**
     * @param stage The window to be displayed.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Create a Group (scene graph) with the line as single element.
        Group root = new Group();
        root.getChildren().add(polyline1);
        root.getChildren().add(polyline2);
        drawAngles(root);
//        drawAngles(root);
//        root.getChildren().add(polyline2);
        /*drawAngles_1(root);
        drawAngles_2(root);*/

        // The scene consists of just one group.
        Scene scene = new Scene(root, X_SIZE, Y_SIZE);
        // Give the stage (window) a title and add the scene.
        stage.setTitle("angles 10 degrees and 45 degrees");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The method draw the line to form these angles.
     *
     * @param root The group to which the line is to be added to form the angle.
     */
    private void drawAngles(Group root) {
        for (int i = 0; i < 2; i++) {
            Line line = new Line(CenterX + i * DISTANCE, CenterY,
                    pointerX[i], pointerY[i]);
            line.setStrokeWidth(2);
            root.getChildren().add(line);
        }
        /*Line line_2 = new Line(Center_x2, Center_y2,
                pointer_x2, pointer_y2);
        line_1.setStrokeWidth(2);
        root.getChildren().add(line_2);*/
    }

    /**
     * The method gives values to the static variables a, b, n, and polyline.
     *
     * @param f              The function to be displayed.
     * @param angles         The array of two angles.
     * @param numberOfValues The number of points on the polyline.
     */
    public static void displayFunctionArea(Function<Double, Double> f, int[] angles, int numberOfValues) {
        polyline1 = functionToPolyline(f, numberOfValues, angles[0]);
        polyline2 = functionToPolyline(f, numberOfValues, angles[1]);
//        polylines = functionToPolyline(f, numberOfValues, angles);
    }

    /**
     * The method generates a polyline corresponding to the graph of circle segment in two centers separately and mark the pointer in the
     * circle segment in order to form the angle.
     *
     * @param f     The circle segment to be drawn.
     * @param n     The number of equidistant circle segment to be drawn.
     * @param angle One of angles should be formed.
     * @return The polyline of the circle segment.
     */
    private static Polyline functionToPolyline(Function<Double, Double> f, int n, int angle) {

        double[] points = new double[2 * (n + 1)];
        double x, y;
        int index = (polyline1 == null) ? 0 : 1;

        /**
         * Loop: Add x and y values to the corresponding arrays
         * draw the circle segment and mark the pointer on the circle segment.
         */
        for (int i = 0; i <= n; i++) {
            x = CenterX + index * DISTANCE - Radius * i / n;
            y = CenterY - Radius * f.apply(i * 1.0 / n);
            points[2 * i] = x;
            points[2 * i + 1] = y;
            /**
             * judge whether the angle1 is formed
             */
            if (Math.abs(CenterX + index * DISTANCE + Radius * Math.cos(Math.PI * (180 - angle) / 180) - x) < 0.1 &&
                    Math.abs(CenterY - Radius * Math.sin(Math.PI * (180 - angle) / 180) - y) < 0.1) {
                pointerX[index] = x;
                pointerY[index] = y;
            }
        }

        /*for (; i <= 2 * n; i++) {
            x = Center_x2 - Radius * (i - n) / n;
            y = Center_y2 - Radius * f.apply((i - n) * 1.0 / n);
            points[2 * i] = x;
            points[2 * i + 1] = y;
            *//**
         * judge whether the angle1 is formed
         *//*
            if (Math.abs(Center_x2 + Math.cos(Math.PI * (180 - angle_2) / 180) - x) < 0.1  &&
                    Math.abs(Center_y2 - Math.sin(Math.PI * (180 - angle_2) / 180) - y) < 0.1) {
                pointer_x2 = x;
                pointer_y2 = y;
            }
        }*/
        /* Draw graph */
        Polyline result = new Polyline(points);
        result.setStrokeWidth(3);
        return result;
    }

    /**
     * Main method is to launch the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        displayFunctionArea(x -> Math.sqrt(1 - x * x), new int[]{10, 45}, 5000);
        launch(args);
    }
}
