package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.intermediateTables.MusicAlbumTable;
import com.mindera.school.music.data.rows.Music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mindera.school.music.data.intermediateTables.IntermediateTables.MUSIC_ALBUM_TABLE;
import static com.mindera.school.music.services.Services.USER_ONLINE;

public class MusicTable extends Table {
    private MusicAlbumTable musicAlbumTable;

    public MusicTable(String table) {
        super(table);
        this.musicAlbumTable = MUSIC_ALBUM_TABLE;
    }

    public void add(Music music) throws SQLException {
        sql.statement.executeUpdate("Call add_music('" + music.getName() + "', '" + music.getDuration() + "', '"
                + music.getYear() + "', " + music.isExplicit() + ", '" + music.getSpotifyURL() + "', '"
                + music.getYoutubeURL() + "', " + music.getCountryId() + ", " + music.getGenreId() + ");");
        musicAlbumTable.add(findIdByName(music.getName()), music.getAlbum_id());
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

    public List<Music> findAllByGenre(int id) throws SQLException {
        List<Music> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_musics_by_genre(" + id + ");");

        while (resultSet.next()) {
            Music music = new Music(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4), resultSet.getBoolean(5),
                    resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                    resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11));

            if (!USER_ONLINE.isLegalAge()) {
                if (!music.isExplicit()) {
                    list.add(music);
                }
            } else {
                list.add(music);
            }
        }
        return list;
    }

    public List<Music> findAllByCountry(int id) throws SQLException {
        List<Music> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_musics_by_country(" + id + ");");

        while (resultSet.next()) {
            Music music = new Music(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4), resultSet.getBoolean(5),
                    resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                    resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11));

            if (!USER_ONLINE.isLegalAge()) {
                if (!music.isExplicit()) {
                    list.add(music);
                }
            } else {
                list.add(music);
            }
        }
        return list;
    }
}
