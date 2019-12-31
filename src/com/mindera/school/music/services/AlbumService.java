package com.mindera.school.music.services;

import com.mindera.school.music.data.favouriteTables.FavouriteAlbumTable;
import com.mindera.school.music.data.favouriteTables.FavouriteArtistTable;
import com.mindera.school.music.data.intermediateTables.*;
import com.mindera.school.music.data.rows.Music;
import com.mindera.school.music.data.tables.*;
import com.mindera.school.music.ui.Mapper;
import com.mindera.school.music.data.rows.Album;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.services.Services.USER_ONLINE;
import static com.mindera.school.music.data.tables.Tables.*;
import static com.mindera.school.music.data.intermediateTables.IntermediateTables.*;

public class AlbumService {
    private Mapper mapper;
    private AlbumTable albumTable;
    private ArtistTable artistTable;
    private MusicTable musicTable;
    private ProducerTable producerTable;
    private StudioTable studioTable;
    private AlbumArtistTable albumArtistTable;
    private AlbumProducerTable albumProducerTable;
    private FavouriteAlbumTable favouriteAlbumTable;
    private FavouriteArtistTable favouriteArtistTable;
    private MusicAlbumTable musicAlbumTable;

    public AlbumService() {
        this.mapper = new Mapper();
        this.albumTable = ALBUM_TABLE;
        this.artistTable = ARTIST_TABLE;
        this.musicTable = MUSIC_TABLE;
        this.producerTable = PRODUCER_TABLE;
        this.studioTable = STUDIO_TABLE;
        this.albumArtistTable = ALBUM_ARTIST_TABLE;
        this.albumProducerTable = ALBUM_PRODUCER_TABLE;
        this.favouriteAlbumTable = FAVOURITE_ALBUM_TABLE;
        this.favouriteArtistTable = FAVOURITE_ARTIST_TABLE;
        this.musicAlbumTable = MUSIC_ALBUM_TABLE;
    }

    public void add(List<KeyValue> keyValueList) throws SQLException {
        Album album = new Album();

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                if (albumTable.verifyIfExistsName(keyValue.getValue().toString())) {
                    System.out.println("This album already exits.");
                    return;
                }
                album.setName(keyValue.getValue().toString());
            }
            if (keyValue.getName().equals("Year")) {
                int year = (Integer) keyValue.getValue();
                while (year < 0 || year > 2020) {
                    Request request = new Request();
                    request.hasInt("Year", "Invalid year. Insert again: ");
                    List<KeyValue> list = request.ask();
                    year = (int) list.get(0).getValue();
                }
                album.setYear(year);
            }
            if (keyValue.getName().equals("Studio")) {
                album.setStudioId(mapper.getStudioIdByName(keyValue.getValue().toString()));
            }
            if (keyValue.getName().equals("Producer")) {
                album.setProducerId(mapper.getProducerIdByName((String) keyValue.getValue()));
            }
            if (keyValue.getName().equals("Artist")) {
                album.setArtistId(mapper.getArtistIdByName((String) keyValue.getValue()));
            }
        }

        albumTable.add(album);
    }

    public void addLikeAlbum(String name) throws SQLException {
        int albumId = albumTable.findIdByName(name);
        if (favouriteAlbumTable.exists(albumId)) {
            System.out.println("This album is already likes.");
        } else {
            favouriteAlbumTable.add(albumId);
        }
    }

    public void removeLikeAlbum(String name) throws SQLException {
        int albumId = albumTable.findIdByName(name);
        if (favouriteAlbumTable.exists(albumId)) {
            favouriteAlbumTable.remove(albumId);
        } else {
            System.out.println("This album is already unlike.");
        }
    }

    public void removeById(int id) throws SQLException {
        albumTable.removeById(id);
    }

    public void removeByName(String name) throws SQLException {
        albumTable.removeByName(name);
    }

    public Album find(int id) throws SQLException {
        return albumTable.findById(id);
    }

    public List<Album> findAll() throws SQLException {
        return albumTable.findAll();
    }

    public void printLikedAlbums() throws SQLException {
        List<Integer> list = favouriteAlbumTable.find();
        if (list.isEmpty()) {
            System.out.println("You don't like any album.");
        } else {
            for (Integer integer : list) {
                System.out.println("Name: " + albumTable.findById(integer).getName());
            }
        }
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

    public int findByName(String name) throws SQLException {
        return albumTable.findIdByName(name);
    }

    public void addMusicToAlbum(String nameMusic, String nameAlbum) throws SQLException {
        int musicId = musicTable.findIdByName(nameMusic);
        int albumId = findByName(nameAlbum);

        if (musicAlbumTable.exists(musicId, albumId)) {
            System.out.println("This music already exits in this album.");
        } else {
            musicAlbumTable.add(musicId, albumId);
        }
    }

    private void printAllUser() throws SQLException {
        List<Album> albumList = findAll();

        if (albumList.isEmpty()) {
            System.out.println("There is no albums.");
            return;
        }

        for (Album album : albumList) {
            System.out.println("Name: " + album.getName());
            System.out.println("Number of Likes: " + album.getNrLikes() + '\n');
        }
    }

    private void printAllAdm() throws SQLException {
        List<Album> albumList = findAll();

        if (albumList.isEmpty()) {
            System.out.println("There is no albums.");
            return;
        }

        for (Album album : albumList) {
            System.out.println("Album id: " + album.getId());
            System.out.println("Name: " + album.getName());
            System.out.println("Number of Likes: " + album.getNrLikes() + '\n');
        }
    }

    private void printUser(int id) throws SQLException {
        Album album = find(id);

        if (album == null) {
            System.out.println("There is no album.");
            return;
        }

        System.out.println("Name: " + album.getName());
        System.out.println("Artist: " + artistTable.findById(albumArtistTable.find(id).get(0)).getName());
        System.out.println("Year: " + album.getYear());
        System.out.println("Producer: " + producerTable.findById(albumProducerTable.find(id).get(0)).getName());
        System.out.println("Studio: " + studioTable.findById(album.getStudioId()).getName());
        System.out.println("Number of Likes: " + album.getNrLikes() + '\n');

        System.out.println("Musics: ");

        List<Integer> musicList = musicAlbumTable.find(id);
        for (Integer idMusic : musicList) {
            Music music = musicTable.findById(idMusic);
            if (music != null) {
                System.out.println("Name: " + music.getName());
            }
        }
    }

    private void printAdm(int id) throws SQLException {
        Album album = find(id);

        if (album == null) {
            System.out.println("There is no album.");
            return;
        }

        System.out.println("Album id: " + album.getId());
        System.out.println("Name: " + album.getName());
        System.out.println("Artist: " + artistTable.findById(albumArtistTable.find(id).get(0)).getName());
        System.out.println("Year: " + album.getYear());
        System.out.println("Producer: " + producerTable.findById(albumProducerTable.find(id).get(0)).getName());
        System.out.println("Studio: " + studioTable.findById(album.getStudioId()).getName());
        System.out.println("Number of Likes: " + album.getNrLikes());
        System.out.println("Number of Searches: " + album.getNrSearch() + '\n');
        System.out.println("Musics: ");

        List<Integer> musicList = musicAlbumTable.find(id);
        for (Integer idMusic : musicList) {
            System.out.println("Name: " + musicTable.findById(idMusic).getName());
        }
    }
}
