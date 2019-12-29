package com.mindera.school.music.data.intermediateRows;

public class MusicAlbum {
    private int music_id;
    private int album_id;

    public MusicAlbum(int music_id, int album_id) {
        this.music_id = music_id;
        this.album_id = album_id;
    }

    public MusicAlbum() {
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }
}
