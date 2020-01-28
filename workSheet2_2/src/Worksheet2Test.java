import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


/** @author 
 *  YuCheng
 * This class contains the test cases for Worksheet2 solutions.
 *  <WRITE YOUR TEST CASES BELOW>
 */

public class Worksheet2Test {
    Worksheet2 worksheet2;
    @BeforeEach
    void setUp() {
        worksheet2 = new Worksheet2();
    }

    static Tree<Integer> buildTree(Integer[] arr, int index) {
        if (arr == null || arr.length == 0 || index >= arr.length || arr[index] == null) {
            return new Tree<>();
        }
        return new Tree<>(arr[index],
                buildTree(arr, index * 2 + 1), buildTree(arr, index * 2 + 2));
    }
    static List<Integer> buildList(Integer[] arr) {
        List<Integer> res = new List<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != null) {
                res = new List<>(arr[i], res);
            }
        }
        return res;
    }
    static void printList(List<Integer> list) {
        if (!list.isEmpty()) {
            System.out.println(list.toString());
        }
    }
    // ---------------------------negateAll---------------------

    @Test
    void negateAll1() {
        /*Tree<Integer> t = new Tree<>(1, new Tree<>(2, new Tree<>(), new Tree<>()),
                new Tree<>(3, new Tree<>(4, new Tree<>(), new Tree<>()), new Tree<>()));*/
        Integer[] arr = {1, 2, 3, null, null, 4};
        Tree<Integer> t  = buildTree(arr, 0);
//        String format = Tree.format(t);
//        System.out.println(format);
        Tree<Integer> acres = worksheet2.negateAll(t);
        Integer[] exarr = {-1, -2, -3, null, null, -4};
        Tree<Integer> exres = buildTree(exarr, 0);
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void negateAll2() {
        Integer[] arr = {-9, 0, null, 9};
        Tree<Integer> t  = buildTree(arr, 0);
//        String format = Tree.format(t);
//        System.out.println(format);
        Tree<Integer> acres = worksheet2.negateAll(t);
        Integer[] exarr = {9, 0, null, -9};
        Tree<Integer> exres = buildTree(exarr, 0);
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void negateAll3() {
        Integer[] arr = null;
        Tree<Integer> t  = buildTree(arr, 0);
//        String format = Tree.format(t);
//        System.out.println(format);
        Tree<Integer> acres = worksheet2.negateAll(t);
        Integer[] exarr = null;
        Tree<Integer> exres = buildTree(exarr, 0);
        Assertions.assertEquals(exres, acres);
    }
// ---------------------------allEven---------------------
    @Test
    void allEven1() {
        /*Tree<Integer> t = new Tree<>(1, new Tree<>(2, new Tree<>(), new Tree<>()),
                new Tree<>(3, new Tree<>(4, new Tree<>(), new Tree<>()), new Tree<>()));*/
        Integer[] arr = {1, 2, 3, null, null, 4};
        Tree<Integer> t  = buildTree(arr, 0);
//        String format = Tree.format(t);
//        System.out.println(format);
        boolean acres = worksheet2.allEven(t);
        boolean exres = false;
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void allEven2() {
        /*Tree<Integer> t = new Tree<>(1, new Tree<>(2, new Tree<>(), new Tree<>()),
                new Tree<>(3, new Tree<>(4, new Tree<>(), new Tree<>()), new Tree<>()));*/
        Integer[] arr = null;
        Tree<Integer> t  = buildTree(arr, 0);
//        String format = Tree.format(t);
//        System.out.println(format);
        boolean acres = worksheet2.allEven(t);
        boolean exres = true;
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void allEven3() {
        /*Tree<Integer> t = new Tree<>(1, new Tree<>(2, new Tree<>(), new Tree<>()),
                new Tree<>(3, new Tree<>(4, new Tree<>(), new Tree<>()), new Tree<>()));*/
        Integer[] arr = {2, 4, null, 6, 8};
        Tree<Integer> t  = buildTree(arr, 0);
//        String format = Tree.format(t);
//        System.out.println(format);
        boolean acres = worksheet2.allEven(t);
        boolean exres = true;
        Assertions.assertEquals(exres, acres);
    }
// ---------------------------depth---------------------
    @Test
    void depth1() {
        /*Tree<Integer> t = new Tree<>(1, new Tree<>(2, new Tree<>(), new Tree<>()),
                new Tree<>(3, new Tree<>(4, new Tree<>(), new Tree<>()), new Tree<>()));*/
        Integer[] arr = {5, 3, 8, 1, 4, 6, null};
        Tree<Integer> t  = buildTree(arr, 0);
//        String format = Tree.format(t);
//        System.out.println(format);
        int acres = worksheet2.depth(t,3);
        int exres = 1;
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void depth2() {
//        Tree<Integer> t = new Tree<>(1, new Tree<>(2, new Tree<>(), new Tree<>()),
//                new Tree<>(3, new Tree<>(4, new Tree<>(), new Tree<>()), new Tree<>()));
        Integer[] arr = null;
        Tree<Integer> t  = buildTree(arr, 0);
//        String format = Tree.format(t);
//        System.out.println(format);
        int acres = worksheet2.depth(t,0);
        int exres = -1;
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void depth3() {
//        Tree<Integer> t = new Tree<>(1, new Tree<>(2, new Tree<>(), new Tree<>()),
//                new Tree<>(3, new Tree<>(4, new Tree<>(), new Tree<>()), new Tree<>()));
        Integer[] arr = {2, 4, null, 6, 8};
        Tree<Integer> t  = buildTree(arr, 0);
//        String format = Tree.format(t);
//        System.out.println(format);
        int acres = worksheet2.depth(t,5);
        int exres = -1;
        Assertions.assertEquals(exres, acres);
    }

    // ---------------------------preorder---------------------
    @Test
    void preorder1() {
        /*Tree<Integer> t = new Tree<>(1, new Tree<>(2, new Tree<>(), new Tree<>()),
                new Tree<>(3, new Tree<>(4, new Tree<>(), new Tree<>()), new Tree<>()));*/
        Integer[] arr = {5, 2, 6, 1, 4, null, 8, null, null, 3, null, null, null, 7, 9};
        Tree<Integer> t  = buildTree(arr, 0);
//        String format = Tree.format(t);
//        System.out.println(format);
        List<Integer> acres = worksheet2.preorder(t);
//        printList(acres);
        Integer[] exarr = {5, 2, 1, 4, 3, 6, 8, 7, 9};
        List<Integer> exres = buildList(exarr);
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void preorder2() {
        /*Tree<Integer> t = new Tree<>(1, new Tree<>(2, new Tree<>(), new Tree<>()),
                new Tree<>(3, new Tree<>(4, new Tree<>(), new Tree<>()), new Tree<>()));*/
        Integer[] arr = {5, 1, 4};
        Tree<Integer> t  = buildTree(arr, 0);
//        String format = Tree.format(t);
//        System.out.println(format);
        List<Integer> acres = worksheet2.preorder(t);
//        printList(acres);
        Integer[] exarr = {5, 1, 4};
        List<Integer> exres = buildList(exarr);
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void preorder3() {
        /*Tree<Integer> t = new Tree<>(1, new Tree<>(2, new Tree<>(), new Tree<>()),
                new Tree<>(3, new Tree<>(4, new Tree<>(), new Tree<>()), new Tree<>()));*/
//        Integer[] arr = {};
        Integer[] arr = null;
        Tree<Integer> t  = buildTree(arr, 0);
//        String format = Tree.format(t);
//        System.out.println(format);
        List<Integer> acres = worksheet2.preorder(t);
//        printList(acres);
        List<Integer> exres = new List<>();
        Assertions.assertEquals(exres, acres);
    }
    // ---------------------------isSearchTree---------------------
    @Test
    void isSearchTree1() {
        Integer[] arr = null;
        Tree<Integer> t  = buildTree(arr, 0);
        boolean acres = worksheet2.isSearchTree(t);
        boolean exres = true;
        Assertions.assertEquals(acres, exres);
    }
    @Test
    void isSearchTree2() {
//        Integer[] arr = {5, 6, 2};
        Integer[] arr = {5, 6, 6};
//        Integer[] arr = {5, 2, 6};
        Tree<Integer> t  = buildTree(arr, 0);
        boolean acres = worksheet2.isSearchTree(t);
        boolean exres = false;
//        boolean exres = true;
        Assertions.assertEquals(acres, exres);
    }
    @Test
    void isSearchTree3() {
        Integer[] arr = {5, 2, 6, 1, 4, null, 8, null, null, 3, null, null, null, 7, 9};
        Tree<Integer> t  = buildTree(arr, 0);
        boolean acres = worksheet2.isSearchTree(t);
//        Integer[] exarr = {5, 1, 4};
        boolean exres = true;
        Assertions.assertEquals(acres, exres);
    }
    // ---------------------------max---------------------
    @Test
    void max1() {
        Integer[] arr = null;
        Tree<Integer> t  = buildTree(arr, 0);
        int acres = worksheet2.max(t);
        int exres = 0;
        Assertions.assertEquals(acres, exres);
    }
    @Test
    void max2() {
//        Integer[] arr = {5, 6, 2};
//        Integer[] arr = {5, 6, 6};
        Integer[] arr = {5, 2, 6};
        Tree<Integer> t  = buildTree(arr, 0);
        int acres = worksheet2.max(t);
        int exres = 6;
//        boolean exres = true;
        Assertions.assertEquals(acres, exres);
    }
    @Test
    void max3() {
        Integer[] arr = {5, 2, 6, 1, 4, null, 8, null, null, 3, null, null, null, 7, 9};
        Tree<Integer> t  = buildTree(arr, 0);
        int acres = worksheet2.max(t);
//        Integer[] exarr = {5, 1, 4};
        int exres = 9;
        Assertions.assertEquals(acres, exres);
    }
    // ---------------------------delete---------------------
    @Test
    void delete1() {
        Integer[] arr = null;
        Tree<Integer> t  = buildTree(arr, 0);
        Tree<Integer> acres = worksheet2.delete(t, 0);
        Tree<Integer> exres = new Tree<>();
        Assertions.assertEquals(acres, exres);
    }
    @Test
    void delete2() {
        Integer[] arr = {5, 2, 6};
        Tree<Integer> t  = buildTree(arr, 0);
        Tree<Integer> acres = worksheet2.delete(t, 5);
        Integer[] exarr = {2, null, 6};
        Tree<Integer> exres = buildTree(exarr, 0);
        Assertions.assertEquals(acres, exres);
    }
    @Test
    void delete3() {
        Integer[] arr = {5, 2, 6, 1, 4, null, 8, null, null, 3, null, null, null, 7, 9};
//        Integer[] arr = {5, 2, 6, 0, 4, null, 8, null, 1, 3, null, null, null, 7, 9};
        Tree<Integer> t  = buildTree(arr, 0);
        Tree<Integer> acres = worksheet2.delete(t, 2);
        Integer[] exarr = {5, 1, 6, null, 4, null, 8, null, null, 3, null, null, null, 7, 9};
//        Integer[] exarr = {5, 1, 6, 0, 4, null, 8, null, null, 3, null, null, null, 7, 9};
        Tree<Integer> exres = buildTree(exarr, 0);
        Assertions.assertEquals(acres, exres);
    }
    // ---------------------------delete---------------------
    @Test
    void isHeightBalanced1() {
        Integer[] arr = null;
        Tree<Integer> t  = buildTree(arr, 0);
        boolean acres = worksheet2.isHeightBalanced(t);
        boolean exres = true;
        Assertions.assertEquals(acres, exres);
    }
    @Test
    void isHeightBalanced2() {
        Integer[] arr = {5, 2, 6, 1};
        Tree<Integer> t  = buildTree(arr, 0);
        boolean acres = worksheet2.isHeightBalanced(t);
//        Integer[] exarr = {2, null, 6};
        boolean exres = true;
        Assertions.assertEquals(acres, exres);
    }
    @Test
    void isHeightBalanced3() {
//        Integer[] arr = {5, 2, 6, 1, 4, null, 8, null, null, 3};
        Integer[] arr = {5, 2, 6, 1, 4, null, 8, null, null, 3, null, null, null, 7, 9};
        Tree<Integer> t  = buildTree(arr, 0);
        boolean acres = worksheet2.isHeightBalanced(t);
//        Integer[] exarr = {5, 1, 6, null, 4, null, 8, null, null, 3, null, null, null, 7, 9};
//        Integer[] exarr = {5, 1, 6, 0, 4, null, 8, null, null, 3, null, null, null, 7, 9};
//        Tree<Integer> exres = buildTree(exarr, 0);
        boolean exres = false;
        Assertions.assertEquals(acres, exres);
    }
    // ---------------------------insertHB & deleteHB---------------------
    @Test
    void insertHB1() {
        Integer[] arr = null;
        Tree<Integer> t  = buildTree(arr, 0);
        Tree<Integer> acres = worksheet2.insertHB(t, 1);
        Tree<Integer> exres = new Tree(1);
        Assertions.assertEquals(acres, exres);
    }
    @Test
    void insertHB2() {
        Integer[] arr = {3,2};
        Tree<Integer> t  = buildTree(arr, 0);
        Tree<Integer> acres = worksheet2.insertHB(t, 1);
//        System.out.println(worksheet2.isHeightBalanced(acres));
        Integer[] exarr = {2,1,3};
        Tree<Integer> exres = buildTree(exarr, 0);
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void insertHB3() {
        Integer[] arr = {1,null,2};
        Tree<Integer> t  = buildTree(arr, 0);
        Tree<Integer> acres = worksheet2.insertHB(t, 3);
//        System.out.println(worksheet2.isHeightBalanced(acres));
        Integer[] exarr = {2, 1, 3};
        Tree<Integer> exres = buildTree(exarr, 0);
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void insertHB4() {
//        Integer[] arr = {5, 2, 6, 1, 4, null, 8, null, null, 3};
        Integer[] arr = {4, 2};
        Tree<Integer> t  = buildTree(arr, 0);
        Tree<Integer> acres = worksheet2.insertHB(t, 3);
//        Integer[] exarr = {5, 1, 6, null, 4, null, 8, null, null, 3, null, null, null, 7, 9};
        Integer[] exarr = {3, 2, 4};
        Tree<Integer> exres = buildTree(exarr, 0);
        Assertions.assertEquals(acres, exres);
    }
    @Test
    void insertHB5() {
//        Integer[] arr = {5, 2, 6, 1, 4, null, 8, null, null, 3};
        Integer[] arr = {4, null, 6};
        Tree<Integer> t  = buildTree(arr, 0);
        Tree<Integer> acres = worksheet2.insertHB(t, 5);
//        Integer[] exarr = {5, 1, 6, null, 4, null, 8, null, null, 3, null, null, null, 7, 9};
        Integer[] exarr = {5, 4, 6};
        Tree<Integer> exres = buildTree(exarr, 0);
        Assertions.assertEquals(acres, exres);
    }
    @Test
    void deleteHB1() {
        Integer[] arr = null;
        Tree<Integer> t  = buildTree(arr, 0);
        Tree<Integer> acres = worksheet2.deleteHB(t, 1);
        Tree<Integer> exres = new Tree();
        Assertions.assertEquals(acres, exres);
    }
    @Test
    void deleteHB2() {
        Integer[] arr = {3, 2, 4, 1};
        Tree<Integer> t  = buildTree(arr, 0);
        Tree<Integer> acres = worksheet2.deleteHB(t, 4);
//        System.out.println(worksheet2.isHeightBalanced(acres));
        Integer[] exarr = {2,1,3};
        Tree<Integer> exres = buildTree(exarr, 0);
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void deleteHB3() {
        Integer[] arr = {3, 2, 4, null, null, null, 5};
        Tree<Integer> t  = buildTree(arr, 0);
        Tree<Integer> acres = worksheet2.deleteHB(t, 2);
//        System.out.println(worksheet2.isHeightBalanced(acres));
        Integer[] exarr = {4, 3, 5};
        Tree<Integer> exres = buildTree(exarr, 0);
        Assertions.assertEquals(exres, acres);
    }
    @Test
    void deleteHB4() {
        Integer[] arr = {3, 1, 4, null, 2};
        Tree<Integer> t  = buildTree(arr, 0);
        Tree<Integer> acres = worksheet2.deleteHB(t, 4);
        Integer[] exarr = {2, 1, 3};
        Tree<Integer> exres = buildTree(exarr, 0);
        Assertions.assertEquals(acres, exres);
    }
    @Test
    void deleteHB5() {
//        Integer[] arr = {5, 2, 6, 1, 4, null, 8, null, null, 3};
        Integer[] arr = {3, 1, 5, null, null, 4};
        Tree<Integer> t  = buildTree(arr, 0);
        Tree<Integer> acres = worksheet2.deleteHB(t, 1);
//        Integer[] exarr = {5, 1, 6, null, 4, null, 8, null, null, 3, null, null, null, 7, 9};
        Integer[] exarr = {4, 3, 5};
        Tree<Integer> exres = buildTree(exarr, 0);
        Assertions.assertEquals(acres, exres);
    }

    /**
     * delete the node which does not exist in the tree.
     */
    @Test
    void deleteHB6() {
//        Integer[] arr = {5, 2, 6, 1, 4, null, 8, null, null, 3};
        Integer[] arr = {3, 1, 5, null, null, 4};
        Tree<Integer> t  = buildTree(arr, 0);
        Tree<Integer> acres = worksheet2.deleteHB(t, 7);
//        Integer[] exarr = {5, 1, 6, null, 4, null, 8, null, null, 3, null, null, null, 7, 9};
        Integer[] exarr = {3, 1, 5, null, null, 4};
        Tree<Integer> exres = buildTree(exarr, 0);
        Assertions.assertEquals(acres, exres);
    }



}
