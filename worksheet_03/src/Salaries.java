import java.util.ArrayList;

public class Salaries  {
    private ArrayList<double[]> allSalaries;
    public void add(double[] Salary) {
        this.allSalaries.add(Salary);
    }


    public Salaries() {
        allSalaries = new ArrayList<>();
    }

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
