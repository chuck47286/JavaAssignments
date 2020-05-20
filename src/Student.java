/**
 * The Student class has ID number, team, last name and first name. It has a toString method and implements
 * the Comparable interface.
 *
 * @author YuCheng
 * @version 2020/5/20 15:56
 */
public class Student implements Comparable<Student> {
    private String firstname;
    private String lastname;
    private int id;
    private String team;

    public Student(String firstname, String surname, int mark, String team) {
        this.firstname = firstname;
        this.lastname = surname;
        this.id = mark;
        this.team = team;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getId() {
        return id;
    }

    public String getTeam() {
        return team;
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
        return this.lastname.compareTo(o.getLastname());
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + this.getFirstname() + '\'' +
                ", surname='" + this.getLastname() + '\'' +
                ", id=" + this.getId() +
                ", team='" + this.getTeam() + '\'' +
                '}';
    }
}
