package com.mindera.school.music.data.rows;

import com.mindera.school.music.ui.StringCode;

public class Artist {
    private int id;
    private String name;
    private int countryId;
    private String description;
    private int nrFollowers = 0;

    public Artist() {
    }

    public Artist(int id, String name, int countryId, String description, int nrFollowers) {
        this.id = id;
        this.name = StringCode.capitalizeEachWord(name);
        this.countryId = countryId;
        this.description = description;
        this.nrFollowers = nrFollowers;
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

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = StringCode.capitalizeFirstWordOfSentences(description);
    }

    public int getNrFollowers() {
        return nrFollowers;
    }
}
