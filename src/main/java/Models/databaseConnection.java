package Models;

import java.sql.Connection;
import java.sql.DriverManager;
public class databaseConnection {
    public static Connection databaseLink;

    public static Connection getConnection(){
         String JDBC_URL = "jdbc:mysql://enqhzd10cxh7hv2e.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/r9a7f0kkwaquhndi";
        String USERNAME = "lnglvlatb6faflvw";
        String PASSWORD = "qglb8lww01godyk9";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }

        return databaseLink;
    }
}
