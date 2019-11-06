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

    public AccountAdministrator(String name, String salutation, String email, String password, boolean loggedIn,
                                ArrayList<AccountStandard> accounts) {
        super(name, salutation, email, password, loggedIn);
        this.accounts = accounts;
    }

    @Override
    public ArrayList<Account> getAccounts() {
        return null;
    }

    @Override
    public void addAccount(Account account) {

    }

    @Override
    public void resetAccount(Account account, String password) {

    }
}
