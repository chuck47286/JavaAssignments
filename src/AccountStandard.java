import java.util.ArrayList;

/**
 * A class AccountStandard extends the class Account and implements the interface AccountStandardInterface
 * has three additional field variables such as balance, titlesBought, failedLoginAttempts of types
 * int, ArrayList<MusicTitle> and int respectively and constant variable MAXIMAL_LOGIN_ATTEMPTS of
 * type int.
 *
 * @author YuCheng
 * @version 2019-11-05
 */
public class AccountStandard extends Account implements AccountStandardInterface {
    public static final int MAXIMAL_LOGIN_ATTEMPTS = 3;
    private int balance;
    private ArrayList<MusicTitle> titlesBought = new ArrayList<>();
    private int failedLoginAttempts;

    /**
     *
     * @param name The name of the AccountStandard.
     * @param salutation The salutation of the AccountStandard.
     * @param email The email of the AccountStandard.
     * @param password The password of the AccountStandard.
     */
    public AccountStandard(String name, String salutation, String email, String password) {
        super(name, salutation, email, password);
//        this.balance = balance;
//        this.titlesBought = titlesBought;
//        this.failedLoginAttempts = failedLoginAttempts;
    }

    /**
     * Getter method to return the balance.
     * @return The balance of the account.
     */
    @Override
    public int getBalance() {
        return this.balance;
    }
    /**
     *  Method for a user to log in to their account by providing a
     *  password. It is first checked whether the account is still
     *  active (that is, not too many failed login attempts were made
     *  in the past) and secondly whether the password provided is
     *  correct. In case of a correct login the number of login
     *  attempts is reset to 0, else increased by 1.
     *  @param password The password provided for the login; this is
     *  to be compared to the password stored on the system.
     */
    @Override
    public void login(String password) {
//        super.login(password);
        /*if (super.login(password)) {
            setFailedLoginAttempts(0);
        } else {
            this.failedLoginAttempts = getFailedLoginAttempts() + 1;
        }*/
        try {
            super.login(password);
            setFailedLoginAttempts(0);
        } catch (IllegalArgumentException e) {
            this.failedLoginAttempts = getFailedLoginAttempts() + 1;
        }
    }

    /**
     * Getter method to return the list of all titles bought by the user.
     * @return The current list of titles bought by the user.
     */
    @Override
    public ArrayList<MusicTitle> getTitlesBought() {
        return this.titlesBought;
    }
    /**
     * Adds the amount - if positive - to the current balance. For
     * non-positive amounts the action does nothing.
     * @param amount The amount being deposited.
     */
    @Override
    public void deposit(int amount) {
        if (amount > 0) {
            this.balance = getBalance() + amount;
        }
    }
    /**
     *  Setter for the balance.
     *  @param balance The new balance of the account.
     */
    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }
    /**
     * Getter method to return the number of failed login attempts.
     * @return The number of failed login attempts.
     */
    @Override
    public int getFailedLoginAttempts() {
        return this.failedLoginAttempts;
    }
    /**
     *  Setter for the failed login attempts.
     *  @param failedLoginAttempts The new number of failed login attempts.
     */
    @Override
    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }
    /**
     *  If the user is logged in and has sufficient funds, a music
     *  title is bought by adding the title to the ArrayList of
     *  titlesBought of the customer. Furthermore the price of the
     *  title is subtracted from the funds of the customer. If the
     *  user is not logged in, a corresponding warning is to be
     *  printed. Likewise if the user has insufficient funds, they
     *  should be asked to pay money into their account.
     *  @param musicTitle The music title that the customer wants to
     *  buy.
     */
    @Override
    public void buy(MusicTitle musicTitle) {
        if (super.getLoggedIn() && getBalance() > 0) {
            titlesBought.add(musicTitle);
            this.balance = getBalance() - musicTitle.getPrice();
        }
        /*else if (!super.getLoggedIn()) {
            throw new IllegalArgumentException("you are not logged.");
        } else if (getBalance() <= 0) {
            throw new IllegalArgumentException("please pay money on your account.");
        }*/
    }
    /**
     * Standard toString method to represent the object in a human
     * readable form. If the user is not logged in, only a warning
     * should be printed, but no substantial information be given.
     * @return The object in a human readable form.
     */
    @Override
    public String toString() {
        return "AccountStandard includes " +
                "balance= " + balance +
                ", titlesBought= " + titlesBought +
                ", failedLoginAttempts= " + failedLoginAttempts +
                 super.toString() +
                ".";
    }
}
