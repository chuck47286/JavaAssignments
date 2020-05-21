import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/5/20 13:12
 */
class TestingTest {
    Testing test1;
    Testing test2;
    Testing test3;
    Testing test4;
    Testing test5;
    Testing test6;
    Testing test7;
    Testing test8;
    Testing test9;
    Testing test10;
    @BeforeEach
    void setUp() {
        test1 = new Testing();
        test2 = new Testing();
        test3 = new Testing();
        test4 = new Testing();
        test5 = new Testing();
        test6 = new Testing();
        test7 = new Testing();
        test8 = new Testing();
        test9 = new Testing();
        test10 = new Testing();
    }


    /**
     * (i) duplicate element only appears in the one of input lists in the first place
     * (ii) [1, 2, 3] [1]
     * (iii) [2, 3]
     */
    @Test
    void unique1() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(1);
        List<Integer> acres = test1.unique(a, b);
        List<Integer> exres = Arrays.asList(2 , 3);
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) duplicate element only appears in the one of input lists in the middle
     * (ii) [1, 2, 3] [2]
     * (iii) [1, 3]
     */
    @Test
    void unique2() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(2);
        List<Integer> acres = test2.unique(a, b);
        List<Integer> exres = Arrays.asList(1 , 3);
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) input lists have same elements
     * (ii) [1, 2, 3] [1, 2, 3]
     * (iii) []
     */
    @Test
    void unique3() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(3);
        List<Integer> acres = test3.unique(a, b);
        List<Integer> exres = Arrays.asList(1 , 2);
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) input lists do not have duplicate element and whether output lists is sorted in ascending order
     * (ii) [1, 2, 3] [4]
     * (iii) [1, 2, 3, 4]
     */
    @Test
    void unique4() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4);
        List<Integer> acres = test4.unique(a, b);
        List<Integer> exres = Arrays.asList(1, 2, 3, 4);
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) One of input lists is empty
     * (ii) [1, 2, 3] []
     * (iii) [1, 2, 3]
     */
    @Test
    void unique5() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList();
        List<Integer> acres = test5.unique(a, b);
        List<Integer> exres = Arrays.asList( 1, 2, 3);
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) one of input lists is empty
     * (ii) [] [1, 2, 3]
     * (iii) [1, 2, 3]
     */
    @Test
    void unique6() {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = Arrays.asList(1 ,2 ,3);
        List<Integer> acres = test6.unique(a, b);
        List<Integer> exres = Arrays.asList(1, 2, 3 );
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) both of input lists are empty
     * (ii) [] []
     * (iii) []
     */
    @Test
    void unique7() {
        List<Integer> a = Arrays.asList();
        List<Integer> b = Arrays.asList();
        List<Integer> acres = test7.unique(a, b);
        List<Integer> exres = Arrays.asList();
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) one of input lists is null
     * (ii) [1, 2, 3] null
     * (iii) [1, 2, 3]
     */
    @Test
    void unique8() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = null;
        List<Integer> acres = Arrays.asList(1, 2, 3);
        List<Integer> exres = Arrays.asList(1, 2, 3);
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) one of input lists is null
     * (ii) null [1, 2, 3]
     * (iii) [1, 2, 3]
     */
    @Test
    void unique9() {
        List<Integer> a = null;
        List<Integer> b = Arrays.asList(1, 2, 3);
        List<Integer> acres = test9.unique(a, b);
        List<Integer> exres = Arrays.asList(1, 2, 3);
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) both of input lists are null
     * (ii) null null
     * (iii) null
     */
    @Test
    void unique10() {
        List<Integer> a = null;
        List<Integer> b = null;
        List<Integer> acres = test10.unique(a, b);
        List<Integer> exres = null;
        Assertions.assertEquals(exres, acres);
    }

}