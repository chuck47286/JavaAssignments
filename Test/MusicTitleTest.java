import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YuCheng
 * @version 2019-11-05
 */
class MusicTitleTest {
    private MusicTitle musicTitle1;
    @BeforeEach
    void setUp() {
        musicTitle1 = new MusicTitle("When we were young", "Adele", 10);
    }

    @Test
    void getTitle() {
        String expected = "When we were young";
        String actual = musicTitle1.getTitle();
        assertEquals(expected,actual);
    }

    @Test
    void getArtist() {
        String expected = "Adele";
        String actual = musicTitle1.getArtist();
        assertEquals(expected,actual);
    }

    @Test
    void getPrice() {
        int expected = 10;
        int actual = musicTitle1.getPrice();
        assertEquals(expected,actual);
    }
}