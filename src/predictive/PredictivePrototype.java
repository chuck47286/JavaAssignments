package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * The class is to
 *
 * @author YuCheng
 * @version 2020/2/8 9:36
 */
public class PredictivePrototype {
    /**
     *
     * @param word The input of the word combination.
     * @return The numeric signature to present the input of the word.
     */
    public static String wordToSignature(String word) {
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
    public static Set<String> signatureToWords(String signature) {
        Set<String> res = new HashSet();
        try {
            Scanner sc = new Scanner(new File("./words"));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                if (line.length() != signature.length() && !isValidWord(line)) {
                    continue;
                }
                res.add(line.toLowerCase());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     *
     * @param line The input of the String word.
     * @return judge whether it is word.
     */
    private static boolean isValidWord(String line) {
        return false;
    }
}
