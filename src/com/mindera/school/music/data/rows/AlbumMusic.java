package com.mindera.school.music.data.rows;

import com.mindera.school.music.data.Row;

public class AlbumMusic implements Row {
    private int albumId;
    private int musicId;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    @Override
    public int getId() {
        throw new RuntimeException("Row does not have an id");
    }
}