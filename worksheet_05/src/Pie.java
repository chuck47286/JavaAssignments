import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * The class Pie extends the class Application. The main function of this class to show the category in
 * the form of the pie.
 *
 * @version 2019-11-29
 * @author YuCheng
 */
public class Pie extends Application {
    /**
     * The X and Y of the center of the pie chart.
     */
    private static final int CEN_X = 600;
    private static final int CEN_Y = 340;
    /**
     * The distance between the text and the circle.
     */
    private static final int DIS = 10;
    /**
     * The radious of the pie chart.
     */
    private static final int RADIUS = 100;
    /**
     * The filed variables of description and percentage of type String array and int array respectively.
     */
    private static String[] description;
    private static Double[] percentage;
    /**
     * The method to create the new Thread to show the scene on the stage.
     * @param primaryStage The collection of the Application, it is to provide the window.
     * @throws Exception The exception would be throw when the method can not be called correctly.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root,980, 680);

        drawCircle(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * The method is to draw the circle chart.
     * @param root The group of the graph.
     */
    private void drawCircle(Group root) {
        Circle circle = new Circle(CEN_X, CEN_Y, RADIUS);
        circle.setFill(null);
        circle.setStroke(Color.BLACK);
        root.getChildren().add(circle);

        Line[] lines = new Line[percentage.length];
        Text[] texts = new Text[percentage.length];
        lines[0] = new Line(CEN_X, CEN_Y,CEN_X +RADIUS,CEN_Y);
        texts[0] = new Text(
                CEN_X + 1.15 * RADIUS*Math.cos(percentage[0] / 2 * Math.PI / 180 ) ,
                CEN_Y - 1.15 * RADIUS*Math.sin(percentage[0] / 2 * Math.PI / 180 ) ,
                String.format("%s", description[0])
        );
        for (int i = 1; i < percentage.length; i++) {
            lines[i] = new Line(CEN_X,CEN_Y,
                    CEN_X + RADIUS*Math.cos(percentage[i - 1] * Math.PI / 180),
                    CEN_Y - RADIUS*Math.sin(percentage[i - 1] * Math.PI / 180)
            );
            texts[i] = new Text(
                    CEN_X + 1.15 * RADIUS*Math.cos(
                            (percentage[i - 1] + percentage[i]) / 2 * Math.PI / 180 ) ,
                    CEN_Y - 1.15 * RADIUS*Math.sin(
                            (percentage[i - 1] + percentage[i]) / 2 * Math.PI / 180 ) ,
                    String.format("%s", description[i])
            );

        }
//        texts[2].setX(CEN_X + 1.35 * RADIUS*Math.cos(
//                (percentage[2 - 1] + percentage[1]) / 2 * Math.PI / 180 ) - 6.8* DIS);
        root.getChildren().addAll(lines);
        // algorithm to adjust the positon of the text
        for (int i = 0; i < texts.length; i++) {
            adjustPosition(texts[i], i);
        }
        root.getChildren().addAll(texts);

    }

    /**
     * The method is to adjust the position of the text in case of no overlapping.
     * @param text The position of the text is to adjust.
     */
    private void adjustPosition(Text text, int i) {
        if (text.getX() >= CEN_X) return;

        while (text.getX() + text.getLayoutBounds().getWidth() - CEN_X >
                RADIUS*Math.cos((percentage[i - 1] + percentage[i]) / 2 * Math.PI / 180 )) {
            text.setX(text.getX() - DIS);
        }
    }


    /**
     * The method is to calculate the certain percentage of the expenditure.
     * @param expenditures all expenditures of the company.
     * @param maximum The maximum category in the table.
     * @return The arr which store the certain percentage of the expenditure.
     */
    private static Double[] calPercentage(Expenditure[] expenditures, int maximum) {
        percentage = new Double[maximum];
        int sum = 0;
        for (Expenditure e: expenditures) {
            sum += e.getValue();
        }
        for (int i = 0; i < maximum ; i++) {
            percentage[i] = Math.round(expenditures[i].getValue() * 100.0 / sum ) * 3.6;
        }
        for (int i = 1; i < maximum; i++) {
            percentage[i] += percentage[i - 1];
        }
        return percentage;
    }
    /**
     * The method is to create the description from the array expenditures.
     * @param expenditures The all details of the expenditures such as description and cost.
     * @param maximum The maximum number of the group could be made according to the expenditure.
     * @return The String arr which store the all categories.
     */
    private static String[] calDescription(Expenditure[] expenditures, int maximum) {
        String[] description = new String[maximum];
        for (int i = 0; i < expenditures.length && i < maximum - 1; i++) {
            description[i] = expenditures[i].getDescription();
        }
        description[maximum - 1] = "Other";
        return description;
    }
    /**
     *  The method gives values to the static variables percentage, description by the
     *  parameter of the method calPercentage and calDescription respectively.
     *  @param expenditures The details of the expenditure.
     *  @param maximum The maximum number of points on the polyline.
     */
    private static void pie(Expenditure[] expenditures, int maximum) {
        percentage = calPercentage(expenditures, maximum);
        description = calDescription(expenditures, maximum);
    }

    /**
     * The default constructor
     */
    public Pie() {
    }

    /**
     * The Parameterized constructors
     * @param expenditures The details of the expenditure.
     * @param maximum The maximum number of points on the polyline.
     */
    public Pie(Expenditure[] expenditures, int maximum) {
//        this.expenditures = expenditures;
//        this.maximum = maximum;
        percentage = calPercentage(expenditures, maximum);
        description = calDescription(expenditures, maximum);
    }


    /**
     * The method is to start the AppFX.
     * @param args the parameter of the main method.
     */
    public static void main(String[] args) {
        Expenditure[] expenditures = new Expenditure[]{
                new Expenditure("Salaries", 11000),
                new Expenditure("Paper", 2000),
                new Expenditure("Rent", 5000),
                new Expenditure(
                        "Most popular books on Java etc.",
                        10000),
                new Expenditure("Heating", 3000),
                new Expenditure("Coffee/Tea", 7000),
                new Expenditure("Biscuits", 8000),
                new Expenditure("Travel", 18000),
                new Expenditure("Electricity", 1000),
                new Expenditure("Pencils", 3000)
        };
        Arrays.sort(expenditures, (Expenditure exp1, Expenditure exp2) ->
                exp2.getValue() - exp1.getValue());
        int maximum = 8;
        pie(expenditures,maximum);
//        percentage = calPercentage(expenditures, maximum);
//        description = calDescription(expenditures, maximum);
        launch(args);
    }
}
