/**
 * An abstract class Account implements the Interface AccountInterface and has five field variables
 * of name, Salutation, email, password and loggedIn of types String, String, String, String and
 * boolean respectively.
 *
 * @author YuCheng
 * @version 2019-11-05
 */
public abstract class Account implements AccountInterface {
    private String name;
    private String salutation;
    private String email;
    private String password;
    private boolean loggedIn;

    /**
     *
     * @param name The name of the Account.
     * @param salutation The salutation of the Account.
     * @param email The email of the Account.
     * @param password The password of the Account.
     * @param loggedIn The loggedIn of the Account.
     */
    public Account(String name, String salutation, String email, String password, boolean loggedIn) {
        this.name = name;
        this.salutation = salutation;
        this.email = email;
        this.password = password;
        this.loggedIn = loggedIn;
    }

    /**
     *
     * @param password The password provided that will be compared to
     *  the password stored on the system, i.e., the value of the
     *  field variable. If the password provided is correct, the field
     *  variable loggedIn is changes to true, else a warning is to be
     *  printed.
     */
    @Override
    public void login(String password) {
        if (this.password == password) {
            loggedIn = true;
        } else
        throw new IllegalArgumentException("your password is wrong");
    }

    /**
     *  Getter to check whether a user is logged in.
     *
     *  If the user is not loggedIn the toString method should be
     *  disabled and only a warning should be printed that first a
     *  login is necessary. Further methods may be disabled in
     *  sub-classes.
     *
     *  @return true if the user is looged in, false else.
     */
    @Override
    public boolean getLoggedIn() {
        return this.loggedIn;
    }

    /**
     *
     * @param loggedIn New value for the variable loggedIn
     */
    @Override
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     *  The user is no longer logged in, that is, the
     *  loggedIn variable set to false.
     */
    @Override
    public void logout() {
        this.loggedIn = false;
    }
    /**
     * Getter method to return the name of the user.
     * @return The name of the user of the account.
     */
    @Override
    public String getName() {
        return this.name;
    }
    /**
     * Getter method to return the salutation of the account holder.
     * @return The salutation of the account holder (e.g., "Mr", "Ms",
     * "Mrs", "Dr", "Prof")
     */
    @Override
    public String getSalutation() {
        return this.salutation;
    }
    /**
     * Getter method to return the email address of the account holder.
     * @return The email address of the account holder.
     */
    @Override
    public String getEmail() {
        return this.email;
    }
    /**
     * Getter method to return the password.
     * @return The password of the account.
     */
    @Override
    public String getPassword() {
        return this.password;
    }
    /**
     *  Setter for the password.
     *  @param password The new password.
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Method to compare a provided password with the stored password.
     * @param password The provided password to which the password of
     * the this object is compared.
     * @return true if the password of the account agrees with the
     * argument, false else.
     */
    @Override
    public boolean checkPassword(String password) {
        return this.password == password;
    }
    /**
     * Changes the password from old to new if the old password is
     * correct, else an error message is printed.
     * @param oldPassword The current password.
     * @param newPassword The future password.
     */
    @Override
    public void changePassword(String oldPassword, String newPassword) {
        if (checkPassword(oldPassword)) {
            this.password = newPassword;
        }
    }
    /**
     * Standard toString method to represent the object in a human
     * readable form.
     * @return The object in a human readable form.
     */
    @Override
    public String toString() {
        return "Account includes " +
                "name= " + name +
                ", salutation= " + salutation +
                ", email= " + email +
                ", password= " + password +
                ", loggedIn= " + loggedIn +
                ".";
    }
}
