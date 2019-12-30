package com.mindera.school.music.services;

import com.mindera.school.music.data.intermediateTables.AlbumArtistTable;
import com.mindera.school.music.data.intermediateTables.AlbumProducerTable;
import com.mindera.school.music.data.intermediateTables.FavouriteArtistTable;
import com.mindera.school.music.data.intermediateTables.MusicAlbumTable;
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
    private AlbumTable albumTable;
    private StudioTable studioTable;
    private Mapper mapper;
    private AlbumArtistTable albumArtistTable;
    private AlbumProducerTable albumProducerTable;
    private MusicAlbumTable musicAlbumTable;
    private FavouriteArtistTable favouriteArtistTable;
    private ProducerTable producerTable;
    private ArtistTable artistTable;
    private MusicTable musicTable;

    public AlbumService() {
        this.albumTable = ALBUM_TABLE;
        this.studioTable = STUDIO_TABLE;
        this.mapper = new Mapper();
        this.albumArtistTable = ALBUM_ARTIST_TABLE;
        this.albumProducerTable = ALBUM_PRODUCER_TABLE;
        this.musicAlbumTable = MUSIC_ALBUM_TABLE;
        this.favouriteArtistTable = FAVOURITE_ARTIST_TABLE;
        this.producerTable = PRODUCER_TABLE;
        this.artistTable = ARTIST_TABLE;
        this.musicTable = MUSIC_TABLE;
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
        }

        albumTable.add(album);
    }

    public void addLikeAlbum(String name) throws SQLException {
        favouriteArtistTable.add(
                albumTable.findIdByName(name), USER_ONLINE.getUserID()
        );
    }

    public void removeLikeAlbum(String name) throws SQLException {
        favouriteArtistTable.remove(
                albumTable.findIdByName(name), USER_ONLINE.getUserID()
        );
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

    public void printAll() throws SQLException {
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

    public int findByName(String name) throws SQLException {
        return albumTable.findIdByName(name);
    }

    public void print(int id) throws SQLException {
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
