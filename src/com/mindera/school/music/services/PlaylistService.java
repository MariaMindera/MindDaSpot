package com.mindera.school.music.services;

import com.mindera.school.music.data.rows.Music;
import com.mindera.school.music.data.rows.Playlist;
import com.mindera.school.music.data.tables.PlaylistTable;
import com.mindera.school.music.ui.KeyValue;

import static com.mindera.school.music.data.tables.Tables.*;

import java.util.List;

public class PlaylistService {
    PlaylistTable playlistTable;

    public PlaylistService() {
        this.playlistTable = PLAYLIST_TABLE;
    }

    public void add(List<KeyValue> keyValueList) {
        Playlist playlist = new Playlist();

        playlist.setId(playlistTable.getNewId());
        playlist.setUserId();

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

    public void removePlaylist(int id) {
        playlistTable.remove(id);
    }

    public Playlist findPlaylist(int id) {
        return playlistTable.findById(id);
    }

    public List<Playlist> findAllPlaylists() {
        return playlistTable.findAll();
    }

    public void printAllPlaylists() {
        List<Playlist> playlistList = findAllPlaylists();

        if (playlistList.isEmpty()) {
            System.out.println("There is no playlist.");
            return;
        }

        for (Playlist playlist : playlistList) {
            System.out.println("Playlist id: " + playlist.getId());
            System.out.println("Name: " + playlist.getName() + '\n');
        }
    }

    public void printPlaylist(int id) {
        Playlist playlist = findPlaylist(id);
        if (playlist == null) {
            System.out.println("There is no playlist with this id.");
            return;
        }

        System.out.println("Playlist id: " + playlist.getId());
        System.out.println("Name: " + playlist.getName());
        System.out.println("Musics: ");

        List<Music> musicList = playlist.getMusicList();
        for (Music music : musicList) {
            System.out.print("Id: " + music.getId() + " Name: " + music.getName() + '\n');
        }
    }
}
