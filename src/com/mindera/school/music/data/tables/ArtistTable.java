package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.Artist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistTable extends Table<Artist> {
    public ArtistTable(String table) {
        super(table);
    }

    public void add(Artist artist) throws SQLException {
        sql.statement.executeUpdate("Call add_artist('" + artist.getName() + "', " + artist.getCountryId() + ", '" + artist.getDescription() + "');");
    }

    public Artist findById(int id) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_artist_by_id(" + id + ");");

        if(resultSet.next()) {
            return new Artist(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5),
                    resultSet.getInt(6));
        }

        return null;
    }

    public List<Artist> findAll() throws SQLException {
        List<Artist> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_all_artist();");

        while (resultSet.next()) {
            list.add(new Artist(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5),
                    resultSet.getInt(6)));
        }

        return list;
    }
}
