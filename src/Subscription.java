/**
 * A class Subscription implements SubscriptionInterface and has three implementation
 * of three methods from Interface SubscriptionInterface.
 *
 * @author YuCheng
 * @version 2019-11-05
 */
public class Subscription implements SubscriptionInterface {
    private String title;
    private String email;
    private int cost;

    /**
     *
     * @param title The title of the Subscription.
     * @param email The email of the Subscription.
     * @param cost The cost of the Subscription.
     */
    public Subscription(String title, String email, int cost) {
        this.title = title;
        this.email = email;
        this.cost = cost;
    }

    /**
     * A standard getter method to get the title of the Subscription.
     * @return The title of the Subscription.
     */
    @Override
    public String getTitle() {
        return this.title;
    }

    /**
     * A standard getter method to get the email of the Subscription.
     * @return The email of the Subscription.
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * A standard getter method to get the cost of the Subscription.
     * @return The cost of the Subscription.
     */
    @Override
    public int getCost() {
        return this.cost;
    }

    /**
     *
     * @return A human readable description of the Subscription in form of
     *          the three field variables specifying it.
     */
    @Override
    public String toString() {
        return "Subscription includes" +
                "title= " + title  +
                ", email= " + email +
                ", cost= " + cost +
                ".";
    }
}
