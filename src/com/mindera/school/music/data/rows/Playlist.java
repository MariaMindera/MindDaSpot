package com.mindera.school.music.data.rows;

import com.mindera.school.music.data.Row;

public class Playlist implements Row {
    private int id;
    private String name;
    private int userId;

    public Playlist() {
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
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
