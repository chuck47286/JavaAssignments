/**
 * The class is to implement the an efficient implementation of the method unique to find the unique element in input lists.
 *
 * @author YuCheng
 * @version 2020/5/20 13:58
 */
public class Recursion {
    static List<Integer> unique(List<Integer> a, List<Integer> b) {
        if (a == null || a.isEmpty()) return b;
        if (b == null || b.isEmpty()) return a;
        if (a.getHead() < b.getHead()) {
            return new List<>(a.getHead(), unique(a.getTail(), b));
        } else if (a.getHead() == b.getHead()) {
            return unique(a.getTail(), b.getTail());
        } else {
            return new List<>(b.getHead(), unique(a, b.getTail()));
        }
    }
}
