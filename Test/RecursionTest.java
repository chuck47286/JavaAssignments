import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/5/20 14:39
 */
class RecursionTest {
    Recursion rec1;
    Recursion rec2;
    Recursion rec3;
    Recursion rec4;
    Recursion rec5;
    Recursion rec6;
    Recursion rec7;
    Recursion rec8;
    Recursion rec9;
    Recursion rec10;
    @BeforeEach
    void setUp() {
        rec1 = new Recursion();
        rec2 = new Recursion();
        rec3 = new Recursion();
        rec4 = new Recursion();
        rec5 = new Recursion();
        rec6 = new Recursion();
        rec7 = new Recursion();
        rec8 = new Recursion();
        rec9 = new Recursion();
        rec10 = new Recursion();
    }
    /**
     * (i) duplicate element only appears in the one of input lists in the first place
     * (ii) [1, 2, 3] [1]
     * (iii) [2, 3]
     */
    @Test
    void unique1() {
        List<Integer> a = new List<>(1, new List<>(2, new List<>(3, new List<>())));
        List<Integer> b = new List<>(1, new List<>());
        List<Integer> acres = rec1.unique(a, b);
        List<Integer> exres = new List<>(2, new List<>(3, new List<>()));
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) duplicate element only appears in the one of input lists in the middle
     * (ii) [1, 2, 3] [2]
     * (iii) [1, 3]
     */
    @Test
    void unique2() {
        List<Integer> a = new List<>(1, new List<>(2, new List<>(3, new List<>())));
        List<Integer> b = new List<>(2, new List<>());
        List<Integer> acres = rec1.unique(a, b);
        List<Integer> exres = new List<>(1, new List<>(3, new List<>()));
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) duplicate element only appears in the one of input lists in the last place
     * (ii) [1, 2, 3] [3]
     * (iii) [1, 2]
     */
    @Test
    void unique3() {
        List<Integer> a = new List<>(1, new List<>(2, new List<>(3, new List<>())));
        List<Integer> b = new List<>(3, new List<>());
        List<Integer> acres = rec1.unique(a, b);
        List<Integer> exres = new List<>(1, new List<>(2, new List<>()));
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) input lists do not have duplicate element and whether output lists is sorted in ascending order
     * (ii) [1, 2, 3] [4]
     * (iii) [1, 2, 3, 4]
     */
    @Test
    void unique4() {
        List<Integer> a = new List<>(1, new List<>(2, new List<>(3, new List<>())));
        List<Integer> b = new List<>(4, new List<>());
        List<Integer> acres = rec1.unique(a, b);
        List<Integer> exres = new List<>(1, new List<>(2, new List<>(3, new List<>(4, new List<>()))));
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) input lists do not have duplicate element and whether output lists is sorted in ascending order
     * (ii) [1, 2, 3] [0]
     * (iii) [0, 1, 2, 3]
     */
    @Test
    void unique5() {
        List<Integer> a = new List<>(1, new List<>(2, new List<>(3, new List<>())));
        List<Integer> b = new List<>(0, new List<>());
        List<Integer> acres = rec1.unique(a, b);
        List<Integer> exres = new List<>(0, new List<>(1, new List<>(2, new List<>(3, new List<>()))));
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) both of input lists are empty
     * (ii) [] []
     * (iii) []
     */
    @Test
    void unique6() {
        List<Integer> a = new List<>();
        List<Integer> b = new List<>();
        List<Integer> acres = rec1.unique(a, b);
        List<Integer> exres = new List<>();
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) unique element appears in the last place in one of the input lists
     * (ii) [1, 2, 3] [1, 2]
     * (iii) [3]
     */
    @Test
    void unique7() {
        List<Integer> a = new List<>(1, new List<>(2, new List<>(3, new List<>())));
        List<Integer> b = new List<>(1, new List<>(2, new List<>()));
        List<Integer> acres = rec1.unique(a, b);
        List<Integer> exres = new List<>(3, new List<>());
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) unique element appears in the first place in one of the input lists
     * (ii) [1, 2, 3] [2, 3]
     * (iii) [1]
     */
    @Test
    void unique8() {
        List<Integer> a = new List<>(1, new List<>(2, new List<>(3, new List<>())));
        List<Integer> b = new List<>(2, new List<>(3, new List<>()));
        List<Integer> acres = rec1.unique(a, b);
        List<Integer> exres = new List<>(1, new List<>());
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) input lists has same elements
     * (ii) [1, 2, 3] [1, 2, 3]
     * (iii) []
     */
    @Test
    void unique9() {
        List<Integer> a = new List<>(1, new List<>(2, new List<>(3, new List<>())));
        List<Integer> b = new List<>(1, new List<>(2, new List<>(3, new List<>())));
        List<Integer> acres = rec1.unique(a, b);
        List<Integer> exres = new List<>();
        Assertions.assertEquals(exres, acres);
    }
    /**
     * (i) one of input lists is empty
     * (ii) [1, 2, 3] []
     * (iii) [1, 2, 3]
     */
    @Test
    void unique10() {
        List<Integer> a = new List<>(1, new List<>(2, new List<>(3, new List<>())));
        List<Integer> b = new List<>();
        List<Integer> acres = rec1.unique(a, b);
        List<Integer> exres = new List<>(1, new List<>(2, new List<>(3, new List<>())));
        Assertions.assertEquals(exres, acres);
    }


}