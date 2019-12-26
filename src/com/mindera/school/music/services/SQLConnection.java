package com.mindera.school.music.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
    public Statement statement;
    public Connection con;

    public SQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mindaSpot", "mindaSpot", "Mp11062001.");
            statement = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void closeConnection() throws SQLException {
        con.close();
    }
}
