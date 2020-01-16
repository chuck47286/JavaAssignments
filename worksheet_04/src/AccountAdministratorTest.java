import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YuCheng
 * @version 2019-11-06
 */
class AccountAdministratorTest {
    private Account account1;
    @BeforeEach
    void setUp() {
        account1 = new AccountAdministrator(
                "Greece", "Ms","321@gmail.com","321");
    }

    @Test
    void login() {
        boolean expected = false;
        String attemptpassword = "111";
        account1.login(attemptpassword);
        Assertions.assertEquals(expected, account1.getLoggedIn());
    }

    @Test
    void getLoggedIn() {
        boolean expected = false;
        boolean actual = account1.getLoggedIn();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void setLoggedIn() {
        boolean expected = true;
        account1.setLoggedIn(true);
        Assertions.assertEquals(expected, account1.getLoggedIn());
    }

    @Test
    void logout() {
        boolean expected = false;
        boolean actual = account1.getLoggedIn();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void getName() {
        String expected = "Greece";
        String actual = account1.getName();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void getSalutation() {
        String expected = "Ms";
        String actual =account1.getSalutation();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void getEmail() {
        String expected = "321@gmail.com";
        String actual = account1.getEmail();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void getPassword() {
        String expected = "321";
        String actual = account1.getPassword();
        Assertions.assertEquals(expected,actual);
    }


    @Test
    void setPassword() {
        String expected = "666";
        account1.setPassword("666");
        Assertions.assertEquals(expected, account1.getPassword());
    }

    @Test
    void checkPassword() {
        boolean expected = false;
        String attemptpassword = "666";
        boolean actual = account1.checkPassword(attemptpassword);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void changePassword() {
        String expected = "666";
        account1.changePassword("321","666");
        Assertions.assertEquals(expected, account1.getPassword());
    }


    @Test
    void getAccounts() {
        AccountAdministrator accountAdministrator1 = (AccountAdministrator) account1;
        ArrayList<Account> expected = new ArrayList();
        Assertions.assertEquals(expected, accountAdministrator1.getAccounts());
    }

    @Test
    void addAccount() {
        AccountAdministrator accountAdministrator1= (AccountAdministrator) account1;
        Account customer = new AccountStandard("Bob", "Mr", "123@gmail.com", "123");
        accountAdministrator1.addAccount(customer);
        ArrayList<Account> expected = new ArrayList<>();
        expected.add(customer);
        Assertions.assertEquals(expected,accountAdministrator1.getAccounts());
    }

    @Test
    void resetAccount() {
        AccountAdministrator accountAdministrator1 = (AccountAdministrator) account1;
        Account customer = new AccountStandard("Bob", "Mr", "123@gmail.com", "123");
        customer.login("c123");

        accountAdministrator1.resetAccount(customer, "666");
        String expectedPassword = "123";
        Assertions.assertTrue(customer.checkPassword(expectedPassword));

        int expectedFailedLoginAttempts = 1;
        int actualFailLoginAttempts = ((AccountStandard) customer).getFailedLoginAttempts();
        Assertions.assertEquals(expectedFailedLoginAttempts, actualFailLoginAttempts);

    }

    @Test
    void testLogin() {
        AccountAdministrator accountAdministrator1 = (AccountAdministrator) account1;
        boolean expected = true;
        accountAdministrator1.login("321");
        Assertions.assertEquals(expected,accountAdministrator1.getLoggedIn());
    }

}