package Controler;

import Models.Employee;

import java.util.List;

public class EmployeeData {
    // No need to store employee data as class fields

    // Constructor can be simplified or removed

    // Method to add employee
    public void addEmployee( String empName, String empNIC, String empContact, String empEmail, int empSalary, String empAddress){
        try {
            // Call the addEmployee method of the Employee class in the Models package
            Employee employee = new Employee( empName, empNIC, empContact, empEmail, empSalary, empAddress);
            employee.addEmployee();
        } catch(Exception ex) {
            ex.printStackTrace(); // Handle exception appropriately
        }
    }
    public List<Employee> getAllEmployees() {
        // Call the static method from the Employee class
        return Employee.getAllEmployees();
    }
    public void removeEmployee(int empId) {
        // Create an instance of Employee and call the removeEmployee method
        Employee employee = new Employee();
        employee.setEmpId(empId); // Set the ID of the employee to be removed
        employee.removeEmployee(); // Call the removeEmployee method
    }
}