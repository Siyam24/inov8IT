package Models;

import java.sql.Connection;
import java.sql.DriverManager;
public class databaseConnection {
    public static Connection databaseLink;

    public static Connection getConnection(){
        String JDBC_URL = "jdbc:mysql://localhost:3306/GMS";
        String USERNAME = "root";
        String PASSWORD = "sham0729";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }


        return databaseLink;
    }
}
