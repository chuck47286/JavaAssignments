package predictive;

/**
 * The class is to test whether the class ListDictionary runs well.
 * It is much faster than the PredictivePrototype.
 *
 *
 *
 * @author YuCheng
 * @version 2020/2/9 23:31
 */
public class Sigs2WordsList {
    public static void main(String[] args) {
        ListDictionary ld = new ListDictionary("/usr/share/dict/words");
        for (String s: args)
            System.out.println(ld.signatureToWords(s));
    }
}
