package com.mindera.school.music.data;

import com.mindera.school.music.ui.SQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mindera.school.music.services.Services.SQL_CONNECTION;

public class IntermediateTable {
    protected String table1;
    protected String table2;
    protected SQLConnection sql;

    public IntermediateTable(String table1, String table2) {
        this.table1 = table1;
        this.table2 = table2;
        this.sql = SQL_CONNECTION;
    }

    public void add(int id1, int id2) throws SQLException {
        sql.statement.executeQuery("Call add_" + table1 + "_" + table2 + "(" + id1 + ", " + id2 + ");");
    }

    public void remove(int id1, int id2) throws SQLException {
        sql.statement.executeQuery("Call remove_" + table1 + "_" + table2 + "(" + id1 + ", " + id2 + ");");
    }

    public List<Integer> find(int id) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_" + table1 + "_" + table2 + "(" + id + ");");
        List<Integer> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(resultSet.getInt(1));
        }

        return list;
    }

    public boolean exists(int id1, int id2) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call exists_" + table1 + "_" + table2 + "(" + id1 + ", " + id2 + ");");

        return resultSet.next();
    }
}
