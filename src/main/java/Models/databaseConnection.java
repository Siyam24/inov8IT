package Models;

import java.sql.Connection;
import java.sql.DriverManager;
public class databaseConnection {
    public static Connection databaseLink;

    public static Connection getConnection(){
        String databaseName = "sys";
        String databaseUser = "root";
        String databasePassword = "Siyam1234";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }

        return databaseLink;
    }
}
