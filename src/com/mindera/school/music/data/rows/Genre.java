package com.mindera.school.music.data.rows;

import com.mindera.school.music.data.Row;

public class Genre implements Row {
    private int id;
    private String name;

    public Genre() {
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
}
