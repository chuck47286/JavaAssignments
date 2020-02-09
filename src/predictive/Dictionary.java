package predictive;

import java.util.Set;

/**
 * The class is to help to increase the efficiency of the searching.
 *
 * @author YuCheng
 * @version 2020/2/9 11:12
 */
public interface Dictionary {
    public Set<String> signatureToWords(String signature);
}
