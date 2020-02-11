package predictive;

import java.io.*;
import java.util.*;

/**
 * The class is to implement the Interface Dictionary in order to search the word by the
 * certain series of numbers more efficiently.
 *
 * @author YuCheng
 * @version 2020/2/9 11:14
 */
public class ListDictionary implements Dictionary{
    private List<WordSig> listdic;
    /**
     * This constructs a new ListDictionary Object. It sets dict to a new
     * ArrayList for the words and signatures to be stored as pairs in a WordSig
     * object. This words are read from the dictionary file 'words' found in
     * C:\Users\Administrator.PC-20190121EABW\IdeaProjects\JavaAssignments\src\predictive\words.
     * (This is in the window OS, it is little different in format from linux)
     * If the word is invalid, it will not add to list. The
     * list is then sorted by signature in a natural order using the Collections
     * sort method. Warning: Duplicates exist in dictionary.
     *
     */
    public ListDictionary(String path) {
        listdic = new ArrayList<>();
        File file =
//                new File("C:\\Users\\Administrator.PC-20190121EABW\\IdeaProjects\\JavaAssignments\\src\\predictive\\words");
//                new File(ListDictionary.class.getResource("/predictive/words").getFile());
            new File(
//                    "/home/chuck/IdeaProjects/JavaAssignments/src/predictive/words"
//                    "/usr/share/dict/words"
                    path
            );



        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                if (isValidWord(line)) {
                    String linesignature = wordToSignature(line);
                    listdic.add(new WordSig(line, linesignature));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(listdic);
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
        for (char c : line.toCharArray()) {
            if (c < 97 || c > 122) {
                return false;
            }
        }
        return true;

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
        Set<String> res = new HashSet<>();
        WordSig ws = new WordSig("", signature);
        int index = Collections.binarySearch(listdic, ws);
        int max = listdic.size();
        if (index >= 0) {
            int tempindex = index;
            // go down search
            while (tempindex >= 0 && listdic.get(tempindex).getSignature().equals(signature)) {
                res.add(listdic.get(tempindex).getWords());
                tempindex--;
            }
            tempindex = index;
            // go up search
            while (tempindex < max && listdic.get(tempindex).getSignature().equals(signature)) {
                res.add(listdic.get(tempindex).getWords());
                tempindex++;
            }
        }
        return res;
    }
    /*public static void main(String[] args) {
        String input = "4663";
        ListDictionary ld = new ListDictionary();
        Set<String> strings = ld.signatureToWords(input);
        System.out.println(strings);
    }*/
}
