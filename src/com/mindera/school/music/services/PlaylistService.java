package com.mindera.school.music.services;

import com.mindera.school.music.data.intermediateTables.MusicPlaylistTable;
import com.mindera.school.music.data.rows.Playlist;
import com.mindera.school.music.data.tables.MusicTable;
import com.mindera.school.music.data.tables.PlaylistTable;
import com.mindera.school.music.ui.KeyValue;

import static com.mindera.school.music.data.tables.Tables.*;
import static com.mindera.school.music.data.intermediateTables.IntermediateTables.*;

import java.sql.SQLException;
import java.util.List;

public class PlaylistService {
    private PlaylistTable playlistTable;
    private MusicPlaylistTable musicPlaylistTable;
    private MusicTable musicTable;

    public PlaylistService() {
        this.playlistTable = PLAYLIST_TABLE;
        this.musicPlaylistTable = MUSIC_PLAYLIST_TABLE;
        this.musicTable = MUSIC_TABLE;
    }

    public void add(List<KeyValue> keyValueList) throws SQLException {
        Playlist playlist = new Playlist();

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                if (playlistTable.verifyIfExistsName(keyValue.getValue().toString())) {
                    System.out.println("This playlist already exits.");
                    return;
                }
                playlist.setName(keyValue.getValue().toString());
            }
        }

        playlistTable.add(playlist);
    }

    public void removeById(int id) throws SQLException {
        playlistTable.removeById(id);
    }

    public void removeByName(String name) throws SQLException {
        playlistTable.removeByName(name);
    }

    public Playlist find(int id) throws SQLException {
        return playlistTable.findById(id);
    }

    public int findIdByName(String name) throws SQLException {
        return playlistTable.findIdByName(name);
    }

    public Playlist findUser(int id) throws SQLException {
        return playlistTable.findByIdUser(id);
    }

    public int findIdByNameUser(String name) throws SQLException {
        return playlistTable.findIdByNameUser(name);
    }

    public List<Playlist> findAll() throws SQLException {
        return playlistTable.findAll();
    }

    public List<Playlist> findAllUser() throws SQLException {
        return playlistTable.findAllUser();
    }

    public void printAllUser() throws SQLException {
        List<Playlist> playlistList = findAllUser();

        if (playlistList.isEmpty()) {
            System.out.println("There is no playlist.");
            return;
        }

        for (Playlist playlist : playlistList) {
            System.out.println("Playlist id: " + playlist.getId());
            System.out.println("Name: " + playlist.getName() + '\n');
        }
    }

    public void printAll() throws SQLException {
        List<Playlist> playlistList = findAll();

        if (playlistList.isEmpty()) {
            System.out.println("There is no playlist.");
            return;
        }

        for (Playlist playlist : playlistList) {
            System.out.println("Playlist id: " + playlist.getId());
            System.out.println("Name: " + playlist.getName());
            System.out.println("User id: " + playlist.getUserId() + '\n');
        }
    }

    public void printUser(int id) throws SQLException {
        Playlist playlist = findUser(id);

        if (playlist == null) {
            System.out.println("There is no playlist.");
            return;
        }

        System.out.println("Playlist id: " + playlist.getId());
        System.out.println("Name: " + playlist.getName());
        System.out.println("User id: " + playlist.getUserId());
        System.out.println("Musics: ");

        List<Integer> musicList = musicPlaylistTable.find(id);
        for (Integer integer : musicList) {
            System.out.println("Name: " + musicTable.findById(integer).getName());
        }
    }

    public void print(int id) throws SQLException {
        Playlist playlist = find(id);

        if (playlist == null) {
            System.out.println("There is no playlist.");
            return;
        }

        System.out.println("Playlist id: " + playlist.getId());
        System.out.println("Name: " + playlist.getName());
        System.out.println("User id: " + playlist.getUserId());
        System.out.println("Musics: ");

        List<Integer> musicList = musicPlaylistTable.find(id);
        for (Integer integer : musicList) {
            System.out.println("Name: " + musicTable.findById(integer).getName());
        }
    }
}
