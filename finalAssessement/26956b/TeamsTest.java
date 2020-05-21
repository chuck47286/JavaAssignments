import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/5/20 19:58
 */
class TeamsTest {
    Teams teams;
    @BeforeEach
    void setUp() {
        Student student1 = new Student("Bob", "James", 1005, "101");
        Student student2 = new Student("Alice", "Jane", 1006, "102");
        Student student3 = new Student("Duncan", "Tim", 1007, "102");
        Student student4 = new Student("Kobe", "Bryant", 1008, "101");
        Student student5 = new Student("Greece", "Lee", 1009, "101");

        Student[] students = {student1, student2, student3, student4, student5};
        teams = new Teams(students);
    }


    @Test
    void add() {

    }

    @Test
    void delete() {

    }

    @Test
    void print() {
        teams.print();
    }
}