package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.intermediateTables.AlbumArtistTable;
import com.mindera.school.music.data.intermediateTables.AlbumProducerTable;
import com.mindera.school.music.data.rows.Album;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mindera.school.music.data.intermediateTables.IntermediateTables.ALBUM_ARTIST_TABLE;
import static com.mindera.school.music.data.intermediateTables.IntermediateTables.ALBUM_PRODUCER_TABLE;

public class AlbumTable extends Table {
    private AlbumArtistTable albumArtistTable;
    private AlbumProducerTable albumProducerTable;

    public AlbumTable(String table) {
        super(table);
        this.albumArtistTable = ALBUM_ARTIST_TABLE;
        this.albumProducerTable = ALBUM_PRODUCER_TABLE;
    }

    public void add(Album album) throws SQLException {
        sql.statement.executeUpdate("Call add_album('" + album.getName() + "', " + album.getYear() + ", " + album.getStudioId() + ");");
        int id = findIdByName(album.getName());
        albumArtistTable.add(id, album.getArtistId());
        albumProducerTable.add(id, album.getProducerId());
    }

    public Album findById(int id) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_album_by_id(" + id + ");");

        if (resultSet.next()) {
            return new Album(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5),
                    resultSet.getInt(6));
        }

        return null;
    }

    public List<Album> findAll() throws SQLException {
        List<Album> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_all_album();");

        while (resultSet.next()) {
            list.add(new Album(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5),
                    resultSet.getInt(6)));
        }

        return list;
    }
}