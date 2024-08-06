package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/school";
        Connection connection = DriverManager.getConnection(url, "root", "12345678");
        String sql = "select * from student";
        Statement statement = connection.createStatement();
        ResultSet s  = statement.executeQuery(sql);
        System.out.println(s);
        while (s.next()){
            System.out.println(s.getString("name"));
        }
        statement.close();
        connection.close();
    }
}