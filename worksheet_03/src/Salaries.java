import java.util.ArrayList;

/**
 * A class Salaries with a field variable allSalaries of type
 * ArrayList which store the double array
 *
 * @version 2019-10-30
 * @author Yu Cheng
 */
public class Salaries  {
    private ArrayList<double[]> allSalaries;

    /**
     * The no-arg constructor is to initialise the class and
     * the public filed variable.
     */
    public Salaries() {
        allSalaries = new ArrayList<>();
    }

    /**
     * Store all the employees salaries.
     * @param Salary Salary of the each employee.
     */
    public void add(double[] Salary) {
        this.allSalaries.add(Salary);
    }

    /**
     * This method is to store each employee average monthly salary.
     * @param employeeSalaries Salaries of each employee.
     * @return The average monthly employee salary of each employee.
     */
    public static double average(double[] employeeSalaries)  {

        int count = 0;
        double sum = 0;
        for (double salary: employeeSalaries) {
            if (salary != 0) {
                sum += salary;
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException();
        }
        return sum /= count;
    }

    /**
     * This method is to store all employee average monthly salary.
     * @return The ArrayList of each employee average monthly salaries.
     */
    public ArrayList<Double> averageSalaries() {
        ArrayList<Double> res = new ArrayList();
        for (double[] employeeSalaries: allSalaries) {
            try {

                res.add(average(employeeSalaries));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return res;
    }

    /**
     * Check whether an employee's salary is not higher than 3 times of
     * the other employee salaries
     * @return True when nobody's salary is 3 times higher than other employee's
     *         average salaries.Otherwise, false.
     */
    public boolean not3TimesHigher() {
        int sum = 0;
        int count = 0;
        for (double employeeAvg: averageSalaries()) {
            sum += employeeAvg;
            count++;
        }

        for (double employeeAvg: averageSalaries()) {
            if (employeeAvg > 3 * (sum - employeeAvg) / (count - 1)) {
                return false;
            }
        }
        return true;
    }


}
