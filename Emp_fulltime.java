
package NguyenVanQuy_4537;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Emp_fulltime extends Employee {

    private double coefficientSalary;

    public Emp_fulltime() {
    }

    public Emp_fulltime(double coefficientSalary) {
        this.coefficientSalary = coefficientSalary;
    }

    public Emp_fulltime(double coefficientSalary, String empID, String empName, Date empDateOfBirth, Date startDate) {
        super(empID, empName, empDateOfBirth, startDate);
        this.coefficientSalary = coefficientSalary;
    }

    public double getCoefficientSalary() {
        return coefficientSalary;
    }

    public void setCoefficientSalary(double coefficientSalary) {
        this.coefficientSalary = coefficientSalary;
    }

    @Override
    public void input() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter ID Employee Full Time: ");
            this.setEmpID(sc.nextLine());
            System.out.print("Enter Name Employee Full Time: ");
            this.setEmpName(sc.nextLine());
            System.out.print("Enter Date Of Birth(dd/MM/yyyy) ");
            this.setEmpDateOfBirth(sdf.parse(sc.nextLine()));
            System.out.print("Enter Start Date(dd/MM/yyyy): ");
            this.setStartDate(sdf.parse(sc.nextLine()));
            System.out.print("Enter Coefficients Salary: ");
            this.setCoefficientSalary(sc.nextDouble());
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
                + "\nCoefficients Salary: " + getCoefficientSalary()
                + "\n");
    }

    @Override
    public double calculatSalary() {
        return basic_salary * coefficientSalary + calculateAllowance();
    }

    @Override
    public double calculateAllowance() {
        int seniority = calculateSeniority();
        if (seniority >= 10) {
            return 1000000;
        } else if (seniority < 10) {
            return 500000;
        }
        return 0;
    }

}
