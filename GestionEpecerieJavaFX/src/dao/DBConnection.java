package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "SYSTEM"; 
    private static final String PASSWORD = "simo"; 

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}