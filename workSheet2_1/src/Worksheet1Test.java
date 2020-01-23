import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.ExpectedException;


/** @author
 *  YuCheng
 * This class contains the test cases for Worksheet1 solutions.
 *  <WRITE YOUR TEST CASES BELOW>
 */

public class Worksheet1Test {
    Worksheet1 worksheet1;
    @BeforeEach
    void setUp() {
        worksheet1= new Worksheet1();
    }
    @Test
    void power() {
        int m = 3;
        int n = 4;
        int acres = worksheet1.power(m, n);
        int exres = 81;
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void fastPower() {
        int m = 2;
        int n = 4;
        int acres = worksheet1.fastPower(m, n);
        int exres = 16;
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void negateAll() {
        List list = new List(2, new List(
                -5, new List(8,
                new List(0, new List()))));
        List acres = worksheet1.negateAll(list);
//        worksheet1.printList(acres);
        List exres = new List(-2, new List(
                5, new List(-8,
                new List(0, new List()))));
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void find1() {
        List list = new List(7, new List(
                5, new List(3,
                new List(8, new List()))));
        int acres1 = worksheet1.find(3, list);
//        worksheet1.printList(acres);
        int exres1 = 2;
        Assertions.assertEquals(exres1, acres1);
    }
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    @Test
    void find2() {
        List list = new List(7, new List(
                5, new List(3,
                new List(8, new List()))));
        try {
            int acres2  = worksheet1.find(2, list);
            int exres2 = -1;
            Assertions.assertEquals(exres2, acres2);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("cannot find", e.getMessage());
        }
    }
    @Test
    void allEven1() {
        List list = new List(7, new List(
                5, new List(3,
                new List(8, new List()))));
        boolean acres1  = worksheet1.allEven(list);
        boolean exres1 = false;
        Assertions.assertEquals(exres1, acres1);
    }
    @Test
    void allEven2() {
        List list = new List(6, new List(
                0, new List(4,
                new List(-8, new List()))));
        boolean acres2  = worksheet1.allEven(list);
        boolean exres2 = true;
        Assertions.assertEquals(exres2, acres2);
    }
    @Test
    void evenNumbers1() {
        List list = new List(2, new List(
                -5, new List(3,
                new List(8, new List(-2, new List())))));
        List acres1  = worksheet1.evenNumbers(list);
        List exres1 = new List(2, new List(8, new List(-2, new List())));
        Assertions.assertEquals(exres1, acres1);
    }
    @Test
    void sorted1() {
        List list = new List(2, new List(
                -5, new List(3,
                new List(8, new List(-2, new List())))));
        boolean acres1  = worksheet1.sorted(list);
        boolean exres1 = false;
        Assertions.assertEquals(exres1, acres1);
    }
    @Test
    void sorted2() {
        List list = new List(-2, new List());
        boolean acres2  = worksheet1.sorted(list);
        boolean exres2 = true;
        Assertions.assertEquals(exres2, acres2);
    }
    @Test
    void sorted3() {
        List list = new List(-2, new List(-2, new List()));
        boolean acres3  = worksheet1.sorted(list);
        boolean exres3 = true;
        Assertions.assertEquals(exres3, acres3);
    }
    @Test
    void merge1() {
        List lista = new List(10, new List(-2, new List()));
        List listb = new List(8, new List());
        List acres1  = worksheet1.merge(lista, listb);
        List exres1 = new List(10, new List(8, new List(-2, new List())));
        Assertions.assertEquals(exres1, acres1);
    }
    @Test
    void merge2() {
        List lista = new List();
        List listb = new List();
        List acres2  = worksheet1.merge(lista, listb);
        List exres2 = new List();
        Assertions.assertEquals(exres2, acres2);
    }
    @Test
    void removeDuplicates1() {
        List lista = new List(9, new List(8, new List(8, new List(7,
                new List(5, new List(5, new List(5, new List(2, new List()))))))));
        List acres1  = worksheet1.removeDuplicates(lista);
        List exres1 = new List(9, new List(8, new List(7,
                 new List(5, new List(2, new List())))));
        Assertions.assertEquals(exres1, acres1);
    }
    @Test
    void removeDuplicates2() {
        List lista = new List(8, new List(8, new List(8,
                        new List(8, new List()))));
        List acres2  = worksheet1.removeDuplicates(lista);
        List exres2 = new List(8, new List());
        Assertions.assertEquals(exres2, acres2);
    }
}


