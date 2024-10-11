/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NguyenVanQuy_4537;


import java.util.ArrayList;
import java.util.Scanner;

public class Emp_list {

    private ArrayList<Employee> empList;

    public Emp_list() {
        empList = new ArrayList<>();
    }

    public Emp_list(ArrayList<Employee> employList) {
        this.empList = employList;
    }

    public ArrayList<Employee> getEmployList() {
        return empList;
    }

    public void setEmployList(ArrayList<Employee> employList) {
        this.empList = employList;
    }

    public void addNew(Employee employee) {
        empList.add(employee);
    }

    public void update(String empID) {
        for (Employee employee : empList) {
            if (employee.getEmpID().equals(empID)) {
                employee.input();
                System.out.println("Update successfully");
                return;
            }
        }
        System.out.println("Employee with ID " + empID + " not found");
    }

    public Employee find(String empID) {
        for (Employee employee : empList) {
            if (employee.getEmpID().equals(empID)) {
                return employee;
            }
        }
        System.out.println("Employee with ID: " + empID + " not found");
        return null;
    }

    public void delete(String empID) {
        for(int i=0;i<empList.size();i++){
            if(empList.get(i).getEmpID().equals(empID))
                empList.remove(i);
        }
    }

    public void displayAllEmp() {
        if (empList.isEmpty()) {
            System.out.println("No employee to display");
        } else {
            for (Employee employee : empList) {
                employee.output();
            }
        }
    }

    public void DisplaySalaries() {
        for (Employee emp : empList) {
            emp.output();
            System.out.println("Salary: " + emp.calculatSalary());
            System.out.println("Allowance: " + emp.calculateAllowance());
            System.out.println("------------------------------------");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("1.Add new employee"
                    + "\n2.Update employee"
                    + "\n3.Find employee"
                    + "\n4.Delete employee"
                    + "\n5.Display all employee"
                    + "\n6.Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("*****Add new employee*****");
                    System.out.println("1.Add new full time"
                            + "\n2.Add new part time");
                    System.out.println("Choose type: ");
                    int type = sc.nextInt();
                    Employee emp;

                    if (type == 1) {
                        emp = new Emp_fulltime();
                    } else {
                        emp = new Emp_parttime();
                    }
                    emp.input();
                    addNew(emp);
                    break;
                case 2:
                    System.out.println("*****Update employee*****");
                    System.out.print("Enter ID To Update: ");
                    String idToUpdate = sc.nextLine();
                    update(idToUpdate);
                    break;
                case 3:
                    System.out.println("*****Find employee*****");
                    System.out.print("Enter ID To Find: ");
                    String idToFind = sc.nextLine();
                    Employee foundEmp = find(idToFind);
                    if (foundEmp != null) {
                        foundEmp.output();
                    }
                    break;
                case 4:
                    System.out.println("*****Delete employee*****");
                    System.out.print("Enter ID To Delete: ");
                    String idToDelete = sc.nextLine();
                    delete(idToDelete);
                    break;
                case 5:
                    System.out.println("*****Display All Employee*****");
                    displayAllEmp();
                    break;
                case 6:
                    run = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again!");
            }
        }
    }

}
