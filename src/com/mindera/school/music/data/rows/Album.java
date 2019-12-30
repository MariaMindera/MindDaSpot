package com.mindera.school.music.data.rows;

public class Album {
    private int id;
    private String name;
    private int year;
    private int nrSearch = 0;
    private int studioId;
    private int nrLikes = 0;

    public Album(int id, String name, int year, int nrSearch, int studioId, int nrLikes) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.nrSearch = nrSearch;
        this.studioId = studioId;
        this.nrLikes = nrLikes;
    }

    public Album() {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNrSearch() {
        return nrSearch;
    }

    public void setNrSearch() {
        this.nrSearch++;
    }

    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    public int getNrLikes() {
        return nrLikes;
    }

    public void setNrLikes() {
        this.nrLikes++;
    }
}
