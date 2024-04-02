package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int empId;
    private String empName;
    private String empNIC;
    private String empContact;
    private String empEmail;
    private int empSalary;
    private String empAddress;


    public Employee( String empName, String empNIC, String empContact, String empEmail, int empSalary, String empAddress) {

        this.empName = empName;
        this.empNIC = empNIC;
        this.empContact = empContact;
        this.empEmail = empEmail;
        this.empSalary = empSalary;
        this.empAddress = empAddress;
    }

    public Employee() {

    }


// Getters and setters
    // Add your getters and setters here

    // Add employee to the database
    public void addEmployee() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Get connection
            connection = databaseConnection.getConnection();

            // Prepare SQL statement
            String sql = "INSERT INTO employee (empName, empNIC, empContact, empEmail, empSalary, empAddress) VALUES (?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);

            // Set parameters
            statement.setString(1, this.empName);
            statement.setString(2, this.empNIC);
            statement.setString(3, this.empContact);
            statement.setString(4, this.empEmail);
            statement.setInt(5, this.empSalary);
            statement.setString(6, this.empAddress);

            // Execute query
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Remove employee from the database
    public void removeEmployee() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Get connection
            connection = databaseConnection.getConnection();

            // Prepare SQL statement
            String sql = "DELETE FROM employee WHERE empId=?";
            statement = connection.prepareStatement(sql);

            // Set parameter
            statement.setInt(1, this.empId);

            // Execute query
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Get connection
            connection = databaseConnection.getConnection();

            // Prepare SQL statement
            String sql = "SELECT * FROM employee";
            statement = connection.prepareStatement(sql);

            // Execute query
            resultSet = statement.executeQuery();

            // Process result set
            while (resultSet.next()) {
                int empId = resultSet.getInt("empId");
                String empName = resultSet.getString("empName");
                String empNIC = resultSet.getString("empNIC");
                String empContact = resultSet.getString("empContact");
                String empEmail = resultSet.getString("empEmail");
                int empSalary = resultSet.getInt("empSalary");
                String empAddress = resultSet.getString("empAddress");

                Employee employee = new Employee( empName, empNIC, empContact, empEmail, empSalary, empAddress);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return employees;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpNIC() {
        return empNIC;
    }

    public String getEmpContact() {
        return empContact;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
