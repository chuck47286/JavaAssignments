/**
 * The class
 *
 * @author YuCheng
 * @version 2020-1-23
 */
public class MemoArr {
    Student[] arr;
    int index;
    public MemoArr(int n) {
        arr = new Student[n];
//        size = n;
    }
    private void insert(String name, int id) {
        if (index == arr.length) throw new IllegalArgumentException("It is beyond the size");
        arr[index].name = name;
        arr[index].id = id;
        index++;
    }
    private String find(int id) {
        if (index == 0) throw new IllegalArgumentException("there is no values in the arr");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].id == id) {
                return arr[i].name;
            }
        }
        throw new IllegalArgumentException("there is no values in the arr");
    }
}
class Student{
    String name;
    int id;
}

