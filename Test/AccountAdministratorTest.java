import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YuCheng
 * @version 2019-11-06
 */
class AccountAdministratorTest {
    private AccountAdministrator accountAdministrator1;
    @BeforeEach
    void setUp() {
        accountAdministrator1 = new AccountAdministrator(
                "Bob", "Mr","123@gmail.com","123",false,
                new ArrayList<>());
    }

    @Test
    void login() {
    }

    @Test
    void getLoggedIn() {
    }

    @Test
    void setLoggedIn() {
    }

    @Test
    void logout() {
    }

    @Test
    void getName() {
    }

    @Test
    void getSalutation() {
    }

    @Test
    void getEmail() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void setPassword() {
    }

    @Test
    void checkPassword() {
    }

    @Test
    void changePassword() {
    }

    @Test
    void testToString() {
    }

    @Test
    void getAccounts() {
    }

    @Test
    void addAccount() {
    }

    @Test
    void resetAccount() {
    }

    @Test
    void testLogin() {
    }

    @Test
    void testToString1() {
    }
}