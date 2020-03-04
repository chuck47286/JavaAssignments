import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/3/4 20:58
 */
class NameTest {
    Name name1;
    Name name2;
    Name name3;
    Name name4;
    Name name5;
    Name name6;
    Name name7;
    @BeforeEach
    void setUp() {
        name1 = new Name("Bob", "Lee");
        name2 = new Name("Alice", "Zhang");
        name3 = new Name("Chuck", "James");
        name4 = new Name("Ella", "Cheng");
        name5 = new Name("Fu", "Cheng");
        name6 = new Name("Fu", "Xin");
        name7 = new Name("Fu", "Cai");
    }

    @Test
    void testToString() {
        System.out.println(name1);
    }

    @Test
    void compareTo() {
        List<Name> list = new ArrayList<>();
        list.add(name1);
        list.add(name2);
        list.add(name3);
        list.add(name4);
        list.add(name5);
        list.add(name6);
        list.add(name7);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("-------------");
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}