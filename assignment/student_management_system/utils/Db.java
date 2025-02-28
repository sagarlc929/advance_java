package utils;

import java.sql.*;

public class Db {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/java_practice";
    static final String USER = "postgres";
    static final String PASS = "";
    Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL, "postgres", "");

        } catch (ClassNotFoundException e) {
            System.out.println("Unable to find postgresql driver\nDetails:");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Unable to connect with database\nDetails:");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error \nDetails:");
            e.printStackTrace();
        }
        return conn;
    }
}
