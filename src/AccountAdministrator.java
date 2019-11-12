import java.util.ArrayList;

/**
 *  A class AccountAdministrator extends the abstract class Account and implements the Interface
 *  AccountAdministratorInterface has an additional field variable such as accounts of type
 *  ArrayList<AccountStandard>.
 *
 * @author YuCheng
 * @version 2019-11-06
 */
public class AccountAdministrator extends Account implements AccountAdministratorInterface {
    private ArrayList<AccountStandard> accounts;

    /**
     *
     * @param name The name of the AccountAdministrator.
     * @param salutation The salutation of the AccountAdministrator.
     * @param email The email of the AccountAdministrator.
     * @param password The password of the AccountAdministrator.
     * @param loggedIn The loggedIn of the AccountAdministrator.
     * @param accounts The accounts of the AccountAdministrator.
     */
    public AccountAdministrator(String name, String salutation, String email, String password, boolean loggedIn,
                                ArrayList<AccountStandard> accounts) {
        super(name, salutation, email, password, loggedIn);
        this.accounts = accounts;
    }

    /**
     * Getter method to return the list of accounts the administrator
     * looks after.
     * @return The list of accounts the administrator looks after.
     */
    @Override
    public ArrayList<Account> getAccounts() {
        return new ArrayList<>(accounts);
    }
    /**
     *  The method adds an account to the list of accounts the
     *  administrator looks after.
     *  @param account The new account to be added to the list of accounts
     *  the administrator looks after.
     */
    @Override
    public void addAccount(Account account) {
        this.accounts.add((AccountStandard) account);
    }
    /**
     *  If an account can no longer be used, since either the user has
     *  forgotten their password or in case of a standard user has
     *  entered the password incorrectly too often the administrator
     *  can reset the account by setting a new password and resetting
     *  the number of failed login attempts to zero (the latter only
     *  if the account is a standard account).
     *  @param account The account that is to be reset.
     *  @param password The new password for the account that is to be
     *  reset.
     */
    @Override
    public void resetAccount(Account account, String password) {
        AccountStandard accountStandard = (AccountStandard) account;
        accountStandard.setPassword(password);
        accountStandard.setFailedLoginAttempts(0);
        addAccount(accountStandard);
    }

    /**
     * Method for an administrator to log in by providing a
     * password. It is checked whether the password provided is
     * correct.
     *
     * @param password The password provided for the login; this is
     *                 to be compared to the password stored on the system.
     */
    public void login(String password) {
        if (super.checkPassword(password)) {
            throw new IllegalArgumentException("your password is correct");
        } else {
            throw new IllegalArgumentException("your password is incorrect");
        }
    }

    /**
     * Standard toString method to represent the object in a human
     * readable form. If the user is not logged in, only a warning
     * should be printed, but no substantial information be given.
     *
     * @return The object in a human readable form.
     */
    @Override
    public String toString() {
        return "AccountAdministrator includes " +
                "accounts=" + accounts +
                super.toString() +
                ".";
    }
}
