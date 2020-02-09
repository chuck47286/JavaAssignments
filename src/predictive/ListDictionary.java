package predictive;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The class is to implement the Interface Dictionary in order to search the word by the
 * certain series of numbers more efficiently.
 *
 * @author YuCheng
 * @version 2020/2/9 11:14
 */
public class ListDictionary implements Dictionary{
    private List<WordSig> listdic;
    public ListDictionary() {
        listdic = new ArrayList<>();

    }


    /**
     *
     * @param word The input of the word combination.
     * @return The numeric signature to present the input of the word.
     */
    public String wordToSignature(String word) {
        if (word == null || word.length() == 0) {
            return " ";
        }
        /**
         * The advantage of StringBuffer than String is saving memory and
         * efficient. This is because the object of the StringBuffer can
         * be modified(such as append operation) multiple times without
         * generating new objects.
         */
        StringBuffer sb = new StringBuffer();
        for (char c: word.toCharArray()) {
            if (c == 'a' || c == 'b' || c == 'c') {
                sb.append(2);
            } else if (c == 'd' || c == 'e' || c == 'f') {
                sb.append(3);
            } else if (c == 'g' || c == 'h' || c == 'i') {
                sb.append(4);
            } else if (c == 'j' || c == 'k' || c == 'l') {
                sb.append(5);
            } else if (c == 'm' || c == 'n' || c == 'o') {
                sb.append(6);
            } else if (c == 'p' || c == 'q' || c == 'r' || c == 's') {
                sb.append(7);
            } else if (c == 't' || c == 'u' || c == 'v') {
                sb.append(8);
            } else if (c == 'w' || c == 'x' || c == 'y' || c == 'z') {
                sb.append(9);
            }
        }
        return sb.toString();
    }

    /**
     *
     * @param signature The input of the numeric signature.
     * @return The set of possible matching words from the dictionary.
     */
    @Override
    public Set<String> signatureToWords(String signature) {

        return null;
    }
}
