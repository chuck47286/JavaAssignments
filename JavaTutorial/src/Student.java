/**
 * The class
 *
 * @author YuCheng
 * @version 2020-2-7
 */
public class Student implements Comparable<Student>{
    private String firstname;
    private String surname;
    private int mark;
    private String id;

    public Student(String firstname, String surname, int mark, String id) {
        this.firstname = firstname;
        this.surname = surname;
        this.mark = mark;
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public int getMark() {
        return mark;
    }

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(Student o) {
        // 这个是ascii从大到小的排列 surname
//        if (this.surname.compareTo(o.getSurname()) > 0) {
//            return -1;
//        } else if (this.surname.compareTo(o.getSurname()) < 0) {
//            return 1;
//        } else {
//            return 0;
//        }
        // 这个就是按照名字的从小到大
        return this.surname.compareTo(o.getSurname());
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", mark=" + mark +
                ", id='" + id + '\'' +
                '}';
    }
}
