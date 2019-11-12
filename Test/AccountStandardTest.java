import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YuCheng
 * @version 2019-11-06
 */
class AccountStandardTest {
    private Account account1;
    @BeforeEach
    void setUp() {
        account1 = new AccountStandard(
                "Bob", "Mr","123@gmail.com","123",false,
                0, new ArrayList<MusicTitle>(), 0);
    }

    @Test
    void login() {
        boolean expected = true;
        String attemptpassword = "123";
        account1.login(attemptpassword);
        assertEquals(expected, account1.getLoggedIn());
    }

    @Test
    void getLoggedIn() {
        boolean expected = false;
        boolean actual = account1.getLoggedIn();
        assertEquals(expected, actual);
    }

    @Test
    void setLoggedIn() {
        boolean expected = true;
        account1.setLoggedIn(true);
    }

    @Test
    void logout() {
        boolean expected = false;
        boolean actual = account1.getLoggedIn();
        assertEquals(expected,actual);
    }

    @Test
    void getName() {
        String expected = "Bob";
        String actual = account1.getName();
        assertEquals(expected,actual);
    }

    @Test
    void getSalutation() {
        String expected = "Mr";
        String actual = account1.getName();
        assertEquals(expected,actual);
    }

    @Test
    void getEmail() {
        String expected = "123@gmail.com";
        String actual = account1.getEmail();
        assertEquals(expected,actual);
    }

    @Test
    void getPassword() {
        String expected = "123";
        String actual = account1.getPassword();
        assertEquals(expected,actual);
    }

    @Test
    void setPassword() {
        String expected = "321";
        account1.setPassword("321");
        assertEquals(expected,account1.getPassword());
    }

    @Test
    void checkPassword() {
        boolean expected = true;
        boolean actual = account1.checkPassword("123");
        assertEquals(expected,actual);
    }

    @Test
    void changePassword() {
        String expected = "321";
        account1.changePassword("123","321");
        assertEquals(expected,account1.getPassword());
    }


    @Test
    void getBalance() {
        int expected = 0;
        AccountStandard accountStandard1 = (AccountStandard) account1;
        int actual = accountStandard1.getBalance();
        assertEquals(expected,actual);
    }

    @Test
    void testLogin() {
        int expected = 1;
        AccountStandard accountStandard1 = (AccountStandard) account1;
        accountStandard1.login("111");
        assertEquals(expected,accountStandard1.getFailedLoginAttempts());
    }

    @Test
    void getTitlesBought() {
        List<MusicTitle> expected = new ArrayList<>();
        AccountStandard accountStandard1 = (AccountStandard) account1;
        ArrayList<MusicTitle> actual = accountStandard1.getTitlesBought();
        assertEquals(expected,actual);
    }

    @Test
    void deposit() {
        int expected = 10;
        AccountStandard accountStandard1 = (AccountStandard) account1;
        accountStandard1.deposit(10);
        assertEquals(expected, accountStandard1.getBalance());
    }

    @Test
    void setBalance() {
        int expected = 100;
        AccountStandard accountStandard1 = (AccountStandard) account1;
        accountStandard1.setBalance(100);
        assertEquals(expected,accountStandard1.getBalance());
    }

    @Test
    void getFailedLoginAttempts() {
        int expected = 0;
        AccountStandard accountStandard1 = (AccountStandard) account1;
        int actual = accountStandard1.getFailedLoginAttempts();
        assertEquals(expected,actual);
    }

    @Test
    void setFailedLoginAttempts() {
        int expected = 3;
        AccountStandard accountStandard1 = (AccountStandard) account1;
        accountStandard1.setFailedLoginAttempts(3);
        assertEquals(expected,accountStandard1.getFailedLoginAttempts());

    }

    @Test
    void buy() {
        MusicTitle musicTitle1 = new MusicTitle("When we were young","Adele",10);
        ArrayList<MusicTitle> expected1 = new ArrayList<>();
        expected1.add(musicTitle1);
        AccountStandard accountStandard1 = (AccountStandard) account1;
        accountStandard1.setBalance(100);
        accountStandard1.setLoggedIn(true);
        accountStandard1.buy(musicTitle1);
        assertEquals(expected1, accountStandard1.getTitlesBought());
        int expected2 = 90;
        assertEquals(expected2, accountStandard1.getBalance());
    }

    @Test
    void testToString() {
    }
}