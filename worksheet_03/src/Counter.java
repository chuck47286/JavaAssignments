import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The class is used in order to interactively count a number of
 * person/items in a room, storeroom, etc. A user is able to select
 * between five options.
 * <pre>
 *     1.add to the counter.
 *     2.subtract from the counter.
 *     3.show the counter.
 *     4.set the counter to a new value, and
 *     5.exit teh program.
 * </pre>
 * @author Yu Cheng
 * @version 2019-10-25
 */
public class Counter {
    /**
     * Pattern for the choice of input: either 1, 2, 3, 4, or 5
     */
    public static final Pattern p12345 = Pattern.compile("[12345]");
    /**
     * Field variable to store the value of the counter
     */
    private int counter;

    /**
     * The constructor initializes the counter as 0. Starts a scanner
     * to read from the command line, offering 5 choices for (add,
     * subtract, show counter, set counter, and exit). It stays in a
     * loop until the program is explicitly exited by entering 5.
     * It has no parameters.
     */
    public Counter() {
        this.counter = 0;
        //System.in is like System.out, however, for input and not for output
        Scanner s = new Scanner(System.in);
        /**
         * can take value 1 (add)
         *                2 (subtract)
         *                3 (show counter)
         *                4 (set counter)
         *                5 (exit)
         */

        byte topChoice = 0; // Can be anything but 5 to enter the loop

        while (topChoice != 5) {

            System.out.println("Please enter:\n" +
                    "1 to add to the total\n" +
                    "2 to subtract from the total\n" +
                    "3 to show the total\n" +
                    "4 to set the total\n" +
                    "5 to exit the program");
            try {
                topChoice = (byte) Integer.parseInt(s.next(p12345));
            }catch (Exception e) {
                System.out.println("Please enter a legal integer.");
                s = new Scanner(System.in);
            }
            switch (topChoice) {
                case 1:
                    add(s);
                    break;
                case 2:
                    subtract(s);
                    break;
                case 3:
                    show();
                    break;
                case 4:
                    set(s);
                    break;
                case 5:
                    System.out.println("Finally there are "
                            + counter + " items available.");
                    break;

            }

        }
    }

    /**
     * The method reads a  number from the input and adds it to the counter.
     * @param s The Scanner from which the input is read.
     */
    public void add(Scanner s) {
        System.out.println("How much to add?");
        try {
            counter += Integer.parseInt(s.next());
        } catch (NumberFormatException e) {
            System.out.println("You need to enter an integer.");
            s = new Scanner(System.in);
        }
    }

    /**
     * The method reads in a number from the input and subtracts it
     * from the counter.
     * @param s The scanner from which the input is read.
     */
    public void subtract(Scanner s) {
        System.out.println("How much to subtract?");
        try {
            counter -= Integer.parseInt(s.next());
        } catch (NumberFormatException e) {
            System.out.println("You need to enter an integer.");
            s = new Scanner(System.in);
        }
    }

    /**
     * The method prints the current value of the counter.
     */
    public void show() {
        System.out.println("Currently there are " + counter +
                " items available.");
    }

    /**
     * The method reads in a number from the input and sets the
     * counter to this value.
     * @param s The scanner from which the input is read.
     */
    public void set(Scanner s) {
        System.out.println("To which value do you want to set the counter");
        try {
            counter = Integer.parseInt(s.next());
        } catch (NumberFormatException e) {
            System.out.println("You need to enter an integer");
            s = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        Counter parcles = new Counter();
    }

}
