
package NguyenVanQuy_4537;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;

public abstract class Employee implements IEmployee {

    private String empID;
    private String empName;
    private Date empDateOfBirth;
    private Date startDate;

    public Employee() {
    }

    public Employee(String empID, String empName, Date empDateOfBirth, Date startDate) {
        this.empID = empID;
        this.empName = empName;
        this.empDateOfBirth = empDateOfBirth;
        this.startDate = startDate;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getEmpDateOfBirth() {
        return empDateOfBirth;
    }

    public void setEmpDateOfBirth(Date empDateOfBirth) {
        this.empDateOfBirth = empDateOfBirth;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public abstract void input();

    public abstract void output();

    public int calculateSeniority() {
        return (int) ChronoUnit.YEARS.between((Temporal) startDate, LocalDate.now());
    }

}
