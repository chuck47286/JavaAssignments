/**
 * The class is the DVD item which is inherited from the parent class and has the filed of playtime typed double.
 *
 * @author YuCheng
 * @version 2020/5/21 15:00
 */
public class DVDItem extends Item {
    /**
     * The length of the playtime of the DVD item.
     */
    int playtime;

    /**
     * The constructor is to initialise the class and the public filed variable.
     *
     * @param price The price of the item.
     * @param name The name of the item.
     * @param discountPercentage how much could be discounted.
     */
    public DVDItem(double price, String name, double discountPercentage) {
        super(price, name, discountPercentage);
    }

    /**
     * The constructor is to initialise the class and the public filed variable.
     *
     * @param price The price of the DVD.
     * @param name The name of the DVD.
     * @param discountPercentage how much could be discounted.
     * @param playtime The length of the playtime of the DVD.
     */
    public DVDItem(double price, String name, double discountPercentage, int playtime) {
        super(price, name, discountPercentage);
        this.playtime = playtime;
    }
    /**
     *
     * @return the information in a suitable human readable form.
     */
    @Override
    public String toString() {
        return "DVDItem{" +
                "playtime=" + playtime +
                ", price=" + price * (100 - discountPercentage) / 100 +
                ", name='" + name + '\'' +
                ", discountPercentage=" + discountPercentage +
                '}';
    }
}
