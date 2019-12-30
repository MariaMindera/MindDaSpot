package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreTable extends Table {
    public GenreTable(String table) {
        super(table);
    }

    public void add(Genre genre) throws SQLException {
        sql.statement.executeUpdate("Call add_genre('" + genre.getName() + "');");
    }

    public Genre findById(int id) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_genre_by_id(" + id + ");");

        if (resultSet.next()) {
            return new Genre(resultSet.getInt(1), resultSet.getString(2));
        }

        return null;
    }

    public List<Genre> findAll() throws SQLException {
        List<Genre> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_all_genre();");

        while (resultSet.next()) {
            list.add(new Genre(resultSet.getInt(1), resultSet.getString(2)));
        }

        return list;
    }
}
