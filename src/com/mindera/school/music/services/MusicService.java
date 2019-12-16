package com.mindera.school.music.services;

import com.mindera.school.music.Mapper;
import com.mindera.school.music.data.rows.Music;
import com.mindera.school.music.data.tables.CountryTable;
import com.mindera.school.music.data.tables.GenreTable;
import com.mindera.school.music.data.tables.MusicTable;
import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.Request;

import java.util.LinkedList;
import java.util.List;

import static com.mindera.school.music.data.tables.Tables.COUNTRY_TABLE;
import static com.mindera.school.music.data.tables.Tables.GENRE_TABLE;

public class MusicService {
    private MusicTable musicTable;
    private CountryTable countryTable;
    private GenreTable genreTable;
    private Mapper mapper;
    private Request request;

    public MusicService(MusicTable musicTable, CountryTable countryTable, GenreTable genreTable) {
        this.musicTable = musicTable;
        this.countryTable = countryTable;
        this.genreTable = genreTable;
        this.mapper = new Mapper(COUNTRY_TABLE, GENRE_TABLE, );
        this.request = new Request();
    }

    public void addMusic(List<KeyValue> keyValueList) {
        Music music = new Music();

        music.setId(musicTable.getNewId());

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
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
                music.setDuration((Integer) keyValue.getValue());
            }
            if (keyValue.getName().equals("Country")) {
                music.setCountryId(
                        mapper.getCountryIdByName(
                                keyValue.getValue().toString()
                        ));
            }
            if (keyValue.getName().equals("Explicit")) {
                char explicit = (char) keyValue.getValue();
                if (explicit == 'Y' || explicit == 'y') {
                    music.setExplicit(true);
                }
                if (explicit == 'N' || explicit == 'n') {
                    music.setExplicit(false);
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

    public void removeMusic(int id) {
        musicTable.remove(id);
    }

    public Music findMusic(int id) {
        return musicTable.findById(id);
    }

    public List<Music> findAllMusics() {
        return musicTable.findAll();
    }

    public List<Music> findNoExplicitMusics() {
        List<Music> musicList = new LinkedList<>();
        List<Music> backend = musicTable.findAll();

        for (Music music : backend) {
            if (!music.isExplicit()) {
                musicList.add(music);
            }
        }
        return musicList;
    }

    public void printAllMusics(int age) {
        List<Music> musicList;
        if(age > 17) {

        }

        if(musicList.isEmpty()) {
            System.out.println("There is no songs.");
            return;
        }

        for (Music music : musicList) {
            System.out.println("Music id: " + music.getId());
            System.out.println("Name: " + music.getName() + '\n');
        }
    }

    public void printMusic(int id, int age) {
        Music music = findMusic(id);
        if(music == null) {
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
        System.out.println("Youtube url: " + music.getYoutubeURL() + '\n');
    }
}