import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sun.security.krb5.SCDynamicStoreConfig;

import java.util.Arrays;

/**
 * The class Waffle is to draw the picture which looks like the waffle chart. The class Waffle
 * extends the class Application to draw the chart picture.
 *
 * @version 2019-11-29
 * @author YuCheng
 */
public class Waffle extends Application {
    /**  SMALL_SIZE is the width and height of a small squares of the board.
     */
    public static final int SMALL_SIZE = 50;
    /**  SMALL_SIZE is the width and height of a small squares of the board.
     */
    public static final int DIS = 10;
    /** X_OFFSET moves the board on the x-axis out of the left upper corner.
     */
    public static final int X_OFFSET = 50;
    /** Y_OFFSET moves the board on the y-axis out of the left upper corner.
     */
    public static final int Y_OFFSET = 50;
    /**
     * Color[] is the array which store all the possible color.
     */
    public static final Color[] colors =  {Color.BLACK, Color.BLUE,Color.RED,Color.YELLOW,
            Color.GREEN,Color.BROWN,Color.DARKBLUE,Color.SKYBLUE,Color.CORAL,Color.CORNFLOWERBLUE};
    /**
     * The filed variables of description and percentage of type String array and int array respectively.
     */
    private static String[] description;
    private static int[] percentage;
//    private Expenditure[] expenditures;
//    private int maximum;

    /**
     * The method to create the new Thread to show the scene on the stage.
     * @param primaryStage The collection of the Application, it is to provide the window.
     * @throws Exception The exception would be throw when the method can not be called correctly.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 1200, 680);

        drawchart(root);
        drawtext(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * The method is to draw the table to show the percentage of the certain expenditure.
     * @param root The group of the graph in the scene.
     */
    private static void drawchart(Group root) {
        Rectangle[][] squares = new Rectangle[10][10];
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                squares[i][j] =
                        new Rectangle(X_OFFSET+ j * (SMALL_SIZE + DIS),
                                Y_OFFSET+ i * (SMALL_SIZE + DIS) , SMALL_SIZE, SMALL_SIZE);
                squares[i][j].setFill(colors[percentage[i * 10 + j]]);
                root.getChildren().add(squares[i][j]);
            }
        }
    }
    /**
     * The method is to draw the text which could list all the category of the expenditure.
     * @param root The group of the graph would be drawn in the scene.
     */
    private static void drawtext(Group root) {
        Text text;
        int maximum = description.length;
        for (int i = 0; i < maximum; i++) {
            Rectangle rectangle = new Rectangle(X_OFFSET + 11 *(SMALL_SIZE + DIS),
                    Y_OFFSET + (1 + i) *(SMALL_SIZE + DIS),SMALL_SIZE,SMALL_SIZE);
            rectangle.setFill(colors[i]);
            root.getChildren().add(rectangle);
            text = new Text(X_OFFSET + 12 *(SMALL_SIZE + DIS),
                    Y_OFFSET + (1 + i) *(SMALL_SIZE + DIS) + 0.75 * SMALL_SIZE,
                    String.format("%s", description[i]));
            text.setFont(Font.font ("Dialog", 28));
            root.getChildren().add(text);
        }
    }

    /**
     * The method is to calculate the certain percentage of the expenditure.
     * @param expenditures all expenditures of the company.
     * @param maximum The maximum category in the table.
     * @return The arr which store the certain percentage of the expenditure.
     */
    private static int[] calPercentage(Expenditure[] expenditures, int maximum) {
        percentage = new int[100];
        Arrays.fill(percentage,maximum - 1);
        int sum = 0;
        for (Expenditure e: expenditures) {
            sum += e.getValue();
        }
        double[] per = new double[maximum];
        for (int i = 0; i < maximum - 1; i++) {
            per[i] = Math.round(expenditures[i].getValue() * 100.0 / sum );
        }
        int index = 0;
        for (int i = 0; i < maximum - 1; i++) {
            for (int j = 0; j < per[i]; j++) {
                percentage[index++] = i;
            }
            if (i == maximum - 2) percentage[index] = i;
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
    private static void waffle(Expenditure[] expenditures, int maximum) {
        percentage = calPercentage(expenditures, maximum);
        description = calDescription(expenditures, maximum);
    }

    /**
     * The default constructor
     */
    public Waffle() {
    }

    /**
     * The Parameterized constructors
     * @param expenditures The details of the expenditure.
     * @param maximum The maximum number of points on the polyline.
     */
    public Waffle(Expenditure[] expenditures, int maximum) {
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
        waffle(expenditures, maximum);
//        percentage = calPercentage(expenditures, maximum);
//        description = calDescription(expenditures, maximum);
        launch(args);
    }




}
