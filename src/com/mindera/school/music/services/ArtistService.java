package com.mindera.school.music.services;

import com.mindera.school.music.data.favouriteTables.FavouriteArtistTable;
import com.mindera.school.music.data.rows.Album;
import com.mindera.school.music.data.rows.Artist;
import com.mindera.school.music.data.rows.Music;
import com.mindera.school.music.data.tables.ArtistTable;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Mapper;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.data.intermediateTables.IntermediateTables.FAVOURITE_ARTIST_TABLE;
import static com.mindera.school.music.data.tables.Tables.ARTIST_TABLE;
import static com.mindera.school.music.data.tables.Tables.COUNTRY_TABLE;
import static com.mindera.school.music.services.Services.USER_ONLINE;

public class ArtistService {
    private ArtistTable artistTable;
    private CountryTable countryTable;
    private Mapper mapper;
    private FavouriteArtistTable favouriteArtistTable;

    public ArtistService() {
        this.artistTable = ARTIST_TABLE;
        this.countryTable = COUNTRY_TABLE;
        this.mapper = new Mapper();
        this.favouriteArtistTable = FAVOURITE_ARTIST_TABLE;
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

    public void removeByName(String name) throws SQLException {
        int id = findIdByName(name);
        if (id == 0) {
            System.out.println("This artist doesn't exists.");
        } else {
            artistTable.removeById(id);
        }
    }

    public Artist find(int id) throws SQLException {
        return artistTable.findById(id);
    }

    public List<Artist> findAll() throws SQLException {
        return artistTable.findAll();
    }

    public void printAllAlbums(String name) throws SQLException {
        int id = findIdByName(name);

        if (id == 0) {
            System.out.println("This artist doesn't exist.");
            return;
        }

        List<Album> list = artistTable.findAllAlbums(id);

        if (list.isEmpty()) {
            System.out.println("There are no albums from this artist.");
        }

        for (Album album : list) {
            System.out.println("Name: " + album.getName());
        }
    }

    public void printAllMusics(String name) throws SQLException {
        int id = findIdByName(name);

        if (id == 0) {
            System.out.println("This artist doesn't exist.");
            return;
        }

        List<Music> list = artistTable.findAllMusics(id);

        if (list.isEmpty()) {
            System.out.println("There are no musics from this artist.");
        }

        for (Music music : list) {
            if (USER_ONLINE.isLegalAge()) {
                System.out.println("Name: " + music.getName());
            } else {
                if (!music.isExplicit()) {
                    System.out.println("Name: " + music.getName());
                }
            }
        }
    }

    public void addFollower(String name) throws SQLException {
        int artistId = artistTable.findIdByName(name);

        if (artistId == 0) {
            System.out.println("This artist doesn't exist.");
        } else {
            if (favouriteArtistTable.exists(artistId)) {
                System.out.println("This artist is already followed.");
            } else {
                favouriteArtistTable.add(artistId);
            }
        }
    }

    public void removeFollower(String name) throws SQLException {
        int artistId = artistTable.findIdByName(name);

        if (artistId == 0) {
            System.out.println("This artist doesn't exist.");
        } else {
            if (favouriteArtistTable.exists(artistId)) {
                favouriteArtistTable.remove(artistId);
            } else {
                System.out.println("This artist is already unfollowed.");
            }
        }
    }

    public void printFollowedArtist() throws SQLException {
        List<Integer> list = favouriteArtistTable.find();
        if (list.isEmpty()) {
            System.out.println("You don't follow any artist.");
        } else {
            for (Integer integer : list) {
                System.out.println("Name: " + artistTable.findById(integer).getName());
            }
        }
    }

    public int findIdByName(String name) throws SQLException {
        return artistTable.findIdByName(name);
    }

    public void print(int id) throws SQLException {
        if (USER_ONLINE.isAdm()) {
            printAdm(id);
        } else {
            printUser(id);
        }
    }

    public void printAll() throws SQLException {
        if (USER_ONLINE.isAdm()) {
            printAllAdm();
        } else {
            printAllUser();
        }
    }

    private void printAllUser() throws SQLException {
        List<Artist> artistList = findAll();

        if (artistList.isEmpty()) {
            System.out.println("There is no artists.");
            return;
        }

        for (Artist artist : artistList) {
            System.out.println("Name: " + artist.getName());
            System.out.println("Number of followers: " + artist.getNrFollowers() + '\n');
        }
    }

    private void printAllAdm() throws SQLException {
        List<Artist> artistList = findAll();

        if (artistList.isEmpty()) {
            System.out.println("There is no artists.");
            return;
        }

        for (Artist artist : artistList) {
            System.out.println("Artist id: " + artist.getId());
            System.out.println("Name: " + artist.getName());
            System.out.println("Number of followers: " + artist.getNrFollowers() + '\n');
        }
    }

    private void printUser(int id) throws SQLException {
        Artist artist = find(id);

        if (artist == null) {
            System.out.println("There is no artist.");
            return;
        }

        System.out.println("Name: " + artist.getName());
        System.out.println("Country: " + countryTable.findById(artist.getCountryId()).getName());
        System.out.println("Description: " + artist.getDescription());
        System.out.println("Number of followers: " + artist.getNrFollowers() + '\n');
    }

    private void printAdm(int id) throws SQLException {
        Artist artist = find(id);

        if (artist == null) {
            System.out.println("There is no artist.");
            return;
        }

        System.out.println("Artist id: " + artist.getId());
        System.out.println("Name: " + artist.getName());
        System.out.println("Country: " + countryTable.findById(artist.getCountryId()).getName());
        System.out.println("Description: " + artist.getDescription());
        System.out.println("Number of followers: " + artist.getNrFollowers() + '\n');
    }
}
