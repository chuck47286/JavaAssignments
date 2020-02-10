package predictive;

/**
 * The class Sigs2WordsTree is to test the class TreeDictionary.
 *
 * chuck@chuck-ThinkPad-X280:~/IdeaProjects/JavaAssignments/src/predictive$ time java -cp . predictive.Sigs2WordsTree 4663 329
 * [hood, ione, ioof, good, hond, inne, gond, hone, hoof, gone, goof, home, gome]
 * [dbw, dax, daw, fax, day, fcy, fay]
 *
 * real    0m1.194s
 * user    0m7.535s
 * sys     0m0.117s
 *
 * @author YuCheng
 * @version 2020-2-10
 */
public class Sigs2WordsTree {
    public static void main(String[] args) {
        TreeDictionary td = new TreeDictionary();
        for (String s: args) {
            System.out.println(td.signatureToWords(s));
        }
    }
}
