package predictive;
/**
 * The class is to parse the numeric signature and return all possible result.
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
