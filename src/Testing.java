import java.util.ArrayList;
import java.util.List;

/**
 * The class is to output the list which has those element which appears in one of input lists but not the order.
 *
 * @author YuCheng
 * @version 2020/5/20 12:56
 */
public class Testing {
    static List<Integer> unique(List<Integer> a, List<Integer> b) {
        if (a == null) return b;
        if (b == null) return a;
        List<Integer> ans = new ArrayList<>();
        int lena = a.size(), lenb = b.size();
        int pa = 0, pb = 0;
        while (pa < lena && pb < lenb) {
            int la = a.get(pa), lb = b.get(pb);
            if (la < lb) {
                ans.add(la);
                pa++;
            } else if (la > lb) {
                ans.add(lb);
                pb++;
            } else {
                pa++;
                pb++;
            }
        }
//        if (pa != lena) {
//            while (pa < lena) ans.add(pa++);
//        }
//        if (pb != lenb) {
//
//        }
        while (pa < lena) ans.add(a.get(pa++));
        while (pb < lenb) ans.add(b.get(pb++));
        return ans;
    }
}
