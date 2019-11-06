/**
 * A class SubscriptionPrime implements An Interface SubscriptionPrimeInterface and
 * implements all methods of SubscriptionPrime.
 *
 * @author YuCheng
 * @version 2019-11-05
 */
public class SubscriptionPrime implements SubscriptionPrimeInterface {
    private String title;
    private String email;
    private int cost;
    private String deliveryAddress;

    /**
     *
     * @param title The tile of the SubscriptionPrime.
     * @param email The email of the SubscriptionPrime.
     * @param cost The cost of the SubscriptionPrime.
     * @param deliveryAddress The deliveryAddress of the SubscriptionPrime.
     */
    public SubscriptionPrime(String title, String email, int cost, String deliveryAddress) {
        this.title = title;
        this.email = email;
        this.cost = cost;
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * A standard getter method to get the address of the SubscriptionPrime.
     * @return The address of the SubscriptionPrime.
     */
    @Override
    public String getAddress() {
        return this.deliveryAddress;
    }
    /**
     * A standard getter method to get the title of the SubscriptionPrime.
     * @return The title of the SubscriptionPrime.
     */
    @Override
    public String getTitle() {
        return this.title;
    }
    /**
     * A standard getter method to get the email of the SubscriptionPrime.
     * @return The email of the SubscriptionPrime.
     */
    @Override
    public String getEmail() {
        return this.email;
    }
    /**
     * A standard getter method to get the cost of the SubscriptionPrime.
     * @return The cost of the SubscriptionPrime.
     */
    @Override
    public int getCost() {
        return this.cost;
    }
    /**
     *
     * @return A human readable description of the Subscription in form of
     *          the four field variables specifying it.
     */
    @Override
    public String toString() {
        return "SubscriptionPrime includes" +
                " title= " + title  +
                ", email= " + email +
                ", cost= " + cost +
                ", deliveryAddress= " + deliveryAddress  +
                ".";
    }
}
