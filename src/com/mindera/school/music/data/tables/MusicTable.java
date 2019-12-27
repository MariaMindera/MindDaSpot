package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.Music;

import static com.mindera.school.music.services.Services.USER_ONLINE;

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
            Music music = new Music(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4), resultSet.getBoolean(5),
                    resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                    resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11));

            ResultSet resultSet1 = sql.statement.executeQuery("Select age_by_user_id(" + USER_ONLINE.getUserID() + ");");

            if (resultSet1.next() && resultSet1.getInt(1) < 17 && music.isExplicit()) {
                return null;
            }

            return music;
        }

        return null;
    }

    public List<Music> findAll() throws SQLException {
        List<Music> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call explicit_songs_by_user_id(" + USER_ONLINE.getUserID() + ");");

        while (resultSet.next()) {
            list.add(new Music(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4), resultSet.getBoolean(5),
                    resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                    resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11)));
        }

        return list;
    }
}
