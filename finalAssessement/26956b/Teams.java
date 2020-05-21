import java.util.*;

/**
 * The class is the collection to help a lecturer for managing team projects for their class.
 *
 * @author YuCheng
 * @version 2020/5/20 16:03
 */
public class Teams {
    /**
     * Map is the collection to make sure each team has member of students .
     * Queue is the collection in java to maintain the a minimum the students and keep the members appear in sorted order.
     * int k is The account of the minimum students.
     */
    Map<String, Queue<Student>> team;
    int k = 3;
//    Queue<Student> members;

    /**
     * Constructor takes an array of Student objects.
     *
     * @param students An array of Students object.
     */
    public Teams(Student[] students) {
        team = new HashMap<>();
//        members = new PriorityQueue<Student>(k, new Comparator<Student>(){
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getLastname().compareTo(o2.getLastname());
//            }
//        });
        for (Student student: students) {
            String team_student = student.getTeam();
            if (!team.containsKey(team_student)) {
                team.put(team_student, new PriorityQueue<Student>());
            }
            team.get(team_student).offer(student);
//            if (team.get(team_student).size() > k) {
//                team.get(team_student).poll();
//            }
        }

//            members = new PriorityQueue<Student>(k, new Comparator<Student>() {
//                @Override
//                public int compare(Student o1, Student o2) {
//                    return o1.getLastname().compareTo(o2.getLastname());
//                }
//            });

//        team.put(student.getTeam(), members);
    }

    /**
     * This method is to add the student in the team.
     *
     * @param student The student required to add in the certain team.
     */
    public void add(Student student) {
//        members.offer(student);
        Queue<Student> members = team.get(student.getTeam());
        if (members.size() >= k) {
            throw new IllegalArgumentException("there are enough students in the " + student.getTeam());
//            return ;
        }
        team.get(student.getTeam()).offer(student);
    }

    /**
     * This method is to remove the student from the team.
     *
     * @param student The student required to remove from the certain team.
     */
    public void delete(Student student) {
//        members.poll();
        if (!team.containsKey(student.getTeam())) {
            throw new IllegalArgumentException("there is no student in the " + student.getTeam());
//            return ;
        }
        team.get(student.getTeam()).remove(student);
    }

    /**
     * @return all the teams along with their members in the format, such as
     * team : member 1, member 2, ...
     */
    public void print() {

        for (Map.Entry<String, Queue<Student>> entry: team.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
