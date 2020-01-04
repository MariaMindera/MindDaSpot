package com.mindera.school.music.services;

import com.mindera.school.music.data.intermediateTables.MusicPlaylistTable;
import com.mindera.school.music.data.rows.Music;
import com.mindera.school.music.data.rows.Playlist;
import com.mindera.school.music.data.tables.MusicTable;
import com.mindera.school.music.data.tables.PlaylistTable;
import com.mindera.school.music.ui.KeyValue;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.data.intermediateTables.IntermediateTables.MUSIC_PLAYLIST_TABLE;
import static com.mindera.school.music.data.tables.Tables.MUSIC_TABLE;
import static com.mindera.school.music.data.tables.Tables.PLAYLIST_TABLE;
import static com.mindera.school.music.services.Services.USER_ONLINE;

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

    public void addMusicPlaylist(String namePlaylist, String nameMusic) throws SQLException {
        int playlistId = findIdByName(namePlaylist);
        int musicId = musicTable.findIdByName(nameMusic);

        if (playlistId == 0) {
            System.out.println("This playlist doesn't exits.");
            return;
        }
        if (musicId == 0) {
            System.out.println("This music doesn't exits.");
            return;
        }

        if (musicPlaylistTable.exists(musicId, playlistId)) {
            System.out.println("This music already exits in this playlist.");
        } else {
            musicPlaylistTable.add(musicId, playlistId);
        }
    }

    public void removeByName(String name) throws SQLException {
        int id = findIdByName(name);
        if (id == 0) {
            System.out.println("This playlist doesn't exists.");
        } else {
            playlistTable.removeById(id);
        }
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
        List<Playlist> playlistList = findAllUser();

        if (playlistList.isEmpty()) {
            System.out.println("There is no playlist.");
            return;
        }

        for (Playlist playlist : playlistList) {
            System.out.println("Name: " + playlist.getName() + '\n');
        }
    }

    private void printAllAdm() throws SQLException {
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

    private void printUser(int id) throws SQLException {
        Playlist playlist = findUser(id);

        if (playlist == null) {
            System.out.println("There is no playlist.");
            return;
        }

        System.out.println("Name: " + playlist.getName());
        System.out.println("Musics: ");

        List<Integer> musicList = musicPlaylistTable.find(id);

        if (musicList.isEmpty()) {
            System.out.println("There is no musics in this playlists.");
        }

        for (Integer integer : musicList) {
            Music music = musicTable.findById(integer);
            if (music != null) {
                System.out.println("Name: " + music.getName());
            }
        }
    }

    private void printAdm(int id) throws SQLException {
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
