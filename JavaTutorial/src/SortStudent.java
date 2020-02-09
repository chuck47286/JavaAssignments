import java.util.Comparator;

/**
 * The class
 *
 * @author YuCheng
 * @version 2020-2-7
 */
public class SortStudent implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        /*if (o1.getSurname().compareTo(o2.getSurname()) == 0) {
            if (o1.getFirstname().compareTo(o2.getFirstname()) == 0) {
                if (o1.getMark() == o2.getMark()) {
                    if (o1.getId().compareTo(o2.getId()) > 0) {
                        return 1;
                    } else if (o1.getId().compareTo(o2.getId()) < 0) {
                        return -1;
                    }
                }
            }
        }*/
        int surnameCheck = o1.getSurname().compareTo(o2.getSurname());
        int firstCheck = o1.getFirstname().compareTo(o2.getFirstname());
        int markCheck = Integer.valueOf(o1.getId()).compareTo(Integer.valueOf(o2.getId()));
        int IdCheck = o1.getId().compareTo(o2.getId());


        if (surnameCheck != 0) {
            return surnameCheck;
        }
        if (firstCheck != 0 )
            return firstCheck;
        if (markCheck != 0)
            return markCheck;
        if (IdCheck != 0)
            return IdCheck;
        return 0;
    }
}
