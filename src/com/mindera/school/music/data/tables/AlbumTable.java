package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.Album;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumTable extends Table<Album> {
    public AlbumTable(String table) {
        super(table);
    }

    public void add(Album album) throws SQLException {
        sql.statement.executeUpdate("Call add_album('" + album.getName() + "', " + album.getYear() + ", " + album.getStudioId() + ");");
    }

    public Album findById(int id) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_album_by_id(" + id + ");");

        if(resultSet.next()) {
            return new Album(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5),
                    resultSet.getInt(6));
        }

        return null;
    }

    public List<Album> findAll() throws SQLException {
        List<Album> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_all_albums();");

        while (resultSet.next()) {
            list.add(new Album(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5),
                    resultSet.getInt(6)));
        }

        return list;
    }
}