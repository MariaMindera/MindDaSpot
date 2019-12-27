package com.mindera.school.music.services;

import com.mindera.school.music.data.rows.Music;
import com.mindera.school.music.data.rows.Playlist;
import com.mindera.school.music.data.tables.PlaylistTable;
import com.mindera.school.music.ui.KeyValue;

import static com.mindera.school.music.data.tables.Tables.*;

import java.sql.SQLException;
import java.util.List;

public class PlaylistService {
    PlaylistTable playlistTable;

    public PlaylistService() {
        this.playlistTable = PLAYLIST_TABLE;
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

    public List<Playlist> findAll() throws SQLException {
        return playlistTable.findAll();
    }

    public void printAll() throws SQLException {
        List<Playlist> playlistList = findAll();

        if (playlistList.isEmpty()) {
            System.out.println("There is no playlist.");
            return;
        }

        for (Playlist playlist : playlistList) {
            System.out.println("Playlist id: " + playlist.getId());
            System.out.println("Name: " + playlist.getName() + '\n');
        }
    }

    public void print(int id) throws SQLException {
        Playlist playlist = find(id);

        if (playlist == null) {
            System.out.println("There is no playlist with this id.");
            return;
        }

        System.out.println("Playlist id: " + playlist.getId());
        System.out.println("Name: " + playlist.getName());
//        System.out.println("Musics: ");
//
//        List<Music> musicList = playlist.getMusicList();
//        for (Music music : musicList) {
//            System.out.print("Id: " + music.getId() + " Name: " + music.getName() + '\n');
//        }
    }
}
