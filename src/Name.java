/**
 * The class is
 *
 * @author YuCheng
 * @version 2020/3/4 20:51
 */
public class Name implements Comparable<Name> {

    public String lastName;
    public String firstName;

    public Name(String last, String first) {
        this.lastName = last;
        this.firstName = first;
    }

    @Override
    public String toString() {
        return "Name{" + /*"\n" +*/
                "\tlastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +/* "\n"+*/
                '}';
    }

    @Override
    public int compareTo(Name other) {
        int d = this.lastName.compareTo(other.lastName);
        if (d == 0) {
            return this.firstName.compareTo(other.firstName);
        }
        return d;
    }


}
