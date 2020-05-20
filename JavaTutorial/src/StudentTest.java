import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class
 *
 * @author YuCheng
 * @version 2020-2-7
 */
public class StudentTest {
    Student stu1;
    Student stu2;
    Student stu3;
    Student stu4;

    @Before
    public void setUp() throws Exception {
        stu1 = new Student("bob","Li",97, "101");
        stu2 = new Student("josh","Cheng",97, "101");
        stu3 = new Student("yun","Ma",97, "101");
        stu4 = new Student("cao","cao",97, "101");

    }

    @Test
    public void compareTo() {
        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        Collections.sort(list);
        for (Student s: list) {
            System.out.println(s);
        }
    }
}