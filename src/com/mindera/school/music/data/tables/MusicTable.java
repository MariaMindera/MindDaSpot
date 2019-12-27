package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.Music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicTable extends Table<Music> {
    public MusicTable(String table) {
        super(table);
    }

    public void add(Music music) throws SQLException {
        sql.statement.executeUpdate("Call add_music('" + music.getName() + "', '" + music.getDuration() + "', '"
                + music.getYear() + "', " + music.isExplicit() + ", '" + music.getSpotifyURL() + "', '"
                + music.getYoutubeURL() + "', " + music.getCountryId() + ", " + music.getGenreId() + ");");
    }

    public Music findById(int id) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_music_by_id(" + id + ");");

        if (resultSet.next()) {
            return new Music(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getInt(4), resultSet.getBoolean(5),
                    resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                    resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11));
        }

        return null;
    }

    public List<Music> findAll() throws SQLException {
        List<Music> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_all_musics();");

        while (resultSet.next()) {
            list.add(new Music(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getInt(4), resultSet.getBoolean(5),
                    resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                    resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11)));
        }

        return list;
    }
}
