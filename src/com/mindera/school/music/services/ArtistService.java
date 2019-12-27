package com.mindera.school.music.services;

import com.mindera.school.music.ui.Mapper;
import com.mindera.school.music.data.rows.Artist;
import com.mindera.school.music.data.tables.ArtistTable;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.ui.KeyValue;

import static com.mindera.school.music.data.tables.Tables.*;

import java.sql.SQLException;
import java.util.List;

public class ArtistService {
    ArtistTable artistTable;
    CountryTable countryTable;
    Mapper mapper;

    public ArtistService() {
        this.artistTable = ARTIST_TABLE;
        this.countryTable = COUNTRY_TABLE;
        this.mapper = new Mapper();
    }

    public void add(List<KeyValue> keyValueList) throws SQLException {
        Artist artist = new Artist();

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                if (artistTable.verifyIfExistsName(keyValue.getValue().toString())) {
                    System.out.println("This artist already exits.");
                    return;
                }
                artist.setName(keyValue.getValue().toString());
            }
            if (keyValue.getName().equals("Country")) {
                artist.setCountryId(
                        mapper.getCountryIdByName(
                                keyValue.getValue().toString()
                        ));
            }
            if (keyValue.getName().equals("Description")) {
                artist.setDescription(keyValue.getValue().toString());
            }
        }

        artistTable.add(artist);
    }

    public void removeById(int id) throws SQLException {
        artistTable.removeById(id);
    }

    public void removeByName(String name) throws SQLException {
        artistTable.removeByName(name);
    }

    public Artist find(int id) throws SQLException {
        return artistTable.findById(id);
    }

    public List<Artist> findAll() throws SQLException {
        return artistTable.findAll();
    }

    public void printAll() throws SQLException {
        List<Artist> artistList = findAll();

        if (artistList.isEmpty()) {
            System.out.println("There is no artists.");
            return;
        }

        for (Artist artist : artistList) {
            System.out.println("Artist id: " + artist.getId());
            System.out.println("Name: " + artist.getName());
            System.out.println("Number of Followers: " + artist.getNrFollowers() + '\n');
        }
    }

    public void print(int id) throws SQLException {
        Artist artist = find(id);

        if (artist == null) {
            System.out.println("There is no artist with this id.");
            return;
        }

        System.out.println("Artist id: " + artist.getId());
        System.out.println("Name: " + artist.getName());
        System.out.println("Country: " + countryTable.findById(artist.getCountryId()).getName());
        System.out.println("Description: " + artist.getDescription());
        System.out.println("Number of Followers: " + artist.getNrFollowers());
        System.out.println("Number of Searches: " + artist.getNrSearch() + '\n');
    }
}
