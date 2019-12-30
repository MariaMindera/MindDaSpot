package com.mindera.school.music.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
    public Statement statement;
    public Connection con;

    public SQLConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mindaSpot", "mindaSpot", "minderaschool");
            statement = con.createStatement();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void closeConnection() throws SQLException {
        con.close();
    }
}
