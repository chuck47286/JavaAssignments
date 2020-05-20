import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/2/9 22:38
 */
public class BinarySearchTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8; i+=2) {
            list.add(2);
        }
        int binarySearch = Collections.binarySearch(list, 1);
        System.out.println(binarySearch);
    }
}
