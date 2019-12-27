package com.mindera.school.music.services;

import com.mindera.school.music.ui.Mapper;
import com.mindera.school.music.data.rows.Music;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.data.tables.GenreTable;
import com.mindera.school.music.data.tables.MusicTable;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static com.mindera.school.music.data.tables.Tables.*;

public class MusicService {
    private MusicTable musicTable;
    private CountryTable countryTable;
    private GenreTable genreTable;
    private Mapper mapper;

    public MusicService() {
        this.musicTable = MUSIC_TABLE;
        this.countryTable = COUNTRY_TABLE;
        this.genreTable = GENRE_TABLE;
        this.mapper = new Mapper();
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
                music.setDuration((String) keyValue.getValue());
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
        }

        musicTable.add(music);
    }

    public void removeById(int id) throws SQLException {
        musicTable.removeById(id);
    }

    public void removeByName(String name) throws SQLException {
        musicTable.removeByName(name);
    }

    public Music findById(int id) throws SQLException {
        return musicTable.findById(id);
    }

    public int findByName(String name) throws SQLException {
        return musicTable.findIdByName(name);
    }

    public List<Music> findAll() throws SQLException {
        return musicTable.findAll();
    }

    public void printAll() throws SQLException {
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

    public void print(int id) throws SQLException {
        Music music = findById(id);

        if (music == null) {
            System.out.println("There is no song with this id.");
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
        System.out.println("Number of likes: " + music.getNrLikes());
        System.out.println("Number of Searches: " + music.getNrSearch() + '\n');
    }
}