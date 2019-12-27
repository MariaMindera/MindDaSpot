package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.Playlist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistTable extends Table<Playlist> {
    public PlaylistTable(String table) {
        super(table);
    }

    public void add(Playlist playlist) throws SQLException {
        sql.statement.executeUpdate("Call add_playlist('" + playlist.getName() + "', " + playlist.getUserId() + ");");
    }

    public Playlist findById(int id) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_playlist_by_id(" + id + ");");

        if (resultSet.next()) {
            return new Playlist(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3));
        }

        return null;
    }

    public List<Playlist> findAll() throws SQLException {
        List<Playlist> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_all_playlist();");

        while (resultSet.next()) {
            list.add(new Playlist(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3)));
        }

        return list;
    }
}
