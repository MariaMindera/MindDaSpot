package com.mindera.school.music.data.rows;

import com.mindera.school.music.ui.StringCode;

public class Playlist {
    private int id;
    private String name;
    private int userId;

    public Playlist(int id, String name, int userId) {
        this.id = id;
        this.name = StringCode.capitalizeEachWord(name);
        this.userId = userId;
    }

    public Playlist() {
    }

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
        this.name = StringCode.capitalizeEachWord(name);
    }

    public int getUserId() {
        return userId;
    }
}
