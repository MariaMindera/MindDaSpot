package com.mindera.school.music.data.intermediateRows;

public class FavouriteMusic {
    private int music_id;
    private int user_id;

    public FavouriteMusic() {
    }

    public FavouriteMusic(int music_id, int user_id) {
        this.music_id = music_id;
        this.user_id = user_id;
    }

    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
