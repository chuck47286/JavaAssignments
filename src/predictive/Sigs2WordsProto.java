package predictive;
/**
 * The class is to parse the numeric signature and return all possible result.
 * chuck@chuck-ThinkPad-X280:~/IdeaProjects/JavaAssignments/src/predictive$ time java -cp . predictive.Sigs2WordsProto 4663 329
 * [hood, ione, ioof, good, hond, inne, gond, hone, hoof, gone, goof, home, gome]
 * [dbw, dax, daw, fax, day, fcy, fay]
 *
 * real    0m0.938s
 * user    0m1.691s
 * sys     0m0.192s
 *
 * @author YuCheng
 * @version 2020/2/8 23:35
 */
public class Sigs2WordsProto {
    public static void main(String[] args) {
        for (String s: args)
            System.out.println(PredictivePrototype.signatureToWords(s));
    }
}
