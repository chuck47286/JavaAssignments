package predictive;

import javafx.scene.layout.Priority;
import jdk.nashorn.internal.objects.annotations.Function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * The class TreeDictionary is another way to implement the Interface Dictionary.
 *
 * @author YuCheng
 * @version 2020-2-10
 */
public class TreeDictionary implements  Dictionary{
    class TrieNode {
        Set<String> word;
//        PriorityQueue<String> word;
        TrieNode[] children;
//        boolean hasword;
        public TrieNode() {
            children = new TrieNode[8];
            word = new HashSet<>();
           /* word = new PriorityQueue<String>(new Comparator<String>(){
                @Override
                public int compare(String a, String b) {
                    return a.length() - b.length();
                }
            });*/
        }
    }
    TrieNode root;
    public TreeDictionary(String path) {
        root = new TrieNode();
        File file =
//                new File("C:\\Users\\Administrator.PC-20190121EABW\\IdeaProjects\\JavaAssignments\\src\\predictive\\words");
//                new File(ListDictionary.class.getResource("/predictive/words").getFile());
                new File(
//                        "/home/chuck/IdeaProjects/JavaAssignments/src/predictive/words"
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
                    String sig = wordToSignature(line);
                    /**
                     * TrieNode is to store the word of the line if
                     * it is the leaf node. Otherwise, it could DFS the
                     * whole tire until the leaf node.
                     */
                    TrieNode cur = root;
                    for (char c: sig.toCharArray()) {
                        if (cur.children[c - '2'] == null) {
                            cur.children[c - '2'] = new TrieNode();
                        }
                        cur = cur.children[c - '2'];
                        cur.word.add(line);
                    }
//                    cur.hasword = true;
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
     * @param signature The input of the signature.
     * @return The set of String which the signature represents.
     */
    @Override
    public Set<String> signatureToWords(String signature) {
        TrieNode cur = root;
        for (char c : signature.toCharArray()) {
            if (cur.children[c - '2'] != null) {
                cur = cur.children[c - '2'];
            } else {
                return new HashSet<String>();
            }
        }
        /*Set<String> res = new HashSet<>();
        while (!cur.word.isEmpty()) {
            String str = cur.word.poll();
            if (str.length() > signature.length()) {
                break;
            }
            res.add(str);
        }*/
        Set<String> res = new HashSet<>();
        for (String str: cur.word) {
            if (str.length() == signature.length()) {
                res.add(str);
            } else {
                res.add(str.substring(0, signature.length()));
            }
        }
        return res;
    }
}
