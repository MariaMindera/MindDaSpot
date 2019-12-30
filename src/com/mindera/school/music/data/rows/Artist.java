package com.mindera.school.music.data.rows;

public class Artist {
    private int id;
    private String name;
    private int countryId;
    private String description;
    private int nrSearch = 0;
    private int nrFollowers = 0;

    public Artist() {
    }

    public Artist(int id, String name, int countryId, String description, int nrSearch, int nrFollowers) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.description = description;
        this.nrSearch = nrSearch;
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
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
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
        this.description = description;
    }

    public int getNrSearch() {
        return nrSearch;
    }

    public void setNrSearch() {
        this.nrSearch++;
    }

    public int getNrFollowers() {
        return nrFollowers;
    }

    public void setNrFollowers() {
        this.nrFollowers++;
    }
}
