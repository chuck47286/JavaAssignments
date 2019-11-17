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
        assertEquals(expected, account1.getLoggedIn());
    }

    @Test
    void getLoggedIn() {
        boolean expected = false;
        boolean actual = account1.getLoggedIn();
        assertEquals(expected,actual);
    }

    @Test
    void setLoggedIn() {
        boolean expected = true;
        account1.setLoggedIn(true);
        assertEquals(expected, account1.getLoggedIn());
    }

    @Test
    void logout() {
        boolean expected = false;
        boolean actual = account1.getLoggedIn();
        assertEquals(expected,actual);
    }

    @Test
    void getName() {
        String expected = "Greece";
        String actual = account1.getName();
        assertEquals(expected,actual);
    }

    @Test
    void getSalutation() {
        String expected = "Ms";
        String actual =account1.getSalutation();
        assertEquals(expected,actual);
    }

    @Test
    void getEmail() {
        String expected = "321@gmail.com";
        String actual = account1.getEmail();
        assertEquals(expected,actual);
    }

    @Test
    void getPassword() {
        String expected = "321";
        String actual = account1.getPassword();
        assertEquals(expected,actual);
    }


    @Test
    void setPassword() {
        String expected = "666";
        account1.setPassword("666");
        assertEquals(expected, account1.getPassword());
    }

    @Test
    void checkPassword() {
        boolean expected = false;
        String attemptpassword = "666";
        boolean actual = account1.checkPassword(attemptpassword);
        assertEquals(expected,actual);
    }

    @Test
    void changePassword() {
        String expected = "666";
        account1.changePassword("321","666");
        assertEquals(expected, account1.getPassword());
    }


    @Test
    void getAccounts() {
        AccountAdministrator accountAdministrator1 = (AccountAdministrator) account1;
        ArrayList<Account> expected = new ArrayList();
        assertEquals(expected, accountAdministrator1.getAccounts());
    }

    @Test
    void addAccount() {
        AccountAdministrator accountAdministrator1= (AccountAdministrator) account1;
        Account customer = new AccountStandard("Bob", "Mr", "123@gmail.com", "123");
        accountAdministrator1.addAccount(customer);
        ArrayList<Account> expected = new ArrayList<>();
        expected.add(customer);
        assertEquals(expected,accountAdministrator1.getAccounts());
    }

    @Test
    void resetAccount() {
        AccountAdministrator accountAdministrator1 = (AccountAdministrator) account1;
        Account customer = new AccountStandard("Bob", "Mr", "123@gmail.com", "123");
        customer.login("c123");

        accountAdministrator1.resetAccount(customer, "666");
        String expectedPassword = "123";
        assertTrue(customer.checkPassword(expectedPassword));

        int expectedFailedLoginAttempts = 1;
        int actualFailLoginAttempts = ((AccountStandard) customer).getFailedLoginAttempts();
        assertEquals(expectedFailedLoginAttempts, actualFailLoginAttempts);

    }

    @Test
    void testLogin() {
        AccountAdministrator accountAdministrator1 = (AccountAdministrator) account1;
        boolean expected = true;
        accountAdministrator1.login("321");
        assertEquals(expected,accountAdministrator1.getLoggedIn());
    }

}