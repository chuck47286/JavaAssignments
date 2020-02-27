package predictive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * The class MapDictionary is the another way to implement the Interface Dictionary.
 *
 * @author YuCheng
 * @version 2020-2-10
 */
public class MapDictionary implements Dictionary{
    Map<String, Set<String>> map;

    public MapDictionary(String path) {
//        map = new HashMap<>();
        map = new TreeMap<>();
        File file =
//                new File("C:\\Users\\Administrator.PC-20190121EABW\\IdeaProjects\\JavaAssignments\\src\\predictive\\words");
//                new File(ListDictionary.class.getResource("/predictive/words").getFile());
                new File(
//                    "/home/chuck/IdeaProjects/JavaAssignments/src/predictive/words"
//                        "/usr/share/dict/words"
                        path
                );


        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                if (isValidWord(line)) {
                    /**
                     * The hashmap would store the signature of the word as the
                     * key, and the word of the same signature as the value.
                     * So, the map would get or put the signature by the hash method
                     * that is O(1) time complexity if the entry is not too much.
                     */
                    String sig = wordToSignature(line);
                    if (!map.containsKey(sig)) {
                        map.put(sig, new HashSet<>());
                    }
                    map.get(sig).add(line);
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
    }

    /**
     *
     * @param signature The input of the signature of the String.
     * @return All possible matching words.
     */
    @Override
    public Set<String> signatureToWords(String signature) {
        /*if (map.containsKey("signature")) {
            return map.get(signature);
        }
        return new HashSet<>();*/
        return map.getOrDefault(signature, new HashSet<>());
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

}
