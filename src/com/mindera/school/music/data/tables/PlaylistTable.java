package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.Playlist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mindera.school.music.services.Services.USER_ONLINE;

public class PlaylistTable extends Table {
    public PlaylistTable(String table) {
        super(table);
    }

    public void add(Playlist playlist) throws SQLException {
        sql.statement.executeUpdate("Call add_playlist('" + playlist.getName() + "', " + USER_ONLINE.getUserID() + ");");
    }

    public Playlist findById(int id) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_playlist_by_id(" + id + ");");

        if (resultSet.next()) {
            return new Playlist(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3));
        }

        return null;
    }

    public Playlist findByIdUser(int id) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_playlist_by_id_by_user(" + id + ", " + USER_ONLINE.getUserID() + ");");

        if (resultSet.next()) {
            return new Playlist(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3));
        }

        return null;
    }

    public int findIdByNameUser(String name) throws SQLException {
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        ResultSet resultSet = sql.con.prepareCall("CALL get_playlist_id_by_name_by_user('" + name + "', " + USER_ONLINE.getUserID() + ");").executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
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

    public List<Playlist> findAllUser() throws SQLException {
        List<Playlist> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_all_playlist_by_user(" + USER_ONLINE.getUserID() + ");");

        while (resultSet.next()) {
            list.add(new Playlist(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3)));
        }

        return list;
    }
}
