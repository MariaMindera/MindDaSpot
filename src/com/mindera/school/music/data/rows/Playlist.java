package com.mindera.school.music.data.rows;

import com.mindera.school.music.data.Row;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements Row {
    private int id;
    private String name;
    private int userId;
    private List<Music> musicList;

    public Playlist() {
        this.musicList = new ArrayList<>();
    }

    public void addMusicToPlaylist(Music music) {
        this.musicList.add(music);
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.substring(0,1).toUpperCase() + name.substring(1);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Music> getMusicList() {
        return musicList;
    }
}
