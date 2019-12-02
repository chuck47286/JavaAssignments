import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * The class Upload extends the class Application, so that the class could draw the picture.
 *
 * @version 2019-11-23
 * @author YuCheng
 */
public class Upload extends Application {
    /**
     * The method to create the new Thread to show the scene on the stage.
     * @param stage The collection of the Application, it is to provide the window.
     * @throws Exception The exception would be throw when the method can not be called correctly.
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root  = new Group();
        Scene scene = new Scene(root, 540, 480);

        Polygon arrow = new Polygon();
        Double[] arrowpoints = arrowGraph();
        arrow.getPoints().addAll(arrowpoints);
        root.getChildren().add(arrow);
        arrow.setFill(Color.RED);
        arrow.setStroke(Color.BLACK);

        Polygon bowl = new Polygon();
        Double[] bowlpoints = bowlGraph();
        bowl.getPoints().addAll(bowlpoints);
        root.getChildren().add(bowl);



        stage.setScene(scene);
        stage.show();


    }



    /**
     * The method is make preparation for building the graph.
     * Here is the point in the graph of arrow.
     *
     * @return The coordinates of the arrowGraph
     */
    public static Double[] arrowGraph() {
        Double[] points = new Double[14];
        //0
        points[0] = 270.0;
        points[1] = 60.0;
        //1
        points[2] = 360.0;
        points[3] = 120.0;
        //2
        points[4] = 300.0;
        points[5] = 120.0;
        //3
        points[6] = 300.0;
        points[7] = 300.0;
        //4
        points[8] = 240.0;
        points[9] = 300.0;
        //5
        points[10] = 240.0;
        points[11] = 120.0;
        //6
        points[12] = 180.0;
        points[13] = 120.0;

        return points;
    }
    /**
     * The method is make preparation for building the graph.
     * Here is the point in the graph of bowl.
     *
     * @return The coordinates of the bowlGraph
     */
    public static Double[] bowlGraph() {
        Double[] points = new Double[16];
        //0
        points[0] = 60.0;
        points[1] = 180.0;
        //1
        points[2] = 120.0;
        points[3] = 180.0;
        //2
        points[4] = 120.0;
        points[5] = 360.0;
        //3
        points[6] = 420.0;
        points[7] = 360.0;
        //4
        points[8] = 420.0;
        points[9] = 180.0;
        //5
        points[10] = 480.0;
        points[11] = 180.0;
        //6
        points[12] = 480.0;
        points[13] = 420.0;
        //7
        points[14] = 60.0;
        points[15] = 420.0;

        return points;
    }

    /**
     * The method is to start the AppFX.
     * @param args the parameter of the main method.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
