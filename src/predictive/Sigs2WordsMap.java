package predictive;

/**
 * The class to test the class MapDictionary.
 *
 * @author YuCheng
 * @version 2020-2-10
 */
public class Sigs2WordsMap {
    public static void main(String[] args) {
        MapDictionary md = new MapDictionary("/usr/share/dict/words");
        for (String s: args) {
            System.out.println(md.signatureToWords(s));
        }
    }
}
