/**
 * A class MusicTile implements the interface MusicTitleInterface and has three field variables
 * such as title, artist and price of types String, String and int respectively.
 *
 * @author YuCheng
 * @version 2019-11-05
 */
public class MusicTitle implements MusicTitleInterface {
    private String title;
    private String artist;
    private int price;

    /**
     *
     * @param title The title of the MusicTitle.
     * @param artist The artist of the MusicTitle.
     * @param price The price of the MusicTitle.
     */
    public MusicTitle(String title, String artist, int price) {
        this.title = title;
        this.artist = artist;
        this.price = price;
    }

    /**
     * A standard method getter to get the title of the MusicTitle.
     * @return The title of the MusicTitle.
     */
    @Override
    public String getTitle() {
        return this.title;
    }
    /**
     * A standard method getter to get the artist of the MusicTitle.
     * @return The artist of the MusicTitle.
     */
    @Override
    public String getArtist() {
        return this.artist;
    }
    /**
     * A standard method getter to get the price of the MusicTitle.
     * @return The price of the MusicTitle.
     */
    @Override
    public int getPrice() {
        return this.price;
    }
}
