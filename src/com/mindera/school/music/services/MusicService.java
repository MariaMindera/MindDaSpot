package com.mindera.school.music.services;

import com.mindera.school.music.actions.music.AddMusicAction;
import com.mindera.school.music.data.favouriteTables.FavouriteMusicTable;
import com.mindera.school.music.data.rows.Music;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.data.tables.GenreTable;
import com.mindera.school.music.data.tables.MusicTable;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Mapper;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.data.intermediateTables.IntermediateTables.FAVOURITE_MUSIC_TABLE;
import static com.mindera.school.music.data.tables.Tables.*;
import static com.mindera.school.music.services.Services.USER_ONLINE;

public class MusicService {
    private MusicTable musicTable;
    private CountryTable countryTable;
    private GenreTable genreTable;
    private Mapper mapper;
    private FavouriteMusicTable favouriteMusicTable;

    public MusicService() {
        this.musicTable = MUSIC_TABLE;
        this.countryTable = COUNTRY_TABLE;
        this.genreTable = GENRE_TABLE;
        this.mapper = new Mapper();
        this.favouriteMusicTable = FAVOURITE_MUSIC_TABLE;
    }

    public void add(List<KeyValue> keyValueList) throws SQLException {
        Music music = new Music();

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                if (musicTable.verifyIfExistsName(keyValue.getValue().toString())) {
                    System.out.println("This music already exits.");
                    return;
                }
                music.setName(keyValue.getValue().toString());
            }
            if (keyValue.getName().equals("Genre")) {
                music.setGenreId(
                        mapper.getGenreIdByName(
                                keyValue.getValue().toString()
                        ));
            }
            if (keyValue.getName().equals("Year")) {
                music.setYear((Integer) keyValue.getValue());
            }
            if (keyValue.getName().equals("Duration")) {
                music.setDuration(keyValue.getValue().toString());
            }
            if (keyValue.getName().equals("Country")) {
                music.setCountryId(
                        mapper.getCountryIdByName(
                                keyValue.getValue().toString()
                        ));
            }
            if (keyValue.getName().equals("Explicit")) {
                char explicit = (char) keyValue.getValue();

                while (true) {
                    if (explicit == 'Y' || explicit == 'y') {
                        music.setExplicit(true);
                        break;
                    }
                    if (explicit == 'N' || explicit == 'n') {
                        music.setExplicit(false);
                        break;
                    }

                    Request request = new Request();
                    request.hasChar("Explicit", "Invalid letter. Is the music explicit? [Y/N]: ");
                    List<KeyValue> newList = request.ask();
                    explicit = (char) newList.get(0).getValue();
                }
            }
            if (keyValue.getName().equals("SpotifyURL")) {
                music.setSpotifyURL(keyValue.getValue().toString());
            }
            if (keyValue.getName().equals("YoutubeURL")) {
                music.setYoutubeURL(keyValue.getValue().toString());
            }
            if (keyValue.getName().equals("Album")) {
                music.setAlbum_id(mapper.getAlbumIdByName(keyValue.getValue().toString()));
            }
        }

        musicTable.add(music);
    }

    public void removeByName(String name) throws SQLException {
        int id = findIdByName(name);
        if (id == 0) {
            System.out.println("This music doesn't exists.");
        } else {
            musicTable.removeById(id);
        }
    }

    public Music findById(int id) throws SQLException {
        return musicTable.findById(id);
    }

    public int findIdByName(String name) throws SQLException {
        return musicTable.findIdByName(name);
    }

    public void addLikeMusic(String name) throws SQLException {
        int musicId = musicTable.findIdByName(name);
        if (musicId == 0) {
            System.out.println("This music doesn't exist.");
        } else {
            if (favouriteMusicTable.exists(musicId)) {
                System.out.println("This music is already liked.");
            } else {
                favouriteMusicTable.add(musicId);
            }
        }
    }

    public void removeLikeMusic(String name) throws SQLException {
        int musicId = musicTable.findIdByName(name);

        if (musicId == 0) {
            System.out.println("This music doesn't exist.");
        } else {
            if (favouriteMusicTable.exists(musicId)) {
                favouriteMusicTable.remove(musicId);
            } else {
                System.out.println("This music is already unlike.");
            }
        }
    }

    public List<Music> findAll() throws SQLException {
        return musicTable.findAll();
    }

    public void printMusicsByGenre(String name) throws SQLException {
        int id = genreTable.findIdByName(name);

        if (id == 0) {
            System.out.println("This genre doesn't exits.");
            return;
        }

        List<Music> list = musicTable.findAllByGenre(id);

        if (list.isEmpty()) {
            System.out.println("There are no musics with this genre.");
        } else {
            for (Music music : list) {
                System.out.println("Name: " + music.getName());
                System.out.println("Number of likes: " + music.getNrLikes() + '\n');
            }
        }
    }

    public void printMusicsByCountry(String name) throws SQLException {
        int id = countryTable.findIdByName(name);

        if (id == 0) {
            System.out.println("This country doesn't exits.");
            return;
        }

        List<Music> list = musicTable.findAllByCountry(id);

        if (list.isEmpty()) {
            System.out.println("There are no musics from this country.");
        } else {
            for (Music music : list) {
                System.out.println("Name: " + music.getName());
                System.out.println("Number of likes: " + music.getNrLikes() + '\n');
            }
        }
    }

    public void printLikedMusics() throws SQLException {
        List<Integer> list = favouriteMusicTable.find();

        if (list.isEmpty()) {
            System.out.println("You don't like any music.");
        } else {
            for (Integer integer : list) {
                System.out.println("Name: " + musicTable.findById(integer).getName());
            }
        }
    }

    public void printAll() throws SQLException {
        if (USER_ONLINE.isAdm()) {
            printAllAdm();
        } else {
            printAllUser();
        }
    }

    public void print(int id) throws SQLException {
        if (USER_ONLINE.isAdm()) {
            printAdm(id);
        } else {
            printUser(id);
        }
    }

    private void printAdm(int id) throws SQLException {
        Music music = findById(id);

        if (music == null) {
            System.out.println("There is no music.");
            return;
        }

        System.out.println("Music id: " + music.getId());
        System.out.println("Name: " + music.getName());
        System.out.println("Genre: " + genreTable.findById(music.getGenreId()).getName());
        System.out.println("Year: " + music.getYear());
        System.out.println("Duration: " + music.getDuration());
        System.out.println("Country: " + countryTable.findById(music.getCountryId()).getName());
        System.out.println("Explicit: " + music.isExplicit());
        System.out.println("Spotify url: " + music.getSpotifyURL());
        System.out.println("Youtube url: " + music.getYoutubeURL());
        System.out.println("Number of likes: " + music.getNrLikes() + '\n');
    }

    private void printUser(int id) throws SQLException {
        Music music = findById(id);

        if (music == null) {
            System.out.println("There is no music.");

            Request request = new Request();
            request.hasChar("Request", "Do you want to add this music? [Y/N]");

            if (request.ask().get(0).getValue().toString().charAt(0) == 'Y') {
                new AddMusicAction().execute();
            }

            return;
        }

        System.out.println("Name: " + music.getName());
        System.out.println("Genre: " + genreTable.findById(music.getGenreId()).getName());
        System.out.println("Year: " + music.getYear());
        System.out.println("Duration: " + music.getDuration());
        System.out.println("Country: " + countryTable.findById(music.getCountryId()).getName());
        System.out.println("Explicit: " + music.isExplicit());
        System.out.println("Spotify url: " + music.getSpotifyURL());
        System.out.println("Youtube url: " + music.getYoutubeURL());
        System.out.println("Number of likes: " + music.getNrLikes() + '\n');
    }

    private void printAllUser() throws SQLException {
        List<Music> musicList = findAll();

        if (musicList.isEmpty()) {
            System.out.println("There is no musics.");
            return;
        }

        for (Music music : musicList) {
            System.out.println("Name: " + music.getName());
            System.out.println("Number of Likes: " + music.getNrLikes() + '\n');
        }
    }

    private void printAllAdm() throws SQLException {
        List<Music> musicList = findAll();

        if (musicList.isEmpty()) {
            System.out.println("There is no musics.");
            return;
        }

        for (Music music : musicList) {
            System.out.println("Music id: " + music.getId());
            System.out.println("Name: " + music.getName());
            System.out.println("Number of Likes: " + music.getNrLikes() + '\n');
        }
    }
}