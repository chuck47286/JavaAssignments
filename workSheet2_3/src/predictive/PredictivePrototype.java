package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * The class has two methods to implement how the program to use the digits 1-9 to
 * simulate the dialing phone numbers.
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
            return "";
        }
        /**
         * The advantage of StringBuffer than String is saving memory and
         * efficient. This is because the object of the StringBuffer can
         * be modified(such as append operation) multiple times without
         * generating new objects.
         */
        StringBuffer sb = new StringBuffer();
        for (char c: word.toLowerCase().toCharArray()) {
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
            } else {
                sb.append(" ");
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
        Set<String> res = new HashSet<String>();
        try {
            Scanner sc =
                    new Scanner(
                            new File(
//                                    "/home/chuck/IdeaProjects/JavaAssignments/src/predictive/words"
                                    "C:\\Users\\Administrator.PC-20190121EABW\\IdeaProjects\\JavaAssignments\\workSheet2_3\\src\\predictive\\words"
                            ));
            while (sc.hasNext()) {
                String line = sc.nextLine().toLowerCase();

                if (line.length() == signature.length()
                        && isValidWord(line)
                        && signature.equals(wordToSignature(line))) {
                    res.add(line);
                }
            }
            sc.close();
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
        if (line == null || line.length() == 0) {
            return false;
        }
        return true;

    }

    /*public static void main(String[] args) {
        String input = "4663";
        Set<String> strings = signatureToWords(input);
        System.out.println(strings);
    }*/
}
