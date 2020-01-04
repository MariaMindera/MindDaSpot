package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.Album;
import com.mindera.school.music.data.rows.Artist;
import com.mindera.school.music.data.rows.Music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistTable extends Table {
    public ArtistTable(String table) {
        super(table);
    }

    public void add(Artist artist) throws SQLException {
        sql.statement.executeUpdate("Call add_artist('" + artist.getName() + "', " + artist.getCountryId() + ", '" + artist.getDescription() + "');");
    }

    public Artist findById(int id) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_artist_by_id(" + id + ");");

        if (resultSet.next()) {
            return new Artist(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(6));
        }

        return null;
    }

    public List<Artist> findAll() throws SQLException {
        List<Artist> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_all_artist();");

        while (resultSet.next()) {
            list.add(new Artist(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(6)));
        }

        return list;
    }

    public List<Music> findAllMusics(int id) throws SQLException {
        List<Music> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_all_musics_from_artist(" + id + ");");

        while (resultSet.next()) {
            list.add(new Music(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4), resultSet.getBoolean(5),
                    resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                    resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11)));
        }

        return list;
    }

    public List<Album> findAllAlbums(int id) throws SQLException {
        List<Album> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_all_albums_from_artist(" + id + ");");

        while (resultSet.next()) {
            list.add(new Album(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5),
                    resultSet.getInt(6)));
        }

        return list;
    }
}
