package com.mindera.school.music.data;

import com.mindera.school.music.ui.SQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mindera.school.music.services.Services.SQL_CONNECTION;
import static com.mindera.school.music.services.Services.USER_ONLINE;

public class FavouriteTable {
    protected SQLConnection sql;
    private String table;

    public FavouriteTable(String table) {
        this.sql = SQL_CONNECTION;
        this.table = table;
    }

    public void add(int id) throws SQLException {
        sql.statement.executeQuery("Call add_favourite_" + table + "(" + id + ", " + USER_ONLINE.getUserID() + ");");
    }

    public void remove(int id) throws SQLException {
        sql.statement.executeQuery("Call remove_favourite_" + table + "(" + id + ", " + USER_ONLINE.getUserID() + ");");
    }

    public List<Integer> find() throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_favourite_" + table + "(" + USER_ONLINE.getUserID() + ");");
        List<Integer> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(resultSet.getInt(1));
        }

        return list;
    }

    public boolean exists(int id1) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call exists_favourite_" + table + "(" + id1 + ", " + USER_ONLINE.getUserID() + ");");

        return resultSet.next();
    }
}
