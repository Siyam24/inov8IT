package Models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter methods for username and password (you can add setters if needed)

    // Method to validate user login
    public boolean login() {
        // Establish database connection
        try (Connection connection = DbConfig.getConnection()) {
            // Create SQL query to check if username and password match
            String sql = "SELECT * FROM tblUser WHERE userName = ? AND userPassword = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    // If result set has next, it means user exists with provided credentials
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of any SQL exception
        }
    }
}

