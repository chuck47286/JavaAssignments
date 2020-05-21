/**
 * The class is the book item which is inherited from the parent class and has the filed of numberOfPages typed int.
 *
 * @author YuCheng
 * @version 2020/5/21 15:22
 */
public class BookItem extends Item {
    /**
     * The number of the page in the book item.
     */
    int numberOfPages;


    /**
     * The constructor is to initialise the class and the public filed variable.
     *
     * @param price The price of the item.
     * @param name The name of the item.
     * @param discountPercentage how much could be discounted.
     */
    public BookItem(double price, String name, double discountPercentage) {
        super(price, name, discountPercentage);
    }

    /**
     * The constructor is to initialise the class and the public filed variable.
     *
     * @param price The price of the book.
     * @param name The name of the book.
     * @param discountPercentage how much could be discounted.
     * @param numberOfPages The number of pages of the book.
     */
    public BookItem(double price, String name, double discountPercentage, int numberOfPages) {
        super(price, name, discountPercentage);
        this.numberOfPages = numberOfPages;
    }
    /**
     *
     * @return the information in a suitable human readable form.
     */
    @Override
    public String toString() {
        return "BookItem{" +
                "numberOfPages=" + numberOfPages +
                ", price=" + price * (100 - discountPercentage) / 100 +
                ", name='" + name + '\'' +
                ", discountPercentage=" + discountPercentage +
                '}';
    }
}
