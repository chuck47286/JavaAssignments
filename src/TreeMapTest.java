import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/3/4 21:24
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String, Integer> treemap = new TreeMap<>();

        treemap.put("Boy", 20);
        treemap.put("Chuck", 20);
        treemap.put("Bye", 19);
        treemap.put("Alice", 23);
        treemap.put("Allen", 19);
        treemap.put("Af", 20);
        for (Map.Entry<String,Integer> entry: treemap.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            System.out.println("key: " + key + ",\tval: " + val );
        }
        System.out.println("---------------");
        // 下面的这种方法就是我们的倒序，这里只能对key实现倒序
        TreeMap<String, Integer> treemapRev = new TreeMap<>(new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        treemapRev.putAll(treemap);
        for (Map.Entry<String, Integer> entry: treemapRev.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            System.out.println("key: " + key + ",\tval: "+ val);
        }

    }
}
