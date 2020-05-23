import java.util.Random;

/**
 * The class is the parent class which has the common filed such as price and name.
 *
 * @author YuCheng
 * @version 2020/5/21 14:49
 */
public class Item {
    /**
     * The filed of each item are the price of the item, name of the item and how much could be discounted of the item.
     */
    double price;
    String name;
    double discountPercentage;
    /**
     * The constructor is to initialise the class and the public filed variable.
     *
     * @param price The price of the item.
     * @param name The name of the item.
     * @param discountPercentage how much could be discounted.
     */
    public Item(double price, String name, double discountPercentage) {
        this.price = price;
        this.name = name;
        this.discountPercentage = discountPercentage;
    }

    /**
     *
     * @return the information in a suitable human readable form.
     */
    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", discountPercentage=" + discountPercentage +
                '}';
    }

    /**
     * The main purpose is to give suitable examples for the different possibilities of items.
     *
     */
    public static void main(String[] args) {
        Item dvd1 = new DVDItem(12.99, "Game of ThronesI", 20.0,538);
        System.out.println(dvd1.toString());
        Item dvd2 = new DVDItem(14.99, "Game of ThronesVII", 0,461 );
        System.out.println(dvd2.toString());
        Item book1 = new BookItem(16.64, "Harry PotterI", 25.0,223);
        System.out.println(book1.toString());
        Item book2 = new BookItem(22.76, "Harry PotterVII", 10.0,464);
        System.out.println(book2.toString());
    }
}
