package com.mindera.school.music.data.rows;

import com.mindera.school.music.ui.StringCode;

public class Album {
    private int id;
    private String name;
    private int year;
    private int nrSearch;
    private int studioId;
    private int nrLikes;
    private int producerId;
    private int artistId;

    public Album(int id, String name, int year, int nrSearch, int studioId, int nrLikes) {
        this.id = id;
        this.name = StringCode.capitalizeEachWord(name);
        this.year = year;
        this.nrSearch = nrSearch;
        this.studioId = studioId;
        this.nrLikes = nrLikes;
    }

    public Album() {
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNrSearch() {
        return nrSearch;
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
}
