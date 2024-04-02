package Models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalaryHistory {
    private int empID;
    private double increasedAmount;
    private Date date;

    // Constructor
    public SalaryHistory(int empID, double increasedAmount, Date date) {
        this.empID = empID;
        this.increasedAmount = increasedAmount;
        this.date = date;
    }

    // Method to insert salary history into the database
    public void insertSalaryHistory() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Get connection
            connection = databaseConnection.getConnection();

            // Prepare SQL statement
            String sql = "INSERT INTO salaryHistory (empID,incresedAmount, date) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);

            // Set parameters
            statement.setInt(1, this.empID);
            statement.setDouble(2, this.increasedAmount);
            statement.setDate(3, this.date);

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
