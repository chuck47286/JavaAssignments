import java.util.function.Function;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
/**
 *  This class is to display a non-constant function such as x goes to
 *  x*x and the area between the function graph and the x-axis in a
 *  given interval [a,b].  It is done by drawing the x-axis and the
 *  y-axis as well as defining a polyline from the function, the
 *  end-point (b, f(b)) and the starting point at (a, f(a)) and then
 *  displaying the corresponding polygon filled with colour and
 *  adquately scaled.
 *
 *  @version 2019-11-17
 *  @author Manfred Kerber
 */
public class DisplayFunctionArea extends Application{
    /** X_SIZE is the width of the panel in pixels. Set to 600.
     */
    public static final int X_SIZE = 600;
    /** Y_SIZE the height of the panel in pixels. Set to 600.
     */
    public static final int Y_SIZE = 600;
    /**
     *  f is the function to be displayed. We introduce it as a global
     *  variable so that it can be used in the start method, but be
     *  defined in the main method.
     */
    private static Function<Double,Double> f;
    /**
     * a is the left border of the interval on which the function is
     * to be displayed. We introduce it as a global variable so that
     * it can be used in the start method, but be defined in the main
     * method.
     */
    private static double a;
    /**
     * b is the right border of the interval on which the function is
     * to be displayed. We introduce it as a global variable so that
     * it can be used in the start method, but be defined in the main
     * method.
     */
    private static double b;
    /**
     *  n is the granularity. More concretely, the interval [a,b] will
     *  be subdivided in n parts and on each the function will be
     *  approximated by a straight line.
     */
    private static int n;
    /**
     *  The polyline will be the approximation of the function and be displayed.
     */
    private static Polyline polyline;
    /**
     *  The polygon will be the area between the function and the
     *  x-axis.
     */
    private static Polygon polygon;
    /**
     *  The colour in which the area is displayed.
     */
    public static Color areaColour = Color.YELLOW;
    /**
     *   The method generates a polygon corresponding to the area
     *   between the function f and the x-axis in the interval [a,b].
     *   @param f The function to be drawn.
     *   @param n The number of equidistant intervals to be drawn.
     *   @param a The minimal x-value in the interval.
     *   @param b The maximal x-value in the interval.
     *   @return The polygon corresponding to the area between the
     *   function f and the x-axis over the interval [a,b] with
     *   granularity n.
     */
    public static Polygon functionToPolygon(Function<Double,Double> f,
                                            int n, double a, double b) {
        if (a >= b) {
            throw new IllegalArgumentException();
        } else {
            double[] points = new double[2*(n+1)+4];
            double x, y;
            /* Loop: Add x and y values to the corresponding arrays
             * for a, b and n-1 equidistant values in between.
             * The (x_i,y_i) values are added to the points array in pairs.
             */
            for (int i = 0; i <= n ; i++){
                x = a + (b - a) * i / n;
                y = f.apply(x);
                points[2*i]   = x;
                points[2*i+1] = y;
            }
            /* Draw graph */
            return new Polygon(points);
        }
    }
    /**
     *   The method generates a polyline corresponding to the graph of
     *   function f in the interval [a,b]
     *   @param f The function to be drawn.
     *   @param n The number of equidistant intervals to be drawn.
     *   @param a The minimal x-value in the interval.
     *   @param b The maximal x-value in the interval.
     *   @return The polyline corresponding to the function f over the
     *   interval [a,b] with granularity n.
     */
    public static Polyline functionToPolyline(Function<Double,Double> f,
                                              int n, double a, double b) {
        if (a >= b) {
            throw new IllegalArgumentException();
        } else {
            double[] points = new double[2*(n+1)];
            double x, y;
            /* Loop: Add x and y values to the corresponding arrays
             * for a, b and n-1 equidistant values in between.
             * The (x_i,y_i) values are added to the points array in pairs.
             */
            for (int i = 0; i <= n ; i++){
                x = a + (b - a) * i / n;
                y = f.apply(x);
                points[2*i]   = x;
                points[2*i+1] = y;
            }
            /* Draw graph */
            Polyline result = new Polyline(points);
            result.setStrokeWidth(3);
            return result;
        }
    }
    /**
     *   The method draws the x-axis if 0 is in the interval ]min,max[.
     *   It is assumed that the function is not constant.
     *   @param root The group to which the x-axis is to be added.
     */
    public static void drawXAxis(Group root){
        /*if (min < 0 && 0 < max) {
            Line line = new Line(0, (max-0) * Y_SIZE/(max-min),
                    X_SIZE, (max-0) * Y_SIZE/(max-min));
            line.setStrokeWidth(2);
            root.getChildren().add(line);
        }*/
    }
    /**
     *   The method draws the y-axis if 0 is in the interval ]a, b[.
     *   @param root The group to which the y-axis is to be added.
     */
    public static void drawYAxis(Group root){
        if (a < 0 && 0 < b) {
            Line line = new Line((b-0) * X_SIZE/(b-a), 0,
                    (b-0) * X_SIZE/(b-a), Y_SIZE);
            line.setStrokeWidth(2);
            root.getChildren().add(line);
        }
    }
    /**
     *  @param stage The window to be displayed.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Create a Group (scene graph) with the line as single element.
        Group root = new Group();
        root.getChildren().add(polyline);
        root.getChildren().add(polygon);
        drawXAxis(root);
        drawYAxis(root);
        // The scene consists of just one group.
        Scene scene = new Scene(root, X_SIZE,Y_SIZE);
        // Give the stage (window) a title and add the scene.
        stage.setTitle("Function Graph");
        stage.setScene(scene);
        stage.show();
    }
    /**
     *  The method gives values to the static variables a, b, n, and polyline.
     *  @param f The function to be displayed.
     *  @param numberOfValues The number of points on the polyline.
     *  @param left The left border of the interval to be displayed.
     *  @param right The right border of the interval to be displayed.
     */
    public static void displayFunctionArea(Function<Double, Double> f,
                                           double left, double right, int
                                                   numberOfValues){
        a = left;
        b = right;
        n = numberOfValues;
        polyline = functionToPolyline(f, numberOfValues, left, right);
        polygon = functionToPolygon(f, numberOfValues, left, right);
        polygon.setFill(areaColour);
    }
    /*
     *  main method to launch the application.
     */
    public static void main(String[] args) {
        displayFunctionArea(x -> x*x*x - 8 * x * x, -2, 9, 500);
        launch(args);
    }
}
