package com.mindera.school.music.data.rows;

import com.mindera.school.music.ui.StringCode;

public class Country {
    private int id;
    private String name;

    public Country(int id, String name) {
        this.id = id;
        this.name = StringCode.capitalizeEachWord(name);
    }

    public Country() {
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
}
