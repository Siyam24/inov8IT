package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employee {
    private int empId;
    private String empName;
    private String empNIC;
    private String empContact;
    private String empEmail;
    private String empSalary;
    private String empAddress;

    public Employee( String empName, String empNIC, String empContact, String empEmail, String empSalary, String empAddress) {
        this.empName = empName;
        this.empNIC = empNIC;
        this.empContact = empContact;
        this.empEmail = empEmail;
        this.empSalary = empSalary;
        this.empAddress = empAddress;
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
            statement.setString(5, this.empSalary);
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

}
