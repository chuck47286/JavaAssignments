package predictive;

/**
 * The class to test the class MapDictionary.
 * chuck@chuck-ThinkPad-X280:~/IdeaProjects/JavaAssignments/src/predictive$ time java -cp . predictive.Sigs2WordsMap 4663 329
 * [hood, ione, ioof, good, hond, inne, gond, hone, hoof, gone, goof, home, gome]
 * [dbw, dax, daw, fax, day, fcy, fay]
 *
 * real    0m0.827s
 * user    0m4.156s
 * sys     0m0.073s
 *
 *
 * @author YuCheng
 * @version 2020-2-10
 */
public class Sigs2WordsMap {
    public static void main(String[] args) {
        MapDictionary md = new MapDictionary();
        for (String s: args) {
            System.out.println(md.signatureToWords(s));
        }
    }
}
