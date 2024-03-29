package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    // JDBC URL, username, and password of JawsDB MySQL server
    private static final String JDBC_URL = "jdbc:mysql://enqhzd10cxh7hv2e.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/r9a7f0kkwaquhndi";
    private static final String USERNAME = "lnglvlatb6faflvw";
    private static final String PASSWORD = "qglb8lww01godyk9";
    // Static block to load the MySQL JDBC driver
//    static {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to load MySQL JDBC driver.");
//        }
//    }

    // Method to establish a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    // Method to close the database connection
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
