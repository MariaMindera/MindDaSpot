package com.mindera.school.music.data.intermediateRows;

public class FavouriteAlbum {
    private int album_id;
    private int user_id;

    public FavouriteAlbum(int album_id, int user_id) {
        this.album_id = album_id;
        this.user_id = user_id;
    }

    public FavouriteAlbum() {
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
