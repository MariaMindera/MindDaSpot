package com.mindera.school.music.data.intermediateRows;

public class MusicPlaylist {
    private int music_id;
    private int playlist_id;

    public MusicPlaylist(int music_id, int playlist_id) {
        this.music_id = music_id;
        this.playlist_id = playlist_id;
    }

    public MusicPlaylist() {
    }

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }
}
