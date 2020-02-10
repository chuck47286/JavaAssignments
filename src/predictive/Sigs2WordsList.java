package predictive;

/**
 * The class is to test whether the class ListDictionary runs well.
 * It is much faster than the PredictivePrototype.
 * chuck@chuck-ThinkPad-X280:~/IdeaProjects/JavaAssignments/src/predictive$ time java -cp . predictive.Sigs2WordsList 4663 329
 * [hood, ione, ioof, good, hond, inne, gond, hone, hoof, gone, goof, home, gome]
 * [dbw, dax, daw, fax, day, fcy, fay]
 *
 * real    0m0.353s
 * user    0m0.725s
 * sys     0m0.063s
 *
 *
 * @author YuCheng
 * @version 2020/2/9 23:31
 */
public class Sigs2WordsList {
    public static void main(String[] args) {
        ListDictionary ld = new ListDictionary();
        for (String s: args)
            System.out.println(ld.signatureToWords(s));
    }
}
