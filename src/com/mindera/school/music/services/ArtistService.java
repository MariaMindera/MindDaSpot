package com.mindera.school.music.services;

import com.mindera.school.music.ui.Mapper;
import com.mindera.school.music.data.rows.Artist;
import com.mindera.school.music.data.tables.ArtistTable;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.ui.KeyValue;

import static com.mindera.school.music.data.tables.Tables.*;

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

    public void add(List<KeyValue> keyValueList) {
        Artist artist = new Artist();

        artist.setId(artistTable.getNewId());

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                if (artistTable.verifyIfExistsName(keyValue.getValue().toString())) {
                    System.out.println("This Artist already exits.");
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

    public void removeArtist(int id) {
        artistTable.remove(id);
    }

    public Artist findArtist(int id) {
        return artistTable.findById(id);
    }

    public List<Artist> findAllArtists() {
        return artistTable.findAll();
    }

    public void printAllArtists() {
        List<Artist> artistList = findAllArtists();

        if (artistList.isEmpty()) {
            System.out.println("There is no artist.");
            return;
        }

        for (Artist artist : artistList) {
            System.out.println("Artist id: " + artist.getId());
            System.out.println("Name: " + artist.getName());
            System.out.println("Number of Followers: " + artist.getNrFollowers() + '\n');
        }
    }

    public void printArtist(int id) {
        Artist artist = findArtist(id);
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
