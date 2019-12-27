package com.mindera.school.music.data.rows;

import com.mindera.school.music.data.Row;

public class Producer implements Row {
    private int id;
    private String name;

    public Producer() {
    }

    public Producer(int id, String name) {
        this.id = id;
        this.name = name;
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
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
