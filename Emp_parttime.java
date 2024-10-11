
package NguyenVanQuy_4537;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Emp_parttime extends Employee {

    private int numberOfWorkdays;

    public Emp_parttime() {
    }

    public Emp_parttime(int numberOfWorkdays) {
        this.numberOfWorkdays = numberOfWorkdays;
    }

    public Emp_parttime(int numberOfWorkdays, String empID, String empName, Date empDateOfBirth, Date startDate) {
        super(empID, empName, empDateOfBirth, startDate);
        this.numberOfWorkdays = numberOfWorkdays;
    }

    public int getNumberOfWorkdays() {
        return numberOfWorkdays;
    }

    public void setNumberOfWorkdays(int numberOfWorkdays) {
        this.numberOfWorkdays = numberOfWorkdays;
    }

    @Override
    public void input() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter ID Employee Part Time: ");
            this.setEmpID(sc.nextLine());
            System.out.print("Enter Name Employee Part Time: ");
            this.setEmpName(sc.nextLine());
            System.out.print("Enter Date Of Birth(dd/MM/yyyy) ");
            this.setEmpDateOfBirth(sdf.parse(sc.nextLine()));
            System.out.print("Enter Start Date(dd/MM/yyyy): ");
            this.setStartDate(sdf.parse(sc.nextLine()));
            System.out.print("Enter Number Of Workdays: ");
            this.setNumberOfWorkdays(sc.nextInt());
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    @Override
    public void output() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\nID Employee Full Time: " + getEmpID()
                + "\nName Employee Full Time: " + getEmpName()
                + "\nDate Of Birth: " + sdf.format(getEmpDateOfBirth())
                + "\nSart Date: " + sdf.format(getStartDate())
                + "\nCoefficients Salary: " + getNumberOfWorkdays()
                + "\n");
    }

    @Override
    public double calculatSalary() {
        return basic_salary * numberOfWorkdays / 26 + calculateAllowance();
    }

    @Override
    public double calculateAllowance() {
        int seniority = calculateSeniority();
        if (seniority >= 10) {
            return 500000;
        } else if (seniority < 10) {
            return 300000;
        }
        return 0;
    }

}
