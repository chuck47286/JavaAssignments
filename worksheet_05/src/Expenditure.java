/**
 * The class Expenditure has two field variables of description and value respectively of type
 * String and int accordingly. It also has the parameter constructor to initialize。
 *
 * @version 2019-11-29
 * @author YuCheng
 */
public class Expenditure {
    private String description;
    private int value;

    public Expenditure(String description, int value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }
}
